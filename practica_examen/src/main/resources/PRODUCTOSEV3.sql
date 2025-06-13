create database prueba_examen;
use prueba_examen;

Create table Asignatura(
                           id_asignatura int primary key,
                           asignatura enum ('Matematicas', 'Sociales', 'Lengua', 'Educacion_Fisica', 'Economia', 'Ingles')
);

Create table Profesor(
                         Id_profe INT PRIMARY KEY auto_increment,
                         Nombre VarChar (50) Not Null unique,
                         Apellido Varchar (50),
                         Edad int Not Null,
                         Direccion Varchar (100),
                         id_asignatura int,
                         FOREIGN KEY (id_asignatura) REFERENCES Asignatura(id_asignatura)
);
