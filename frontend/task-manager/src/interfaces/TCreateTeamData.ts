import { TCreateProjectData } from "./TCreateProjectData";

export type TEmployeesPick = {
  fullName: string;
  account: any | null;
  birthDate: string;
  firstName: string;
  id: number;
  lastName: string;
  projects: TCreateProjectData[];
  tasks: any[];
};

export type TTeamSizePick = {
  label: string;
  value?: number;
};

export type TCreateTeamData = {
  name: string;
  employees: TEmployeesPick[];
  size: number | string;
};
