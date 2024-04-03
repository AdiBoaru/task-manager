import { useDispatch, useSelector } from "react-redux";
import {
  selectIsModalOpen,
  openModal,
  closeModal,
} from "../store/slices/modalSlice";
import { useState } from "react";
import NewTeamForm from "../components/Forms/NewTeamForm/NewTeamForm";
import EditTeamForm from "../components/Forms/EditTeamForm/EditTeamForm";
import NewProjectForm from "../components/Forms/NewProjectForm/NewProjectForm";

export const useModal = () => {
  const dispatch = useDispatch();
  const isOpen = useSelector(selectIsModalOpen);
  const [modalContent, setModalContent] = useState<any>(null);

  const openModalHandler = (e: any, modalType: string) => {
    e.stopPropagation();
    dispatch(openModal());
    setModalContent(getModalContent(modalType));
  };

  const closeModalHandler = () => {
    dispatch(closeModal());
  };

  const getModalContent = (modalType: string) => {
    switch (modalType) {
      case "addTeam":
        return <NewTeamForm handleClose={closeModalHandler} />;
      case "editTeam":
        return <EditTeamForm handleClose={closeModalHandler} />;
      case "addProject":
        return (
          <NewProjectForm
            btnStyle={"w-[25rem]"}
            handleClose={closeModalHandler}
          />
        );

      default:
        return null;
    }
  };

  return { isOpen, openModalHandler, closeModalHandler, modalContent };
};
