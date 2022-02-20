<?php
$response=array();
$connect=mysqli_connect("localhost","root","","gym");

if(isset($_REQUEST['user_name']) && isset($_REQUEST['password']) && isset($_REQUEST['name']) && isset($_REQUEST['phone'])&& isset($_REQUEST['height'])&& isset($_REQUEST['weight']) )
{
    $employee_id = $_REQUEST['employee_id'];
    $user_name = $_REQUEST['user_name'];
    $password = $_REQUEST['password'];
    $name = $_REQUEST['name'];
    $phone = $_REQUEST['phone'];
    $height = $_REQUEST['height'];
    $weight = $_REQUEST['weight'];

    $sql=mysqli_query($connect,"INSERT INTO `member`(`employee_id`, `user_name`, `password`, `name`, `phone`, `height`, `weight`) values 
    ('$employee_id','$user_name','$password','$name','$phone','$height','$weight')");
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