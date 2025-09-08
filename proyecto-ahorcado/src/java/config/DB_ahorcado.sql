-- Drop database if exists DB_ahorcado;
create database DB_ahorcado;
use DB_ahorcado;

create table palabras (
    codigoPalabra int auto_increment key,
    nombre varchar(50) not null,
    pista1 varchar(255) not null,
    pista2 varchar(255) not null,
    pista3 varchar(255) not null
);

insert into palabras (nombre, pista1, pista2, pista3) values
('Estrella', 'Brilla en el cielo', 'Forma constelaciones', 'Se ve de noche'),
('Computar', 'Se usa para procesar datos', 'Puede ser portátil', 'Tiene memoria y CPU'),
('Montañas', 'Elevaciones de tierra', 'Forman cadenas', 'Pueden tener nieve'),
('Bicicleta', 'Tiene dos ruedas', 'Se usa para transportarse', 'Requiere pedales'),
('Cocodrilo', 'Reptil grande', 'Vive en ríos y lagos', 'Tiene dientes afilados');

delimiter $$
create procedure sp_listarPalabras()
begin
    select 
        codigoPalabra,
        nombre,
        pista1,
        pista2,
        pista3
    from palabras;
end $$
delimiter ;

call sp_listarPalabras();
