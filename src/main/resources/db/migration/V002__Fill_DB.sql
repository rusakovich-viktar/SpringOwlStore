
INSERT INTO "online-store".categories (name, image_path)
VALUES ('Mobile phones', 'mobile.jpg'),
       ('Laptops', 'laptop.jpg'),
       ('GPS Navigators', 'jps_nav.jpg'),
       ('Fridges', 'fridge.jpg'),
       ('Cars', 'car.jpg'),
       ('Cameras', 'camera.jpg');

INSERT INTO "online-store".users (username, password, name, surname, birthday, gender, email,
                                  registration_date)
VALUES ('admin', 'admin', 'username', 'adminovich', '20.03.1900', 'male', 'admin@tms.by', '20.03.1900'),
       ('test', 'test', 'testname', 'testovich', '20.03.1800', 'female', 'test@test.com', '20.03.1900');


INSERT INTO "online-store".products (image_path, name, description, price, category_id)
VALUES ('mobileApple.jpg', 'Смартфон Apple iPhone 13 128GB (темная ночь)', 'Apple iOS, экран 6.1'' OLED (1170x2532), Apple A15 Bionic, ОЗУ 4 ГБ, флэш-память 128 ГБ, " +
                                    "камера 12 Мп, аккумулятор 3227 мАч, 1 SIM', 2600, 1),
       ('mobileSamsung.jpg', 'Смартфон Samsung Galaxy A52 SM-A525F/DS 8GB/256GB (синий)', 'Android, экран 6.5'' AMOLED (1080x2400), Qualcomm Snapdragon 720G, ОЗУ 8 ГБ, флэш-память 256 ГБ," +
                                    " карты памяти, камера 64 Мп, аккумулятор 4500 мАч, 2 SIM', 1200, 1),
       ('laptopLenovo.jpg', 'Игровой ноутбук Lenovo Legion 5 15ACH6H 82JU00A1PB', '15.6'' 1920 x 1080 IPS, 120 Гц, несенсорный, AMD Ryzen 7 5800H 3200 МГц, 16 ГБ DDR4," +
                                    " SSD 512 ГБ, видеокарта NVIDIA GeForce RTX 3060 6 ГБ, Windows 10, цвет крышки темно-синий',
        5500, 2),
       ('laptopAcer.jpg', 'Игровой ноутбук Acer Nitro 5 AN515-45-R1A6 NH.QBREP.00B', '15.6'' 1920 x 1080 IPS, 144 Гц, несенсорный, AMD Ryzen 5 5600H 3300 МГц, 16 ГБ DDR4," +
                                    " SSD 1024 ГБ, видеокарта NVIDIA GeForce RTX 3070 8 ГБ, Linux, цвет крышки черный',
        5000, 2),
       ('navigatorGeofox.jpg', 'GPS навигатор GEOFOX MID502GPS',
        'экран 5'' TFT (800 x 480), ОЗУ 128 Мб, флэш-память 8 Гб, Windows CE 6.0', 222, 3),
       ('navigatorNavitel.jpg', 'GPS навигатор NAVITEL E707 Magnetic',
        'экран 7'' TFT (800 x 480), процессор MStar MSB2531 800 МГц, флэш-память 8 Гб, Linux', 322, 3),
       ('fridgeBosch.jpg', 'Холодильник Bosch Serie 6 VitaFresh Plus KGN39AI32R', 'Холодильник Bosch Serie 6 VitaFresh Plus KGN39AI32R" +
                                    "полка для вина, защита от отпечатков, 60x66x203 см, " +
                                    "нержавеющая сталь', 2950, 4),
       ('fridgeSamsung.jpg', 'Холодильник Samsung RB37A52N0B1/WT', '1отдельностоящий, полный No Frost, электронное управление, класс A+, " +
                                    "полезный объём: 367 л (269 + 98 л), инверторный компрессор', 2233, 4),
       ('carVolvo.jpg', 'Volvo XC40', '1.6 T3 MT Turbo Momentum', 87832, 5),
       ('carTesla.jpg', 'Tesla Model X', 'электрический двигатель, P100D Long Range', 272107, 5),
       ('cameraCanon.jpg', 'Зеркальный фотоаппарат Canon EOS 4000D Kit 18-55mm III', 'зеркальная камера, байонет Canon EF-S, матрица APS-C (1.6 crop) 18 Мп," +
                                    " с объективом F3.5-5.6 18-55 мм, Wi-Fi', 1449, 6),
       ('cameraNikon.jpg', 'Зеркальный фотоаппарат Nikon D5600 Kit 18-55mm AF-P DX VR', 'матрица APS-C (1.6 crop) 18 Мп," +
                                    " с объективом F3.5-5.6 18-55 мм, Wi-Fi', 2550, 6);
