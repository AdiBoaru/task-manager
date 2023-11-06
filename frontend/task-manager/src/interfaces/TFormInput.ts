import { RegisterOptions } from "react-hook-form";

export type TFormInput = {
    inputId: string;
    name: string;
    placeholder:string;
    testId: string;
    labelText: string;
    type: string;
    errorTestId?: string;
    inputTestId?: string;
    validation?:  RegisterOptions;
    labelStyle?: string;
    inputStyle?: string;
}