<?php
if($_SERVER['REQUEST_METHOD']=='POST'){

include 'DatabaseConfigHabib.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

$user_name = $_POST['UserName'];
    $password = $_POST['Password'];
    $name = $_POST['Name'];
    $phone = $_POST['Phone'];
    $height = $_POST['Height'];
    $weight = $_POST['Weight'];

$Sql_Query = "UPDATE member SET user_name= '$user_name', password = '$password', name = '$name' , phone ='$phone' , height ='$height' , weight ='$weight' WHERE id = $id";

 if(mysqli_query($con,$Sql_Query))
{
 echo 'Updated Successfully';
}
else
{
 echo 'Something Wrong';
 }
 }
 mysqli_close($con);
?>