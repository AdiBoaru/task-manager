import * as yup from 'yup'

export const registerSchema = yup
.object()
.shape({
    firstName: yup.string().min(2, "First Name must be at least 2 characters long.").required('First name is required.'),
    lastName: yup.string().min(2, 'Last Name must be at least 2 characters long.').required('Last name is required.'),
    email: yup.string().email("Email format is not valid.").required('Email is required.'),
    password: yup.string().min(6, "Password must be at least 6 characters.").required('Password is required.'),
    confirmPassword: yup.string().oneOf([yup.ref("password")], "Please confirm your password."),
    role: yup.string().required('Role is required.'),
    birthDate: yup.string().required('Please choose your birth date.'),
})

export const loginSchema = yup
.object()
.shape({
    email: yup.string().email("Email or password is incorrect").required('Email is required.'),
    password: yup.string().min(6, "Email or password is incorrect").required('Password is required.'),
})

export const newProjectSchema = yup
.object()
.shape({
    name: yup.string().min(2, "Name should be at least 2 characters").required('Project name is required.'),
    description: yup.string().min(6, "Description should be at least 6 characters").required('Description is required'),
    team: yup.object().required('Team is required.'),
    dueDate: yup.string().required('Please choose your completion date.'),
})

export const newTeamSchema = yup
.object()
.shape({
    name: yup.string().matches(/^[^\d]*$/, 'Value must not contain any numbers').min(2, "Name should be at least 2 characters").required('Team name is required.'),
    employeesTeam: yup.array().required('Employees is required.'),
    size: yup.string().required('Team size is required.')
})
