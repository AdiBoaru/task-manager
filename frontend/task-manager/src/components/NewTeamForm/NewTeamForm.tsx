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

import { newTeamSchema } from "../../constants/formValidations";
import {
  TCreateTeamData,
  TEmployeesPick,
  TTeamSizePick,
} from "../../interfaces/TCreateTeamData";
import Button from "../../UI/Button/Button";
import FormInput from "../../UI/FormInput/FormInput";
import {
  useCreateTeamMutation,
  useGetEmployeesQuery,
} from "../../services/api/api";
import { useNavigate } from "react-router-dom";
import ROUTESPATHS from "../../constants/routePaths";

type TNewTeamForm = {
  handleClose: () => void;
};

const NewTeamForm = ({ handleClose }: TNewTeamForm) => {
  const [teamSize, setTeamSize] = useState<number>(0);
  const [teamMembers, setTeamMembers] = useState([]);
  const [createTeam] = useCreateTeamMutation();
  const { data: employees } = useGetEmployeesQuery();
  const navigate = useNavigate();

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
    createTeam(data);
    navigate(ROUTESPATHS.TEAMS);
  };

  const { field: employeesField } = useController({
    name: "employeesTeam",
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
      zIndex: 9999,
    }),
  };

  return (
    <FormProvider {...methods}>
      <form
        data-testid="create-project-form"
        className="flex flex-col bg-primaryColor items-center gap-3 z-10 py-10 rounded-[20px] border border-secondaryColor h-auto w-[40%] laptop:h-[55%]"
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
                  menuPosition="fixed"
                  menuPortalTarget={document.body}
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
              name="employeesTeam"
              control={control}
              rules={{ required: "Choose your employees" }}
              render={() => (
                <Select
                  id="employees"
                  options={employees}
                  isMulti
                  menuPosition="fixed"
                  menuPortalTarget={document.body}
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
            name={"employeesTeam"}
            render={({ message }) => (
              <p className="text-red-600 pl-5 ">{message}</p>
            )}
          />
        </div>
        <Button
          testId="create-button"
          type="submit"
          style="text-secondaryColor text-xl border border-secondaryColor rounded-[10px] py-3 w-[25rem] hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor "
        >
          Create
        </Button>
        <Button
          testId="cancel-button"
          type="button"
          style={`text-gray-500 text-xl border border-gray-500 rounded-[10px] py-3 w-[25rem] hover:font-semibold hover:text-white hover:bg-gray-500`}
          onClick={handleClose}
        >
          Cancel
        </Button>
      </form>
    </FormProvider>
  );
};

export default NewTeamForm;
