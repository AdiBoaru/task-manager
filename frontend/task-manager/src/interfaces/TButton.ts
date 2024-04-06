import { ReactNode } from "react";

export type TButton = {
  type: "button" | "submit" | "reset";
  children: ReactNode;
  testId: string;
  onClick?: (e: React.MouseEvent<HTMLButtonElement>) => any;
  disabled?: boolean;
  style?: string;
  id?: string;
};
