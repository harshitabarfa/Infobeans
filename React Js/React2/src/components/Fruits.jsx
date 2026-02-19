import { useState } from "react"

function Fruits() {
    const [fruits, setFruits] = useState(["Apple", "Mango"]);
    const [fruitName, setFruitName] = useState("");

    const addFruit = () => {
        if(fruitName.trim() !== "") {
        setFruits([...fruits, fruitName]);
        setFruitName("");
        }
    }

    return (
        <>
        <h2>Add Fruits</h2>
        <input type="text" value={fruitName} onChange={(e) => setFruitName(e.target.value)} placeholder="Enter fruit name"/>

        <ul>
            {
                fruits.map((f, index) => (
                    <li key={index}>{f}</li>
                ))
            }
            <button onClick={addFruit}>Add fruit</button>
        </ul>
        </>
    )
}

export default Fruits