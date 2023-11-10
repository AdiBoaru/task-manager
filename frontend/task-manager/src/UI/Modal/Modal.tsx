import { ReactNode } from "react";
import Button from "../Button/Button";

type TModal = {
  children?: ReactNode;
  isOpen?: boolean;
  handleClose?: () => void;
};

const Modal = ({ isOpen, children, handleClose }: TModal) => {
  return isOpen ? (
    <div className="absolute flex items-center justify-center flex-col bg-primaryColor bg-opacity-[95%] h-full w-full z-50  border border-secondaryColor">
      {children}
      <Button
        testId="cancel-button"
        type="button"
        style="text-gray-500 text-xl border border-gray-500 rounded-[10px] py-3 mx-4 my-7 w-[25rem] hover:font-semibold hover:text-white hover:bg-gray-500 "
        onClick={handleClose}
      >
        Cancel
      </Button>
    </div>
  ) : null;
};

export default Modal;
