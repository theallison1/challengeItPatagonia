-- Insertar datos en la tabla Empresa (con ID manual)
INSERT INTO Empresa (id, cuit, razon_social, fecha_adhesion) VALUES
(1, '30-12345678-9', 'Empresa A', '2023-01-01'),
(2, '30-87654321-0', 'Empresa B', '2023-02-15');

-- Insertar datos en la tabla Transferencia (sin especificar el ID)
INSERT INTO Transferencia (importe, cuenta_debito, cuenta_credito, fecha_transferencia, empresa_id) VALUES
(1000.0, 'Cuenta1', 'Cuenta2', '2023-10-01', 1),
(2000.0, 'Cuenta3', 'Cuenta4', '2023-10-05', 1),
(1500.0, 'Cuenta5', 'Cuenta6', '2023-09-20', 2);

-- Reiniciar la secuencia de generación de ID para la tabla Empresa
ALTER TABLE Empresa ALTER COLUMN id RESTART WITH 3;