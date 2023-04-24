<?php
	// Load the PHPMailer library


	require_once 'path/to/PHPMailer/src/PHPMailer.php';

	if(isset($_POST['submit'])) {
		// Retrieve the user's email and password from the form
		$email = $_POST['email'];
		$password = $_POST['password'];

		// Create a new PHPMailer instance
		$mail = new PHPMailer();

		// Set the SMTP server settings (replace with your own)
		$mail->isSMTP();
		$mail->Host       = 'smtp.example.com';
		$mail->SMTPAuth   = true;
		$mail->Username   = $email;
		$mail->Password   = $password;
		$mail->SMTPSecure = 'tls';
		$mail->Port       = 587;

		// Set the email message settings
		$mail->setFrom($email, 'User Name');
		$mail->addAddress($email, 'User Name');
		$mail->Subject = 'Test Email';
		$mail->Body    = 'This is a test email.';

		// Connect to the SMTP server and send the email
		if (!$mail->send()) {
		    echo '<p>Error: Message could not be sent.</p>';
		    echo '<p>Mailer Error: ' . $mail->ErrorInfo . '</p>';
		} else {
		    echo '<p>Success: Message sent successfully.</p>';
		}

		// Disconnect from the SMTP server
		$mail->smtpClose();
	}
?>



// // Load the autoloader
// require 'vendor/autoload.php';

// if (isset($_POST['submit'])) {
//     // Retrieve the user's email and password from the form
//     $email = $_POST['email'];
//     $password = $_POST['password'];

//     // Create a new PHPMailer instance
//     $mail = new PHPMailer\PHPMailer\PHPMailer();

//     // Set the SMTP server settings (replace with your own)
//     $mail->isSMTP();
//     $mail->Host       = 'smtp.example.com';
//     $mail->SMTPAuth   = true;
//     $mail->Username   = $email;
//     $mail->Password   = $password;
//     $mail->SMTPSecure = 'tls';
//     $mail->Port       = 587;

//     // Set the email message settings
//     $mail->setFrom($email, 'User Name');
//     $mail->addAddress($email, 'User Name');
//     $mail->Subject = 'Test Email';
//     $mail->Body    = 'This is a test email.';

//     // Connect to the SMTP server and send the email
//     if (!$mail->send()) {
//         echo '<p>Error: Message could not be sent.</p>';
//         echo '<p>Mailer Error: ' . $mail->ErrorInfo . '</p>';
//     } else {
//         echo '<p>Success: Message sent successfully.</p>';
//     }

//     // Disconnect from the SMTP server
//     $mail->smtpClose();
// }
