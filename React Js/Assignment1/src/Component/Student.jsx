import "./Student.css";

function Student() {
    return (
        <div className="container">
            <h2>STUDENT REGISTRATION FORM</h2>

            <form>
                <div className="row">
                    <label>FIRST NAME</label>
                    <input type="text" />
                    <span>(max 30 characters a-z and A-Z)</span>
                </div>

                <div className="row">
                    <label>LAST NAME</label>
                    <input type="text" />
                    <span>(max 30 characters a-z and A-Z)</span>
                </div>

                <div className="row">
                    <label>DATE OF BIRTH</label>
                    <select><option>Day</option></select>
                    <select><option>Month</option></select>
                    <select><option>Year</option></select>
                </div>

                <div className="row">
                    <label>EMAIL ID</label>
                    <input type="email" />
                </div>

                <div className="row">
                    <label>MOBILE NUMBER</label>
                    <input type="text" />
                    <span>(10 digit number)</span>
                </div>

                <div className="row">
                    <label>GENDER</label>
                    <input type="radio" name="gender" /> Male
                    <input type="radio" name="gender" /> Female
                </div>

                <div className="row">
                    <label>ADDRESS</label>
                    <textarea />
                </div>

                <div className="row">
                    <label>CITY</label>
                    <input type="text" />
                </div>

                <div className="row">
                    <label>PIN CODE</label>
                    <input type="text" />
                </div>

                <div className="row">
                    <label>STATE</label>
                    <input type="text" />
                </div>

                <div className="row">
                    <label>COUNTRY</label>
                    <input type="text" value="India" readOnly />
                </div>

                <div className="row">
                    <label>HOBBIES</label>
                    <input type="checkbox" /> Drawing
                    <input type="checkbox" /> Singing
                    <input type="checkbox" /> Dancing
                    <input type="checkbox" /> Sketching
                    <br />
                    Others <input type="text" />
                </div>

                <h4>QUALIFICATION</h4>
                <table>
                    <thead>
                        <tr>
                            <th>Sl.No</th>
                            <th>Examination</th>
                            <th>Board</th>
                            <th>Percentage</th>
                            <th>Year of Passing</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr><td>1</td><td>Class X</td><td><input /></td><td><input /></td><td><input /></td></tr>
                        <tr><td>2</td><td>Class XII</td><td><input /></td><td><input /></td><td><input /></td></tr>
                        <tr><td>3</td><td>Graduation</td><td><input /></td><td><input /></td><td><input /></td></tr>
                        <tr><td>4</td><td>Masters</td><td><input /></td><td><input /></td><td><input /></td></tr>
                    </tbody>
                </table>

                <div className="row">
                    <label>COURSES APPLIED FOR</label>
                    <input type="radio" name="course" /> BCA
                    <input type="radio" name="course" /> B.Com
                    <input type="radio" name="course" /> B.Sc
                    <input type="radio" name="course" /> B.A
                </div>

                <div className="buttons">
                    <button type="submit">Submit</button>
                    <button type="reset">Reset</button>
                </div>
            </form>
        </div>
    );
}

export default Student;