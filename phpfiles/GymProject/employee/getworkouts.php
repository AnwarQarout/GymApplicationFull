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

    $sql = $conn->prepare("SELECT w.id,w.employee_id, w.name, w.steps, w.video from membership m, workout2membership w2m, workout w 
            WHERE  m.name = '" . $selectedMembership . "'  AND   m.id = w2m.membership_id AND
            w2m.workout_id = w.id ;") ;
        $sql->execute() ;
        $sql->bind_result($id,$employee_id,$name,$steps,$video) ;

    $resultarray = array();
    while ($sql ->fetch()) {
        $temp = array() ;
        $temp['id'] = $id ;
        $temp['employee_id'] = $employee_id ;
        $temp['name'] = $name ;
        $temp['steps'] = $steps ;
        $temp['video'] = $video;
        array_push($resultarray,$temp) ;
    }
    echo json_encode($resultarray);
    $conn->close();
}
?>