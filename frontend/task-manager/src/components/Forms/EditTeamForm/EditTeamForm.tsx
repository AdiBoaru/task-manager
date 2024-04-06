import { useEffect, useState } from "react";
import { ErrorMessage } from "@hookform/error-message";

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

import {
  TCreateTeamData,
  TEmployeesPick,
  TTeamSizePick,
} from "../../../interfaces/TCreateTeamData";
import FormInput from "../../../UI/FormInput/FormInput";
import { useUpdateTeamMutation } from "../../../services/TeamsApi/api";
import { useGetEmployeesQuery } from "../../../services/EmployeesApi/api";
import { useNavigate } from "react-router-dom";
import ROUTESPATHS from "../../../constants/routePaths";
import useToastify from "../../../hooks/useToastify";

type TEditTeamFormProps = {
  onSuccess: () => void;
  prefillFormData?: TCreateTeamData;
};

const EditTeamForm = ({ onSuccess, prefillFormData }: TEditTeamFormProps) => {
  const [teamSize, setTeamSize] = useState<number>(0);
  const [teamMembers, setTeamMembers] = useState(prefillFormData?.employees);
  const [updateTeam] = useUpdateTeamMutation();
  const { data: employees } = useGetEmployeesQuery();

  const navigate = useNavigate();
  const { notification } = useToastify();

  useEffect(() => {
    setTeamMembers([]);
  }, [teamSize]);

  const methods = useForm<TCreateTeamData>({
    mode: "onChange",
    defaultValues: prefillFormData,
  });
  const {
    control,
    handleSubmit,
    formState: { errors },
  } = methods;

  const onInvalid = (errors: any) => console.error(errors);
  const onSubmit: SubmitHandler<TCreateTeamData> = (data: TCreateTeamData) => {
    console.log(data);
    updateTeam(data)
      .unwrap()
      .then(() => {
        onSuccess();
        navigate(ROUTESPATHS.TEAMS);
        notification("Team edited successfully", "success");
      })
      .catch(({ data }) => console.log(data));
  };

  const { field: editEmployeesField } = useController({
    name: "employees",
    control,
  });

  const { field: editTeamSizeField } = useController({
    name: "size",
    control,
  });

  const handleEmployeesPick = (option: MultiValue<TEmployeesPick>) => {
    editEmployeesField.onChange(option);
    setTeamMembers(option as any);
  };

  const handleTeamSizePick = (option: SingleValue<TTeamSizePick>) => {
    editTeamSizeField.onChange(option?.value);
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
      cursor: "pointer",
      ":hover": {
        backgroundColor: isFocused ? "lightblue" : "lightgray",
      },
    }),
  };
  const options = [
    { value: 3, label: "Small (3)" },
    { value: 5, label: "Medium (5)" },
    { value: 10, label: "Large (10)" },
  ];
  const defaultValueForTeamSize = options.find(
    ({ value }: any) => prefillFormData?.size! <= value
  );

  return (
    <FormProvider {...methods}>
      <form
        id="edit-team-form"
        data-testid="edit-team-form"
        className="flex flex-col bg-primaryColor items-center gap-3 z-50 py-10 rounded-[20px] h-auto w-[40%] laptop:h-[55%]"
        onSubmit={handleSubmit(onSubmit, onInvalid)}
      >
        <FormInput
          testId="edit-team-name"
          inputTestId="edit-team-name-input"
          errorTestId="edit-team-name-error"
          labelStyle="px-4 text-white text-lg"
          inputStyle="w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your team name"
          type="text"
          labelText="Team name"
          inputId="editTeamName"
          name="name"
        />
        <div>
          <label className="ml-3 text-white text-lg">
            Select your team size
            <Controller
              data-testid="controller"
              name="size"
              control={control}
              render={() => (
                <Select
                  id="editSize"
                  defaultValue={defaultValueForTeamSize}
                  data-testid="teamSize-select"
                  onChange={handleTeamSizePick}
                  options={options}
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
              render={() => (
                <Select
                  id="editEmployees"
                  options={employees}
                  isMulti
                  data-testid="employees-select"
                  onChange={handleEmployeesPick}
                  getOptionLabel={(option: TEmployeesPick) => option.fullName}
                  getOptionValue={(option: any) => option.id}
                  isOptionDisabled={() => teamMembers!.length >= teamSize}
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

export default EditTeamForm;
