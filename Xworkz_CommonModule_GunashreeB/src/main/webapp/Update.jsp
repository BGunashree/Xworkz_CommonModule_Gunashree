<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Form</title>
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

<jsp:include page="Header.jsp"/>
<div class="form-container">
    <h2><i class="fas fa-user-edit"></i> Update Details</h2>
   <c:forEach  items="${error}" var="i" >
                <span style="color:red">${i.message}</span>
                </c:forEach>

<c:set var="userName"  value="${userName}" />
    <form action="update" method="post" enctype="multipart/form-data">

        <input type="text" name="userName"  value="${userName}"  readonly/>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" value="${entity.email}" name="email" id="email" onchange="onEmail()" placeholder="Enter your email" required>
            <span id="displayEmail" style="color:red"></span>


        </div>

        <div class="form-group">
            <label for="phone">Phone</label>
            <input type="tel" class="form-control" value="${entity.phone}" name="phone" id="phone" onchange="onInputChange('phone','displayPhone')" placeholder="Enter your phone number" required>
            <span id="displayPhone" style="color:red"></span>
        </div>

        <div class="form-group">
            <label for="altEmail">Alternate Email</label>
            <input type="text" class="form-control" value="${entity.alternateEmail}" name="alternateEmail" id="altEmail" onchange="onInputChange('altEmail','displayAltEmail')" placeholder="Enter an alternate email" required>
            <span id="displayAltEmail" style="color:red"></span>
             <div id="emailValidationMessage" style="color: red; font-weight: bold;"></div>
        </div>

        <div class="form-group">
            <label for="altPhone">Alternate Phone</label>
            <input type="tel" class="form-control" value="${entity.alternatePhone}" id="altPhone" name="alternatePhone" onchange="onInputChange('altPhone','displayAltPhone')" placeholder="Enter an alternate phone number" required>
            <span id="displayAltPhone" style="color:red"></span>
            <div id="phoneValidationMessage" style="color: red; font-weight: bold;"></div>
        </div>

       <div class="form-group">
           <label for="location" class="form-label">Location</label>
           <select id="location" name="location" class="form-control">
               <option value="">Select the option</option>
               <c:forEach items="${listLocation}" var="location">
                   <option value="${location}">${location}</option>
               </c:forEach>
           </select>
       </div>

      <div class="form-group">
          <label for="picture">Choose Picture</label>
          <input type="file" class="form-control" id="picture" name="picture" accept="image/*" >
          <small class="form-text text-muted">Only image files (e.g., JPG, PNG) are allowed.</small>
      </div>



        <button type="submit" class="btn btn-custom btn-block"><i class="fas fa-paper-plane"></i>Submit</button>
    </form>
</div>
<script>


  function onEmail() {
      var userEmail = document.getElementById('email');
      var userValue = userEmail.value;

      if (!userValue) {
          document.getElementById("displayEmail").innerHTML = "Email cannot be empty.";
          return;

      } else if (!/^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/.test(userValue)) {
          document.getElementById("displayEmail").innerHTML = "Invalid email format.";
          return;
      } else {
          document.getElementById("displayEmail").innerHTML = "";
      }

      var xhttp = new XMLHttpRequest();
      xhttp.open("GET", "http://localhost:8082/Xworkz_CommonModule_GunashreeB/email/" + userValue);
      xhttp.onload = function () {
          document.getElementById("displayEmail").innerHTML = this.responseText;
      };
      xhttp.send();

      validateEmails();
  }

  function onInputChange(fieldId, spanId) {
      var inputElement = document.getElementById(fieldId);
      var inputValue = inputElement.value;

      if (!inputValue) {
          document.getElementById(spanId).innerHTML = "Cannot be empty.";
          return;
      }

      if (fieldId === 'phone' || fieldId === 'altPhone') {
          if (!/^\d{10}$/.test(inputValue)) {
              document.getElementById(spanId).innerHTML = "Phone number must be exactly 10 digits.";
              return;
          }
      } else if (fieldId === 'altEmail') {
          if (!/^[a-zA-Z0-9.]+@[a-zA-Z0-9]+\.[a-zA-Z]{2,}$/.test(inputValue)) {
              document.getElementById(spanId).innerHTML = "Invalid email format.";
              return;
          }
      }

      document.getElementById(spanId).innerHTML = "";

      var xhttp = new XMLHttpRequest();
      xhttp.open("GET", "http://localhost:8082/Xworkz_CommonModule_GunashreeB/" + fieldId + "/" + inputValue);
      xhttp.onload = function () {
          document.getElementById(spanId).innerHTML = this.responseText;
      };
      xhttp.send();

      if (fieldId === 'altEmail') {
          validateEmails();
      } else if (fieldId === 'altPhone') {
          validatePhones();
      }
  }

  function validateEmails() {
      const email = document.getElementById('email').value;
      const altEmail = document.getElementById('altEmail').value;
      const validationMessage = document.getElementById('emailValidationMessage');

      if (email && altEmail && email === altEmail) {
          validationMessage.textContent = "Email and alternate email cannot be the same.";
      } else {
          validationMessage.textContent = "";
      }
  }

  function validatePhones() {
      const phone = document.getElementById('phone').value;
      const altPhone = document.getElementById('altPhone').value;
      const phoneValidationMessage = document.getElementById('phoneValidationMessage');

      if (phone && altPhone && phone === altPhone) {
          phoneValidationMessage.textContent = "Phone and alternate phone cannot be the same.";
      } else {
          phoneValidationMessage.textContent = "";
      }
  }

</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
