<?php
$server_name = "localhost";
$username = "root";
$password = "";
$dbname = "gym";

$conn = new mysqli($server_name, $username, $password, $dbname);
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = $conn->prepare("SELECT Distinct n.type  from nutrition_programs n ;");

$sql->execute();
$sql->bind_result($type);

$resultarray = array();
while ($sql->fetch()) {
    $temp = array();
    $temp['type'] = $type;

    array_push($resultarray, $temp);
}
echo json_encode($resultarray);
$conn->close();

?>
