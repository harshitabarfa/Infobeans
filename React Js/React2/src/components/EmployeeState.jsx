import { useState } from "react";

function EmployeeState() {
    const [employees, setEmployees] = useState([
        { id: 101, name: "harshita", department: "IT", salary: 50000 },
        { id: 102, name: "janvi", department: "CS", salary: 60000 },
        { id: 103, name: "amit", department: "HR", salary: 70000 }
    ])

    return (
        <>
            <h2>Employee details</h2>

            <table border="1">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Department</th>
                        <th>Salary</th>
                    </tr>
                </thead>
                <tbody>
                    {
                        employees.map((emp) => (
                            <tr key={emp.id}>
                                <td>{emp.id}</td>
                                <td>{emp.name}</td>
                                <td>{emp.department}</td>
                                <td>{emp.salary}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </>
    )
}

export default EmployeeState