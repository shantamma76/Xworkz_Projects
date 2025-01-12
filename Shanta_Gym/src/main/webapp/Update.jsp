<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
    body {
     background-image: url('https://img.freepik.com/premium-photo/empty-gym-with-treadmills_564714-18757.jpg');

    }
    </style>
</head>

<body class="bg-success">
    <div class="container d-flex justify-content-center align-items-center" style="min-height: 100vh;">
        <div class="card shadow-lg" style="max-width: 600px; width: 100%;">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Update Profile</h2>

                <form action="register" method="post">
                    <div class="mb-2">
                       <label for="package" class="form-label">Package</label>
                        <input type="number" class="form-control" id="package" name="package" required>

                        <label for="trainer" class="form-label">Trainer</label>
                        <input type="text" class="form-control" id="trainer" name="trainer" required>

                       <label for="amount" class="form-label">Amount</label>
                       <input type="number" class="form-control" id="amount" name="amount" required>

                       <label for="balance" class="form-label">Balance</label>
                       <input type="number" class="form-control" id="balance" name="balance" required>

                    </div>

                    <button type="submit" class="btn btn-info w-100"> Updete</button>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
