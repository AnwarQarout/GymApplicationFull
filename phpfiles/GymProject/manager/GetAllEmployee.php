<?php
    $server_name = "localhost";
    $username = "root";
    $password = "";
    $dbname = "gym";

    $conn = new mysqli($server_name, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = $conn->prepare("SELECT * from employee") ;
    $sql->execute() ;
    $sql->bind_result($id,$manger_id ,$user_name,$password,$name,$phone,$salary) ;

    $resultarray = array();
    while ($sql ->fetch()) {
        $temp = array() ;
        $temp['id'] = $id ;
        $temp['manger_id'] = $manger_id ;
        $temp['user_name'] = $user_name ;
        $temp['password'] = $password ;
        $temp['name'] = $name ;
        $temp['phone'] = $phone ;
        $temp['salary'] = $salary ;
        array_push($resultarray,$temp) ;
    }
    echo json_encode($resultarray);
    $conn->close();
?>