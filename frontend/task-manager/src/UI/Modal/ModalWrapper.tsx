import React, { FC, ReactElement } from "react";
import { Modal as ModalComponent, ModalProps } from "react-responsive-modal";
import "react-responsive-modal/styles.css";
import Button from "../Button/Button";

interface IModalProps extends ModalProps {
  onConfirm: () => void;
  formId: string | undefined;
  btnText: string | ReactElement;
}

const ModalWrapper: FC<React.PropsWithChildren<IModalProps>> = (
  props: IModalProps
) => {
  const { children, onConfirm, onClose, formId, btnText } = props;

  return (
    <ModalComponent {...props} modalId="modal" center>
      {children}
      <Button
        testId="create-button"
        type="submit"
        style="text-secondaryColor text-xl border border-secondaryColor rounded-[10px] py-3 w-[25rem] hover:font-semibold hover:text-primaryColor hover:bg-secondaryColor "
        id={formId}
        onClick={onConfirm}
      >
        {btnText}
      </Button>
      <Button
        testId="cancel-button"
        type="button"
        style={`text-gray-500 text-xl border border-gray-500 rounded-[10px] py-3 w-[25rem] hover:font-semibold hover:text-white hover:bg-gray-500`}
        onClick={onClose}
      >
        Cancel
      </Button>
    </ModalComponent>
  );
};

export default ModalWrapper;
