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
            background-image: url('https://img.freepik.com/premium-photo/contemporary-spotless-fitness-gym-center-interiorgenerative-ai_391052-10889.jpg?w=2000');
            background-size: cover;
            font-family: 'Arial', sans-serif;
            margin: 0;
            padding: 0;
            min-height: 100vh;
            display: flex;
            flex-direction: column;
        }

        /* Navbar */
        .navbar {
            background-color:gray; /* Semi-transparent background */
            box-shadow: 0 3px 6px rgba(0, 0, 0, 0.2);
            z-index: 1;
        }

        .navbar-brand img {
            width: 120px;
            height: auto;
        }

        .nav-link {
            color: white !important;
            font-size: 1.1rem;
            text-transform: uppercase;
        }

        .nav-link:hover {
            color: blue !important;
            text-decoration: underline;
        }

        /* Hero Section */
        .hero-section {
            flex-grow: 1;
            display: flex;
            align-items: center;
            justify-content: center;
            text-align: center;
            padding: 120px 15px;
            color: white;
            position: relative;
            z-index: 0;
        }

        .hero-section::before {
            content: '';
            position: absolute;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5); /* Dark overlay */
            z-index: -1;
        }

        .hero-section h1 {
            font-size: 3.5rem;
            font-weight: bold;
            margin-bottom: 20px;
            letter-spacing: 1px;
        }

        .hero-section p {
            font-size: 1.25rem;
            font-weight: 300;
            margin-bottom: 30px;
        }

        .btn-custom {
            background-color: #ffd700;
            color: #2e3a47;
            font-weight: bold;
            padding: 12px 30px;
            border-radius: 30px;
            font-size: 1.1rem;
            transition: all 0.3s ease;
        }

        .btn-custom:hover {
            background-color: #ffcc00;
            color: #ffffff;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        }

        /* Footer */
        .footer {
            background-color: gray;
            color: white;
            padding: 20px 0;
            text-align: center;
            font-size: 1rem;
            margin-top: auto;
        }

        /* Responsive Adjustments */
        @media (max-width: 767px) {
            .hero-section h1 {
                font-size: 2.5rem;
            }

            .hero-section p {
                font-size: 1.1rem;
            }
        }
    </style>
</head>

<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top">
        <div class="container">
            <!-- Logo -->
            <a class="navbar-brand" href="#">
                <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Xworkz Logo">
            </a>

            <!-- Navbar Links -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="Admin.jsp">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero-section">
        <div class="container">
            <h1>Welcome to Gym</h1>
            <p>The gym is not the social club for the fit. Its a training ground for everyone.</p>

        </div>
    </section>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2025 Gym. All Rights Reserved.</p>
    </footer>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
