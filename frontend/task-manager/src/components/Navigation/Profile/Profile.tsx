import { IoMdNotificationsOutline } from "react-icons/io";

const Profile = () => {
  return (
    <div className="flex items-center mx-20">
      <span className="text-secondaryColor text-[38px] rounded-full">
        <IoMdNotificationsOutline />
      </span>
      <img
        className="rounded-full h-[40px] w-[40px] m-4"
        src="../../../../assets/willSmith.png"
      />
      <div className="flex flex-col items-start">
        <span className="text-white text-lg">User Name</span>
        <span className="text-white text-sm">User Role</span>
      </div>
    </div>
  );
};

export default Profile;
