import { RegisterOptions } from "react-hook-form";

export type TFormInput = {
    inputId: string;
    inputName: string;
    placeholder:string;
    validation?:  RegisterOptions;
    labelText: string;
    type: string;
    labelStyle?: string;
    inputStyle?: string;
}