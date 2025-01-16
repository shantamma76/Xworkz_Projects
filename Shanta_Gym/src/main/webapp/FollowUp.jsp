<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Follow-Up Page</title>
    <style>
        body {
            font-family: 'Roboto', Arial, sans-serif;
            background-color: #1c1e26; /* Dark background for contrast */
            margin: 0;
            padding: 20px;
            color: #f9f9f9; /* Light text for contrast */
        }

        h1 {
            text-align: center;
            color: #f39c12; /* Vibrant orange for headings */
            font-size: 2em;
            margin-bottom: 20px;
            text-transform: uppercase;
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            background: #2c2f38; /* Slightly lighter dark for contrast */
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            padding: 20px;
        }

.search-bar {
            margin-bottom: 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 10px 0;
            border-bottom: 2px solid #3e424d;
        }

        .search-bar label {
            font-size: 1rem;
            font-weight: bold;
            color: #f39c12;
        }

        .search-bar select {
            padding: 5px 10px;
            font-size: 1rem;
            border: 1px solid #7f8c8d;
            border-radius: 5px;
            background-color: #2c2f38;
            color: #f9f9f9;
        }

        .search-bar .btn {
            font-size: 0.9rem;
            padding: 8px 15px;
            background-color: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

 .search-bar .btn:hover {
            background-color: #2980b9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 12px;
            text-align: center;
            border: 1px solid #3e424d;
        }

        th {
            background-color: #16a085; /* Contrasting green for table headers */
            color: white;
            text-transform: uppercase;
            font-size: 0.9rem;
        }

        tr:nth-child(even) {
            background-color: #2c2f38;
        }

        tr:nth-child(odd) {
            background-color: #1c1e26;
        }

        tr:hover {
            background-color: #34495e; /* Highlight row on hover */
        }
td select, td input {
            padding: 5px;
            font-size: 0.9rem;
            border: 1px solid #7f8c8d;
            border-radius: 5px;
            width: 90%;
            background-color: #1c1e26;
            color: #f9f9f9;
        }

        td .btn {
            font-size: 0.8rem;
            padding: 5px 10px;
            background-color: #e74c3c; /* Vibrant red for buttons */
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        td .btn:hover {
            background-color: #c0392b;
        }

        @media (max-width: 768px) {
            table, th, td {
                font-size: 0.8rem;
            }

            .search-bar {
                flex-direction: column;
                align-items: flex-start;
         }

            .search-bar label {
                margin-bottom: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Follow-Up Records</h1>

        <!-- Search Bar -->
        <div class="search-bar">
            <form action="search" method="post">
                <label for="status">Filter by Status:</label>
                <select name="status" id="status">
                    <option value="">--Select Status--</option>
                    <c:forEach var="status" items="${statusOptions}">
                        <option value="${status}" ${param.status == status ? 'selected' : ''}>
                            ${status}
                        </option>
                    </c:forEach>
                </select>
                <button type="submit" class="btn">Search</button>
            </form>
        </div>

        <table>
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Area</th>
                    <th>PhoneNo</th>
                    <th>Distance</th>
                    <th>Age</th>
                    <th>Status</th>
                    <th>Reason</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="enquiry" items="${enquiryList}">
                    <tr>
                        <form action="updateFollowUp" method="post">
                            <td>${enquiry.name}</td>
                            <td>${enquiry.area}</td>
                            <td>${enquiry.phone}</td>
                            <td>${enquiry.distance}</td>
                            <td>${enquiry.age}</td>
                            <td>
                                <select name="status">
                                    <c:forEach var="status" items="${statusOptions}">
                                        <option value="${status}" ${status == enquiry.status ? 'selected' : ''}>
                                            ${status}
                                        </option>
                                    </c:forEach>
                                </select>
                            </td>
                            <td>
                                <input type="text" name="reason" value="${enquiry.reason}" />
                            </td>
                            <td>
                                <input type="hidden" name="name" value="${enquiry.name}" />
                                <button type="submit" class="btn">Update</button>
                            </td>
                         </form>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>