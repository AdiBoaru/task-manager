import { ReactNode } from "react";

export type TButton = {
    type: "button" | "submit" | "reset";
    children: ReactNode;
    onClick: () => void;
    disabled?: boolean;
    style?: string;
}