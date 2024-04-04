import { useEffect } from "react";
import NewProfileForm from "../../components/NewProfile/NewProfileForm";

function ProfilePage() {
  useEffect(() => {
    const profilePic = document.getElementById(
      "profile-pic"
    ) as HTMLImageElement;
    const inputFile = document.getElementById("input-file") as HTMLInputElement;

    if (inputFile && profilePic) {
      inputFile.addEventListener("change", function () {
        if (inputFile.files && inputFile.files[0]) {
          profilePic.setAttribute(
            "src",
            URL.createObjectURL(inputFile.files[0])
          );
        }
      });
    }

    return () => {
      if (inputFile && profilePic) {
        inputFile.removeEventListener("change", () => {});
      }
    };
  }, []);

  return (
    <div className="flex items-center justify-around bg-primaryColor h-screen">
      <div className="items-center">
        <img
          className="object-contain py-3 mx-4 my-7 h-50 w-[25rem] items-center rounded-full"
          src="./assets/no-profile-picture-icon.svg"
          id="profile-pic"
        />
        <label
          className="px-4 text-white text-lg
     text-gray-500 text-xl border border-secondaryColor rounded-[10px] 
     py-3 mx-4 my-7 w-[25rem] hover:font-semibold 
     hover:text-primaryColor hover:bg-secondaryColor"
          htmlFor="input-file"
        >
          Update Profile Picture
        </label>
        <input
          className="hidden"
          type="file"
          accept="image/jpeg, image/png, image/jpg"
          id="input-file"
        />
      </div>
      <div>
        <NewProfileForm
          btnStyle={""}
          handleClose={function (): void {
            throw new Error("Function not implemented.");
          }}
        />
      </div>
    </div>
  );
}
export default ProfilePage;
