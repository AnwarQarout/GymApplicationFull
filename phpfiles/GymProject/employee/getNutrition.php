<?php


$selectedMembership = "";
if (isset($_GET['selectedMembership'])) {
    $selectedMembership = $_GET['selectedMembership'];
}
if (!empty($selectedMembership)) {
    $server_name = "localhost";
    $username = "root";
    $password = "";
    $dbname = "gym";

    $conn = new mysqli($server_name, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = $conn->prepare("SELECT *  from nutrition_programs n
            WHERE  n.membership = '" . $selectedMembership . "';");
           
    $sql->execute() ;
    $sql->bind_result($id,$employee_id,$name,$type,$membership,$image) ;

    $resultarray = array();
    while ($sql ->fetch()) {
        $temp = array() ;
        $temp['id'] = $id ;
        $temp['employee_id'] = $employee_id ;
        $temp['name'] = $name ;
        $temp['type'] = $type ;
        $temp['membership'] = $membership ;
        $temp['image'] = $image;
        array_push($resultarray,$temp) ;
    }
    echo json_encode($resultarray);
    $conn->close();
}
?>
