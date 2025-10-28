CREATE DATABASE taller;

USE taller;

CREATE TABLE CLIENTES (
    idCliente Number PRIMARY KEY,
    nombre varchar(40),
    direccion varchar(50),
    telefono Number
);

CREATE TABLE VEHICULO (
    idVehiculo Number PRIMARY KEY,
    idCliente Number,
    FOREIGN KEY (idCliente) REFERENCES CLIENTES(id),
    matricula varchar(7),
    marca varchar(30),
    modelo Number,
    anioFabricacion Number
);

CREATE TABLE FACTURAS (
    idFacturas Number PRIMARY KEY,
    idCliente Number,
    FOREIGN KEY (idCliente) REFERENCES CLIENTES(id),
    fechaEmision Number,
    montoTotal Number,
    metodoPago varchar(20)
);

CREATE TABLE REPARACIONES (
    idReparaciones Number PRIMARY KEY,
    idFacturas Number,
    FOREIGN KEY(idFacturas) REFERENCES FACTURAS(id),
    idVehiculo FOREIGN KEY(idVehiculo) REFERENCES VEHICULO(id),
    fechaInicio Number,
    fechaFinal Number,
    estado varchar(20)
);

CREATE TABLE EMPLEADOS (
    idEmpleados Number PRIMARY KEY,
    nombre varchar(35),
    especialidad varchar(30),
    fechaContratacion Number
);

CREATE TABLE reparaciones_empleados(
    idReparaciones Number,
    idEmpleados varchar(30),
    FOREIGN KEY(idReparaciones) REFERENCES REPARACIONES(id),
    FOREIGN KEY(idEmpleados) REFERENCES EMPLEADOS(id)
);

CREATE TABLE cliente_vehiculo (
    idCliente Number,
    idVehiculo Number,
    FOREIGN KEY (idCliente) REFERENCES CLIENTES(id),
    FOREIGN KEY (idVehiculo) REFERENCES VEHICULO(id)
);