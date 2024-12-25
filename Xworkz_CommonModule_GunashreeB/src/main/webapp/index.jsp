<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            background-image: url('https://source.unsplash.com/1600x900/?technology,abstract');
            background-size: cover;
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-position: center;
            color: #ffffff;
            font-family: 'Arial, sans-serif';
        }

        .navbar {
            background-color: rgba(52, 58, 64, 0.9);
            transition: background-color 0.3s;
        }

        .navbar-brand img {
            height: 50px;
        }

        .navbar-brand, .nav-link {
            color: #ffffff !important;
        }

        .navbar-brand:hover, .nav-link:hover {
            color: #007bff !important;
        }

        .main-section {
            text-align: center;
            padding: 120px 20px;
            background-color: rgba(0, 0, 0, 0.6);
            border-radius: 15px;
            margin: 50px auto;
            max-width: 800px;
            animation: fadeIn 1.5s ease-in-out;
        }

        .main-section h1 {
            font-size: 4em;
            font-weight: bold;
            margin-bottom: 20px;
            color: #f8f9fa;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.7);
        }

        .main-section p {
            font-size: 1.5em;
            color: #ffc107;
            margin-bottom: 30px;
        }

        .main-section .btn {
            background-color: #ff5722;
            color: #ffffff;
            padding: 12px 25px;
            font-size: 1.2em;
            border-radius: 50px;
            transition: all 0.3s ease;
        }

        .main-section .btn:hover {
            background-color: #e64a19;
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.3);
        }

        .sign-up-btn {
            background-color: #343a40;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 50px;
            font-size: 1.2em;
            transition: background-color 0.3s ease, transform 0.3s ease;
        }

        .sign-up-btn:hover {
            background-color: #007bff;
            transform: translateY(-3px);
        }

        .sign-up-btn a {
            color: #ffffff;
            text-decoration: none;
        }

        @keyframes fadeIn {
            from {
                opacity: 0;
                transform: translateY(20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }
    </style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Logo">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="SignUp.jsp">Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="SignIn.jsp">Sign In</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="main-section">
    <h1>Welcome to Xworkz</h1>
    <p>Empowering your skills with the best learning experience.</p>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
