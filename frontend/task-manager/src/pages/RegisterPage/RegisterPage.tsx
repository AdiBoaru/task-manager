import Logo from "../../UI/Logo/Logo";
import RegisterForm from "../../components/Forms/RegisterForm/RegisterForm";

const RegisterPage = () => {
  return (
    <div className="relative flex justify-between h-screen bg-primaryColor px-[20rem]">
      <div className="flex flex-col w-[70%] justify-between">
        <Logo mt="mt-[150px]" />
        <div className="py-[3rem] h-[55%] laptop:h-[70%]">
          <RegisterForm />
        </div>
        <p className="w-[13rem] mb-10 text-white laptop:right-[55rem]">
          All rights reserved 2023 ©
        </p>
      </div>
      <div className="w-[50%] flex justify-evenly">
        <div className="relative">
          <div className="bg-white h-[500px] w-[2px]" />
          <div className="bg-white h-[100px] w-[100px] rounded-full absolute -left-[3rem] laptop:left-[21%]" />
        </div>
        <div className="relative">
          <div className="bg-secondaryColor h-[700px] w-[2px]" />
          <div className="bg-secondaryColor h-[130px] w-[130px] rounded-full absolute -left-[4rem] laptop:left-[50%]" />
        </div>
      </div>
    </div>
  );
};

export default RegisterPage;
