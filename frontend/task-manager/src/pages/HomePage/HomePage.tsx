import { AiOutlineUsergroupAdd } from "react-icons/ai";
import { HiOutlineViewGridAdd } from "react-icons/hi";
import Button from "../../UI/Button/Button";
import useModal from "../../hooks/useModal";
import NewProjectForm from "../../components/NewProjectForm/NewProjectForm";
import NewTeamForm from "../../components/NewTeamForm/NewTeamForm";
import Modal from "../../UI/Modal/Modal";

const HomePage = () => {
  const { isOpen, modalContent, openModalHandler, closeModalHandler } =
    useModal();

  return (
    <div className="relative bg-primaryColor h-[calc(100vh-200px)]">
      <div className="absolute transform -translate-x-1/2 -translate-y-1/2 top-1/2 left-1/2 flex justify-around w-[70%]">
        <Button
          style={
            "hover:shadow-[0_5px_30px_rgba(239,_239,_249,_0.4)] cursor-pointer flex flex-col items-center justify-center bg-white h-[400px] w-[500px] rounded-[20px] border-[2px] border-secondaryColor text-xl font-bold"
          }
          type="button"
          testId="homePage-addProject-btn"
          onClick={() =>
            openModalHandler(
              <NewProjectForm
                handleClose={closeModalHandler}
                btnStyle={"w-[25rem]"}
              />
            )
          }
        >
          <span className="text-[40px]">
            <HiOutlineViewGridAdd />
          </span>{" "}
          Add project
        </Button>
        <Button
          style={
            "hover:shadow-[0_5px_30px_rgba(239,_239,_249,_0.4)] cursor-pointer flex flex-col items-center justify-center bg-white h-[400px] w-[500px] rounded-[20px] border-[2px] border-secondaryColor text-xl font-bold"
          }
          type="button"
          testId="homePage-createTeam-btn"
          onClick={() =>
            openModalHandler(<NewTeamForm handleClose={closeModalHandler} />)
          }
        >
          <span className="text-[40px]">
            <AiOutlineUsergroupAdd />
          </span>{" "}
          Create a team
        </Button>
      </div>
      {isOpen && (
        <Modal closeModal={closeModalHandler} isOpen={isOpen}>
          {modalContent}
        </Modal>
      )}
    </div>
  );
};

export default HomePage;
