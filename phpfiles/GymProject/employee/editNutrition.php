<?php
$response=array();
$connect=mysqli_connect("localhost","root","","gym");

if(isset($_REQUEST['id']) &&isset($_REQUEST['employee_id']) && isset($_REQUEST['name']) && isset($_REQUEST['type']) && isset($_REQUEST['membership']) && isset($_REQUEST['image']))
{
    $id=$_REQUEST['id'];
    $employee_id=$_REQUEST['employee_id'];
    $name=$_REQUEST['name'];
    $type=$_REQUEST['type'];
    $membership=$_REQUEST['membership'];
    $image=$_REQUEST['image'];
    $sql=mysqli_query($connect,"UPDATE nutrition_programs set employee_id = '$employee_id', name ='$name' ,type='$type',membership='$membership',image='$image' WHERE id= '$id'; ");
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
