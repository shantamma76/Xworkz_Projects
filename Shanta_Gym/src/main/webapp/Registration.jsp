<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration page</title>
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
                <h2 class="card-title text-center mb-4">Registration</h2>
                <form action="register" method="post">
                    <div class="mb-2">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name" required>

                       <label for="email" class="form-label">Email</label>
                       <input type="email" class="form-control" id="email" name="email" required>

                         <label for="password" class="form-label">Password</label>
                         <input type="password" class="form-control" id="password" name="password" required>

                       <label for="package" class="form-label">Package</label>
                        <input type="number" class="form-control" id="package" name="package" required>

                       <label for="trainer" class="form-label">Trainer</label>
                        <input type="text" class="form-control" id="trainer" name="trainer" required>

                   <label for="phone" class="form-label">Phone No</label>
                      <input type="number" class="form-control" id="phone" name="phone" required>

                    <label for="amount" class="form-label">Amount</label>
                    <input type="number" class="form-control" id="amount" name="amount" required>

                   <label for="discount" class="form-label">Discount</label>
                      <input type="number" class="form-control" id="discount" name="discount" required>

               <label for="gymName" class="form-label">Gym Name</label>
                   <input type="text" class="form-control" id="gymName" name="gymName" required>

               <label for="balance" class="form-label">Balance</label>
                   <input type="number" class="form-control" id="balance" name="balance" required>
                     <label for="installment" class="form-label">Installment</label>
                    <input type="text" class="form-control" id="installment" name="installment" required>
                </div>

                    <button type="submit" class="btn btn-info w-100">Submit</button>
                    <a href="Update.jsp">Update</a>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
