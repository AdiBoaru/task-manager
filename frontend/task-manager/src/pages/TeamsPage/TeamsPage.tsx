import DeleteModal from "../../UI/Modal/DeleteModal/DeleteModal";
import TeamTableModal from "../../UI/Modal/TeamTableModal/TeamTableModal";
import Table from "../../UI/Table/Table";
import EditTeamForm from "../../components/Forms/EditTeamForm/EditTeamForm";
import { useModal } from "../../hooks/useModal";
import {
  useGetTeamsQuery,
  useGetTeamByIdQuery,
} from "../../services/TeamsApi/api";
import ConfirmDelete from "../../UI/ConfirmDelete/ConfirmDelete";
import { useState } from "react";

const TeamsPage = () => {
  const { data: teams } = useGetTeamsQuery();
  const { onClose, open, openModal, modalId } = useModal();
  const { data: team, isFetching } = useGetTeamByIdQuery(modalId);
  const [isConfirmationModal, setIsConfirmationModal] = useState(false);

  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      <Table
        data={teams}
        openModal={openModal}
        setIsConfirmationModal={setIsConfirmationModal}
      />
      {team && !isFetching && !isConfirmationModal && (
        <TeamTableModal
          confirmBtnForm="edit-team-form"
          onClose={onClose}
          open={open}
          btnText="Edit"
        >
          <EditTeamForm onSuccess={onClose} prefillFormData={team} />
        </TeamTableModal>
      )}
      {isConfirmationModal && (
        <DeleteModal
          confirmBtnForm="confirm-delete-modal"
          onClose={onClose}
          open={open}
          btnText="Confirm"
        >
          <ConfirmDelete
            onSuccess={onClose}
            modalId={modalId}
            title={
              <p className="text-white">
                You are about to delete <strong>{team?.name}</strong>
              </p>
            }
            content="Are you sure you want to proceed"
          />
        </DeleteModal>
      )}
    </div>
  );
};

export default TeamsPage;
