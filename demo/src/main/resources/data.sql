/*------------------------------------------------------------Instructor---------------------------------------------------------------------------------*/
insert into instructor (id, address, city, country, email, last_name, name, password, phone_number, is_enabled) values
    (1, 'Karađorđeva 12', 'Nova Gajdobra', 'Republika Srbija', 'mare@gmail.com', 'Isaković', 'Marko', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '065-244-32-21', true);

insert into instructor (id, address, city, country, email, last_name, name, password, phone_number, is_enabled) values
    (2, 'Alekse Santica 49', 'Novi Sad', 'Serbia', 'wwwwwww@gmail.com', 'Ilija', 'Perić', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '064-775-88-76', true);

insert into instructor (id, address, city, country, email, last_name, name, password, phone_number, is_enabled) values
    (13, 'Karađorđeva 12', 'Nova Gajdobra', 'Republika Srbija', 'viktor@gmail.com', 'Balinović', 'Viktor', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '060-244-32-21', true);
/*-------------------------------------------------------------------Administrator----------------------------------------------------------------------------------*/
insert into administrator (id, address, city, country, email, name, last_name, password, phone_number, is_enabled) values
    (3, 'Vojvođanska 32', 'Obrovac', 'Republika Srbija', 'nikolaMitro@gmail.com', 'Nikola', 'Mitrović', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '065-231-222-01', true);

/*-------------------------------------------------------------------------ShipOwner---------------------------------------------------------------------------------------*/
insert into ship_owner (id, address, city, country, email, name, last_name, password, phone_number, is_enabled) values
    (4, 'Vojvođanska 32', 'Obrovac', 'Republika Srbija', 'nik@gmail.com', 'Nikola', 'Mitrović', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '065-231-666-01', true);

/*----------------------------------------------------------------------Registration request-----------------------------------------------------------------------------------------------*/
insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (1, 'maki@gmail.com', 'maki123', 'Marija', 'Stojadinović', 'Bulevar Mihajla Pupina 12', 'Novi Sad', 'Republika Srbija', '066/113-23-32', 1, 'Because.', '2022-01-20T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (2, 'mira@yahoo.com', 'mira02131', 'Mira', 'Jokić', 'Doža Đerđa', 'Novi Sad', 'Republika Srbija', '066/123-13-32', 2, 'Because.', '2022-01-22T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (3, 'nikolaM@gmail.com', 'manda123', 'Nikola', 'Mandić', 'Dr. Svetislava Kasapinovića', 'Novi Sad', 'Republika Srbija', '065/221-56-62', 0, 'Because.', '2022-01-18T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (4, 'jenja@gmail.com', 'jenja123', 'Jovan', 'Jenjić', 'Kosovska 5', 'Novi Sad', 'Republika Srbija', '061/173-89-382', 1, 'Because.', '2021-12-01T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (5, 'mili123@gmail.com', 'mili123', 'Strahinja', 'Milivojević', 'Železnička 11', 'Novi Sad', 'Republika Srbija', '061/113-2331-32', 0, 'Because.', '2021-02-01T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (6, 'joecole@gmail.com', 'joeCole4453', 'Joe', 'Cole', 'Bulevar Mihajla Pupina 12', 'Novi Sad', 'Republika Srbija', '066/1133-23-32', 1, 'Because.', '2021-02-01T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (7, 'leabrich@yahoo.com', 'lea0121', 'Lea', 'Brich', 'Vojvođanska 13', 'Bačka Topola', 'Republika Srbija', '066/1213-23-32', 1, 'Because.', '2021-02-01T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (8, 'oki@gmail.com', 'okiM212', 'Mitar', 'Okulić', 'Slobodana Selenića', 'Vrbas', 'Republika Srbija', '066/113-23-553', 0, 'Because.', '2021-02-01T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (9, 'nukitr321@gmail.com', '76767jfkgjd', 'Nikola', 'Trbojević', 'Pionirska 11', 'Mladenovo', 'Republika Srbija', '066/123-23-32', 2, 'Because.', '2021-02-01T08:00:00.00');

insert into registration_request (id, email, password, name, last_name, address, city, country, phone_number, user_type, registration_explanation, request_date) values
    (10, 'steva123@gmail.com', 'steva123', 'Stevan', 'Simić', 'Stevana Sremca 89', 'Novi Sad', 'Republika Srbija', '066/1123-23-32', 2, 'Because.', '2021-02-01T08:00:00.00');

/*----------------------------------------------------------------------Adventure-----------------------------------------------------------------------------------------------*/
insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, price, terms_of_use, instructor_id) values
    (1, 'Pecanje u Obrovcu', 'Kanal DTD', 'Uživajte na pecanju u Obrovcu', 'Trenutno nedostupna', 10, 'Pravila', 'Pecaljka/Ručak', 90, 'Uslovi otkaza rezervacije', 1);
insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, price, terms_of_use, instructor_id) values
    (2, 'Pecanje u Mladenovu', 'Dunavac Mladenovo', 'Uživajte na pecanju u Mladenovu', 'Trenutno nedostupna', 5, 'Pravila', 'Pecaljka/Ručak', 120, 'Uslovi otkaza rezervacije', 1);
insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, price, terms_of_use, instructor_id) values
    (3, 'Pecanje u Silbašu', 'Kanal DTD', 'Uživajte na pecanju u Silbašu', 'Trenutno nedostupna', 7, 'Pravila', 'Pecaljka/Ručak', 150, 'Uslovi otkaza rezervacije', 1);

insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, price, terms_of_use, instructor_id) values
    (4, 'Pecanje u Sivcu', 'Jezero', 'Uživajte na pecanju u Sivcu', 'Trenutno nedostupna', 10, 'Pravila', 'Pecaljka/Ručak', 140, 'Uslovi otkaza rezervacije', 13);

insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, price, terms_of_use, instructor_id) values
    (5, 'Pecanje u Mošorinu', 'Reka Tisa', 'Uživajte na pecanju na Tisi', 'Trenutno nedostupna', 10, 'Pravila', 'Pecaljka/Ručak', 50, 'Uslovi otkaza rezervacije', 13);


/*----------------------------------------------------------------------Adventure additional service-----------------------------------------------------------------------------------------------*/
insert into adventure_additional_service(id, name, price, adventure_id) values (1, 'Brod', 100, 1);
insert into adventure_additional_service(id, name, price, adventure_id) values (2, 'Odelo', 30, 1);
insert into adventure_additional_service(id, name, price, adventure_id) values (3, 'Čizme', 15, 1);

/*----------------------------------------------------------------------Images-----------------------------------------------------------------------------------------------*/
insert into image(id, url, adventure_id) values (1, 'first.jpg', 1);
insert into image(id, url, adventure_id) values (2, 'second.jpg', 1);
insert into image(id, url, adventure_id) values (3, 'third.jpg', 1);

/*----------------------------------------------------------------------Client-----------------------------------------------------------------------------------------------*/
insert into client (id, address, city, country, email, name, last_name, password, phone_number, verification_code, is_enabled) values
    (12, 'Vojvođanska 32', 'Obrovac', 'Republika Srbija', 'klijent@gmail.com', 'Neki', 'Klijent', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '064-231-222-01', 'code', true);

insert into client (id, address, city, country, email, name, last_name, password, phone_number, verification_code, is_enabled) values
    (11, 'Bulevar Cara Lazara 5', 'Novi Sad', 'Republika Srbija', 'mita123@gmail.com', 'Mita', 'Mitrović',
    '$2a$10$8k/e1uzWqrh5rl4OpKmhYem0z9SwEd8Kl5eYXXP7F8ilYxj8WBHaa', '065-222-222-01', 'code', true);

