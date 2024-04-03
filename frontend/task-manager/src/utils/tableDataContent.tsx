import { TTeamPick } from "../interfaces/TCreateProjectData";
import { TEmployeesPick } from "../interfaces/TCreateTeamData";

export const renderContent = (data: string | TEmployeesPick[] | TTeamPick) => {
  let content;

  if (Array.isArray(data)) {
    content = (
      <ul>
        {data.length ? (
          data.map((el) => <li key={el.id}>{el.fullName}</li>)
        ) : (
          <li>-</li>
        )}
      </ul>
    );
  } else if (typeof data === "object" && data !== null) {
    content = data.name;
  } else {
    content = data;
  }

  return content;
};
