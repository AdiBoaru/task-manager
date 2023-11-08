import {toast, TypeOptions} from 'react-toastify';

import { TToast } from '../interfaces/TToast';

const useToastify = (): TToast => {
    const notification = (message: string, type: TypeOptions) => {
        toast(message, {
            type,
            position: 'bottom-center',
            autoClose: 5000,
            hideProgressBar: false,
            closeOnClick: true,
            pauseOnHover: true,
            draggable: true,
            theme: 'light'
        });
    };

    return { notification };
}

export default useToastify;

