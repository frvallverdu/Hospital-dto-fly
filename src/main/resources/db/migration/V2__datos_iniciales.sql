-- V2: Datos semilla iniciales

INSERT INTO tipo_usuario (nombre) VALUES
    ('Particular'),
    ('FONASA'),
    ('ISAPRE');

INSERT INTO medico (run_medico, nombre_completo, especialidad, jefe_turno) VALUES
    ('12345678-9', 'Dr. Juan Perez',      'Medicina General', 'S'),
    ('98765432-1', 'Dra. Ana Gonzalez',   'Cardiologia',       'N'),
    ('11223344-5', 'Dr. Carlos Rojas',    'Traumatologia',     'N');
