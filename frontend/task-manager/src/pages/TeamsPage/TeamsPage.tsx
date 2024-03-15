import { useEffect, useState } from "react";
import TeamTable from "../../UI/Table/TeamTable/TeamTable";

const TeamsPage = () => {
  const [teams, setTeams] = useState([]);
  const URL = "http://localhost:8080/team";

  useEffect(() => {
    fetch(URL)
      .then((res) => res.json())
      .then((teams) => setTeams(teams));
  }, []);


  return (
    <div className="flex items-center justify-center h-[calc(100vh-200px)] w-full bg-primaryColor text-primaryColor">
      <TeamTable  data={teams}/>
    </div>
  );
};

export default TeamsPage;
