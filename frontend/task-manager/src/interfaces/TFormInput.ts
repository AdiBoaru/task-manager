import { RegisterOptions } from "react-hook-form";

export type TFormInput = {
    inputId: string;
    name: string;
    placeholder:string;
    testId: string;
    validation?:  RegisterOptions;
    labelText: string;
    type: string;
    labelStyle?: string;
    inputStyle?: string;
}