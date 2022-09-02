# Grupo-Rojas_Magnatera_Granda

La presente aplicación consta de un planificador de consultas ciudadanas, el cual le permite a un usuario determinado levantar mociones populares, tener un registro de las
consultas que este se han creado, y finalmente responder otras consultas creadas por otros usuarios.

Los datos recopilados y cargados al inicio de la aplicación se encuentran almacenados en archivos .csv, los cuales tienen la siguiente distribución:

bd_personas.csv:  identificadorDeUsuario;rutDeUsuario;nombreUsuario;géneroUsuario;edadUsuario;númeroDeContacto
bd_consultas.csv: identificadorDeConsulta;identificadorDeCreadorDeLaConsulta;descripciónDeConsulta
bd_respuesta.csv: idetificadorDeConsultaRespondida;identificadorDeUsuarioQueRespondió;respuesta
