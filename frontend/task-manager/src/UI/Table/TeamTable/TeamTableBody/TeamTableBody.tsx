const TeamTableBody = ({ entries, columns }: any) => {
    console.log("Entries:", entries);
    return (
      <tbody className="bg-gray-50 h-[200px] ">
        {entries.map((entry: any) => (
          <tr key={entry.id}>
            {columns.map(({ key }: any) => (
              <td className="p-5 border-b-2" key={key}>
                  {key === "employeesTeam" ? (
                // Display the names of employees in the team
                <ul>
                  {entry.employees.map((employee: any) => (
                    <li key={employee.id}>{employee.firstName} {employee.lastName}</li>
                  ))}
                </ul>
               /* {key === "edit" ? (
                  <div>
                    {entry[key] && entry[key].map((editItem: any, index: number) => (
                      <div key={index} className="flex space-x-2">
                        {editItem.trashIcon}
                        {editItem.editIcon}
                      </div>
                    ))}
                  </div>
                  */
                ) : (
                  entry[key]
                )}
              </td>
            ))}
          </tr>
        ))}
      </tbody>
    );
  };

  export default TeamTableBody;
  