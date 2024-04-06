import { FC, ReactElement } from "react";
import ModalWrapper from "../ModalWrapper";

interface Props {
  onClose: () => void;
  onConfirm?: () => void;
  open: boolean;
  title?: string | ReactElement;
  content?: string | ReactElement;
  children: string | ReactElement;
  childrenClassName?: string;
  confirmBtnForm?: string;
  btnText: string | ReactElement;
}

const DeleteModal: FC<Props> = ({
  onConfirm,
  onClose,
  open,
  children,
  confirmBtnForm,
  btnText,
  ...rest
}) => {
  return (
    <ModalWrapper
      classNames={{
        modalContainer: "overflow-hidden",
        modal:
          "modal rounded-lg !overflow-visible bg-primaryColor border border-secondaryColor flex flex-col items-center gap-2 relative transform -translate-x-1/2 -translate-y-1/2 top-[30%] left-[40%]",
      }}
      closeIcon={<></>}
      onClose={onClose}
      open={open}
      onConfirm={() => onConfirm}
      formId={confirmBtnForm}
      btnText={btnText}
      {...rest}
    >
      {children}
    </ModalWrapper>
  );
};

export default DeleteModal;