/*----------------------------------------------------------------------Adventure reservation-----------------------------------------------------------------------------------------------*/
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (1, '2022-01-04T08:00:00.00', '2022-01-04T09:00:00.00', 11, 1, 90, 0.1);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (2, '2022-01-04T10:00:00.00', '2022-01-04T11:00:00.00', 12, 1, 90, 0.1);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (3, '2022-01-04T12:00:00.00', '2022-01-04T13:00:00.00', 12, 1, 90, 0.1);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (4, '2022-01-05T08:00:00.00', '2022-01-05T09:00:00.00', 11, 1, 90, 0.1);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (5, '2022-01-05T10:00:00.00', '2022-01-05T11:00:00.00', 12, 2, 120, 0.1);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (6, '2022-01-06T08:00:00.00', '2022-01-06T09:00:00.00', 11, 1, 90, 0.2);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (7, '2022-01-06T11:00:00.00', '2022-01-06T12:00:00.00', 12, 1, 90, 0.2);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (8, '2022-01-06T15:00:00.00', '2022-01-06T16:00:00.00', 12, 1, 90, 0.2);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (9, '2022-01-07T08:00:00.00', '2022-01-07T09:00:00.00', 11, 3, 150, 0.2);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (10, '2022-01-08T08:00:00.00', '2022-01-08T09:00:00.00', 11, 2, 120, 0.2);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (11, '2022-01-08T10:00:00.00', '2022-01-08T11:00:00.00', 12, 2, 120, 0.2);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (12, '2022-01-08T13:00:00.00', '2022-01-08T14:00:00.00', 11, 2, 120, 0.2);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (13, '2022-01-15T13:00:00.00', '2022-01-15T14:00:00.00', 12, 4, 140, 0.1);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (14, '2022-01-18T13:00:00.00', '2022-01-18T14:00:00.00', 11, 5, 50, 0.1);
insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill, system_sallary) values
    (15, '2022-01-11T13:00:00.00', '2022-01-11T14:00:00.00', 12, 4, 140, 0.1);

/*----------------------------------------------------------------------Action adventure-----------------------------------------------------------------------------------------------*/
insert into action_adventure (id, additional_services, creation_date, duration, end_time, start_time, price, adventure_id) values
    (1, '', '2022-10-10T08:00:00.00', 15, '2022-11-10T09:00:00.00', '2022-11-10T08:00:00.00', 70, 1);
insert into action_adventure (id, additional_services, creation_date, duration, end_time, start_time, price, adventure_id) values
    (2, '', '2022-10-10T08:00:00.00', 10, '2022-12-10T09:00:00.00', '2022-12-10T08:00:00.00', 90, 2);
insert into action_adventure (id, additional_services, creation_date, duration, end_time, start_time, price, adventure_id) values
    (3, '', '2022-10-10T08:00:00.00', 6, '2022-09-10T09:00:00.00', '2022-09-10T08:00:00.00', 50, 3);

/*----------------------------------------------------------------------Cottage owner-----------------------------------------------------------------------------------------------*/
insert into cottage_owner (id, address, city, country, email, name, last_name, password, phone_number, is_enabled) values
    (5, 'Bulevar Cara Lazara 15', 'Novi Sad', 'Republika Srbija', 'steva123@gmail.com', 'Stevan', 'Martinović', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '066-122-222-01', true);

insert into cottage_owner (id, address, city, country, email, name, last_name, password, phone_number, is_enabled) values
    (6, 'Bulevar Cara Lazara 35', 'Novi Sad', 'Republika Srbija', 'mmina123@gmail.com', 'Mina', 'Nikolić', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '062-122-222-01', true);

insert into cottage_owner (id, address, city, country, email, name, last_name, password, phone_number, is_enabled) values
    (7, 'Bulevar Cara Lazara 35', 'Novi Sad', 'Republika Srbija', 'nina123@gmail.com', 'Nikolina', 'Ivanić', '$2a$10$syFgCOEoyd8Mz4KxNdKXa.F8R.NNdY7IdR6jPRNJFcFdMyh/2sYwi', '064-122-222-01', true);


/*----------------------------------------------------------------------Cottage-----------------------------------------------------------------------------------------------*/
insert into cottage (id, name, address, promotive_description, conduct_rules, pricelist, cottage_owner_id)
    values(1, 'Stevanova', 'Neka', 'Dodjite u Stevanovu kolibu', 'Pravila', 50, 5);

insert into cottage (id, name, address, promotive_description, conduct_rules, pricelist, cottage_owner_id) values
    (4, 'Koliba na fruskoj', 'Fruska Gora', 'Dodjite u Stevanovu kolibu, najbolji odnos cene i kvaliteta', 'Pravila ponasanja', 40, 5);

