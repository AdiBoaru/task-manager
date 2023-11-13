import { useState } from "react";
import { ASC, DESC } from "../constants/sort-constants";

const useTable = () => {
    const [sort,setSort] = useState({keyToSort: 'PROJECT NAME', direction: ASC});
    console.log(sort);
    
    const handleSortClick = ({header, key} : any) => {
        setSort({keyToSort: key,
        direction: key === sort.keyToSort ? sort.direction === ASC ? DESC : ASC : DESC
        })
    }

    return {sort, handleSortClick}

}

export default useTable;