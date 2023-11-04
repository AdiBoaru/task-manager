export type TRegisterFormData = {
    firstName: string;
    lastName: string;
    email: string;
    password?: string;
    confirmPassword?: string;
    role?: any;  // < this will be updated later after we get the roles
    birthDate?: string;
}