<html>
<head>
    <title>Success Page</title>
    <style>
        /* Basic styles */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        h1 {
            text-align: center;
            margin-top: 50px;
        }

        /* The navigation menu */
        .navbar {
            display: none;
            list-style-type: none;
            padding: 0;
            margin: 0;
            background-color: blue;
            text-align: center;
        }

        .navbar li {
            display: block;
            padding: 12px;
        }

        .navbar li a {
            color: white;
            text-decoration: none;
            display: block;
        }

        .navbar li a:hover {
            background-color: red;
        }

        /* Hamburger Icon Styles */
        .hamburger {
            display: block;
            position: relative;
            width: 30px;
            height: 25px;
            cursor: pointer;
            margin-top: 20px;
            margin-left: 20px;
        }

        .hamburger span {
            background-color: #333;
            display: block;
            height: 4px;
            width: 100%;
            margin: 6px 0;
            transition: 0.3s;
        }

        /* Toggle the menu */
        .hamburger.active span:nth-child(1) {
            transform: rotate(45deg);
            position: absolute;
            top: 7px;
        }

        .hamburger.active span:nth-child(2) {
            opacity: 0;
        }

        .hamburger.active span:nth-child(3) {
            transform: rotate(-45deg);
            position: absolute;
            top: 7px;
        }

        /* Show the menu when hamburger is active */
        .navbar.show {
            display: block;
        }
    </style>
    
</head>

<body>
<h1>Login Successfully Done!</h1><br>
<!-- Hamburger Icon -->
<div class="hamburger" onclick="toggleMenu()">
    <span></span>
    <span></span>
    <span></span>
</div>

<!-- Navigation Menu -->
<ul class="navbar" id="navbar">
    <li><a href="index.jsp">Home</a></li>
    <li><a href="Enquiry.jsp">Enquiry</a></li>
    <li><a href="search">Follow Up</a></li>
    <li><a href="Registration.jsp">Register</a></li>
    <li><a href="Update.jsp">Update</a></li>
</ul>

<script>
    // Function to toggle the menu visibility and hamburger icon animation
    function toggleMenu() {
        var menu = document.getElementById("navbar");
        var hamburger = document.querySelector(".hamburger");

        menu.classList.toggle("show");
        hamburger.classList.toggle("active");
    }
</script>

</body>
</html>
