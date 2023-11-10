import { useState } from "react";

const useSearchBar = () => {
    const [searchInput, setSearchInput] = useState('');
    const [searchedData, setSearchedData] = useState([]);

    const filteredData = () => []

    const searchApp = (searchValue: string) => {
        setSearchInput(searchValue);
        setSearchedData(filteredData);
    }

    return {searchInput, searchedData, searchApp}
}

export default useSearchBar;