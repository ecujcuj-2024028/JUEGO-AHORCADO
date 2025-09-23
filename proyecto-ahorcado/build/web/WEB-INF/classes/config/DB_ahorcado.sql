-- drop database if exists DB_ahorcado;
create database DB_ahorcado;
use DB_ahorcado;

create table palabras (
    codigo_palabra int auto_increment,
    nombre varchar(50) not null,
    pista_1 varchar(255) not null,
    pista_2 varchar(255) not null,
    pista_3 varchar(255) not null,
    imagen varchar(255) not null,
    primary key pk_codigo_palabra (codigo_palabra)
);

insert into palabras (nombre, pista_1, pista_2, pista_3, imagen) values
('estrella', 'brilla en el cielo', 'forma constelaciones', 'se ve de noche', 'estrella.jpg'),
('computadora', 'se usa para procesar datos', 'puede ser portátil', 'tiene memoria y cpu', 'computadora.jpg'),
('montañas', 'elevaciones de tierra', 'forman cadenas', 'pueden tener nieve', 'montaña.jpg'),
('bicicleta', 'tiene dos ruedas', 'se usa para transportarse', 'requiere pedales', 'bicicleta.jpg'),
('cocodrilo', 'reptil grande', 'vive en ríos y lagos', 'tiene dientes afilados', 'cocodrilo');

create table usuarios (
    codigo_usuario int auto_increment,
    nombre_usuario varchar(50) not null unique,
    correo varchar(100) not null unique,
    fecha_registro datetime,
    password varchar(250),
    primary key pk_codigo_usuario (codigo_usuario)
);

insert into usuarios (nombre_usuario, correo, fecha_registro, password) values
('leo', 'leo@gmail.com', '2025-01-10 14:32:00', '123');

delimiter $$
create procedure sp_listar_palabras()
begin
    select 
        codigo_palabra,
        nombre,
        pista_1,
        pista_2,
        pista_3,
        imagen
    from palabras;
end $$
delimiter ;

call sp_listar_palabras();

delimiter $$
create procedure sp_listar_usuarios()
begin
    select 
        codigo_usuario,
        nombre_usuario,
        correo,
        fecha_registro,
        password
    from usuarios;
end $$
delimiter ;

call sp_listar_usuarios();
