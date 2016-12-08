<?php

    $con = mysqli_connect("mysql4.000webhost.com", "a6915637_user", "limite123", "a6915637_Horario");
    
    $matricula = $_POST["matricula"];
    $password = $_POST["password"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM ALUMNOS WHERE matricula = ? AND password = ?");
    mysqli_stmt_bind_param($statement, "ss", $matricula, $password);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $matricula, $name, $app, $apm, $correo,$carrera,$semestre,$paswword);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["matricula"] = $matricula;
        $response["name"] = $name;
        $response["app"] = $app;
        $response["apm"] = $apm;
        $response["correo"] = $correo;
        $response["carrera"] = $carrera;
        $response["semestre"] = $semestre;
        $response["password"] = $password;
    }
    
    echo json_encode($response);
    mysqli_close($con);
?>
