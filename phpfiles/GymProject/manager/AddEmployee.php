<?php
$response=array();
$connect=mysqli_connect(
    "localhost",
    "root",
    "",
    "gym");

if(isset($_REQUEST['manger_id']) && isset($_REQUEST['user_name']) && isset($_REQUEST['password']) && isset($_REQUEST['name']) && isset($_REQUEST['phone']) && isset($_REQUEST['salary']) )
{

    $manger_id = $_REQUEST['manger_id'];
    $user_name =$_REQUEST['user_name'];
    $password = $_REQUEST['password'];
        $name = $_REQUEST['name'];
    $phone = $_REQUEST['phone'];
    $salary = $_REQUEST['salary'];
    $sql=mysqli_query($connect,"insert into employee (manger_id,user_name,password,name,phone,salary) values
                                                         ('$manger_id','$user_name','$password','$name','$phone','$salary')");
    if($sql)
    {
        $response['success']=1;
        $response['message']="success";
    }

    echo json_encode($response);
}
?>