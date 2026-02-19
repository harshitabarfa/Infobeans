function validateForm() {
    let valid = true;

    let name = document.getElementById("fullname");
    if (!/^[A-Za-z ]+$/.test(name.value)) {
        document.getElementById("nameError").innerText = "Enter valid name";
        name.className = "error";
        valid = false;
    } else {
        name.className = "success";
        document.getElementById("nameError").innerText = "";
    }

    let dob = document.getElementById("dob");
    let birthDate = new Date(dob.value);
    let age = new Date().getFullYear() - birthDate.getFullYear();
    if (!dob.value || age < 18) {
        document.getElementById("dobError").innerText = "Must be 18 or older";
        dob.className = "error";
        valid = false;
    } else {
        dob.className = "success";
        document.getElementById("dobError").innerText = "";
    }

    let gender = document.querySelector('input[name="gender"]:checked');
    if (!gender) {
        document.getElementById("genderError").innerText = "Select gender";
        valid = false;
    } else {
        document.getElementById("genderError").innerText = "";
    }

    let email = document.getElementById("email");
    if (!/^\S+@\S+\.\S+$/.test(email.value)) {
        document.getElementById("emailError").innerText = "Invalid email";
        email.className = "error";
        valid = false;
    } else {
        email.className = "success";
        document.getElementById("emailError").innerText = "";
    }

    let username = document.getElementById("username");
    if (username.value.length < 5 || /[^a-zA-Z0-9]/.test(username.value)) {
        document.getElementById("usernameError").innerText = "Invalid username";
        username.className = "error";
        valid = false;
    } else {
        username.className = "success";
        document.getElementById("usernameError").innerText = "";
    }

    let password = document.getElementById("password");
    if (!/(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&]).{8,}/.test(password.value)) {
        document.getElementById("passwordError").innerText = "Weak password";
        password.className = "error";
        valid = false;
    } else {
        password.className = "success";
        document.getElementById("passwordError").innerText = "";
    }

    let confirmPassword = document.getElementById("confirmPassword");
    if (confirmPassword.value !== password.value) {
        document.getElementById("confirmPasswordError").innerText = "Passwords do not match";
        confirmPassword.className = "error";
        valid = false;
    } else {
        confirmPassword.className = "success";
        document.getElementById("confirmPasswordError").innerText = "";
    }

    let mobile = document.getElementById("mobile");
    if (!/^\d{10}$/.test(mobile.value)) {
        document.getElementById("mobileError").innerText = "Enter 10-digit number";
        mobile.className = "error";
        valid = false;
    } else {
        mobile.className = "success";
        document.getElementById("mobileError").innerText = "";
    }

    let country = document.getElementById("country");
    if (country.value === "") {
        document.getElementById("countryError").innerText = "Select country";
        country.className = "error";
        valid = false;
    } else {
        country.className = "success";
        document.getElementById("countryError").innerText = "";
    }

    let skills = document.querySelectorAll(".skill:checked");
    if (skills.length < 2) {
        document.getElementById("skillError").innerText = "Select at least 2 skills";
        valid = false;
    } else {
        document.getElementById("skillError").innerText = "";
    }

    let exp = document.getElementById("experience");
    if (exp.value === "") {
        document.getElementById("experienceError").innerText = "Select experience";
        exp.className = "error";
        valid = false;
    } else {
        exp.className = "success";
        document.getElementById("experienceError").innerText = "";
    }

    let salary = document.getElementById("salary");
    if (isNaN(salary.value) || salary.value <= 0) {
        document.getElementById("salaryError").innerText = "Invalid salary";
        salary.className = "error";
        valid = false;
    } else {
        salary.className = "success";
        document.getElementById("salaryError").innerText = "";
    }

    let terms = document.getElementById("terms");
    if (!terms.checked) {
        document.getElementById("termsError").innerText = "Accept terms";
        valid = false;
    } else {
        document.getElementById("termsError").innerText = "";
    }
    return valid;
}
