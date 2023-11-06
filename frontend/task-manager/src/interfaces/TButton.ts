import { ReactNode } from "react";

export type TButton = {
    type: "button" | "submit" | "reset";
    children: ReactNode;
    testId: string;
    onClick?: () => void;
    disabled?: boolean;
    style?: string;
}