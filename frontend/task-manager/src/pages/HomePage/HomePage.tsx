import { AiOutlineUsergroupAdd } from "react-icons/ai";
import { HiOutlineViewGridAdd } from "react-icons/hi";
import Button from "../../UI/Button/Button";
import WebSocket from "../../components/WebSocket/WebSocket";
import { useModal } from "../../hooks/useModal";
import NewTeamModal from "../../UI/Modal/NewTeamModal/NewTeamModal";
import NewTeamForm from "../../components/Forms/NewTeamForm/NewTeamForm";
import NewProjectForm from "../../components/Forms/NewProjectForm/NewProjectForm";
import NewProjectModal from "../../UI/Modal/NewProjectModal/NewProjectModal";
import { useState } from "react";

const HomePage = () => {
  const { openModal, onClose, open } = useModal();
  const [isProject, setIsProject] = useState(false);

  return (
    <div className="relative bg-primaryColor h-[calc(100vh-200px)]">
      <div className="absolute transform -translate-x-1/2 -translate-y-1/2 top-1/2 left-1/2 flex justify-around w-[70%]">
        {/* <WebSocket></WebSocket> */}
        <Button
          style={
            "hover:shadow-[0_5px_30px_rgba(239,_239,_249,_0.4)] cursor-pointer flex flex-col items-center justify-center bg-white h-[400px] w-[500px] rounded-[20px] border-[2px] border-secondaryColor text-xl font-bold"
          }
          type="button"
          testId="homePage-addProject-btn"
          onClick={() => {
            openModal();
            setIsProject(true);
          }}
        >
          <span className="text-[40px]">
            <HiOutlineViewGridAdd />
          </span>{" "}
          Create new team
        </Button>
        {isProject && (
          <NewTeamModal
            confirmBtnForm="create-new-team-form"
            onClose={onClose}
            onConfirm={() => {}}
            open={open}
            btnText="Create"
          >
            <NewTeamForm onSuccess={onClose} />
          </NewTeamModal>
        )}
        <Button
          style={
            "hover:shadow-[0_5px_30px_rgba(239,_239,_249,_0.4)] cursor-pointer flex flex-col items-center justify-center bg-white h-[400px] w-[500px] rounded-[20px] border-[2px] border-secondaryColor text-xl font-bold"
          }
          type="button"
          testId="homePage-createTeam-btn"
          onClick={() => {
            openModal();
            setIsProject(false);
          }}
        >
          <span className="text-[40px]">
            <AiOutlineUsergroupAdd />
          </span>{" "}
          Add new project
        </Button>
        {!isProject && (
          <NewProjectModal
            confirmBtnForm="create-new-project-form"
            onClose={onClose}
            open={open}
            onConfirm={() => {}}
            btnText="Create"
          >
            <NewProjectForm onSuccess={onClose} />
          </NewProjectModal>
        )}
      </div>
    </div>
  );
};

export default HomePage;
