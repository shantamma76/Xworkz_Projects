<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enquiry page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CDN -->
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
            padding-top: 70px;  /* Adjust for the height of the fixed navbar */
        }

        .container {
            min-height: 120vh; /* Increased from 100vh to 120vh */
        }

        .form-control {
            padding-left: 25px;
             /* Space for icon */
        }

        .input-group-text {
            background-color: #e9ecef;
            border-right: none;
        }

        .input-group-prepend {
            display: flex;
            align-items: center;
        }

        .input-group i {
            font-size: 18px;
            color: #555;
        }
    </style>
</head>

<body class="bg-success">
    <!-- Navigation Menu -->
    <ul class="navbar">
        <li><a href="index.jsp"><i class="fas fa-home"></i> Home</a></li>
        <li><a href="Enquiry.jsp"><i class="fas fa-question-circle"></i> Enquiry</a></li>
        <li><a href="search"><i class="fas fa-search"></i> Follow Up</a></li>
        <li><a href="Registration.jsp"><i class="fas fa-user-plus"></i> Register</a></li>
        <li><a href="Update.jsp"><i class="fas fa-edit"></i> Update</a></li>
    </ul>

    <div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
        <div class="card shadow-lg" style="max-width:500px; width: 100%;">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Enquiry page</h2>

                <form action="enquiry" method="post">
                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                        <input type="text" class="form-control" id="name" name="name" onChange="onNameChange()" placeholder="Enter your name" required>
                        <span id="nameDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                        <input type="text" class="form-control" id="area" name="area" onChange="onArea()" placeholder="Enter area" required>
                         <span id="areaDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-phone"></i></span>
                        <input type="number" class="form-control" id="phone" name="phone" onChange="onPhone()" placeholder="Enter phone number" required> </br>
                        <span id="phoneDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-ruler"></i></span>
                        <input type="number" class="form-control" id="distance" name="distance" onChange="onDistance()" placeholder="Enter distance" required>
                        <span id="distanceDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-calendar-alt"></i></span>
                        <input type="number" class="form-control" id="age" name="age" onChange="onAge()" placeholder="Enter age" required>
                        <span id="ageDemo" style="color:red;"></span>
                    </div>

                    <button type="submit" class="btn btn-success w-100">Submit</button>

                </form>
            </div>
        </div>
    </div>

    <script>
    function onNameChange(){
       console.log('this is on place name');
       var name = document.getElementById('name');
       var nameValue = name.value;

      if (nameValue.trim().length < 3){
      document.getElementById("nameDemo").innerHTML = "Name must be at least 3 characters long.";
      return;
      }else {
      document.getElementById("nameDemo").innerHTML = "";
                              }
      const xhttp = new XMLHttpRequest();
      xhttp.open("GET","http://localhost:8080/Shanta_Gym/name/" + nameValue);
      xhttp.send();

      xhttp.onload = function(){
      document.getElementById("nameDemo").innerHTML = this.responseText;
        }
      }

 function onArea() {
             console.log('this is on place area');
             var area = document.getElementById('area');
             var areaValue = area.value;

              if (areaValue.trim().length < 4){
              document.getElementById("areaDemo").innerHTML = "Area must be at least 4 characters long.";
              return;
              }else {
              document.getElementById("areaDemo").innerHTML = "";
              }

             var xhttp = new XMLHttpRequest();
             xhttp.open("GET", "http://localhost:8080/Shanta_Gym/area/" + areaValue);
             xhttp.send();

             xhttp.onload = function(){
             document.getElementById("areaDemo").innerHTML = this.responseText;
             }
         }

          function onPhone() {
             console.log('this is on place phoneNo');
             var phoneNo = document.getElementById('phone');
             var phoneNoValue = phoneNo.value;

           if (phoneNoValue.trim().length !== 10 || (!phoneNoValue.startsWith("6") && !phoneNoValue.startsWith("7")
            && !phoneNoValue.startsWith("8") && !phoneNoValue.startsWith("9")))
          {
          document.getElementById("phoneDemo").innerHTML = "Phone number must contain 10 digits and should be valid.";
          return;
          }else {
          document.getElementById("phoneDemo").innerHTML = "";
          }

             var xhttp = new XMLHttpRequest();
             xhttp.open("GET", "http://localhost:8080/Shanta_Gym/phone/" + phoneNoValue);
             xhttp.send();

             xhttp.onload = function(){
             document.getElementById("phoneDemo").innerHTML = this.responseText;
             }
      }

             function onDistance() {
             console.log('this is on place distance');
             var distance = document.getElementById('distance');
             var distanceValue = distance.value;

             var xhttp = new XMLHttpRequest();
             xhttp.open("GET", "http://localhost:8080/Shanta_Gym/distance/" + distanceValue);
             xhttp.send();

             xhttp.onload = function(){
             document.getElementById("distanceDemo").innerHTML = this.responseText;
             }
             }

 function onAge() {
             console.log('this is on place age');
             var age = document.getElementById('age');
             var ageValue = age.value;

             if (ageValue <= 18)
             {
             document.getElementById("ageDemo").innerHTML = "Age should be valid and above 18";
             return;
             }else {
             document.getElementById("ageDemo").innerHTML = "";
             }

             var xhttp = new XMLHttpRequest();
             xhttp.open("GET", "http://localhost:8080/Shanta_Gym/age/" + ageValue);
             xhttp.send();

             xhttp.onload = function(){
             document.getElementById("ageDemo").innerHTML = this.responseText;
             }
        }
</script>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
