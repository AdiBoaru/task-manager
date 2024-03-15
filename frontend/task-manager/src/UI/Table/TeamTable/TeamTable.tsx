import { useEffect, useState } from "react";
import { headerDataTeam } from "../../../constants/tableTeamResource";
import TeamTableHeader from "./TeamTableHeader/TeamTableHeader";
import TeamTableBody from "./TeamTableBody/TeamTableBody";

const TeamTable = ({ data }: { data: any[] }) => {
  const [dataInfo, setDataInfo] = useState([]);

  const url = "http://localhost:8080/team";
  useEffect(() => {
    fetch(url)
      .then((res) => res.json())
      .then((res) => setDataInfo(res));
  }, []);

  console.log(dataInfo);
  return (
    <div className="flex flex-col items-start ">
      <div className="overflow-y-scroll scrollbar h-[70vh] rounded-t-[20px]">
        {data.length ? (
          <table className="h-[100vh] w-[70vw]">
            <TeamTableHeader />
            <TeamTableBody entries={data} columns={headerDataTeam} />
          </table>
        ) : (
          <p>No data</p>
        )}
      </div>
      <p className="text-white">Teams: {data.length}</p>
    </div>
  );
};

export default TeamTable;
