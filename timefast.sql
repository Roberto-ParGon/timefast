CREATE DATABASE timefast;
USE timefast;

CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidoPaterno VARCHAR(50) NOT NULL,
    apellidoMaterno VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    telefono VARCHAR(20) NOT NULL,
    codigoPostal VARCHAR(10) NOT NULL,
    calle VARCHAR(100) NOT NULL,
    numero VARCHAR(10) NOT NULL,
    colonia VARCHAR(100) NOT NULL
);

CREATE TABLE Colaborador (
    curp VARCHAR(18) PRIMARY KEY NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    apellidoPaterno VARCHAR(50) NOT NULL,
    apellidoMaterno VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL,
    pass VARCHAR(100) NOT NULL,
    foto LONGBLOB,
	numLicencia VARCHAR(50),
    rol ENUM('Administrador', 'Ejecutivo de tienda','Conductor') NOT NULL
);

CREATE TABLE DireccionOrigen (
    idOrigen INT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(100) NOT NULL,
	numero VARCHAR(10) NOT NULL,
    colonia VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL
);

CREATE TABLE DireccionDestino (
    idDestino INT PRIMARY KEY AUTO_INCREMENT,
    calle VARCHAR(100) NOT NULL,
	numero VARCHAR(10) NOT NULL,
    colonia VARCHAR(100) NOT NULL,
    ciudad VARCHAR(100) NOT NULL,
    estado VARCHAR(100) NOT NULL
);

CREATE TABLE Paquete(
	numGuia INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    descripcion VARCHAR(100) NOT NULL,
    peso INT NOT NULL,
    alto INT NOT NULL,
    profundidad INT NOT NULL,
    ancho INT NOT NULL
);


CREATE TABLE Estatus(
	idEstatus INT PRIMARY KEY AUTO_INCREMENT,
    estado VARCHAR(50) NOT NULL DEFAULT 'Pendiente',
    fecha DATE NOT NULL,
    hora TIME NOT NULL,
    curp VARCHAR(18) NOT NULL,
    FOREIGN KEY (curp) REFERENCES Colaborador(curp)
);


CREATE TABLE Envio (
    idEnvio INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    costo DECIMAL(10,2) NOT NULL,
    numGuia INT UNIQUE NOT NULL,
    idOrigen INT NOT NULL,
    idDestino INT NOT NULL,
    idEstatus INT NOT NULL,
    curp VARCHAR(18) NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (numGuia) REFERENCES Paquete(numGuia),
    FOREIGN KEY (idOrigen) REFERENCES DireccionOrigen(idOrigen),
    FOREIGN KEY (idDestino) REFERENCES DireccionDestino(idDestino),
    FOREIGN KEY (idEstatus) REFERENCES Estatus(idEstatus),
    FOREIGN KEY (curp) REFERENCES Colaborador(curp)
);

INSERT INTO Cliente (nombre, apellidoPaterno, apellidoMaterno, correo, telefono, codigoPostal, calle, numero, colonia) VALUES 
('Juan', 'Pérez', 'González', 'juan.perez@email.com', '5512345678', '54700', 'Av. Revolución', '123', 'Centro'),
('María', 'Rodríguez', 'Sánchez', 'maria.rodriguez@email.com', '5587654321', '01050', 'Paseo de la Reforma', '456', 'Juárez'),
('Carlos', 'Martínez', 'López', 'carlos.martinez@email.com', '5543210987', '80000', 'Insurgentes Sur', '789', 'Del Valle');

INSERT INTO Colaborador (curp, nombre, apellidoPaterno, apellidoMaterno, correo, pass, rol, numLicencia) VALUES 
('PRGJ850315HDFRNS09', 'Miguel', 'Ramírez', 'García', 'miguel.ramirez@timefast.com', SHA2('Miguel2024', 256), 'Administrador', NULL),
('SOLM900622MDFNRD05', 'Laura', 'Soto', 'López', 'laura.soto@timefast.com', SHA2('Laura2024', 256), 'Ejecutivo de tienda', NULL),
('GUCJ920814HDFRZN07', 'Jorge', 'Guzmán', 'Cruz', 'jorge.guzman@timefast.com', SHA2('Jorge2024', 256), 'Conductor', 'LIC987654');

INSERT INTO DireccionOrigen (calle, numero, colonia, ciudad, estado) VALUES 
('Av. Industria', '100', 'Parque Industrial', 'Guadalajara', 'Jalisco'),
('Calle Comercio', '250', 'Zona Empresarial', 'Monterrey', 'Nuevo León'),
('Boulevar Tecnológico', '50', 'Parque Tecnológico', 'Querétaro', 'Querétaro');

INSERT INTO DireccionDestino (calle, numero, colonia, ciudad, estado) VALUES 
('Av. Principal', '75', 'Residencial San Jorge', 'Ciudad de México', 'CDMX'),
('Calle Secundaria', '200', 'Fraccionamiento Los Pinos', 'Puebla', 'Puebla'),
('Camino Real', '300', 'Villa Universitaria', 'Guadalajara', 'Jalisco');

INSERT INTO Paquete (descripcion, peso, alto, profundidad, ancho) VALUES 
('Paquete de electrónica', 5, 30, 20, 25),
('Muestras médicas', 3, 25, 15, 20),
('Documentos importantes', 1, 35, 25, 30);

INSERT INTO Estatus (fecha, hora, curp) VALUES 
('2024-02-15', '10:30:00', 'SOLM900622MDFNRD05'),
('2024-02-16', '14:45:00', 'GUCJ920814HDFRZN07'),
('2024-02-17', '09:15:00', 'GUCJ920814HDFRZN07');

INSERT INTO Envio (idCliente, costo, numGuia, idOrigen, idDestino, idEstatus, curp) VALUES 
(1, 250.50, 1, 1, 1, 1, 'SOLM900622MDFNRD05'),
(2, 180.75, 2, 2, 2, 2, 'GUCJ920814HDFRZN07'),
(3, 150.25, 3, 3, 3, 3, 'GUCJ920814HDFRZN07');