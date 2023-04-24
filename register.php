<?php

@include 'config.php';

if(isset($_POST['submit'])){

   $name = mysqli_real_escape_string($conn, $_POST['name']);
   $email = mysqli_real_escape_string($conn, $_POST['email']);
   $pass = md5($_POST['password']);
   

   $select = " SELECT * FROM user_form WHERE email = '$email' ";

   $result = mysqli_query($conn, $select);

   if(mysqli_num_rows($result) > 0){

    echo "<p> Email already exists in database !!! </p>";

      

   }else{

      $insert = "INSERT INTO user_form(name, email, password) VALUES('$name','$email','$pass')";
      if(mysqli_query($conn, $insert)){
         $error[] = 'password not matched!';
         echo "<p> User registered sucessfully. </p>";
      }else{
        echo "<p> Error inserting user data: ".mysqli_error($conn)."</p>";
         header('location:login_form.php');
      }
   }

   mysqli_close($conn);
};


?>



<!DOCTYPE html>
<html lang="en">
<head>
   <meta charset="UTF-8">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>register form</title>

   <!-- custom css file link  -->
   <link rel="stylesheet" href="styles.css">

</head>
<body>
   
<div class="form-container">

   <form action="" method="post">
      <h3>register now</h3>
      <?php
      if(isset($error)){
         foreach($error as $error){
            echo '<span class="error-msg">'.$error.'</span>';
         };
      };
      ?>
      <input type="text" name="name" required placeholder="Enter your name">
      <input type="email" name="email" required placeholder="Enter your email">
      <input type="password" name="password" required placeholder="Enter your password">
      <!-- <input type="password" name="cpassword" required placeholder="confirm your password">
      <select name="user_type">
         <option value="user">user</option>
         <option value="admin">admin</option>
      </select> -->
      <input type="submit" name="submit" value="register now" class="form-btn">
      <p>already have an account? <a href="login.html">login now</a></p>
      <p style="text-align:center">
   </form>

</div>

</body>
</html>