import NewProjectForm from "../../components/NewProjectForm/NewProjectForm";

function ProfilePage() {
  return (
    <div className="flex justify-center items-center min-h-screen bg-gray-100">
    <div className="max-w-3xl bg-white shadow-md rounded-md p-8 flex">

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
