import { TButton } from "../../interfaces/TButton";

const Button = ({ type, children, onClick, style }: TButton) => {
  return (
    <button type={type} className={style} onClick={onClick}>
      {children}
    </button>
  );
};

export default Button;
