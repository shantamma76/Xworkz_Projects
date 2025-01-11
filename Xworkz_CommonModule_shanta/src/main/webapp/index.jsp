<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Xworkz</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Custom styles */
        body {

            background-color: #f7f9fc;
            font-family: 'Arial', sans-serif;
        }

        .navbar {
            background-color:#0ef;
        }

        .navbar-brand img {
            width: 100px;
            height: 70px;
        }

        .nav-link {
            color: black !important;
        }

        .nav-link:hover {
            color: red !important;
        }

        .hero-section {
            background:hsl(333, 95%, 57%);
            color: white;
            padding: 100px 0;
            text-align: center;
        }

        .hero-section h1 {
            font-size: 3rem;
            font-weight: bold;
        }

        .hero-section p {
            font-size: 1.25rem;
            margin-top: 10px;
        }

        .btn-custom {
            background-color: #ffd700;
            color: #17a2b8;
            font-weight: bold;
            padding: 10px 25px;
            border-radius: 25px;
        }

        .btn-custom:hover {
            background-color: #ffcc00;
            color: #ffffff;
        }

        .footer {
            background-color: #0ef;
            color: black;
            padding: 30px 0;
            text-align: center;
        }

        @media (max-width: 767px) {
            .hero-section h1 {
                font-size: 2rem;
            }

            .hero-section p {
                font-size: 1rem;
            }
        }
    </style>
</head>

<body>
    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light">
        <div class="container">
            <!-- Logo -->
            <a class="navbar-brand" href="#">
                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz Logo">
            </a>

            <!-- Toggler for smaller screens -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <!-- Navbar Links -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="sup">Sign Up</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="SignIn.jsp">Sign In</a>
                    </li>



                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero-section">
        <div class="container">
            <h1>Welcome to Xworkz</h1>
            <p>Your journey to excellence starts here. Join us and experience the future.</p>

        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2024 Xworkz. All Rights Reserved.</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
