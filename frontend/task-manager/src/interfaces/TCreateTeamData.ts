export type TEmployeesPick = {
    label: string;
    value?: string;
    id?: string;
  };

export type TCreateTeamData = {
    teamName: string,
    employeesPick?: TEmployeesPick[],
}