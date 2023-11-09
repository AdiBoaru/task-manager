import { NavLink } from "react-router-dom";
import { SubmitHandler, useForm, FormProvider } from "react-hook-form";
import { yupResolver } from "@hookform/resolvers/yup";

import { loginSchema } from "../../constants/formValidations";
import { TLoginFormData } from "../../interfaces/TLoginFormData";
import { REGISTER } from "../../constants/routePaths";
import FormInput from "../../UI/FormInput/FormInput";
import Button from "../../UI/Button/Button";
import useToastify from "../../hooks/useToastify";

const LoginForm = () => {
  const { notification } = useToastify();
  const methods = useForm<TLoginFormData>({
    mode: "onBlur",
    resolver: yupResolver<TLoginFormData>(loginSchema),
  });
  const { handleSubmit } = methods;
  const onSubmit: SubmitHandler<TLoginFormData> = (data: TLoginFormData) => {
    notification(
      "Please verify your email to confirm your registration.",
      "success"
    );
    console.log(data);
    fetch("localhost:8080/account/login", {
      method: "POST",
      body: JSON.stringify(data),
      headers: {
        "Content-Type": "application/json",
      },
    });
  };

  return (
    <FormProvider {...methods}>
      <form
        data-testid="register-form"
        className="flex flex-col justify-around flex-wrap h-full relative"
        onSubmit={handleSubmit(onSubmit)}
      >
        <div>
          <FormInput
            testId="email"
            inputTestId="email-input"
            errorTestId="email-error"
            labelStyle="px-4 text-white text-lg"
            inputStyle="ml-3 mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
            placeholder="Enter your Email"
            type="email"
            labelText="Email"
            inputId="email"
            name="email"
          />
          <FormInput
            testId="password"
            inputTestId="password-input"
            errorTestId="password-error"
            labelStyle="p-4 text-white text-lg"
            inputStyle="ml-3 mb-[10px] w-[25rem] p-3 rounded-[10px] focus:border-secondaryColor focus:outline-secondaryColor"
            placeholder="Enter your password"
            type="password"
            labelText="Password"
            inputId="password"
            name="password"
          />
          <FormInput
            testId="rememberMe"
            inputTestId="remember-me-input"
            labelStyle="p-4 text-white text-lg"
            inputStyle="mx-10 cursor-pointer"
            style="w-[28rem] h-fit flex items-center justify-between"
            type="checkbox"
            labelText="Remember me!"
            inputId="checkbox"
            name="checkbox"
          />
        </div>
        <div>
          <Button
            testId="register-button"
            type="submit"
            style="text-secondaryColor text-xl border border-secondaryColor rounded-[10px] py-3 mx-4 my-7 w-[20%] hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor "
          >
            Login
          </Button>
          <p className="mx-4 text-start text-white ">
            Don't have an account yet?{" "}
            <NavLink
              data-testid="login-redirect"
              className="text-secondaryColor text-lg"
              to={REGISTER}
            >
              Register Here
            </NavLink>
          </p>
        </div>
      </form>
    </FormProvider>
  );
};

export default LoginForm;
