import { ReactElement } from "react";
import { useSelector } from "react-redux";
import useDelete from "../../hooks/useDelete";

interface IConfirmDelete {
  content?: string | ReactElement;
  title?: string | ReactElement;
  onSuccess: () => void;
  modalId: string | number;
}

const ConfirmDelete = ({
  content,
  title,
  onSuccess,
  modalId,
}: IConfirmDelete) => {
  const pageContext = useSelector((state: any) => state.tableContext);
  const deleteHandler = useDelete(pageContext);

  const onSubmit = (e: any) => {
    e.preventDefault();
    console.log(modalId);
    deleteHandler(modalId);
    onSuccess();
  };

  return (
    <form id="confirm-delete-modal" onSubmit={onSubmit}>
      {title}
      <p className="text-secondaryColor">{content}</p>
    </form>
  );
};

export default ConfirmDelete;
