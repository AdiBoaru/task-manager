import { useLocation, useNavigate } from "react-router-dom";
import { renderContent } from "../../../utils/tableDataContent";

const TableBody = ({ entries }: any) => {
  const navigate = useNavigate();
  const location = useLocation();

  const handleRowClick = (entryId: string) => {
    navigate(`${location.pathname}/${entryId}`);
  };

  return (
    <tbody className="bg-gray-50 ">
      {entries.map((entry: any) => {
        const rowData = Object.values(entry);

        return (
          <tr
            key={entry.name}
            className="bg-gray-200 bg-opacity-25 cursor-pointer hover:bg-opacity-50"
            onClick={() => handleRowClick(entry.id)}
          >
            {rowData.map((item: any, idx) => (
              <td key={idx} className="p-5 border-b-2">
                {renderContent(item)}
              </td>
            ))}
          </tr>
        );
      })}
    </tbody>
  );
};

export default TableBody;
