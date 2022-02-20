<?php


{
    $server_name = "localhost";
    $username = "root";
    $password = "";
    $dbname = "gym";

    $conn = new mysqli($server_name, $username, $password, $dbname);
    if ($conn->connect_error) {
        die("Connection failed: " . $conn->connect_error);
    }

    $sql = $conn->prepare("SELECT * from member") ;
    $sql->execute() ;
    $sql->bind_result($id,$employee_id,$user_name,$password,$name,$phone,$image,$height,$weight) ;

    $resultarray = array();
    while ($sql ->fetch()) {
        $temp = array() ;
        $temp['id'] = $id ;
        $temp['employee_id'] = $employee_id ;
        $temp['user_name'] = $user_name ;
        $temp['password'] = $password ;
        $temp['name'] = $name;
        $temp['phone'] = $phone;
        $temp['image'] = $image;
        $temp['height'] = $height;
        $temp['weight'] = $weight;
        array_push($resultarray,$temp) ;
    }
    echo json_encode($resultarray);
    $conn->close();
}
?>