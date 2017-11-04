<?php
// Create connection
$roll=$_POST["id"];
$conn = mysqli_connect("localhost", "root", "", "attendance");
// Check connection
if (!$conn) {
    die("Connection failed: " . mysqli_connect_error());
}
$sql = "UPDATE cse set pa='pre' where rollno=$roll";

if (mysqli_query($conn, $sql)) {
    echo "true";
} else {
    echo "false";
}

mysqli_close($conn);
?>