<?php
$response=array();
$connect=mysqli_connect("localhost","root","","gym");

if(isset($_REQUEST['id']) &&isset($_REQUEST['employee_id']) && isset($_REQUEST['name']) && isset($_REQUEST['steps']) && isset($_REQUEST['video']))
{
    $id=$_REQUEST['id'];
    $employee_id=$_REQUEST['employee_id'];
    $name=$_REQUEST['name'];
    $steps=$_REQUEST['steps'];
    $video=$_REQUEST['video'];

    $sql=mysqli_query($connect,"UPDATE workout set employee_id = '$employee_id', name ='$name' ,steps='$steps',video='$video' WHERE id= '$id'; ");
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
?>