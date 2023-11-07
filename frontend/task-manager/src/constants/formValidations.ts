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