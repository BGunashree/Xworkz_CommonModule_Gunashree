<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bootstrap Form</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css">
    <style>
        body {
            background: linear-gradient(135deg, #e3f2fd, #bbdefb);
            font-family: 'Arial, sans-serif';
            padding: 20px;
        }

        .form-container {
            background-color: #ffffff;
            padding: 40px;
            border-radius: 15px;
            box-shadow: 0px 5px 20px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 50px auto;
            animation: fadeIn 1.2s ease-in-out;
        }

        .form-container h2 {
            color: #007bff;
            font-weight: bold;
            text-align: center;
            margin-bottom: 30px;
        }

        .form-group label {
            font-weight: bold;
        }

        .form-control {
            border-radius: 10px;
        }

        .btn-custom {
            background-color: #007bff;
            color: #ffffff;
            border-radius: 50px;
            padding: 10px 20px;
            font-size: 1.2em;
            transition: all 0.3s ease;
        }

        .btn-custom:hover {
            background-color: #0056b3;
            transform: translateY(-3px);
            box-shadow: 0 5px 15px rgba(0, 91, 187, 0.3);
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
    </style>

</head>
<body>

<div class="form-container">
    <h2><i class="fas fa-user-edit"></i> Fill Out the Form</h2>
    <form action="submit" method="post">
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" name="name" id="name" placeholder="Enter your full name" required>
        </div>

        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" class="form-control"  name="email" id="email" placeholder="Enter your email" required>
        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" name="phone" id="phone" placeholder="Enter your phone number" required>
        </div>

        <div class="form-group">
            <label for="altEmail">Alternate Email</label>
            <input type="email" class="form-control" name="alternateEmail" id="altEmail" placeholder="Enter an alternate email">
        </div>

        <div class="form-group">
            <label for="altPhone">Alternate Phone</label>
            <input type="tel" class="form-control" id="altPhone" name="alternatePhone" placeholder="Enter an alternate phone number">
        </div>

        <div class="form-group">
            <label for="location">Location</label>
            <input type="text" class="form-control" id="location" name="location" placeholder="Enter your location" required>
        </div>

        <button type="submit" class="btn btn-custom btn-block"><i class="fas fa-paper-plane"></i>Submit</button>
    </form>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
