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
  testId,
  errorTestId,
  inputTestId,
}: TFormInput) => {
  const {
    register,
    formState: { errors },
  } = useFormContext();

  return (
    <div data-testid={testId} className="h-[7rem] m-1">
      <label className={labelStyle} htmlFor={inputId}>
        {labelText}
      </label>
      <div>
        <input
          data-testid={inputTestId}
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
            <p data-testid={errorTestId} className="text-red-600 pl-3">
              {message}
            </p>
          )}
        />
      </div>
    </div>
  );
};

export default FormInput;
