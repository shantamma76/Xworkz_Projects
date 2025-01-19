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
            padding-top: 70px; /* Adjust for the height of the fixed navbar */
        }

        .form-control {
            padding-left: 35px; /* Space for icon */
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
        <div class="card shadow-lg" style="max-width: 400px; width: 100%;">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Enquiry page</h2>

                <form action="enquiry" method="post">
                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-user"></i></span>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" required>
                    </div>

                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
                        <input type="text" class="form-control" id="area" name="area" placeholder="Enter area" required>
                    </div>

                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-phone"></i></span>
                        <input type="number" class="form-control" id="phone" name="phone" placeholder="Enter phone number" required>
                    </div>

                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-ruler"></i></span>
                        <input type="number" class="form-control" id="distance" name="distance" placeholder="Enter distance" required>
                    </div>

                    <div class="mb-3 input-group">
                        <span class="input-group-text"><i class="fas fa-calendar-alt"></i></span>
                        <input type="number" class="form-control" id="age" name="age" placeholder="Enter age" required>
                    </div>

                    <button type="submit" class="btn btn-success w-100">Submit</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
