<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Successful Page</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #4caf50, #81c784);
            color: #fff;
            font-family: 'Arial, sans-serif';
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            margin: 0;
        }

        .success-container {
            background: #ffffff;
            color: #333;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0 5px 20px rgba(0, 0, 0, 0.2);
            text-align: center;
            max-width: 500px;
            width: 100%;
            animation: fadeIn 1.5s ease-in-out;
        }

        .success-container h1 {
            font-size: 2.5em;
            color: #28a745;
            margin-bottom: 15px;
        }

        .success-container p {
            font-size: 1.2em;
            margin-bottom: 25px;
        }

        .success-icon {
            font-size: 3em;
            color: #28a745;
            margin-bottom: 15px;
            animation: bounceIn 1s;
        }

        .action-buttons {
            display: flex;
            justify-content: space-between;
            gap: 15px;
            margin-top: 20px;
        }

        .action-buttons form,
        .action-buttons a {
            flex: 1;
        }

        .btn {
            display: block;
            width: 100%;
            padding: 12px;
            border-radius: 50px;
            font-size: 1.1em;
            text-decoration: none;
            transition: background-color 0.3s ease, transform 0.3s ease;
            text-align: center;
        }

        .btn-update {
            background-color: #17a2b8;
            color: #fff;
        }

        .btn-update:hover {
            background-color: #138496;
            transform: translateY(-3px);
            box-shadow: 0 5px 15px rgba(23, 162, 184, 0.3);
        }

        .btn-home {
            background-color: #28a745;
            color: #fff;
        }

        .btn-home:hover {
            background-color: #218838;
            transform: translateY(-3px);
            box-shadow: 0 5px 15px rgba(40, 167, 69, 0.3);
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        @keyframes bounceIn {
            0% {
                transform: scale(0);
                opacity: 0;
            }
            60% {
                transform: scale(1.1);
                opacity: 1;
            }
            100% {
                transform: scale(1);
            }
        }
    </style>
</head>
<body>
    <c:set var="userName" value="${userName}" />

    <div class="success-container">
        <div class="success-icon">
            <i class="fas fa-check-circle"></i>
        </div>

        <h1>Successful!</h1>
        <p>Welcome <strong>${userName}</strong>!</p>

        <div class="action-buttons">
            <!-- Update Details Form -->
            <form action="updating" method="post">
                <input type="hidden" name="userName" value="${userName}" />
                <button type="submit" class="btn btn-update"><i class="fas fa-edit"></i> Update Details</button>
            </form>

            <!-- Home Button -->
            <a href="index.jsp" class="btn btn-home"><i class="fas fa-home"></i> Go to Home</a>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
