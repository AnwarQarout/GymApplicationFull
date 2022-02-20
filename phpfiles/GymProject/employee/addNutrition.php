<?php
$response=array();
$connect=mysqli_connect("localhost","root","","gym");

if(isset($_REQUEST['employee_id']) && isset($_REQUEST['name']) && isset($_REQUEST['type']) && isset($_REQUEST['membership'])&& isset($_REQUEST['image']))
{
    $employee_id=$_REQUEST['employee_id'];
    $name=$_REQUEST['name'];
    $type=$_REQUEST['type'];
    $membership=$_REQUEST['membership'];
    $image=$_REQUEST['image'];
    $sql=mysqli_query($connect,"INSERT INTO `nutrition_programs`( `employee_id`, `name`, `type`, `membership`, `image`) VALUES
                                                                      ('$employee_id','$name','$type','$membership','$image')");
    if($sql)
    {
        $response['message']="success";
    }
    else
    {
        $response['message']="Error";
    }
    echo json_encode($response);
}
?>
