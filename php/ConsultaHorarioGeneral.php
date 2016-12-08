<?php

	$response = array();
	$dia = $_POST["dia"];


 	$con = mysqli_connect("mysql4.000webhost.com", "a6915637_user", "limite123", "a6915637_Horario");


    $result = mysqli_query($con, "SELECT m.nombre, m.tipo, DATE_FORMAT( h.hora_in,  '%H:%i' ) AS Hora_in, DATE_FORMAT( h.hora_fin,  '%H:%i' ) AS Hora_fin
								  FROM HORARIO h
								  INNER JOIN MATERIA m ON h.clave = m.clave
								  WHERE h.dia =1");
    
 
    $num_filas = mysqli_num_rows($result);
    if ($num_filas > 0) {
    
          $response["materias"] = array();  
   
             while($row = mysqli_fetch_array($result)){
                $data = array();
                $data["nombre"] = $row["nombre"]; 
                $data["tipo"] = $row["tipo"]; 
                $data["hora_in"] = $row["hora_in"];
                $data["hora_fin"] = $row["hora_fin"];
                array_push($response["materias"], $data);
            }
    
        $response["success"] = 1;
        echo json_encode($response);
         

    }else{

            $response["success"] = 0;
            $response["message"] = "No data";
 
            // echo no users JSON
         echo json_encode($response);

    }
?>