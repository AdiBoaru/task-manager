export type TEmployeesCount = {
    label: string;
    value?: string;
    id?: string;
}

export type TCreateProjectData = {
    title: string,
    description: string,
    teamSize?: string,
    dueDate?: string,
}