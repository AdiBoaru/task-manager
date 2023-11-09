export type TInput = {
    type: string,
    style?: string,
    inputStyle?: string,
    placeholder?: string
    onFocus?: () => void;
    onClick?: () => void;
    onChange?: () => void;
    
}