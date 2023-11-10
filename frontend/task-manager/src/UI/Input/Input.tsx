import { TInput } from "../../interfaces/TInput";

const Input = ({
  style,
  inputStyle,
  type,
  placeholder,
  onFocus,
  onClick,
  onChange,
}: TInput) => {
  return (
    <div className={style}>
      <input
        className={inputStyle}
        type={type}
        placeholder={placeholder}
        onFocus={onFocus}
        onClick={onClick}
        onChange={onChange}
      />
    </div>
  );
};

export default Input;
