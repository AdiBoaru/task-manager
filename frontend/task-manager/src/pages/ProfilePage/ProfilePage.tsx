import NewProfileForm from "../../components/NewProfile/NewProfileForm";

function ProfilePage() {
  return (
    <div className="flex items-center justify-center relative bg-primaryColor h-[calc(100vh-200px)]">
      <div>
        <div className="border-b-4 border-indigo-500 ">
            <img className="object-contain h-50 w-96" src="./assets/no-profile-picture-icon.svg" alt="Profile" />
          </div>
      </div>
      <div>
        <div>
          <NewProfileForm
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
