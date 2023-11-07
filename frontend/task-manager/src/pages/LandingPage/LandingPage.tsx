import { NavLink } from "react-router-dom";
import { BsShieldFillCheck } from "react-icons/bs";
import { SlOrganization } from "react-icons/sl";
import { GiProgression } from "react-icons/gi";

import { LOGIN, REGISTER } from "../../constants/routePaths";
import Logo from "../../UI/Logo/Logo";

const LandingPage = () => {
  return (
    <div className="flex flex-col h-screen w-screen bg-primaryColor overflow-hidden">
      <div className="h-1/6 flex justify-between px-[12rem] items-center">

        <Logo />
        <NavLink
          data-testid="landing-page-login-btn"
          to={LOGIN}
          className="text-secondaryColor inline-block relative text-3xl transition-all duration-500 before:content-[''] before:absolute before:-bottom-2 before:left-0 before:w-0 before:h-1.5 before:rounded-full before:opacity-0 before:transition-all before:duration-500 before:bg-secondaryColor hover:before:w-full hover:before:opacity-100"
        >
          Login
        </NavLink>
      </div>
      <div className="h-screen w-screen flex">
        <div className="flex flex-col w-1/2 items-start justify-between py-[5rem] px-[12rem]">
          <div className="h-full flex w-[39rem] items-start justify-between flex-col">
            <h2
              data-testid="landing-page-title"
              className="text-[6rem] leading-[9rem] text-white pt-20 w-[40rem] laptop:w-[30rem] laptop:text-[4rem] laptop:leading-[7rem]"
            >
              Task Management For Your Company
            </h2>
            <NavLink
              data-testid="landing-page-register-btn"
              className="text-secondaryColor text-xl border rounded-md p-3 hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor"
              to={REGISTER}
            >
              Register Now
            </NavLink>
            <p className="mr-5 text-white text-lg">
              Start managing your clients and projects like a pro.
            </p>
          </div>
        </div>
        <div className="w-1/2 bg-primaryColor relative">
          <div className="bg-white h-[70rem] w-[70rem] rounded-full absolute -right-[15rem] -bottom-[15rem] flex items-center justify-center laptop:h-[60rem] laptop:w-[60rem] ">
            <div className="h-[30rem] w-[40rem] flex flex-col justify-around items-end font-semibold text-5xl mb-[10rem] mr-[10rem] laptop:text-3xl laptop:mr-[20rem] laptop:mb-[10rem]">
              <div className="flex justify-end w-full">
                <p className="text-primaryColor">Projects organization</p>
                <SlOrganization className="text-secondaryColor ml-5" />
              </div>
              <div className="flex justify-end w-full">
                <p className="text-primaryColor">Track Projects Status</p>
                <GiProgression className="text-secondaryColor ml-5" />
              </div>
              <div className="flex justify-end w-full">
                <p className="text-primaryColor">Privacy Security</p>
                <BsShieldFillCheck className="text-secondaryColor ml-5" />
              </div>
            </div>
          </div>
          <div className="bg-white h-[12rem] w-[12rem] rounded-full absolute right-[44rem] bottom-[49rem] laptop:right-[28rem] laptop:bottom-[45rem]" />
          <div className="bg-secondaryColor h-[10rem] w-[10rem] rounded-full absolute right-[54rem] bottom-[36rem] laptop:right-[41rem] laptop:bottom-[35rem]" />
          <div className="bg-white h-[7rem] w-[7rem] rounded-full absolute right-[58rem] bottom-[24rem] laptop:right-[47rem]" />
          <div className="bg-white h-[4rem] w-[4rem] rounded-full absolute right-[59rem] bottom-[16rem] laptop:right-[49rem]" />
          <div className="bg-secondaryColor h-[2rem] w-[2rem] rounded-full absolute right-[58rem] bottom-[10rem] laptop:right-[49rem]" />
          <div className="bg-white h-[1rem] w-[1rem] rounded-full absolute right-[56rem] bottom-[6rem] laptop:right-[48rem]" />
          <p className="w-[13rem] text-white absolute right-[65rem] bottom-[5rem] laptop:right-[55rem]">
            All rights reserved 2023 ©
          </p>
        </div>
      </div>
    </div>
  );
};

export default LandingPage;
