import { useState } from "react";


const useModal = () => {
    const [isOpen, setIsOpen] = useState(false);
    const [modalContent, setModalContent] = useState<React.ReactNode | null>(null);
  
    const openModalHandler = (content: React.ReactNode) => {
      setIsOpen(true);
      setModalContent(content);
    };
  
    const closeModalHandler = () => {
      setIsOpen(false);
    };
  
    return { isOpen, modalContent, openModalHandler, closeModalHandler };
  };
  
  export default useModal;