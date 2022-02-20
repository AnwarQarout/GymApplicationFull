<?php
$response=array();
$connect=mysqli_connect("localhost","root","","gym");

if(isset($_REQUEST['employee_id']) && isset($_REQUEST['name']) && isset($_REQUEST['steps']) && isset($_REQUEST['video']))
{
    $employee_id=$_REQUEST['employee_id'];
    $name=$_REQUEST['name'];
    $steps=$_REQUEST['steps'];
    $video=$_REQUEST['video'];
    $membership=$_REQUEST['membership'];
    $membership_id ="";
    if($membership == "MassGain"){
     $membership_id = "3" ;
    }else  if($membership == "WeightLoss"){
        $membership_id = "2" ;
    }else  if($membership == "WeightGain"){
        $membership_id = "1" ;
    }

    $sql=mysqli_query($connect,"insert into workout(employee_id,name,steps,video) values ('$employee_id','$name','$steps','$video')");
    $maxId = getLastId() ;
    $sql1=mysqli_query($connect,"INSERT INTO `workout2membership`(`workout_id`, `membership_id`) VALUES ('$maxId','$membership_id')") ;



    if($sql)
    {
        $response['success']=1;
        $response['message']="success";
    }
    else
    {
        $response['success']=0;
        $response['message']="Error";
    }
    echo json_encode($response);
}


function getLastId()
{
    $dsn = "mysql:host=localhost;dbname=gym";
    $user = "root";
    $passwd = "";
    $pdo = new PDO($dsn, $user, $passwd);
    $stm = $pdo->query("SELECT MAX(id) FROM workout  ");
    $version = $stm->fetch();
    return $version[0];
}
?>