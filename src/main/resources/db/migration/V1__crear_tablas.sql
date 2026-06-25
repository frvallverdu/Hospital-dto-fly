-- V1: Creacion de tablas iniciales del sistema Hospital_vm

CREATE TABLE IF NOT EXISTS tipo_usuario (
    id      INT AUTO_INCREMENT PRIMARY KEY,
    nombre  VARCHAR(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS medico (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    run_medico      VARCHAR(10) NOT NULL,
    nombre_completo VARCHAR(255) NOT NULL,
    especialidad    VARCHAR(100),
    jefe_turno      CHAR(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS paciente (
    id               INT AUTO_INCREMENT PRIMARY KEY,
    run              VARCHAR(13) NOT NULL UNIQUE,
    nombres          VARCHAR(255) NOT NULL,
    apellidos        VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE,
    correo           VARCHAR(255) NOT NULL,
    id_tipo          INT NOT NULL,
    CONSTRAINT fk_paciente_tipo FOREIGN KEY (id_tipo) REFERENCES tipo_usuario(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS ficha_paciente (
    id_paciente         INT PRIMARY KEY,
    datos_personales_1  VARCHAR(100) NOT NULL,
    datos_personales_2  VARCHAR(100) NOT NULL,
    datos_personales_3  VARCHAR(100) NOT NULL,
    datos_personales_4  VARCHAR(100) NOT NULL,
    datos_personales_5  VARCHAR(100) NOT NULL,
    CONSTRAINT fk_ficha_paciente FOREIGN KEY (id_paciente) REFERENCES paciente(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS atencion (
    id              INT AUTO_INCREMENT PRIMARY KEY,
    fecha_atencion  DATE           NOT NULL,
    hora_atencion   TIME           NOT NULL,
    costo           DECIMAL(10,2)  NOT NULL,
    id_paciente     INT            NOT NULL,
    id_medico       INT            NOT NULL,
    comentario      VARCHAR(300),
    CONSTRAINT fk_atencion_paciente FOREIGN KEY (id_paciente) REFERENCES paciente(id),
    CONSTRAINT fk_atencion_medico   FOREIGN KEY (id_medico)   REFERENCES medico(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
