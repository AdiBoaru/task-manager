import { ReactNode } from "react";
import Button from "../Button/Button";

type TModal = {
  children?: ReactNode | any;
  isOpen?: boolean;
  handleClose?: () => void;
};

const Modal = ({ isOpen, children, handleClose }: TModal) => {
  console.log(children?.type.name);
  return isOpen ? (
    <div className="relative flex items-center justify-center flex-col bg-opacity-[90%] bg-primaryColor h-full w-full z-2">
      {children}
      <Button
        testId="cancel-button"
        type="button"
        style={`absolute ${
          children?.type.name === "NewTeamForm"
            ? "bottom-[32%]"
            : "bottom-[25%]"
        } z-[10] text-gray-500 text-xl border border-gray-500 rounded-[10px] py-3 mx-4 my-7 w-[25rem] hover:font-semibold hover:text-white hover:bg-gray-500`}
        onClick={handleClose}
      >
        Cancel
      </Button>
    </div>
  ) : null;
};

export default Modal;
