import React from 'react';

const students = [
    { name: 'Harshita', marks: 85 },
    { name: 'Janhvi', marks: 35 },
    { name: 'Yash', marks: 45 },
    { name: 'Sourabh', marks: 30 }
];

const Fourth = () => {
    return (
        <div>
            <h2>Student List</h2>
            <ul>
                {students.map((student, index) => {
                    const status = student.marks >= 40 ? 'Pass' : 'Fail';
                    const statusStyle = student.marks >= 40 ? { color: 'green' } : { color: 'red' };

                    return (
                        <li key={index}>
                            {student.name} - Marks: {student.marks} -{' '}
                            <span style={statusStyle}>{status}</span>
                        </li>
                    );
                })}
            </ul>
        </div>
    );
};

export default Fourth;
