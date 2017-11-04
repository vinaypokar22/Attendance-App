<?php
$username=$_POST["id"];
$password=$_POST["pass"];

$conn = new mysqli("localhost", "root", "", "attendance");

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 

$sql = "SELECT id, pass FROM login WHERE id=$username";
$result = $conn->query($sql);

if($result->num_rows > 0) {
    while($row = $result->fetch_assoc()) {
        #echo $row["id"]." ".$row["pass"]."<br>";
		if($username==$row["id"] && $password==$row["pass"])
			echo "true";
    }
}
else {
    echo "false";
}
$conn->close();
?>