import { useFormContext } from "react-hook-form";
import { ErrorMessage } from "@hookform/error-message";

import { TFormInput } from "../../interfaces/TFormInput";

const FormInput = ({
  inputId,
  labelText,
  inputName,
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
    <>
      <label className={labelStyle} htmlFor={inputId}>
        {labelText}
      </label>
      <div>
        <input
          className={inputStyle}
          type={type}
          placeholder={placeholder}
          {...register(inputName)}
        />
        <ErrorMessage
          errors={errors}
          name={inputName}
          render={({ message }) => <p>{message}</p>}
        />
      </div>
    </>
  );
};

export default FormInput;