insert into cottage (id, name, address, promotive_description, conduct_rules, pricelist, cottage_owner_id) values
    (5, 'Koliba na fruskoj 2', 'Fruska Gora', 'Dodjite u Stevanovu kolibu na fruskoj gori', 'Pravila ponasanja', 60, 5);

insert into cottage (id, name, address, promotive_description, conduct_rules, pricelist, cottage_owner_id) values
    (6, 'Koliba na fruskoj 3', 'Fruska Gora', 'Dodjite u Stevanovu kolibu 3', 'Pravila ponasanja 3', 70, 5);

insert into cottage (id, name, address, promotive_description, conduct_rules, pricelist, cottage_owner_id) values
    (7, 'Koliba na fruskoj 4', 'Fruska Gora', 'Dodjite u Stevanovu kolibu 4', 'Pravila ponasanja 4', 90, 5);

insert into cottage (id, name, address, promotive_description, conduct_rules, pricelist, cottage_owner_id) values
    (2, 'Minina', 'Neka', 'Dodjite u Mininu kolibu', 'Pravila', 60, 6);

insert into cottage (id, name, address, promotive_description, conduct_rules, pricelist, cottage_owner_id) values
    (3, 'Ninina', 'Neka', 'Dodjite u Nininu kolibu', 'Pravila', 20, 7);

/*----------------------------------------------------------------------Rooms-----------------------------------------------------------------------------------------------*/
insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (1, 1, 2, true, true, 1);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (7, 1, 2, true, true, 4);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (8, 1, 2, false , false , 5);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (9, 1, 2, false , true, 6);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (10, 1, 2, true, false , 7);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (11, 2, 4, true, false , 7);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (12, 3, 3, true, true , 7);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (2, 2, 3, true, true, 1);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (3, 3, 1, true, false, 1);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (4, 1, 2, true, true, 2);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (5, 1, 2, true, true, 2);

insert into room (id, room_number, beds_number, bathroom, clime, cottage_id)
    values (6, 1, 2, true, true, 3);
/*----------------------------------------------------------------------Ship owner-----------------------------------------------------------------------------------------------*/
insert into ship_owner (id, address, city, country, email, name, last_name, password, phone_number, is_enabled) values
    (8, 'Bulevar Cara Lazara 35', 'Novi Sad', 'Republika Srbija', 'vule123@gmail.com', 'Vukašin', 'Crnjanski', 'ninaIvanic123', '064-312-002-01', true);

insert into ship_owner (id, address, city, country, email, name, last_name, password, phone_number, is_enabled) values
    (9, 'Bulevar Cara Lazara 35', 'Novi Sad', 'Republika Srbija', 'tole123@gmail.com', 'Todor', 'Mijailović', 'todor123', '061-211-002-01', true);

insert into ship_owner (id, address, city, country, email, name, last_name, password, phone_number, is_enabled) values
    (10, 'Bulevar Cara Lazara 35', 'Novi Sad', 'Republika Srbija', 'ogi123@gmail.com', 'Ognjen', 'Nestorović', 'ogi123', '061-211-002-87', true);


/*----------------------------------------------------------------------Ship-----------------------------------------------------------------------------------------------*/
insert into ship (id, name, type, length, engine_number, engine_power, max_speed, address, promotive_description, capacity, pricelist, conduct_rules, additional_services_info, cancellation_policy, ship_owner_id) values
    (1, 'Vuletov', 'Tip', 4, 2, 100, 70, 'Adresa', 'Vuletov opis', 11, 300, 'Pravila', 'Dodatne informacije', 'Uslovi otkazivanja', 8);

insert into ship (id, name, type, length, engine_number, engine_power, max_speed, address, promotive_description, capacity, pricelist, conduct_rules, additional_services_info, cancellation_policy, ship_owner_id) values
    (2, 'Todorov', 'Tip', 4, 2, 100, 70, 'Adresa', 'Todorov opis', 10, 500, 'Pravila', 'Dodatne informacije', 'Uslovi otkazivanja', 9);

