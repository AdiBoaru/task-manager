export type TEmployeesCount = {
    label: string;
  value?: string;
  id?: string;
}

export type TCreateProjectData = {
    projectName: string,
    description: string,
    employeesCount?: string,
    releaseDate?: string,
}