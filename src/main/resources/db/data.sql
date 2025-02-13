INSERT IGNORE INTO companies (cuit, business_name, adhesion_date) VALUES
('20-12345678-1', 'Empresa Uno', '2024-12-10 10:30:00'),
('20-87654321-2', 'Empresa Dos', '2024-12-15 15:45:00'),
('27-23456789-3', 'Empresa Tres', '2024-12-20 08:20:00'),

('30-34567890-4', 'Empresa Cuatro', '2025-01-05 09:00:00'),
('30-45678901-5', 'Empresa Cinco', '2025-01-12 14:15:00'),
('33-56789012-6', 'Empresa Seis', '2025-01-25 17:30:00'),

('34-67890123-7', 'Empresa Siete', '2025-02-02 11:10:00'),
('34-78901234-8', 'Empresa Ocho', '2025-02-14 13:25:00'),
('35-89012345-9', 'Empresa Nueve', '2025-02-21 16:40:00'),
('35-90123456-0', 'Empresa Diez', '2025-02-28 19:55:00');

INSERT IGNORE INTO transfers (amount, company_id, debit_account, credit_account, date) VALUES
(15000.50, (SELECT id FROM companies WHERE cuit = '20-12345678-1'), '123-456789-01', '987-654321-09', '2024-12-02 09:15:00'),
(3200.75, (SELECT id FROM companies WHERE cuit = '20-87654321-2'), '111-222333-04', '444-555666-07', '2024-12-05 11:30:00'),
(50000.00, (SELECT id FROM companies WHERE cuit = '27-23456789-3'), '222-333444-05', '555-666777-08', '2024-12-08 15:45:00'),
(4500.25, (SELECT id FROM companies WHERE cuit = '30-34567890-4'), '333-444555-06', '666-777888-09', '2024-12-11 17:10:00'),
(23000.80, (SELECT id FROM companies WHERE cuit = '30-45678901-5'), '444-555666-07', '777-888999-10', '2024-12-15 10:20:00'),
(12500.60, (SELECT id FROM companies WHERE cuit = '33-56789012-6'), '555-666777-08', '888-999000-11', '2024-12-20 13:55:00'),
(9800.90, (SELECT id FROM companies WHERE cuit = '34-67890123-7'), '666-777888-09', '999-000111-12', '2024-12-22 08:40:00'),
(17500.35, (SELECT id FROM companies WHERE cuit = '34-78901234-8'), '777-888999-10', '000-111222-13', '2025-01-03 14:05:00'),
(2800.65, (SELECT id FROM companies WHERE cuit = '35-89012345-9'), '888-999000-11', '111-222333-14', '2025-01-06 16:30:00'),
(42000.45, (SELECT id FROM companies WHERE cuit = '35-90123456-0'), '999-000111-12', '222-333444-15', '2025-01-10 12:25:00'),
(3900.15, (SELECT id FROM companies WHERE cuit = '20-12345678-1'), '000-111222-13', '333-444555-16', '2025-01-14 19:40:00'),
(20500.75, (SELECT id FROM companies WHERE cuit = '20-87654321-2'), '111-222333-14', '444-555666-17', '2025-01-17 10:10:00'),
(11500.20, (SELECT id FROM companies WHERE cuit = '27-23456789-3'), '222-333444-15', '555-666777-18', '2025-01-21 15:55:00'),
(8900.30, (SELECT id FROM companies WHERE cuit = '30-34567890-4'), '333-444555-16', '666-777888-19', '2025-01-25 18:15:00'),
(19000.90, (SELECT id FROM companies WHERE cuit = '30-45678901-5'), '444-555666-17', '777-888999-20', '2025-02-01 09:45:00'),
(3300.85, (SELECT id FROM companies WHERE cuit = '33-56789012-6'), '555-666777-18', '888-999000-21', '2025-02-04 11:55:00'),
(46000.25, (SELECT id FROM companies WHERE cuit = '34-67890123-7'), '666-777888-19', '999-000111-22', '2025-02-08 14:20:00'),
(3700.50, (SELECT id FROM companies WHERE cuit = '34-78901234-8'), '777-888999-20', '000-111222-23', '2025-02-12 16:45:00'),
(22500.80, (SELECT id FROM companies WHERE cuit = '35-89012345-9'), '888-999000-21', '111-222333-24', '2025-02-16 10:30:00'),
(13000.40, (SELECT id FROM companies WHERE cuit = '35-90123456-0'), '999-000111-22', '222-333444-25', '2025-02-20 13:10:00'),
(8700.60, (SELECT id FROM companies WHERE cuit = '20-12345678-1'), '000-111222-23', '333-444555-26', '2025-02-25 08:50:00');
