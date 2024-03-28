export type TTeamPick = {
    id: number;
    size: number;
    employees: string[];
    name: string;
}

export type TCreateProjectData = {
    name: string,
    description: string,
    team?: {},
    dueDate?: string,
}