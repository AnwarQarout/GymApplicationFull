<?php

$id= "";

if (isset($_POST['id'])) {
    $id = $_POST['id'];

}
$server_name = "localhost";
$username = "root";
$password = "";
$dbname = "gym";

$conn = new mysqli($server_name, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
$sql = $conn->prepare("DELETE FROM `nutrition_programs` WHERE id = ".$id." ; ") ;

$sql->execute() ;
$sql->bind_result($id) ;
?>
