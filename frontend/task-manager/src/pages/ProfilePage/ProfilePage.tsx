import NewProjectForm from "../../components/NewProjectForm/NewProjectForm";

function ProfilePage() {
  return (
    <div className="grid gap-0 grid-cols-2">
      <div>
        <h1>EDIT PROFILE</h1>
        <div className="">
          {/* Profile Image */}
          <img
            src="profile-image.jpg"
            alt="Profile"
            className="w-32 h-32 rounded-full mx-auto"
          />
        </div>
      </div>
      <div>
        <div className="py-[3rem] h-[55%] laptop:h-[70%]">
          <NewProjectForm
            btnStyle={""}
            handleClose={function (): void {
              throw new Error("Function not implemented.");
            }}
          />
        </div>
      </div>
    </div>
  );
}

export default ProfilePage;
