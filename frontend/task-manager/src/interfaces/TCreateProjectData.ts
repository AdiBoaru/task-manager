export type TEmployeesCount = {
    label: string;
    value?: string;
    id?: string;
}

export type TCreateProjectData = {
    title: string,
    description: string,
    teams?: string[],
    dueDate?: string,
}