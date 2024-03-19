const TableBody = ({ entries }: any) => {
  return (
    <tbody className="bg-gray-50 ">
      {entries.map((entry: any) => {
        const test = Object.values(entry);

        return (
          <tr key={entry.id}>
            {test.map((item: any, idx) => (
              <td key={idx} className="p-5 border-b-2">
                {Array.isArray(item) ? "test" : item}
              </td>
            ))}
          </tr>
        );
      })}
    </tbody>
  );
};

export default TableBody;
