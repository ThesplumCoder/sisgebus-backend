# SISGEBUS Backend
El Sistema de Gestión de Buses (SISGEBUS) es una aplicación web que permite conocer el estado actual 
del sistema de transporte público, pero también permite hacer compra de pasajes.

## Base de Datos
Para esta aplicación se decidió usar MySQL como gestor de base de datos.

### Modelo Relacional
### Creación de la BD
Creación de la base de datos:
```SQL
CREATE DATABASE sisgebus;
USE sisgebus;
```
Creamos el usuario para la base de datos, puede ser cualquier otro pero hay que asegurarnos de que 
tenga todos los permisos sobre la base de datos creada:
```SQL
CREATE USER 'sisgebus_user'@'%' IDENTIFIED BY 'sisgebus_password';
GRANT ALL ON sisgebus.* TO 'sisgebus_user'@'%';
```
Creamos las tablas:
```SQL
CREATE TABLE passenger (
id CHAR(36),
name VARCHAR(100),
card CHAR(36),
busTickets INT,
PRIMARY KEY (id)
);

CREATE TABLE card (
id CHAR(36),
type VARCHAR(10),
PRIMARY KEY (id)
);
```
