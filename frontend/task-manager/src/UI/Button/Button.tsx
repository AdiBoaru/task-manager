import { TButton } from "../../interfaces/TButton";

const Button = ({ testId, type, children, onClick, style }: TButton) => {
  return (
    <button
      data-testid={testId}
      type={type}
      className={style}
      onClick={onClick}
    >
      {children}
    </button>
  );
};

export default Button;
