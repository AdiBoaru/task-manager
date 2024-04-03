import Button from "../UI/Button/Button";
import { useModal } from "../hooks/useModal";

import { TTeamPick } from "../interfaces/TCreateProjectData";
import { TEmployeesPick } from "../interfaces/TCreateTeamData";

export const renderTableDataContent = (
  data: string | TEmployeesPick[] | TTeamPick | any,
  id: number,
  deleteHandler: (
    e: React.MouseEvent<HTMLButtonElement, MouseEvent>,
    id: number,
    action: "edit" | "delete"
  ) => void
) => {
  let content;
  const { openModalHandler } = useModal();

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
    const hasEditKey = Object.hasOwn(data, "edit");

    content = hasEditKey ? (
      <div className="flex items-center justify-center w-fit gap-3">
        <Button
          type="button"
          testId="edit-icon-button"
          onClick={(e) => openModalHandler(e, "editTeam")}
        >
          {data.edit.editIcon}
        </Button>
        <Button
          type="button"
          testId="trash-icon-button"
          onClick={(e) => deleteHandler(e, id, "delete")}
        >
          {data.edit.trashIcon}
        </Button>
      </div>
    ) : (
      data.name
    );
  } else {
    content = data;
  }

  return content;
};
