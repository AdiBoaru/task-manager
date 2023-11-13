import { ErrorMessage } from "@hookform/error-message";
import { yupResolver } from "@hookform/resolvers/yup";
import {
  useForm,
  SubmitHandler,
  useController,
  FormProvider,
  Controller,
} from "react-hook-form";
import Select, { CSSObjectWithLabel, MultiValue } from "react-select";

import { newTeamSchema } from "../../constants/formValidations";
import {
  TCreateTeamData,
  TEmployeesPick,
} from "../../interfaces/TCreateTeamData";
import Button from "../../UI/Button/Button";
import FormInput from "../../UI/FormInput/FormInput";

const NewTeamForm = () => {
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
    console.log(data);
    fetch("http://localhost:8080/create_team", {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        "Content-Type": "application/json",
      },
    });
  };
  const { field: employeesField } = useController({
    name: "employeesPick",
    control,
  });
  const handleEmployeesPick = (option: MultiValue<TEmployeesPick>) => {
    employeesField.onChange(option);
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
        className="flex flex-col bg-primaryColor items-center justify-start z-10 pt-20 rounded-[20px] border border-secondaryColor h-[40%] w-[40%] laptop:h-[55%]"
        onSubmit={handleSubmit(onSubmit, onInvalid)}
      >
        <FormInput
          testId="team-name"
          inputTestId="team-name-input"
          errorTestId="team-name-error"
          labelStyle="px-4 text-white text-lg"
          inputStyle="mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your team name"
          type="text"
          labelText="Team name"
          inputId="teamName"
          name="teamName"
        />
        <div>
          <label className="ml-3 text-white text-lg">
            Select your team members
          </label>
          <Controller
            data-testid="controller"
            name="employeesPick"
            control={control}
            rules={{ required: "Choose your employees" }}
            render={() => (
              <Select
                id="employees"
                menuPosition="fixed"
                menuPortalTarget={document.body}
                data-testid="employees-select"
                onChange={handleEmployeesPick}
                options={[
                  { value: "Toghi", label: "Toghi", id: "1" },
                  { value: "Ditz", label: "Ditz", id: "2" },
                  { value: "Cici", label: "Cici", id: "3" },
                ]}
                isMulti
                placeholder="Choose your employees"
                styles={colorStyles}
              />
            )}
          />
          <ErrorMessage
            errors={errors}
            name={"employeesPick"}
            render={({ message }) => (
              <p className="text-red-600 pl-5 ">{message}</p>
            )}
          />
        </div>
        <Button
          testId="create-button"
          type="submit"
          style="text-secondaryColor text-xl border border-secondaryColor rounded-[10px] py-3 my-7 w-[25rem] hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor "
        >
          Create
        </Button>
      </form>
    </FormProvider>
  );
};

export default NewTeamForm;
