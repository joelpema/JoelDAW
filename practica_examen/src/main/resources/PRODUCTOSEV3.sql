Drop database if exists prueba_examen;
create database prueba_examen;
use prueba_examen;


Create table Profesor(
                         Id_profe INT PRIMARY KEY auto_increment,
                         Nombre VarChar (50) Not Null,
                         Apellido Varchar (50),
                         Edad int Not Null,
                         Direccion Varchar (100),
                         Profesion Enum ('estudiante', 'profesor')
);