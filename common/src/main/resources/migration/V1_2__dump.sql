INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (1, 'Gelly', 'SomeAddress', 50, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2018-06-06');
INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (2, 'Toyota', 'SomeAddress', 100, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2010-01-01');
INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (3, 'Audi', 'SomeAddress', 100, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2010-01-01');
INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (4, 'Mercedes', 'SomeAddress', 100, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2011-01-01');
INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (5, 'Lada', 'SomeAddress', 100, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2012-01-01');
INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (6, 'BMW', 'SomeAddress', 100, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2013-01-01');
INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (7, 'Honda', 'SomeAddress', 100, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2014-01-01');
INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (8, 'Jeep', 'SomeAddress', 100, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2015-01-01');
INSERT INTO public.m_auto_dealer (id, name, address, capacity, created, changed, year_of_foundation)
VALUES (9, 'Lincoln', 'SomeAddress', 100, '2020-06-06 15:43:43.000000', '2020-06-06 15:43:47.000000', '2016-01-01');


INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (34, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', '666666666',
        'ыtestHibernateAndRollback!', '2020-07-09 21:51:34.156000', '2020-07-09 21:51:34.156000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (36, 'Viachaslau', 'Kalevich', '1996-07-08', 'testconverter', 'qweqwe', '2020-07-21 20:50:12.422000',
        '2020-07-21 20:50:12.423000', false, 65.5, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (6, 'Slavka', 'Kalevich', '1996-07-08', 'viachaslauk4', 'f359560c-f26c-4841-8183-f1d0577b810f',
        '2020-05-14 20:04:15.000000', '2020-05-14 20:04:19.000000', false, 65.5, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (7, 'Nikolai', 'Kolya', '2020-05-26', 'nikolas', 'f359560c-f26c-4841-8183-f1d0577b810f',
        '2020-05-26 21:53:05.005000', '2020-05-26 22:00:34.012000', false, 85, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (4, 'Viachaslau', 'Kalevich + 4', '1996-07-08', 'viachaslauk1', 'f359560c-f26c-4841-8183-f1d0577b810f',
        '2020-05-14 20:04:15.000000', '2020-05-14 20:04:19.000000', false, 74.1, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (8, 'Nikolai', 'Kolya', '2020-05-26', 'nikolasjjj', 'password', '2020-06-16 21:52:23.123000',
        '2020-06-16 21:52:23.123000', false, 85, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (9, 'qweqw', 'qweqwe', '2020-06-16', 'qwert', 'qweqwe', '2020-06-23 21:27:11.592000',
        '2020-06-23 21:27:11.592000', false, 85, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (1, 'Viachaslau', 'Kalevich', '1996-07-08', 'viachaslauk', 'qweqwe', '2020-05-14 20:04:15.000000',
        '2020-05-14 20:04:19.000000', false, 65.5, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (10, 'testprincipal', 'testprincipal', '1996-06-23', 'testprincipal', 'testprincipal',
        '2020-06-30 21:09:06.427000', '2020-06-30 21:09:06.427000', false, 55, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (11, 'testregistration', 'testregistration', '1995-06-30', 'testregistration', 'testregistration',
        '2020-06-30 21:20:13.423000', '2020-06-30 21:20:13.423000', false, 90, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (12, 'testregistration', 'testregistration', '1995-06-30', 'testregistration2', 'testregistration',
        '2020-06-30 21:27:09.271000', '2020-06-30 21:27:09.271000', false, 90, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (13, 'testregistration', 'testregistration', '1995-06-30', 'testregistration3', 'testregistration',
        '2020-06-30 21:29:22.609000', '2020-06-30 21:29:22.609000', false, 90, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (14, 'testregistration', 'testregistration', '1995-06-30', 'testregistration4', 'testregistration',
        '2020-06-30 21:30:50.571000', '2020-06-30 21:30:50.571000', false, 90, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (15, 'hibernate', 'hibernate', '1999-07-02', 'hibernate', 'hibernate', '2020-07-02 21:11:44.336000',
        '2020-07-02 21:11:44.336000', false, 90, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (16, 'testHibernateSave', 'testHibernateSave', '1996-07-08', 'testHibernateSave', 'testHibernateSave',
        '2020-07-09 20:09:34.710000', '2020-07-09 20:09:34.710000', false, 99, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (18, 'testHibernateAndRole', 'testHibernateAndRole', '1996-07-08', 'testHibernateAndRole',
        'testHibernateAndRole', '2020-07-09 20:24:10.234000', '2020-07-09 20:24:10.234000', false, 99, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (19, 'testHibernateAndSpring', 'testHibernateAndSpring', '1996-07-08', 'testHibernateAndSpring',
        'testHibernateAndSpring', '2020-07-09 21:05:32.030000', '2020-07-09 21:05:32.030000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (20, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'testHibernateAndRollback!',
        'testHibernateAndRollback!', '2020-07-09 21:08:05.689000', '2020-07-09 21:08:05.689000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (21, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'testHibernateAndRollback555!',
        'testHibernateAndRollback!', '2020-07-09 21:10:51.808000', '2020-07-09 21:10:51.808000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (22, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'testHibernateAndRollback777!',
        'testHibernateAndRollback!', '2020-07-09 21:14:26.357000', '2020-07-09 21:14:26.357000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (23, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'testHibernateAndRollback77799!',
        'testHibernateAndRollback!', '2020-07-09 21:18:46.629000', '2020-07-09 21:18:46.629000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (24, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'testHibernateAndRollback77799000!',
        'testHibernateAndRollback!', '2020-07-09 21:23:32.617000', '2020-07-09 21:23:32.617000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (25, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'rollbackplease!',
        'testHibernateAndRollback!', '2020-07-09 21:26:50.580000', '2020-07-09 21:26:50.580000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (27, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'rollbackplease77!',
        'testHibernateAndRollback!', '2020-07-09 21:32:00.331000', '2020-07-09 21:32:00.331000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (28, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'rollbackplease7887!',
        'testHibernateAndRollback!', '2020-07-09 21:35:23.824000', '2020-07-09 21:35:23.824000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (29, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'rollbackplease788awdawd7!',
        'testHibernateAndRollback!', '2020-07-09 21:40:11.356000', '2020-07-09 21:40:11.356000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (30, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'rollbackplease788awdawd7wefsfd!',
        'testHibernateAndRollback!', '2020-07-09 21:42:48.855000', '2020-07-09 21:42:48.855000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (31, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', 'rollbackplease788awdawd777wefsfd!',
        'testHibernateAndRollback!', '2020-07-09 21:44:10.704000', '2020-07-09 21:44:10.704000', false, 99,
        'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (32, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08',
        'rollbackplease788awdawd7sdfsdfsd77wefsfd!', 'testHibernateAndRollback!', '2020-07-09 21:45:25.059000',
        '2020-07-09 21:45:25.059000', false, 99, 'NOT_SELECTED');
INSERT INTO public.m_users (id, username, surname, birth_date, login, password, created, changed, is_blocked, weight,
                            gender)
VALUES (33, 'testHibernateAndRollback!', 'testHibernateAndRollback!', '1996-07-08', '999999',
        'testHibernateAndRollback!', '2020-07-09 21:50:42.877000', '2020-07-09 21:50:42.877000', false, 99,
        'NOT_SELECTED');

INSERT INTO public.m_good (id, good_name)
VALUES (1, 'Orange');
INSERT INTO public.m_good (id, good_name)
VALUES (2, 'Coca-Cola');
INSERT INTO public.m_good (id, good_name)
VALUES (3, 'Xiaomi');

INSERT INTO public.l_user_goods (id, user_id, good_id, count, created, changed)
VALUES (1, 1, 1, 2, '2020-07-07 20:37:08.000000', '2020-07-07 20:37:08.000000');
INSERT INTO public.l_user_goods (id, user_id, good_id, count, created, changed)
VALUES (2, 1, 2, 2, '2020-07-07 20:37:08.000000', '2020-07-07 20:37:08.000000');
INSERT INTO public.l_user_goods (id, user_id, good_id, count, created, changed)
VALUES (3, 1, 3, 2, '2020-07-07 20:37:08.000000', '2020-07-07 20:37:08.000000');

INSERT INTO public.m_cars (id, model, guarantee_expiration_date, price, dealer_id, user_id)
VALUES (1, 'Corolla', '2023-06-06 16:22:49.000000', 19000, 1, 1);
INSERT INTO public.m_cars (id, model, guarantee_expiration_date, price, dealer_id, user_id)
VALUES (2, 'Corolla', '2023-06-06 16:22:49.000000', 19000, 2, 1);
INSERT INTO public.m_cars (id, model, guarantee_expiration_date, price, dealer_id, user_id)
VALUES (3, 'Corolla', '2023-06-06 16:22:49.000000', 19000, 3, 1);
INSERT INTO public.m_cars (id, model, guarantee_expiration_date, price, dealer_id, user_id)
VALUES (4, 'Corolla', '2023-06-06 16:22:49.000000', 19000, 4, 1);
INSERT INTO public.m_cars (id, model, guarantee_expiration_date, price, dealer_id, user_id)
VALUES (5, 'Corolla', '2023-06-06 16:22:49.000000', 19000, 5, 1);

INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (1, 'ROLE_ADMIN', 1);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (11, 'ROLE_ADMIN', 8);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (3, 'ROLE_ADMIN', 4);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (12, 'ROLE_ADMIN', 13);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (13, 'ROLE_ADMIN', 14);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (14, 'ROLE_ADMIN', 18);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (15, 'ROLE_ADMIN', 19);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (16, 'ROLE_ADMIN', 20);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (17, 'ROLE_ADMIN', 21);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (18, 'ROLE_ADMIN', 22);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (19, 'ROLE_ADMIN', 23);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (20, 'ROLE_ADMIN', 24);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (21, 'ROLE_ADMIN', 25);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (22, 'ROLE_ADMIN', 27);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (23, 'ROLE_ADMIN', 28);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (24, 'ROLE_ADMIN', 29);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (25, 'ROLE_ADMIN', 30);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (26, 'ROLE_ADMIN', 31);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (27, 'ROLE_ADMIN', 32);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (28, 'ROLE_ADMIN', 33);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (29, 'ROLE_ADMIN', 34);
INSERT INTO public.m_roles (id, role_name, user_id)
VALUES (30, 'ROLE_USER', 36);