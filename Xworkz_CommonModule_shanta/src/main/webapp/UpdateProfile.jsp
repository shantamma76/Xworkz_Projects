<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Profile</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .form-container {
            max-width: 500px;
            margin: 0 auto;
            padding: 20px;
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="card shadow-lg form-container">
            <div class="card-body">
                <h2 class="card-title text-center mb-4">Update Profile</h2>

                <form action="update" method="post" enctype="multipart/form-data">
                    <div class="mb-3">
                        <label for="name" class="form-label">Name</label>
                        <input type="text" class="form-control" id="name" name="name" value="${name}" placeholder="Enter your name">
                        <span id="nameDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                        <label for="email" class="form-label">Email</label>
                        <input type="email" class="form-control" id="email" name="email" value="${email}" placeholder="Enter email">
                        <span id="emailDemo" style="color:red;"></span>
                    </div>

                    <div class="mb-3">
                        <label for="phone" class="form-label">Phone Number</label>
                        <input type="text" class="form-control" id="phone" name="phone" value="${phone}" placeholder="Enter phone number">
                      <span id="phoneDemo" style="color:red;"></span>
                    </div>

                      <div class="form-group">
                                 <label for="alterEmail">Alternate Email</label>
                                 <input type="email" class="form-control" id="alterEmail" name="alterEmail" placeholder="Enter an alternate email">
                             <span id="altEmailDemo" style="color:red;"></span>
                      </div>

                     <div class="form-group">
                                <label for="alterPhone">Alternate Phone Number</label>
                                <input type="text" class="form-control" id="alterPhone" name="alterPhone" placeholder="Enter an alternate phone number">
                      <span id="altPhoneNumberDemo" style="color:red;"></span>
                      </div>

                    <div class="mb-3">
                        <label for="location" class="form-label">Location</label>
                        <select id="location" name="location" class="form-control">
                            <option value="">Select location</option>
                            <c:forEach items="${listoflocation}" var="location">
                                <option value="${location}">${location}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <input type="file" name="picture" />
                    <button type="submit" class="btn btn-warning w-100">Update</button>
                </form>
            </div>
        </div>
    </div>



    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
