import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";

import { TFormInput } from "../../interfaces/TFormInput";

const FormInput = ({
  inputId,
  labelText,
  name,
  placeholder,
  type,
  labelStyle,
  inputStyle,
}: TFormInput) => {
  const {
    register,
    formState: { errors },
  } = useFormContext();

  return (
    <div className="h-[7rem] m-1">
      <label className={labelStyle} htmlFor={inputId}>
        {labelText}
      </label>
      <div>
        <input
          id={inputId}
          className={inputStyle}
          type={type}
          placeholder={placeholder}
          {...register(name)}
        />
        <ErrorMessage
          errors={errors}
          name={name}
          render={({ message }) => (
            <p className="text-red-600 pl-3">{message}</p>
          )}
        />
      </div>
    </div>
  );
};

export default FormInput;
