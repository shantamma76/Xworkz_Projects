<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration page</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome CDN -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">

    <style>
        body {
            background-image: url('https://img.freepik.com/premium-photo/contemporary-spotless-fitness-gym-center-interiorgenerative-ai_391052-10889.jpg?w=2000');
        }

        .container {
            margin-top: 80px;
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
            padding-top: 10px;
        }

        .form-label i {
            margin-right: 10px;
        }

        .form-control {
            padding-left: 30px; /* Space for icon inside input field */
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

                <h2 class="card-title text-center mb-4">Registration Form</h2>
                <form action="register" method="post">
                    <div class="mb-2">
                        <label for="name" class="form-label"><i class="fas fa-user"></i> Name</label>
                        <input type="text" class="form-control" id="name" name="name"  required>

                        <label for="email" class="form-label"><i class="fas fa-envelope"></i> Email</label>
                        <input type="email" class="form-control" id="email" name="email" required>

                        <label for="password" class="form-label"><i class="fas fa-lock"></i> Password</label>
                        <input type="password" class="form-control" id="password" name="password" required>

                        <label for="packages" class="form-label"><i class="fas fa-gift"></i> Packages</label>
                        <select class="form-control" id="packages" name="packages" required>
                            <option value="" data-amount="0">--select package--</option>
                            <option value="Silver" data-amount="30000">Silver - 30000</option>
                            <option value="Premium" data-amount="40000">Premium - 40000</option>
                        </select>

                        <label for="trainer" class="form-label"><i class="fas fa-chalkboard-teacher"></i> Trainer</label>
                        <input type="text" class="form-control" id="trainer" name="trainer" required>

                        <label for="phone" class="form-label"><i class="fas fa-phone-alt"></i> Phone No</label>
                        <input type="tel" class="form-control" id="phone" name="phone" required>

                        <label for="gymName" class="form-label"><i class="fas fa-building"></i> Gym Name</label>
                        <input type="text" class="form-control" id="gymName" name="gymName" required>

                        <label for="amount" class="form-label"><i class="fas fa-dollar-sign"></i> Amount</label>
                        <input type="number" step="0.01" class="form-control" id="amount" name="amount" readonly required>

                        <label for="discount" class="form-label"><i class="fas fa-percentage"></i> Discount(%)</label>
                        <input type="text" step="0.01" class="form-control" id="discount" name="discount" required>

                        <label for="paid" class="form-label"><i class="fas fa-money-bill-wave"></i> Paid</label>
                        <input type="number" step="0.01" class="form-control" id="paid" name="paid" required>

                        <label for="balance" class="form-label"><i class="fas fa-calculator"></i> Balance</label>
                        <input type="number" step="0.01" class="form-control" id="balance" name="balance" readonly required>

                        <label for="installment" class="form-label"><i class="fas fa-calendar-alt"></i> Installment</label>
                        <input type="number" step="0.01" class="form-control" id="installment" name="installment" required>
                    </div>

                    <button type="submit" class="btn btn-info w-100">Submit</button>
                    <a href="Update.jsp" class="btn btn-warning w-100 mt-2">Update</a>
                </form>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS and dependencies -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        // Update the amount based on the selected package
        document.getElementById('packages').addEventListener('change', function () {
            const packageSelect = this;
            const selectedOption = packageSelect.options[packageSelect.selectedIndex];
            const packageAmount = selectedOption.getAttribute('data-amount');
            document.getElementById('amount').value = packageAmount; // Set the amount field
            calculateBalance(); // Recalculate balance when package is changed
        });

        // Update the balance and discount calculations
        function calculateBalance() {
            const amount = parseFloat(document.getElementById('amount').value) || 0;
            const discount = parseFloat(document.getElementById('discount').value) || 0;
            const paid = parseFloat(document.getElementById('paid').value) || 0;

            const discountedAmount = amount - (amount * (discount / 100));
            const balance = discountedAmount - paid;
            document.getElementById('balance').value = balance.toFixed(2); // Update balance field
        }

        // Recalculate balance when discount value is changed
        document.getElementById('discount').addEventListener('input', calculateBalance);

        // Recalculate balance when paid amount is changed
        document.getElementById('paid').addEventListener('input', calculateBalance);
    </script>
</body>

</html>
