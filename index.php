<?php
$servername = "mysql3.000webhost.com";
$username = "a7296609_root123";
$password = "android1234";
$dbname = "a7296609_testdb";


    $name  = urldecode($_GET['name']);
         $user     = urldecode($_GET['user']);
         $email   = urldecode($_GET['email']);
         $pass    = urldecode($_GET['pass']);
 

// Create connection
$conn = mysqli_connect($servername, $username, $password, $dbname);
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}

$sql = "INSERT INTO android (firstname, lastname)
VALUES ('$name', '$user')";

if (mysqli_query($conn, $sql)) {
    echo "New record created successfully";
} else {
    echo "Error: " . $sql . "<br>" . mysqli_error($conn);
}

mysqli_close($conn);
?> 
