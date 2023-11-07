import {
  SubmitHandler,
  useForm,
  FormProvider,
  Controller,
  useController,
} from "react-hook-form";
import { NavLink } from "react-router-dom";
import { yupResolver } from "@hookform/resolvers/yup";
import Select, { CSSObjectWithLabel, SingleValue } from "react-select";
import { ErrorMessage } from "@hookform/error-message";

import { TRegisterFormData } from "../../interfaces/TRegisterFormData";
import { schema } from "../../constants/formValidations";
import { LOGIN } from "../../constants/routePaths";
import FormInput from "../../UI/FormInput/FormInput";
import Button from "../../UI/Button/Button";

type TRole = {
  label: string;
  value?: string;
  id?: string;
};

const RegisterForm = () => {
  const methods = useForm<TRegisterFormData>({
    mode: "onChange",
    resolver: yupResolver<TRegisterFormData>(schema),
  });
  const {
    control,
    handleSubmit,
    formState: { errors },
  } = methods;
  const onInvalid = (errors: any) => console.error(errors);
  const onSubmit: SubmitHandler<TRegisterFormData> = (
    data: TRegisterFormData
  ) => {
    console.log(data);
    fetch("http://localhost:8080/register/process_register", {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        "Content-Type": "application/json",
      },
    });
  };
  const { field: roleField } = useController({ name: "role", control });
  const handleRoleChange = (option: SingleValue<TRole>) => {
    roleField.onChange(option?.label);
  };

  const colorStyles = {
    control: (styles: CSSObjectWithLabel) => ({
      ...styles,
      width: "25rem",
      padding: "6px",
      marginBottom: ".7rem",
      marginLeft: "1.1rem",
      borderRadius: "10px",
    }),
  };
  return (
    <FormProvider {...methods}>
      <form
        data-testid="register-form"
        className="flex flex-col flex-wrap h-full relative"
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
        <div>
          <label className="ml-6 text-white text-lg">Role</label>
          <Controller
            data-testid="controller"
            name="role"
            control={control}
            rules={{ required: "Role is required" }}
            render={() => (
              <Select
                id="role"
                data-testid="role-select"
                onChange={handleRoleChange}
                options={[
                  { label: "test", id: "test" },
                  { label: "test2", id: "test2" },
                ]}
                placeholder="Choose your role"
                styles={colorStyles}
              />
            )}
          />
          <ErrorMessage
            errors={errors}
            name={"role"}
            render={({ message }) => (
              <p className="text-red-600 pl-5 ">{message}</p>
            )}
          />
        </div>
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
          style="text-secondaryColor text-xl border rounded-[10px] py-3 mx-4 my-7 w-[20%] hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor "
        >
          Register
        </Button>
        <p className="mx-4 text-start text-white ">
          Already have an account?{" "}
          <NavLink
            data-testid="login-redirect"
            className="text-secondaryColor text-lg"
            to={LOGIN}
          >
            Login Here
          </NavLink>
        </p>
      </form>
    </FormProvider>
  );
};

export default RegisterForm;
