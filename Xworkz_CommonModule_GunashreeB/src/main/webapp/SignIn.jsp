<%@page isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SignIn Form</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="Header.jsp"/>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <h2 class="text-center mb-4">SignIn</h2>
            <form  action="find"  method="post">
                <!-- Email Field -->
                <div class="form-group">
                    <label for="email">Email address</label>
                    <input type="email" class="form-control" name="email" id="email" onchange="onEmail()" placeholder="Enter your email" required>
                    <span id="displayEmail" style="color:red"></span>
                </div>

                <!-- Password Field -->
                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" class="form-control" name="password" id="password" onchange="onPasswordChange()" placeholder="Enter your password" required>
                    <span id="displayPassword" style="color:red"></span>
                </div>

                <!-- Submit Button -->
                <button type="submit" class="btn btn-primary btn-block">Submit</button>
            </form>

            <span style="color:red">${updateMessage}</span>
        </div>
    </div>
</div>
<script>


function onPasswordChange() {
       console.log('Input changed for field');
       var inputElement = document.getElementById('password');
       var Value = inputElement.value;

       var xhttp = new XMLHttpRequest();
       xhttp.open("GET", "http://localhost:8082/Xworkz_CommonModule_GunashreeB/password/"+Value);
       xhttp.send();

       xhttp.onload =function(){
                              document.getElementById("displayPassword").innerHTML = this.responseText;
             }
   }
</script>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
