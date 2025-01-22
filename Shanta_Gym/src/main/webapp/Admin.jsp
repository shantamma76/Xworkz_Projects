<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin login</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Font Awesome Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    <style>
        body {
            background-image: url('https://img.freepik.com/premium-photo/empty-gym-with-treadmills_564714-18757.jpg');
        }

        /* Navbar styling */
        .navbar {
            display: flex;
            justify-content: flex-end; /* Aligns the items to the right */
            list-style-type: none;
            padding: 0;
            margin: 0;
            background-color: #333;
            width: 100%;
            position: fixed; /* Fix the navbar at the top */
            top: 0;
            left: 0;
            z-index: 1000; /* Ensures the navbar is above other content */
        }

        .navbar li {
            display: inline-block;
            padding: 12px;
        }

        .navbar li a {
            color: white;
            text-decoration: none;
            display: block;
        }

        .navbar li a:hover {
            background-color: #575757;
        }

        /* Add padding to the top of the body to prevent content overlap */
        .content {
            padding-top: 70px; /* Adjust for the height of the fixed navbar */
        }

        .navbar li a i {
            margin-right: 8px; /* Space between icon and text */
        }
    </style>
</head>

<body class="bg-success">
    <!-- Navigation Menu -->
    <ul class="navbar">
        <li><a href="index.jsp"><i class="fas fa-home"></i>Home</a></li>
        <li><a href="Enquiry.jsp"><i class="fas fa-question-circle"></i>Enquiry</a></li>
        <li><a href="search"><i class="fas fa-search"></i>Follow Up</a></li>
        <li><a href="Registration.jsp"><i class="fas fa-user-plus"></i>Register</a></li>
        <li><a href="Update.jsp"><i class="fas fa-edit"></i>Update</a></li>
    </ul>

    <!-- Main content area -->
    <div class="container d-flex justify-content-center align-items-center content" style="min-height: 100vh;">
        <div class="card shadow-lg" style="max-width: 400px; width: 100%;">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Admin Login</h2>

                <form action="signIn" method="get">
                    <!-- Name field with icon -->
                    <div class="input-group mb-3">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                        <input type="name" class="form-control" id="name" name="name" onChange="onNameChange()" placeholder="Enter your name" required> <br>
                        <span id="nameDemo" style="color:red;"></span>
                    </div>

                    <!-- Email field with icon -->
                    <div class="input-group mb-3">
                        <span class="input-group-text"><i class="fas fa-envelope"></i></span>
                        <input type="email" class="form-control" id="email" name="email"  onChange="onEmailChange()" required placeholder="Enter your email"> </br>
                        <span id="emailDemo" style="color:red;"></span>
                    </div>

                    <!-- Password field with icon -->
                    <div class="input-group mb-3">
                        <span class="input-group-text"><i class="fas fa-lock"></i></span>
                        <input type="password" class="form-control" id="password" name="password" onChange="onPasswordChange()" required placeholder="Enter your password">
                     <span id="passwordDemo" style="color:red;"></span>
                    </div>

                    <button type="submit" class="btn btn-success w-100">
                        <i class="fas fa-sign-in-alt"></i> Login
                    </button>

                    <div class="register">
                        <p>Don't have an account? <a href="Registration.jsp">Register</a></p>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script>

      function onNameChange(){
          console.log('this is on place name');
          var name = document.getElementById('name');
          var nameValue = name.value;

          var xhttp = new XMLHttpRequest();
          xhttp.open("GET", "http:////localhost:3306/gym_database/name/" +nameValue);
          xhttp.send();

          xhttp.onload = function(){
          document.getElementById("nameDemo").innerHTML = this.responseText;
          }
          }

       function onEmailChange() {
                var  emailvalue = document.getElementById('email').value;
                  if (!emailvalue.match(/^[a-zA-Z0-9._%+-]+@(gmail\.com|yahoo\.com|outlook\.com|hotmail\.com|edu|org|info|net)$/)) {
                      document.getElementById("emailDemo").innerHTML = "Enter a valid email address.";
                  } else {
                      document.getElementById("emailDemo").innerHTML = "";
                  }
              }

       function onPasswordChange() {
           var passwordValue = document.getElementById('password').value;
           if (passwordValue != null && passwordValue.length >= 8 && passwordValue.includes("@") && /[A-Z]/.test(passwordValue)) {
               document.getElementById("passwordDemo").innerHTML = "Enter a valid password.";
           } else {
               document.getElementById("passwordDemo").innerHTML = "";
           }
       }


    </script>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