insert into ship (id, name, type, length, engine_number, engine_power, max_speed, address, promotive_description, capacity, pricelist, conduct_rules, additional_services_info, cancellation_policy, ship_owner_id) values
    (3, 'Ognjenov', 'Tip', 4, 2, 100, 70, 'Adresa', 'Ognjenov opis', 12, 600, 'Pravila', 'Dodatne informacije', 'Uslovi otkazivanja', 10);

/*----------------------------------------------------------------------Instructor complaint-----------------------------------------------------------------------------------------------*/
insert into instructor_complaint(id, text, instructor_id, client_id) values (1, 'Neki tekst zalbe 1', 1, 11);

insert into instructor_complaint(id, text, instructor_id, client_id) values (2, 'Neki tekst zalbe 2', 1, 12);

/*----------------------------------------------------------------------Ship complaint-----------------------------------------------------------------------------------------------*/
insert into ship_complaint(id, text, ship_id, ship_owner_id, client_id) values (1, 'Neki tekst zalbe 3', 1, 8, 11);

insert into ship_complaint(id, text, ship_id, ship_owner_id, client_id) values (2, 'Neki tekst zalbe 4', 2, 9, 11);

insert into ship_complaint(id, text, ship_id, ship_owner_id, client_id) values (3, 'Neki tekst zalbe 5', 3, 10, 12);

/*----------------------------------------------------------------------Cottage complaint-----------------------------------------------------------------------------------------------*/
insert into cottage_complaint(id, text, cottage_id, cottage_owner_id, client_id) values (1, 'Neki tekst zalbe 6', 1, 5, 12);

insert into cottage_complaint(id, text, cottage_id, cottage_owner_id, client_id) values (2, 'Neki tekst zalbe 7', 2, 6, 12);

insert into cottage_complaint(id, text, cottage_id, cottage_owner_id, client_id) values (3, 'Neki tekst zalbe 8', 3, 7, 11);

/*----------------------------------------------------------------------Delete account request-----------------------------------------------------------------------------------------------*/
insert into delete_account_request(id, delete_reason, user_full_name, user_type, user_id) values (1, 'Zato', 'Vukašin Crnjanski', 1, 8);

insert into delete_account_request(id, delete_reason, user_full_name, user_type, user_id) values
    (2, 'Ne želim više da koristim sistem.', 'Stevan Martinović', 0, 5);

/*----------------------------------------------------------------------Availability-----------------------------------------------------------------------------------------------*/
insert into cottage_availability(id, end_date, start_date, cottage_id) values (1, '2022-08-06 21:47', '2022-06-05 21:47', 1);
/*----------------------------------------------------------------------Roles-----------------------------------------------------------------------------------------------*/
insert into role (id, name) VALUES (1, 'ROLE_CLIENT');
insert into role (id, name) VALUES (2, 'ROLE_ADMIN');
insert into role (id, name) VALUES (3, 'ROLE_COTTAGE_OWNER');
insert into role (id, name) VALUES (4, 'ROLE_SHIP_OWNER');
insert into role (id, name) VALUES (5, 'ROLE_INSTRUCTOR');

/*----------------------------------------------------------------------User role-----------------------------------------------------------------------------------------------*/
insert into USER_ROLE (user_id, role_id) VALUES (1, 5);
insert into USER_ROLE (user_id, role_id) VALUES (2, 5);
insert into USER_ROLE (user_id, role_id) VALUES (3, 2);
insert into USER_ROLE (user_id, role_id) VALUES (4, 4);
insert into USER_ROLE (user_id, role_id) VALUES (5, 3);
insert into USER_ROLE (user_id, role_id) VALUES (6, 3);
insert into USER_ROLE (user_id, role_id) VALUES (7, 3);
insert into USER_ROLE (user_id, role_id) VALUES (8, 4);
insert into USER_ROLE (user_id, role_id) VALUES (9, 4);
insert into USER_ROLE (user_id, role_id) VALUES (10, 4);
insert into USER_ROLE (user_id, role_id) VALUES (11, 1);
insert into USER_ROLE (user_id, role_id) VALUES (12, 1);
insert into USER_ROLE (user_id, role_id) VALUES (13, 5);