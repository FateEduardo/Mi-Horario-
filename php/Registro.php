<?php
 $con = mysqli_connect("mysql4.000webhost.com", "a6915637_user", "limite123", "a6915637_Horario");

    $matricula = $_POST["matricula"];
    $name= $_POST["name"];
    $app= $_POST["app"];
    $apm= $_POST["apm"];
    $correo= $_POST["correo"];
    $carrera= $_POST["carrera"];
  	$semestre= $_POST["semestre"];
  	$password = $_POST["password"];

  $statement = mysqli_prepare($con, "INSERT INTO ALUMNOS (matricula, name, app, apm, correo, carrera, semestre, password) VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
  mysqli_stmt_bind_param($statement, "isssssis", $matricula, $name, $app, $apm, $correo, $carrera, $semestre, $password);
  mysqli_stmt_execute($statement);

   $response = array();
   $response["success"] = true;  

   echo json_encode($response);
   mysqli_close($con);

?>