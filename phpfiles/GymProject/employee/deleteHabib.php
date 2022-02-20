<?php
if($_SERVER['REQUEST_METHOD']=='POST'){

include 'DatabaseConfigHabib.php';

 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);

 $id = $_POST['id'];

$Sql_Query = "DELETE FROM member WHERE id = '$id'";

 if(mysqli_query($con,$Sql_Query))
{
 echo 'Deleted Successfully';
}
else
{
 echo 'Something Wrong';
 }
 }
 mysqli_close($con);
?>