import { TButton } from "../../interfaces/TButton";

const Button = ({ testId, type, children, onClick, style, id }: TButton) => {
  return (
    <button
      data-testid={testId}
      type={type}
      className={style}
      onClick={onClick}
      form={id}
    >
      {children}
    </button>
  );
};

export default Button;
