import { useEffect } from "react";
import NewProfileForm from "../../components/NewProfile/NewProfileForm";


function ProfilePage() {
  useEffect(() => {
    const profilePic = document.getElementById("profile-pic") as HTMLImageElement;
    const inputFile = document.getElementById("input-file") as HTMLInputElement;

    const handleFileChange = () => {
      if (inputFile.files && inputFile.files[0]) {
        const file = inputFile.files[0];
        profilePic.setAttribute("src", URL.createObjectURL(file));

        // Assuming you have a function to upload the file to the backend API
        uploadFileToBackend(file);
      }
    };

    if (inputFile && profilePic) {
      inputFile.addEventListener("change", handleFileChange);
    }

    return () => {
      if (inputFile && profilePic) {
        inputFile.removeEventListener("change", handleFileChange);
      }
    };
  }, []);

  const uploadFileToBackend = (file : any) => {
    // Replace the {id} with the actual ID you want to send
    const url = `/register/image/{id}`;

    // Create form data and append the file
    const formData = new FormData();
    formData.append("profilePic", file);

    // Send a POST request to the backend API
    fetch(url, {
      method: "PUT",
      body: formData,
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("Failed to upload profile picture");
        }
        // Handle success if needed
      })
      .catch((error) => {
        console.error("Error uploading profile picture:", error);
        // Handle error if needed
      });
  };


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
