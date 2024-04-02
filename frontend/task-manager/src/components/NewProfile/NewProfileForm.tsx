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
import moment from "moment";
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

import { newProjectSchema } from "../../constants/formValidations";
import {
  TCreateProjectData,
  TTeamPick,
} from "../../interfaces/TCreateProjectData";
import Button from "../../UI/Button/Button";
import FormInput from "../../UI/FormInput/FormInput";
import {
  useCreateProjectMutation,
  useGetTeamsQuery,
} from "../../services/api/api";
import { useNavigate } from "react-router-dom";
import ROUTESPATHS from "../../constants/routePaths";
import { useState } from "react";
import useToastify from "../../hooks/useToastify";

type TNewProjectFormProps = {
  btnStyle: string;
  handleClose: () => void;
};

const NewProfileForm = ({ btnStyle, handleClose }: TNewProjectFormProps) => {
  const { data: teams } = useGetTeamsQuery();
  const [createProject] = useCreateProjectMutation();
  const { notification } = useToastify();
  const [selectedDate, setSelectedDate] = useState<Date | string>(new Date());

  const navigate = useNavigate();
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
    createProject(data)
      .unwrap()
      .then((response) => console.log(response))
      .catch(({ data }) => console.log(data));
    navigate(ROUTESPATHS.PROJECTS);
    notification("Project created successfully", "success");
  };

  const { field: teamsField } = useController({
    name: "team",
    control,
  });
  const { field: dateField } = useController({
    name: "dueDate",
    control,
  });

  const handleTeamPick = (option: SingleValue<TTeamPick>) => {
    teamsField.onChange(option);
  };

  const handleDatePick = (option: SingleValue<Date>) => {
    if (option) {
      dateField.onChange(moment(option).format("YYYY-MM-DD"));
      setSelectedDate(moment(option).format("YYYY-MM-DD"));
    }
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
        className="absolute flex flex-col bg-primaryColor items-center gap-1 z-10 py-10 rounded-[20px] h-auto w-[40%] laptop:pt-0 laptop:h-[70%]"
        onSubmit={handleSubmit(onSubmit, onInvalid)}
      >
         <FormInput
          testId="first-name"
          inputTestId="first-name-input"
          errorTestId="first-name-error"
          labelStyle="px-4 text-white text-lg"
          inputStyle="ml-3 mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your first name"
          type="text"
          labelText="First Name"
          inputId="firstName"
          name="firstName"
        />
        <FormInput
          testId="last-name"
          inputTestId="last-name-input"
          errorTestId="last-name-error"
          labelStyle="p-4 text-white text-lg"
          inputStyle="ml-3 mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your last name"
          type="text"
          labelText="Last Name"
          inputId="lastName"
          name="lastName"
        />
        <FormInput
          testId="email"
          inputTestId="email-input"
          errorTestId="email-error"
          labelStyle="p-4 text-white text-lg"
          inputStyle="ml-3 mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your email"
          type="email"
          labelText="Email"
          inputId="email"
          name="email"
        />
        <FormInput
          testId="password"
          inputTestId="password-input"
          errorTestId="password-error"
          labelStyle="p-3 text-white text-lg"
          inputStyle="ml-3 mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Enter your password"
          type="password"
          labelText="Password"
          inputId="password"
          name="password"
        />
        <FormInput
          testId="confirm-password"
          inputTestId="confirm-password-input"
          errorTestId="confirm-password-error"
          labelStyle="p-4 text-white text-lg"
          inputStyle="ml-3 mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          placeholder="Confirm your password"
          type="password"
          labelText="Confirm password"
          inputId="confirmPassword"
          name="confirmPassword"
        />
     
        <FormInput
          testId="birth-date"
          labelStyle="p-4 text-white text-lg"
          inputStyle="ml-3 mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
          labelText="Date of birth"
          placeholder="Enter your date of birth"
          type="date"
          name="birthDate"
          inputId="birthDate"
        />
        <Button
          testId="register-button"
          type="submit"
          style="text-secondaryColor text-xl border border-secondaryColor rounded-[10px] py-3 mx-4 my-7 w-[25rem] hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor "
          onClick={() => {
            handleSubmit(onSubmit, onInvalid)();
          }}
        >
          Update Account
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

export default NewProfileForm;
