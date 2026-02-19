function First({ name, age, grade }) {
    return (
        <>
            <div>
                <h3>Name: {name}</h3>
                <p>Age: {age}</p>
                <p>Grade: {grade}</p>
            </div>
        </>
    )
}

function App() {
    return (
        <div>
            <First name="Harshita" age={20} grade="A" />
            <First name="Janhvi" age={21} grade="B" />
            <First name="Yash" age={22} grade="A+" />
        </div>
    );
};

export default App