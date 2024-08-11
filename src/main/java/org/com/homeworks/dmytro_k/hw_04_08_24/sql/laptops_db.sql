use laptops;

CREATE TABLE laptops(
laptop_id INT AUTO_INCREMENT PRIMARY KEY,
model VARCHAR(50),
manufacturer VARCHAR(50),
release_date DATE,
RAM_capacity INT,
SSD_capacity INT,
processor VARCHAR(100)
);

INSERT INTO laptops (model, manufacturer, release_date, RAM_capacity, SSD_capacity, processor)
VALUES
('XPS 13',              'Dell',      '2022-03-01', 16,  512, 'Intel Core i7-1165G7'),
('MacBook Air',         'Apple',     '2022-06-01', 8,   256, 'Apple M1'),
('ThinkPad X1 Carbon',  'Lenovo',    '2022-01-15', 16,  1024,'Intel Core i7-1165G7'),
('Spectre x360',        'HP',        '2021-11-05', 16,  512, 'Intel Core i7-10750H'),
('Surface Laptop 4',    'Microsoft', '2021-04-13', 16,  512, 'AMD Ryzen 7 4980U'),
('ROG Zephyrus G14',    'Asus',      '2021-03-10', 16,  1024,'AMD Ryzen 9 4900HS'),
('Swift 3',             'Acer',      '2020-09-01', 8,   256, 'Intel Core i5-1035G1'),
('Gram 17',             'LG',        '2022-02-25', 16,  512, 'Intel Core i7-1165G7'),
('Yoga 9i',             'Lenovo',    '2021-12-11', 16,  1024,'Intel Core i7-1185G7'),
('Inspiron 15',         'Dell',      '2021-10-23', 8,   256, 'Intel Core i5-1135G7'),
('MacBook Pro',         'Apple',     '2022-01-10', 16,  512, 'Apple M1 Pro'),
('Elite Dragonfly',     'HP',        '2021-08-05', 16,  512, 'Intel Core i7-1165G7'),
('MateBook X Pro',      'Huawei',    '2021-07-15', 16,  512, 'Intel Core i7-10510U'),
('Pixelbook Go',        'Google',    '2020-11-05', 8,   128, 'Intel Core i5-8200Y'),
('VivoBook S15',        'Asus',      '2021-09-20', 8,   512, 'Intel Core i7-1165G7'),
('Pavilion 15',         'HP',        '2021-05-30', 8,   256, 'Intel Core i5-1135G7'),
('Legion 5',            'Lenovo',    '2021-03-14', 16,  1024,'AMD Ryzen 7 5800H'),
('Latitude 7420',       'Dell',      '2021-02-10', 16,  512, 'Intel Core i7-1185G7'),
('Blade 15',            'Razer',     '2022-04-01', 16,  1024,'Intel Core i7-11800H'),
('ProBook 450',         'HP',        '2020-08-25', 8,   256, 'Intel Core i5-10210U'),
('Galaxy Book Pro 360', 'Samsung',   '2021-05-10', 16,  512, 'Intel Core i7-1165G7'),
('Tecra A50',           'Toshiba',   '2020-10-10', 8,   256, 'Intel Core i5-1035G1'),
('ThinkPad E15',        'Lenovo',    '2020-12-20', 8,   256, 'Intel Core i5-10210U'),
('Aspire 5',            'Acer',      '2021-01-15', 8,   512, 'Intel Core i5-1135G7'),
('Yoga Slim 7',         'Lenovo',    '2021-03-01', 16,  512, 'AMD Ryzen 7 4800U'),
('OMEN 15',             'HP',        '2021-04-20', 16,  1024,'AMD Ryzen 7 5800H'),
('Envy 13',             'HP',        '2021-06-30', 16,  512, 'Intel Core i7-1165G7'),
('Vivobook 14',         'Asus',      '2021-07-12', 8,   256, 'AMD Ryzen 5 4500U'),
('ThinkBook 14s Yoga',  'Lenovo',    '2021-10-05', 16,  512, 'Intel Core i7-1165G7'),
('ExpertBook B9',       'Asus',      '2022-01-25', 16,  1024,'Intel Core i7-1165G7');
