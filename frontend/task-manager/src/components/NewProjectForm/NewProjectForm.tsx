import { ErrorMessage } from "@hookform/error-message";
import { yupResolver } from "@hookform/resolvers/yup";
import {
  useForm,
  SubmitHandler,
  useController,
  FormProvider,
  Controller,
} from "react-hook-form";
import Select, { CSSObjectWithLabel, SingleValue } from "react-select";

import { newProjectSchema } from "../../constants/formValidations";
import {
  TCreateProjectData,
  TEmployeesCount,
} from "../../interfaces/TCreateProjectData";
import Button from "../../UI/Button/Button";
import FormInput from "../../UI/FormInput/FormInput";

type TNewProjectFormProps = {
  btnStyle: string;
  handleClose: () => void;
};

const NewProjectForm = ({ btnStyle, handleClose }: TNewProjectFormProps) => {
  const methods = useForm<TCreateProjectData>({
    mode: "onChange",
    resolver: yupResolver<TCreateProjectData>(newProjectSchema),
  });
  const {
    control,
    handleSubmit,
    formState: { errors },
  } = methods;

  const onInvalid = (errors: any) => console.error(errors);
  const onSubmit: SubmitHandler<TCreateProjectData> = (
    data: TCreateProjectData
  ) => {
    //TODO du-te in API.js si baga acolo requestu asta
    console.log(data);
    fetch("http://localhost:8080/project", {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        "Content-Type": "application/json",
      },
    });
  };

  const { field: employeesField } = useController({
    name: "teams",
    control,
  });
  const handleEmployeesChange = (option: SingleValue<TEmployeesCount>) => {
    employeesField.onChange(option?.label);
  };

  const colorStyles = {
    control: (styles: CSSObjectWithLabel) => ({
      ...styles,
      width: "25rem",
      padding: "5px",
      borderRadius: "10px",
    }),
  };

  return (
    <FormProvider {...methods}>
      <form
        data-testid="create-project-form"
        className="absolute flex flex-col bg-primaryColor items-center gap-3 z-10 py-10 rounded-[20px] border border-secondaryColor h-auto w-[40%] laptop:pt-0 laptop:h-[70%]"
        onSubmit={handleSubmit(onSubmit, onInvalid)}
      >
        <FormInput
          testId="project-name"
          inputTestId="project-name-input"
          errorTestId="project-name-error"
          labelStyle="px-4 text-white text-lg"
          inputStyle=" mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your project name"
          type="text"
          labelText="Project name"
          inputId="projectName"
          name="title"
        />
        <FormInput
          testId="project-description"
          inputTestId="project-description-input"
          errorTestId="project-description-error"
          labelStyle="p-4 text-white text-lg"
          inputStyle=" mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter project description"
          type="text"
          labelText="Description"
          inputId="description"
          name="description"
        />
        <div>
          <label className="ml-3 text-white text-lg">
            Teams
            <Controller
              data-testid="controller"
              name="teams"
              control={control}
              rules={{ required: "Employees is required" }}
              render={() => (
                <Select
                  id="employees"
                  data-testid="employees-select"
                  onChange={handleEmployeesChange}
                  options={[
                    //TODO adauga aicia echipele ce vin din API
                  ]}
                  placeholder="Choose the number of employees"
                  styles={colorStyles}
                />
              )}
            />
          </label>
          <ErrorMessage
            errors={errors}
            name={"teams"}
            render={({ message }) => <p className="text-red-600">{message}</p>}
          />
        </div>
        <FormInput
          testId="release-date"
          labelStyle="p-4 text-white text-lg"
          inputStyle=" mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          labelText="Completion Date"
          placeholder="Enter your completion date"
          type="date"
          name="dueDate"
          inputId="releaseDate"
        />
        <Button
          testId="create-button"
          type="submit"
          style={`${btnStyle} text-secondaryColor text-xl border border-secondaryColor rounded-[10px] py-3 hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor `}
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

export default NewProjectForm;
