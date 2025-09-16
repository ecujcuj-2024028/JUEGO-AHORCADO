-- drop database if exists DB_ahorcado;
create database DB_ahorcado;
use DB_ahorcado;

create table palabras (
    codigo_palabra int auto_increment,
    nombre varchar(50) not null,
    pista_1 varchar(255) not null,
    pista_2 varchar(255) not null,
    pista_3 varchar(255) not null,
    primary key pk_codigo_palabra (codigo_palabra)
);

insert into palabras (nombre, pista_1, pista_2, pista_3) values
('estrella', 'brilla en el cielo', 'forma constelaciones', 'se ve de noche'),
('computar', 'se usa para procesar datos', 'puede ser portátil', 'tiene memoria y cpu'),
('montañas', 'elevaciones de tierra', 'forman cadenas', 'pueden tener nieve'),
('bicicleta', 'tiene dos ruedas', 'se usa para transportarse', 'requiere pedales'),
('cocodrilo', 'reptil grande', 'vive en ríos y lagos', 'tiene dientes afilados');

create table usuarios (
    codigo_usuario int auto_increment,
    nombre_usuario varchar(50) not null unique,
    correo varchar(100) not null unique,
    fecha_registro datetime,
    password varchar(250),
    primary key pk_codigo_usuario (codigo_usuario)
);

insert into usuarios (nombre_usuario, correo, fecha_registro, password) values
('carlos23', 'carlos23@gmail.com', '2025-01-10 14:32:00', '1234'),
('maria88', 'maria88@yahoo.com', '2025-02-05 09:15:00', 'abcd'),
('juanito7', 'juanito7@hotmail.com', '2025-02-18 20:45:00', 'juan123'),
('lauraX', 'laurax@gmail.com', '2025-03-01 11:22:00', 'laura321'),
('pedro99', 'pedro99@gmail.com', '2025-03-15 16:40:00', 'pedro999'),
('sofia12', 'sofia12@hotmail.com', '2025-04-02 08:10:00', 'sofia12'),
('andres45', 'andres45@gmail.com', '2025-04-20 21:05:00', 'andres45'),
('dianaQ', 'diana.q@yahoo.com', '2025-05-10 13:55:00', 'dianaQpass'),
('luisito', 'luisito@gmail.com', '2025-06-03 07:50:00', 'luisito123'),
('valentina', 'valentina@hotmail.com', '2025-06-25 19:35:00', 'valentina1');




delimiter $$
create procedure sp_listar_palabras()
begin
    select 
        codigo_palabra,
        nombre,
        pista_1,
        pista_2,
        pista_3
    from palabras;
end $$
delimiter ;

call sp_listar_palabras();
