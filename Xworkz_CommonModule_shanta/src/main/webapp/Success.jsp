<!DOCTYPE html>
<%@page isELIgnored = "false"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Success Page</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
             background-image: url('https://static.vecteezy.com/system/resources/previews/001/340/791/original/pastel-rainbow-blurry-background-with-sparks-free-vector.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-position: center;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
        }

        .container {
            background-color: rgba(255, 255, 255, 0.9);
            border-radius: 15px;
            padding: 40px;
            box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.3);
            margin-top: 100px;
            text-align: center;
        }

        h1 {
            font-size: 3rem;
            color: #4caf50;
            font-weight: bold;
            margin-bottom: 20px;
        }

        p {
            font-size: 1.5rem;
            color: #333;
        }

        .btn-primary {
            background-color: #512da8;
            border: none;
            border-radius: 10px;
            padding: 10px 20px;
            margin-top: 20px;
            transition: background-color 0.3s;
        }

        .btn-primary:hover {
            background-color: #3f51b5;
        }

        footer {
            margin-top: 50px;
            text-align: center;
            color: #d1c4e9;
            font-size: 1em;
            padding: 10px;
            background-color: rgba(63, 81, 181, 0.7);
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Success!</h1>
        <p>Your operation was completed successfully.</p>
        <a href="index.jsp" class="btn btn-warning">Go to Home</a> </br>

    <img src="download?filePath=${filePath}" alt="profile picture" width="100" height="100">

      <!-- Upadte profile form below -->
        <form action="update" method="get">
        <input type="text" name="name" value="${userName}"/>
        <input type="submit" value="update signup">
        </form>
    </div>

    <!-- Bootstrap JS (Optional) -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.4.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
