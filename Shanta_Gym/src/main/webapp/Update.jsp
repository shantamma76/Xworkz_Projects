<%@page isELIgnored="false" %>
    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Update page</title>
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
                justify-content: flex-end;
                list-style-type: none;
                padding: 0;
                margin: 0;
                background-color: #333;
                width: 100%;
                position: fixed;
                top: 0;
                left: 0;
                z-index: 1000;
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
                padding-top: 70px;
                /* Adjust for the height of the fixed navbar */
            }

            .form-label i {
                margin-right: 10px;
            }

            .form-control {
                padding-left: 30px;
                /* Space for icon inside input field */
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
            <div class="card shadow-lg" style="max-width: 600px; width: 100%;">
                <div class="card-body">
                    <h2 class="card-title text-center mb-4">Update Profile</h2>

                    <form action="update" method="post">

                        <div class="mb-2">
                            <label for="name" class="form-label"><i class="fas fa-user"></i> Name</label>
                            <input type="text" class="form-control" id="name" name="name" required>

                            <label for="phone" class="form-label"><i class="fas fa-phone-alt"></i>Phone No</label>
                            <input type="number" class="form-control" id="phone" name="phone" required>

                            <label for="package" class="form-label"><i class="fas fa-gift"></i> Package</label>
                            <input type="text" class="form-control" id="packages" name="packages" required>

                            <label for="trainer" class="form-label"><i class="fas fa-chalkboard-teacher"></i>
                                Trainer</label>
                            <input type="text" class="form-control" id="trainer" name="trainer" required>

                            <label for="amount" class="form-label"><i class="fas fa-dollar-sign"></i> Amount</label>
                            <input type="number" class="form-control" id="amount" name="amount" required>

                            <label for="balance" class="form-label"><i class="fas fa-calculator"></i> Balance</label>
                            <input type="number" class="form-control" id="balance" name="balance" required>

                        </div>

                        <button type="submit" class="btn btn-info w-100"><i class="fas fa-sync-alt"></i>Update</button>
                    </form>
                </div>
            </div>
        </div>

        <!-- Bootstrap JS and dependencies -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>


    </html>