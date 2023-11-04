import {
  SubmitHandler,
  useForm,
  FormProvider,
  Controller,
} from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";
import Select, { CSSObjectWithLabel } from "react-select";

import { TRegisterFormData } from "../../interfaces/TRegisterFormData";
import { schema } from "../../constants/formValidations";
import FormInput from "../../UI/FormInput/FormInput";
import Button from "../../UI/Button/Button";

const RegisterForm = () => {
  const methods = useForm<TRegisterFormData>({
    mode: "onChange",
    resolver: yupResolver<TRegisterFormData>(schema),
  });
  const { control, handleSubmit } = methods;

  const onSubmit: SubmitHandler<TRegisterFormData> = (
    data: TRegisterFormData
  ) => console.log(data);

  return (
    <FormProvider {...methods}>
      <form onSubmit={handleSubmit(onSubmit)}>
        <FormInput
          placeholder="Enter your first name"
          type="text"
          labelText="First Name"
          inputId="firstName"
          inputName="firstName"
        />
        <FormInput
          placeholder="Enter your last name"
          type="text"
          labelText="Last Name"
          inputId="lastName"
          inputName="lastName"
        />
        <FormInput
          placeholder="Enter your email"
          type="email"
          labelText="Email"
          inputId="email"
          inputName="email"
        />
        <FormInput
          placeholder="Enter your password"
          type="password"
          labelText="Password"
          inputId="password"
          inputName="password"
        />
        <FormInput
          placeholder="Confirm your password"
          type="password"
          labelText="Confirm password"
          inputId="confirmPassword"
          inputName="confirmPassword"
        />
        <Controller
          name="role"
          control={control}
          rules={{ required: "Role is required" }}
          render={() => (
            <Select
              id="role"
              onChange={() => {}}
              options={[]}
              placeholder="Choose your role"
              styles={{
                control: (styles: CSSObjectWithLabel) => ({
                  ...styles,
                }),
              }}
            />
          )}
        />
        <FormInput
          labelText="Date of birth"
          placeholder="Enter your date of birth"
          type="text"
          inputName="birthDate"
          inputId="birthDate"
        />
        <Button type="submit" style="" onClick={() => {}} disabled>
          Register
        </Button>
      </form>
    </FormProvider>
  );
};

export default RegisterForm;
