import Input from "../../UI/Input/Input";

const SearchBar = () => {
  return (
    <Input
      type="text"
      inputStyle="text-white bg-primaryColor border border-secondaryColor rounded-[30px] min-w-[50vw] h-[40px] px-10 focus:outline-none focus:border-[2px]"
      placeholder="Search..."
    />
  );
};

export default SearchBar;
