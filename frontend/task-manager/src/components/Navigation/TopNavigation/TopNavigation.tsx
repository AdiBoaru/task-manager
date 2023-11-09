import { BiSearchAlt } from "react-icons/bi";

import Logo from "../../../UI/Logo/Logo";
import SearchBar from "../../SearchBar/SearchBar";
import Profile from "../Profile/Profile";

const TopNavigation = () => {
  return (
    <div className="fixed top-0 left-0 flex items-center justify-between w-screen h-[200px] bg-primaryColor">
      <Logo style={"mx-5"} />
      <div className="relative">
        <span className="cursor-pointer absolute top-3 left-3 text-white text-xl">
          <BiSearchAlt />
        </span>
        <SearchBar />
      </div>
      <Profile />
    </div>
  );
};

export default TopNavigation;
