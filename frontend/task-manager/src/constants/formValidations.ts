import * as yup from 'yup'

export const schema = yup
.object()
.shape({
    firstName: yup.string().min(2).required('First name is required'),
    lastName: yup.string().min(2).required('Last name is required'),
    email: yup.string().email("Email format is not valid").required('Email is required'),
    password: yup.string().min(6).required('Password is required'),
    confirmPassword: yup.string().oneOf([yup.ref("password")]),
    role: yup.string().required('Role is required'),
    birthDate: yup.string().required('Please choose your birth date'),
})