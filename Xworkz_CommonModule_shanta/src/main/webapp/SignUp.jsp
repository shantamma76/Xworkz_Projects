<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignUp</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow-lg form-container">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Sign Up Form</h2>

                <c:forEach items="${error}" var="i">
                    <span style="color:red">${i.message}</span>
                </c:forEach>

                <form action="signup" method="post" onsubmit="return validateForm()">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" onChange="onNameChange()" name="name" placeholder="Enter Name">
                        <span id="nameDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" onChange="onEmailChange()" placeholder="Enter Email" required>
                        <span id="emailDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                        <label for="phoneNo" class="form-label">Phone Number</label>
                        <input type="text" class="form-control" id="phoneNo" name="phone" pattern="^[6-9]\d{9}$" onblur="onPhoneChange()" onChange="onPhoneChange()" placeholder="Enter Phone Number" required>
                        <span id="phoneDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                          <label for="alterEmail" class="form-label">Alternate Email</label>
                          <input type="email" class="form-control" id="alterEmail" onChange="onAltEmailChange()" name="alterEmail" placeholder="Enter Alternate Email" required>
                          <span id="altEmailDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                          <label for="alterPhone" class="form-label">Alternate Phone Number</label>
                          <input type="text" class="form-control" id="alterPhone" onChange="onAltPhoneChange()" name="alterPhone" placeholder="Enter Alternate Phone Number" required>
                          <span id="altPhoneNumberDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                        <label for="location" class="form-label">Location</label>
                        <select id="location" name="location" onChange="onLocationChange()">
                            <option value="">Select the option</option>
                            <c:forEach items="${listoflocation}" var="location">
                                <option value="${location}">${location}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-warning w-100">Sign Up</button>
                </form>
            </div>
        </div>
    </div>

    <!-- JavaScript Functions -->
    <script>
        // Declare variables to store input values
        var emailvalue = "";
        var alternateemailvalue = "";
        var phoneNumbervalue = "";
        var alternatephonevalue = "";

        // Name Validation
        function onNameChange() {
            var name = document.getElementById('name').value;
            if (name.trim().length < 4) {
                document.getElementById("nameDemo").innerHTML = "Name must be at least 4 characters long.";
            } else {
                document.getElementById("nameDemo").innerHTML = "";
            }
        }

        // Email Validation
        function onEmailChange() {
            emailvalue = document.getElementById('email').value;
            if (!emailvalue.match(/^[a-zA-Z0-9._%+-]+@(gmail\.com|yahoo\.com|outlook\.com|hotmail\.com|edu|org|info|net)$/)) {
                document.getElementById("emailDemo").innerHTML = "Enter a valid email address.";
            } else {
                document.getElementById("emailDemo").innerHTML = "";
            }
        }

        // Phone Number Validation
        function onPhoneChange() {
            phoneNumbervalue = document.getElementById('phoneNo').value;
            if (phoneNumbervalue.trim().length !== 10 || !phoneNumbervalue.match(/^[6-9]\d{9}$/)) {
                document.getElementById("phoneDemo").innerHTML = "Phone number must contain 10 digits and should start with 6-9.";
            } else {
                document.getElementById("phoneDemo").innerHTML = "";
            }
        }

        // Alternate Email Validation
        function onAltEmailChange() {
            alternateemailvalue = document.getElementById('alterEmail').value;
            if (!alternateemailvalue.match(/^[a-zA-Z0-9._%+-]+@(gmail\.com|yahoo\.com|outlook\.com|hotmail\.com|edu|org|info|net)$/)) {
                document.getElementById("altEmailDemo").innerHTML = "Enter a valid email address.";
            } else if (alternateemailvalue === emailvalue) {
                document.getElementById("altEmailDemo").innerHTML = "Email and Alternate Email should be different.";
            } else {
                document.getElementById("altEmailDemo").innerHTML = "";
            }
        }

        // Alternate Phone Number Validation
        function onAltPhoneChange() {
            alternatephonevalue = document.getElementById('alterPhone').value;
            if (alternatephonevalue.trim().length !== 10 || !alternatephonevalue.match(/^[6-9]\d{9}$/)) {
                document.getElementById("altPhoneNumberDemo").innerHTML = "Phone number must contain 10 digits and should start with 6-9.";
            } else if (alternatephonevalue === phoneNumbervalue) {
                document.getElementById("altPhoneNumberDemo").innerHTML = "Phone number and Alternate Phone number should be different.";
            } else {
                document.getElementById("altPhoneNumberDemo").innerHTML = "";
            }
        }

        // Form validation before submission
        function validateForm() {
            var isValid = true;
            // Name Validation
            var name = document.getElementById('name').value;
            if (name.trim().length < 4) {
                document.getElementById("nameDemo").innerHTML = "Name must be at least 4 characters long.";
                isValid = false;
            }

            // Email Validation
            var email = document.getElementById('email').value;
            if (!email.match(/^[a-zA-Z0-9._%+-]+@(gmail\.com|yahoo\.com|outlook\.com|hotmail\.com|edu|org|info|net)$/)) {
                document.getElementById("emailDemo").innerHTML = "Enter a valid email address.";
                isValid = false;
            }

            // Phone Validation
            var phone = document.getElementById('phoneNo').value;
            if (phone.trim().length !== 10 || !phone.match(/^[6-9]\d{9}$/)) {
                document.getElementById("phoneDemo").innerHTML = "Phone number must contain 10 digits and should start with 6-9.";
                isValid = false;
            }

            // Alternate Email Validation
            var altEmail = document.getElementById('alterEmail').value;
            if (!altEmail.match(/^[a-zA-Z0-9._%+-]+@(gmail\.com|yahoo\.com|outlook\.com|hotmail\.com|edu|org|info|net)$/)) {
                document.getElementById("altEmailDemo").innerHTML = "Enter a valid email address.";
                isValid = false;
            } else if (altEmail === email) {
                document.getElementById("altEmailDemo").innerHTML = "Email and Alternate Email should be different.";
                isValid = false;
            }

            // Alternate Phone Validation
            var altPhone = document.getElementById('alterPhone').value;
            if (altPhone.trim().length !== 10 || !altPhone.match(/^[6-9]\d{9}$/)) {
                document.getElementById("altPhoneNumberDemo").innerHTML = "Phone number must contain 10 digits and should start with 6-9.";
                isValid = false;
            } else if (altPhone === phone) {
                document.getElementById("altPhoneNumberDemo").innerHTML = "Phone number and Alternate Phone number should be different.";
                isValid = false;
            }

            return isValid;
        }
    </script>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
