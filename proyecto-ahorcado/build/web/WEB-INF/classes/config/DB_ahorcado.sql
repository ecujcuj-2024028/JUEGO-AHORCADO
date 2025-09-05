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
('Elefante', 'Mamífero terrestre', 'Posee trompa larga', 'Vive en manadas'),
('Horizonte', 'Límite visual', 'Divide cielo y tierra', 'Depende de la perspectiva'),
('Volcán', 'Expulsa lava', 'Genera gases', 'Puede ser activo o inactivo'),
('Software', 'Conjunto de programas', 'Intangible', 'Controla el hardware'),
('Baterías', 'Almacenan energía', 'Suministran corriente', 'Pueden recargarse');

select * from palabras;