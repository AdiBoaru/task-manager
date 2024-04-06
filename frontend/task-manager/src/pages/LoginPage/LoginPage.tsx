import Logo from "../../UI/Logo/Logo";
import LoginForm from "../../components/Forms/LoginForm/LoginForm";

const LoginPage = () => {
  return (
    <div className="relative flex justify-around h-screen bg-primaryColor px-[30rem]">
      <div className="flex flex-col w-[70%] justify-around">
        <Logo />
        <div className="h-[50%] laptop:h-[70%]">
          <LoginForm />
        </div>
        <p className="w-[13rem] mb-10 text-white laptop:right-[55rem]">
          All rights reserved 2023 ©
        </p>
      </div>
      <div className="h-full flex items-end justify-evenly w-[50%]">
        <div className=" flex flex-col items-center ">
          <div className="bg-secondaryColor h-[130px] w-[130px] rounded-full " />
          <div className="bg-secondaryColor h-[700px] w-[2px] " />
        </div>
        <div className=" flex flex-col items-center">
          <div className="bg-white h-[100px] w-[100px] rounded-full" />
          <div className="bg-white h-[500px] w-[2px]" />
        </div>
        <div className=" flex flex-col items-center ">
          <div className="bg-secondaryColor h-[140px] w-[140px] rounded-full " />
          <div className="bg-secondaryColor h-[80vh] w-[2px]" />
        </div>
      </div>
    </div>
  );
};

export default LoginPage;
