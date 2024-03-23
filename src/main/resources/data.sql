INSERT INTO car (license_plate, repair_date , customer_name           , catalog          , car_maker)
VALUES          ('29V7-65366' , '2003-11-16', 'Hoàng Mai Thảo'     , 'Bảo dưỡng lần 1',     'Honda'    ),
                ('29V7-52143' , '2021-03-05', 'Ngô Mạnh Tân'       , 'Bảo dưỡng lần 4',     'Toyota'   ),
                ('29E2-53434' , '2021-12-05', 'Lê Anh Thơ'         , 'Bảo dưỡng lần 4',     'Mercedes' );


INSERT INTO accessory (license_plate, repair_date , name         , price  , status_damaged, repair_status)
VALUES                ('29V7-52143' , '2021-03-05', 'Cần gạt mưa', 999000 , 'Bị gãy'      , 'Thay mới'   ),
                      ('29V7-65366' , '2003-11-16', 'Lọc gió'    , 199000 , 'Bị bụi bẩn'  , 'Làm sạch'   ),
                      ('29V7-65366' , '2003-11-16', 'Lốp xe'     , 2000000, 'Bị thủng'    , 'Thay lốp'   ),
                      ('29V7-65366' , '2003-11-16', 'Bình ắc quy', 1465000, 'Bị hết điện' , 'Sạc điện'   ),
                      ('29E2-53434' , '2021-12-05', 'Đèn xe'     , 369000 , 'Bị vỡ'       , 'Thay đèn'   );


INSERT INTO role (type   )
VALUES           ("ADMIN"),
                 ("USER" );



--INSERT INTO user (id,     fullname,         password,      username   )
--VALUES           (1,     'Ngô Mạnh Tân',    'hoho'  ,       'hoho'    ),
--                 (2,     'Hoàng Mai Thảo',  'thao'  ,       'thao'    );
--
--
--INSERT INTO user_role (role_id,   user_id)
--VALUES                (   2   ,      1   ),
--                      (   2   ,      2   );

