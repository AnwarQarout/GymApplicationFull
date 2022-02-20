<?php

$id= "";
$m_id= "";
if (isset($_POST['id']) && isset($_POST['m_id'])) {
    $id = $_POST['id'];
    $m_id = $_POST['m_id'];
}
    $server_name = "localhost";
    $username = "root";
    $password = "";
    $dbname = "gym";

    $conn = new mysqli($server_name, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }
$sql = $conn->prepare("DELETE FROM `workout2membership` WHERE workout_id = ".$id." AND membership_id =".$m_id." ; ") ;

    $sql->execute() ;
    $sql->bind_result($id,$m_id) ;



?>