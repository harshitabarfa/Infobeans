import { useState } from "react";

function ArrayState() {
    const [tasks, setTasks] = useState([])
    const [taskInput, setTaskInput] = useState("")

    const addTask = () => {
        if (taskInput.trim() !== "") {
            setTasks([...tasks, taskInput])
            setTaskInput("");
        }
    }

    const removeTask = (indexToRemove) => {
        const updatedTask = [...tasks];
        updatedTask.splice(indexToRemove, 1);
        setTasks(updatedTask)
    }

    return (
        <>
            <h2>Task list</h2>
            <input type="text" placeholder="Enter task" value={taskInput} onChange={(e) => setTaskInput(e.target.value)} />

            <button onClick={addTask}>Add task</button>
            <ul>
                {
                    tasks.map((task, index) => (
                        <li key={index}>{task}
                            <button onClick={removeTask}>delete</button>
                        </li>
                    ))
                }
            </ul>

            <h3>{taskInput}</h3>
        </>
    )
}

export default ArrayState;