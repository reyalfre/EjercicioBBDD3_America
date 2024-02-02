Create table Pais(
    Id tinyint primary key,
    Nombre Varchar(15),
    Tamanio varchar(15)) Engine=InnoDB;

Create table Persona(
    Id int primary key,
    Nombre Varchar(15),
    Apellido varchar(15),
    Edad tinyint,
    Pais tinyint)Engine=InnoDB;

Alter Table Persona add Foreign key (Pais) References Pais(Id);

Insert into Pais values (1, 'Chile', 'Grande');
Insert into Pais values (2, 'Costa Rica', 'Pequenio');
Insert into Pais values (3, 'Mexico', 'Mediano');
Insert into Pais values (4, 'Venezuela', 'Mediano');


Insert into Persona values (1, 'Frank', 'Malfoy', 16,1);
Insert into Persona values (2, 'Alis', 'Rodriguez', 30,2);
Insert into Persona values (3, 'Karen', 'Juarez', 22,1);
Insert into Persona values (4, 'Andrea', 'Fernandez', 21,3);
Insert into Persona values (5, 'Alesa', 'Benede', 13,4);
Insert into Persona values (6, 'Henry', 'Gonzalez', 21,2);
Insert into Persona values (7, 'Daniel', 'Hidalgo', 16,1);
Insert into Persona values (8, 'Roy', 'Castro', 20,4);
Insert into Persona values (9, 'Sabrina', 'de la Torre', 18,2);