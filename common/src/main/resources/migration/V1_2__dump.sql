INSERT INTO m_users (id, name, surname, login, password, email, gender, birth_date, height, weight, fitness_level, goal, created, changed, is_blocked) VALUES (1, 'Maxim', 'Zabavksiy', 'Maxim111', 'Max111111', 'zabavskiy.mv@gmail.com', 'MALE', '1992-11-22', 176, 73, 'ADVANCED', 'LEARN_TECHNIQUES', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_users (id, name, surname, login, password, email, gender, birth_date, height, weight, fitness_level, goal, created, changed, is_blocked) VALUES (2, 'Ken', 'Brown', 'Ken222', 'Ken222222', 'brown.ken@yandex.ru', 'MALE', '1993-12-18', 170, 70, 'INTERMEDIATE', 'BUILD_MUSCLE', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_users (id, name, surname, login, password, email, gender, birth_date, height, weight, fitness_level, goal, created, changed, is_blocked) VALUES (3, 'Lisa', 'Grey', 'Lisa333', 'Lisa333333', 'grey.lisa@gmail.com', 'FEMALE', '1991-01-15', 161, 55, 'INTERMEDIATE', 'LOSE_FAT', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_users (id, name, surname, login, password, email, gender, birth_date, height, weight, fitness_level, goal, created, changed, is_blocked) VALUES (4, 'Kate', 'White', 'Kate444', 'Kate444444', 'white.kate@mail.ru', 'FEMALE', '1995-03-23', 170, 65, 'ADVANCED', 'LEARN_TECHNIQUES', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_users (id, name, surname, login, password, email, gender, birth_date, height, weight, fitness_level, goal, created, changed, is_blocked) VALUES (5, 'Tom', 'Black', 'Tom555', 'Tom555555', 'black.tom@gmail.com', 'MALE', '1992-04-03', 186, 71, 'BEGINNER', 'BUILD_MUSCLE', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);

INSERT INTO m_programs (id, user_id, name, difficulty, duration, type, created, changed, is_blocked) VALUES (1, 1, 'HOME_WORKOUT', 'HARD', 'TWO_WEEKS', 'AT_HOME', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_programs (id, user_id, name, difficulty, duration, type, created, changed, is_blocked) VALUES (2, 2, 'STRENGTH_BUILDER', 'EASY', 'THREE_WEEKS', 'ON_AIR', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_programs (id, user_id, name, difficulty, duration, type, created, changed, is_blocked) VALUES (3, 3, 'BURNING_FAT', 'MEDIUM', 'ONE_WEEK', 'GYM', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_programs (id, user_id, name, difficulty, duration, type, created, changed, is_blocked) VALUES (4, 4, 'HOME_WORKOUT', 'EASY', 'TWO_WEEKS', 'ON_AIR', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_programs (id, user_id, name, difficulty, duration, type, created, changed, is_blocked) VALUES (5, 5, 'HYBRID_BODY_BUILDER', 'HARD', 'FOUR_WEEKS', 'GYM', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);

INSERT INTO m_roles (id, user_id, role_name, created, changed, is_blocked) VALUES (1, 1, 'ROLE_ADMIN', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_roles (id, user_id, role_name, created, changed, is_blocked) VALUES (2, 2, 'ROLE_USER', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_roles (id, user_id, role_name, created, changed, is_blocked) VALUES (3, 3, 'ROLE_MODERATOR', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_roles (id, user_id, role_name, created, changed, is_blocked) VALUES (4, 4, 'ROLE_USER', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_roles (id, user_id, role_name, created, changed, is_blocked) VALUES (5, 5, 'ROLE_USER', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);

INSERT INTO m_workouts (id, program_id, user_id, muscle_group, exercise, rounds, reps, created, changed, is_blocked) VALUES (1, 1, 1, 'BICEPS', 'PULLUPS', 3, 15, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_workouts (id, program_id, user_id, muscle_group, exercise, rounds, reps, created, changed, is_blocked) VALUES (2, 2, 2, 'SHOULDERS', 'PUSHUPS', 4, 20, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_workouts (id, program_id, user_id, muscle_group, exercise, rounds, reps, created, changed, is_blocked) VALUES (3, 3, 3, 'CHEST', 'PUSHUPS', 4, 20, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_workouts (id, program_id, user_id, muscle_group, exercise, rounds, reps, created, changed, is_blocked) VALUES (4, 4, 4, 'LEGS', 'SQUATS', 4, 25, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_workouts (id, program_id, user_id, muscle_group, exercise, rounds, reps, created, changed, is_blocked) VALUES (5, 5, 5, 'TRICEPS', 'DIPS', 4, 15, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);

INSERT INTO m_equipment (id, clothes, shoes, beverage, cleanser, created, changed, is_blocked) VALUES (1, 'SHORTS', 'SNEAKERS', 'BCA', 'SHOWER_GEL', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_equipment (id, clothes, shoes, beverage, cleanser, created, changed, is_blocked) VALUES (2, 'T_SHIRT_AND_TROUSERS', 'SLIPPERS', 'BCA', 'SHAMPOO', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_equipment (id, clothes, shoes, beverage, cleanser, created, changed, is_blocked) VALUES (3, 'T_SHIRT_AND_TROUSERS', 'SNEAKERS', 'WATER', 'SHOWER_GEL', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_equipment (id, clothes, shoes, beverage, cleanser, created, changed, is_blocked) VALUES (4, 'TROUSERS_AND_HOODIE', 'SLIPPERS', 'PROTEIN', 'SHAMPOO', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_equipment (id, clothes, shoes, beverage, cleanser, created, changed, is_blocked) VALUES (5, 'T_SHIRT_AND_TROUSERS', 'SNEAKERS', 'WATER', 'SOAP', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);

INSERT INTO m_calendar (id, user_id, program_id, workout_id, equipment_id, date, created, changed, is_blocked) VALUES (1, 1, 1, 1, 1, '2021-01-09', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_calendar (id, user_id, program_id, workout_id, equipment_id, date, created, changed, is_blocked) VALUES (2, 2, 2, 2, 2, '2021-01-10', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_calendar (id, user_id, program_id, workout_id, equipment_id, date, created, changed, is_blocked) VALUES (3, 3, 3, 3, 3, '2021-01-11', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_calendar (id, user_id, program_id, workout_id, equipment_id, date, created, changed, is_blocked) VALUES (4, 4, 4, 4, 4, '2021-01-12', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_calendar (id, user_id, program_id, workout_id, equipment_id, date, created, changed, is_blocked) VALUES (5, 5, 5, 5, 5, '2021-01-13', '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);

INSERT INTO m_perfomance (id, user_id, max_pullups, max_pushups, max_squats, max_dips, created, changed, is_blocked) VALUES (1, 1, 20, 70, 100, 40, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_perfomance (id, user_id, max_pullups, max_pushups, max_squats, max_dips, created, changed, is_blocked) VALUES (2, 2, 10, 30, 80, 10, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_perfomance (id, user_id, max_pullups, max_pushups, max_squats, max_dips, created, changed, is_blocked) VALUES (3, 3, 15, 25, 50, 15, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_perfomance (id, user_id, max_pullups, max_pushups, max_squats, max_dips, created, changed, is_blocked) VALUES (4, 4, 8, 45, 60, 12, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO m_perfomance (id, user_id, max_pullups, max_pushups, max_squats, max_dips, created, changed, is_blocked) VALUES (5, 5, 5, 20, 70, 18, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);

INSERT INTO l_calendar_equipment (id, calendar_id, equipment_id, created, changed, is_blocked) VALUES (1, 1, 1, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO l_calendar_equipment (id, calendar_id, equipment_id, created, changed, is_blocked) VALUES (2, 2, 2, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO l_calendar_equipment (id, calendar_id, equipment_id, created, changed, is_blocked) VALUES (3, 3, 3, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO l_calendar_equipment (id, calendar_id, equipment_id, created, changed, is_blocked) VALUES (4, 4, 4, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO l_calendar_equipment (id, calendar_id, equipment_id, created, changed, is_blocked) VALUES (5, 5, 5, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);

INSERT INTO l_programs_workouts (id, program_id, workout_id, created, changed, is_blocked) VALUES (1, 1, 1, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO l_programs_workouts (id, program_id, workout_id, created, changed, is_blocked) VALUES (2, 2, 2, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO l_programs_workouts (id, program_id, workout_id, created, changed, is_blocked) VALUES (3, 3, 3, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO l_programs_workouts (id, program_id, workout_id, created, changed, is_blocked) VALUES (4, 4, 4, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);
INSERT INTO l_programs_workouts (id, program_id, workout_id, created, changed, is_blocked) VALUES (5, 5, 5, '2020-12-11 18:35:23.123000', '2020-12-11 18:36:23.123000', false);