import { ReactNode } from "react";

type TModal = {
  children?: ReactNode;
  isOpen?: boolean;
};

const Modal = ({ isOpen, children }: TModal) => {
  return isOpen ? (
    <div className="relative flex justify-center items-center bg-opacity-[90%] bg-primaryColor h-full w-full">
      {children}
    </div>
  ) : null;
};

export default Modal;
