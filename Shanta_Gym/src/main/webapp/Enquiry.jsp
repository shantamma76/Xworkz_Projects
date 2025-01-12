<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enquiry page</title>
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
        <div class="card shadow-lg" style="max-width: 400px; width: 100%;">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Enquiry page</h2>
                <form action="enquiry" method="post">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="mb-3">
                        <label for="area" class="form-label">Area</label>
                        <input type="text" class="form-control" id="area" name="area" required>
                    </div>
                    <div class="mb-3">
                         <label for="phone" class="form-label">Phone No</label>
                         <input type="number" class="form-control" id="phone" name="phone" required>
                    </div>
                 <div class="mb-3">
                       <label for="distance" class="form-label">Distance</label>
                        <input type="number" class="form-control" id="distance" name="distance" required>
                 </div>
                  <div class="mb-3">
                       <label for="age" class="form-label">Age</label>
                        <input type="number" class="form-control" id="age" name="age" required>
                  </div>

                <div class="mb-3">
                     <label for="status" class="form-label">Status</label>
                    <input type="text" class="form-control" id="status" name="status" required>
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
