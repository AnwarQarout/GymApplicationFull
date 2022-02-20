<?php
$connect=mysqli_connect(
    "localhost",
    "root",
    "",
    "gym");
if( isset($_REQUEST['salary']) && isset($_REQUEST['id']) )
{
    $id=$_REQUEST['id'];
    $salary = $_REQUEST['salary'];

    $data="UPDATE employee SET salary='$salary' WHERE id='$id'";
    mysqli_query($connect,$data);
    if($data)
    {
        $response['success']=1;
        $response['message']="success";
    }

    echo json_encode($response);
}
?>