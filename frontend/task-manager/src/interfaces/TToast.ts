import { TypeOptions } from 'react-toastify'

export type TToast = {
    notification: (message: string, type: TypeOptions) => void,
    position?: string,
    autoClose?: number,
    theme?: string
    hideProgressBar?: boolean,
    closeOnClick?: boolean,
    pauseOnHover?: boolean,
    draggable?: boolean,
}