import { useState } from "react";
import { ASC } from "../constants/sort-constants";

const useTable = () => {
    const [sort,setSort] = useState({colTitle: 'Id', direction: ASC});
     
    const handleSortClick = ( newSorting: {colTitle: string, direction: string} ) => {
        setSort(newSorting)
    }
    
    return {sort, handleSortClick}

}

export default useTable;