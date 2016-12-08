<?php
 $con = mysqli_connect("mysql4.000webhost.com", "a6915637_user", "limite123", "a6915637_Horario");

    $matricula = $_POST["matricula"];
    $clave = $_POST["clave"];

  $statement = mysqli_prepare($con, "INSERT INTO HORARIOPERSONALIZADO (matricula, clave, dia_alta) VALUES(?, ?, CURDATE())");
  mysqli_stmt_bind_param($statement, "ii", $matricula, $clave);
  mysqli_stmt_execute($statement);

   $response = array();
   $response["success"] = true;  

   echo json_encode($response);
   mysqli_close($con);

?>