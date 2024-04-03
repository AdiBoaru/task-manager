import Modal from "../../UI/Modal/Modal";
import Table from "../../UI/Table/Table";
import EditTeamForm from "../../components/Forms/EditTeamForm/EditTeamForm";
import { useModal } from "../../hooks/useModal";
import { useGetTeamsQuery } from "../../services/TeamsApi/api";

const TeamsPage = () => {
  const { data: teams } = useGetTeamsQuery();
  const { isOpen, modalContent } = useModal();

  return (
    // <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
    <div className="relative bg-primaryColor h-[calc(100vh-200px)]">
      <div className="absolute transform -translate-x-1/2 -translate-y-1/2 top-1/2 left-1/2 flex justify-around w-[70%]">
        <Table data={teams} />
      </div>
      {isOpen && <Modal isOpen={isOpen}>{modalContent}</Modal>}
    </div>
    // </div>
  );
};

export default TeamsPage;
