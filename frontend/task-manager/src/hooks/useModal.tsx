import { useState } from "react";

export const useModal = (initialState = false) => {
  const [open, setOpen] = useState<boolean>(initialState);
  const [modalId, setModalId] = useState<number | string>("");

  const onClose = () => {
    setOpen(!open);
  };

  const openModal = (id?: string | number) => {
    if (id) {
      setModalId(id);
    }
    setOpen(true);
  };

  return {
    open,
    modalId,
    onClose,
    openModal,
  };
};
