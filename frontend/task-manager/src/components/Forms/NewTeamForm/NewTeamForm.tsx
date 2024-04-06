import { useEffect, useState } from "react";
import { ErrorMessage } from "@hookform/error-message";
import { yupResolver } from "@hookform/resolvers/yup";
import {
  useForm,
  SubmitHandler,
  useController,
  FormProvider,
  Controller,
} from "react-hook-form";
import Select, {
  CSSObjectWithLabel,
  MultiValue,
  SingleValue,
} from "react-select";

import { newTeamSchema } from "../../../constants/formValidations";
import {
  TCreateTeamData,
  TEmployeesPick,
  TTeamSizePick,
} from "../../../interfaces/TCreateTeamData";
import FormInput from "../../../UI/FormInput/FormInput";
import { useCreateTeamMutation } from "../../../services/TeamsApi/api";
import { useGetEmployeesQuery } from "../../../services/EmployeesApi/api";
import { useNavigate } from "react-router-dom";
import ROUTESPATHS from "../../../constants/routePaths";
import useToastify from "../../../hooks/useToastify";

type TNewTeamForm = {
  onSuccess: () => void;
};

const NewTeamForm = ({ onSuccess }: TNewTeamForm) => {
  const [teamSize, setTeamSize] = useState<number>(0);
  const [teamMembers, setTeamMembers] = useState([]);
  const [createTeam] = useCreateTeamMutation();
  const { data: employees } = useGetEmployeesQuery();
  const navigate = useNavigate();
  const { notification } = useToastify();

  useEffect(() => {
    setTeamMembers([]);
  }, [teamSize]);

  const methods = useForm<TCreateTeamData>({
    mode: "onChange",
    resolver: yupResolver<TCreateTeamData>(newTeamSchema),
  });
  const {
    control,
    handleSubmit,
    formState: { errors },
  } = methods;

  const onInvalid = (errors: any) => console.error(errors);
  const onSubmit: SubmitHandler<TCreateTeamData> = (data: TCreateTeamData) => {
    createTeam(data)
      .unwrap()
      .then(() => {
        onSuccess();
        navigate(ROUTESPATHS.TEAMS);
        notification("Team created successfully", "success");
      })
      .catch((error) => console.log(error));
  };

  const { field: employeesField } = useController({
    name: "employees",
    control,
  });

  const { field: teamSizeField } = useController({
    name: "size",
    control,
  });

  const handleEmployeesPick = (option: MultiValue<TEmployeesPick>) => {
    employeesField.onChange(option);
    setTeamMembers(option as any);
  };

  const handleTeamSizePick = (option: SingleValue<TTeamSizePick>) => {
    teamSizeField.onChange(option?.value);
    setTeamSize(+option?.value!);
  };

  const colorStyles = {
    control: (styles: CSSObjectWithLabel) => ({
      ...styles,
      width: "25rem",
      padding: "6px",
      margin: "4px",
      borderRadius: "10px",
    }),
    option: (styles: CSSObjectWithLabel, { isSelected, isFocused }: any) => ({
      ...styles,
      color: "black",
      backgroundColor: isSelected ? "lightblue" : undefined,
      overflow: "hidden",
      cursor: "pointer",
      ":hover": {
        backgroundColor: isFocused ? "lightblue" : "lightgray",
      },
    }),
  };

  return (
    <FormProvider {...methods}>
      <form
        id="create-new-team-form"
        data-testid="create-team-form"
        className="flex flex-col items-center gap-3 w-full py-10 h-auto laptop:h-[55%]"
        onSubmit={handleSubmit(onSubmit, onInvalid)}
      >
        <FormInput
          testId="team-name"
          inputTestId="team-name-input"
          errorTestId="team-name-error"
          labelStyle="px-4 text-white text-lg"
          inputStyle="w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your team name"
          type="text"
          labelText="Team name"
          inputId="teamName"
          name="name"
        />
        <div>
          <label className="ml-3 text-white text-lg">
            Select your team size
            <Controller
              data-testid="controller"
              name="size"
              control={control}
              rules={{ required: "Choose your team size" }}
              render={() => (
                <Select
                  id="size"
                  data-testid="teamSize-select"
                  onChange={handleTeamSizePick}
                  options={[
                    { value: 3, label: "Small (3)" },
                    { value: 5, label: "Medium (5)" },
                    { value: 10, label: "Large (10)" },
                  ]}
                  placeholder="Choose your team size"
                  styles={colorStyles}
                />
              )}
            />
          </label>
          <ErrorMessage
            errors={errors}
            name={"size"}
            render={({ message }) => (
              <p className="text-red-600 pl-5">{message}</p>
            )}
          />
        </div>
        <div>
          <label className="ml-3 text-white text-lg">
            Select your team members
            <Controller
              data-testid="controller"
              name="employees"
              control={control}
              rules={{ required: "Choose your employees" }}
              render={() => (
                <Select
                  id="employees"
                  options={employees}
                  isMulti
                  data-testid="employees-select"
                  onChange={handleEmployeesPick}
                  getOptionLabel={(option: TEmployeesPick) => option.fullName}
                  getOptionValue={(option: any) => option.id}
                  isOptionDisabled={() => teamMembers.length >= teamSize}
                  placeholder="Choose your employees"
                  styles={colorStyles}
                  value={teamMembers}
                />
              )}
            />
          </label>
          <ErrorMessage
            errors={errors}
            name={"employees"}
            render={({ message }) => (
              <p className="text-red-600 pl-5 ">{message}</p>
            )}
          />
        </div>
      </form>
    </FormProvider>
  );
};

export default NewTeamForm;
