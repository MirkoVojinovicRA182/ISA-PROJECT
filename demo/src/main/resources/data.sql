insert into administrator (id, address, city, country, email, name, last_name, password, phone_number) values (2,
                                                                                                            'Vojvođanska 32',
                                                                                                            'Obrovac',
                                                                                                            'Republika Srbija',
                                                                                                            'nikolaMitro@gmail.com',
                                                                                                            'Nikola',
                                                                                                            'Mitrović',
                                                                                                            'mitar567',
                                                                                                            '065-231-222-01');

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




insert into instructor (id, address, city, country, email, last_name, name, password, phone_number) values (1,
                                                                                                            'Karađorđeva 12',
                                                                                                            'Nova Gajdobra',
                                                                                                            'Republika Srbija',
                                                                                                            'mare@gmail.com',
                                                                                                            'Marko',
                                                                                                            'Isaković',
                                                                                                            'mare123',
                                                                                                            '065-244-32-21');

insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, price, terms_of_use, instructor_id)
 values (1, 'Pecanje u Obrovcu', 'Kanal DTD', 'Uživajte na pecanju u Obrovcu', 'Trenutno nedostupna', 10, 'Pravila', 'Pecaljka/Ručak', 90, 'Uslovi otkaza rezervacije', 1);
insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, price, terms_of_use, instructor_id)
values (2, 'Pecanje u Mladenovu', 'Dunavac Mladenovo', 'Uživajte na pecanju u Mladenovu', 'Trenutno nedostupna', 5, 'Pravila', 'Pecaljka/Ručak', 120, 'Uslovi otkaza rezervacije', 1);
insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, price, terms_of_use, instructor_id)
values (3, 'Pecanje u Silbašu', 'Kanal DTD', 'Uživajte na pecanju u Silbašu', 'Trenutno nedostupna', 7, 'Pravila', 'Pecaljka/Ručak', 150, 'Uslovi otkaza rezervacije', 1);

insert into adventure_additional_service(id, name, price, adventure_id) values (1, 'Brod', 100, 1);
insert into adventure_additional_service(id, name, price, adventure_id) values (2, 'Odelo', 30, 1);
insert into adventure_additional_service(id, name, price, adventure_id) values (3, 'Čizme', 15, 1);

insert into image(id, url, adventure_id) values (1, 'first.jpg', 1);
insert into image(id, url, adventure_id) values (2, 'second.jpg', 1);
insert into image(id, url, adventure_id) values (3, 'third.jpg', 1);


insert into client (id, address, city, country, email, name, last_name, password, phone_number, verification_code, enabled) values (3,
                                                                                                                                    'Vojvođanska 32',
                                                                                                                                    'Obrovac',
                                                                                                                                    'Republika Srbija',
                                                                                                                                    'klijent@gmail.com',
                                                                                                                                    'Neki',
                                                                                                                                    'Klijent',
                                                                                                                                    'klijent123',
                                                                                                                                    '064-231-222-01',
                                                                                                                                    'code',
                                                                                                                                    'true');
insert into client (id, address, city, country, email, name, last_name, password, phone_number, verification_code, enabled) values (4,
                                                                                                                                    'Bulevar Cara Lazara 5',
                                                                                                                                    'Novi Sad',
                                                                                                                                    'Republika Srbija',
                                                                                                                                    'mita123@gmail.com',
                                                                                                                                    'Mita',
                                                                                                                                    'Mitrović',
                                                                                                                                    'mita123',
                                                                                                                                    '065-222-222-01',
                                                                                                                                    'code',
                                                                                                                                    'true');

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill)
values (1, '2021-02-01T08:00:00.00', '2021-02-01T09:00:00.00', 3, 1, 300);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill)
values (2, '2022-02-01T08:00:00.00', '2022-02-01T09:00:00.00', 4, 1, 100);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill)
values (3, '2020-02-01T08:00:00.00', '2020-02-01T09:00:00.00', 3, 1, 312);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill)
values (4, '2023-02-01T08:00:00.00', '2023-02-01T09:00:00.00', 4, 3, 450);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id, bill)
values (5, '2018-02-01T08:00:00.00', '2018-02-01T09:00:00.00', 3, 2, 60);


insert into action_adventure (id, additional_services, creation_date, duration, end_time, start_time, price, adventure_id) values (1, 'Pecaljka Brod', '2022-10-10T08:00:00.00', 15, '2022-11-10T09:00:00.00', '2022-11-10T08:00:00.00', 70, 1);
insert into action_adventure (id, additional_services, creation_date, duration, end_time, start_time, price, adventure_id) values (2, 'Kombinezon', '2022-10-10T08:00:00.00', 10, '2022-12-10T09:00:00.00', '2022-12-10T08:00:00.00', 90, 2);
insert into action_adventure (id, additional_services, creation_date, duration, end_time, start_time, price, adventure_id) values (3, 'Camac', '2022-10-10T08:00:00.00', 6, '2022-09-10T09:00:00.00', '2022-09-10T08:00:00.00', 50, 3);

insert into cottage_owner (id, address, city, country, email, name, last_name, password, phone_number) values (5,
                                                                                                        'Bulevar Cara Lazara 15',
                                                                                                        'Novi Sad',
                                                                                                        'Republika Srbija',
                                                                                                        'steva123@gmail.com',
                                                                                                        'Stevan',
                                                                                                        'Martinović',
                                                                                                        'steva123',
                                                                                                        '066-122-222-01');

insert into cottage_owner (id, address, city, country, email, name, last_name, password, phone_number) values (6,
                                                                                                               'Bulevar Cara Lazara 35',
                                                                                                               'Novi Sad',
                                                                                                               'Republika Srbija',
                                                                                                               'mmina123@gmail.com',
                                                                                                               'Mina',
                                                                                                               'Nikolić',
                                                                                                               'mina123',
                                                                                                               '062-122-222-01');

insert into cottage_owner (id, address, city, country, email, name, last_name, password, phone_number) values (7,
                                                                                                               'Bulevar Cara Lazara 35',
                                                                                                               'Novi Sad',
                                                                                                               'Republika Srbija',
                                                                                                               'nina123@gmail.com',
                                                                                                               'Nikolina',
                                                                                                               'Ivanić',
                                                                                                               'ninaIvanic123',
                                                                                                               '064-122-222-01');

insert into cottage (id, name, address, promotive_description, rooms_number, beds_number, conduct_rules, pricelist, cottage_owner_id)
    values(1, 'Stevanova', 'Neka', 'Dodjite u Stevanovu kolibu', 10, 15, 'Pravila', 'Cenovnik', 5);

insert into cottage (id, name, address, promotive_description, rooms_number, beds_number, conduct_rules, pricelist, cottage_owner_id)
values(2, 'Minina', 'Neka', 'Dodjite u Mininu kolibu', 10, 15, 'Pravila', 'Cenovnik', 6);

insert into cottage (id, name, address, promotive_description, rooms_number, beds_number, conduct_rules, pricelist, cottage_owner_id)
values(3, 'Ninina', 'Neka', 'Dodjite u Nininu kolibu', 10, 15, 'Pravila', 'Cenovnik', 7);

insert into ship_owner (id, address, city, country, email, name, last_name, password, phone_number) values (8,
                                                                                                               'Bulevar Cara Lazara 35',
                                                                                                               'Novi Sad',
                                                                                                               'Republika Srbija',
                                                                                                               'vule123@gmail.com',
                                                                                                               'Vukašin',
                                                                                                               'Crnjanski',
                                                                                                               'ninaIvanic123',
                                                                                                               '064-312-002-01');

insert into ship_owner (id, address, city, country, email, name, last_name, password, phone_number) values (9,
                                                                                                            'Bulevar Cara Lazara 35',
                                                                                                            'Novi Sad',
                                                                                                            'Republika Srbija',
                                                                                                            'tole123@gmail.com',
                                                                                                            'Todor',
                                                                                                            'Mijailović',
                                                                                                            'todor123',
                                                                                                            '061-211-002-01');

insert into ship_owner (id, address, city, country, email, name, last_name, password, phone_number) values (10,
                                                                                                            'Bulevar Cara Lazara 35',
                                                                                                            'Novi Sad',
                                                                                                            'Republika Srbija',
                                                                                                            'ogi123@gmail.com',
                                                                                                            'Ognjen',
                                                                                                            'Nestorović',
                                                                                                            'ogi123',
                                                                                                            '061-211-002-87');

insert into ship (id, name, type, length, engine_number, engine_power, max_speed, address, promotive_description, capacity, pricelist, conduct_rules, additional_services_info, cancellation_policy, ship_owner_id)
values (1, 'Vuletov', 'Tip', 4, 2, 100, 70, 'Adresa', 'Vuletov opis', 10, 'Cenovnik', 'Pravila', 'Dodatne informacije', 'Uslovi otkazivanja', 8);

insert into ship (id, name, type, length, engine_number, engine_power, max_speed, address, promotive_description, capacity, pricelist, conduct_rules, additional_services_info, cancellation_policy, ship_owner_id)
values (2, 'Todorov', 'Tip', 4, 2, 100, 70, 'Adresa', 'Todorov opis', 10, 'Cenovnik', 'Pravila', 'Dodatne informacije', 'Uslovi otkazivanja', 9);

insert into ship (id, name, type, length, engine_number, engine_power, max_speed, address, promotive_description, capacity, pricelist, conduct_rules, additional_services_info, cancellation_policy, ship_owner_id)
values (3, 'Ognjenov', 'Tip', 4, 2, 100, 70, 'Adresa', 'Ognjenov opis', 10, 'Cenovnik', 'Pravila', 'Dodatne informacije', 'Uslovi otkazivanja', 10);

insert into instructor_complaint(id, text, instructor_id, client_id)
values (1, 'Neki tekst zalbe 1', 1, 3);

insert into instructor_complaint(id, text, instructor_id, client_id)
values (2, 'Neki tekst zalbe 2', 1, 4);

insert into ship_complaint(id, text, ship_id, ship_owner_id, client_id)
values (1, 'Neki tekst zalbe 3', 1, 8, 3);

insert into ship_complaint(id, text, ship_id, ship_owner_id, client_id)
values (2, 'Neki tekst zalbe 4', 2, 9, 3);

insert into ship_complaint(id, text, ship_id, ship_owner_id, client_id)
values (3, 'Neki tekst zalbe 5', 3, 10, 4);

insert into cottage_complaint(id, text, cottage_id, cottage_owner_id, client_id)
values (1, 'Neki tekst zalbe 6', 1, 5, 4);

insert into cottage_complaint(id, text, cottage_id, cottage_owner_id, client_id)
values (2, 'Neki tekst zalbe 7', 2, 6, 4);

insert into cottage_complaint(id, text, cottage_id, cottage_owner_id, client_id)
values (3, 'Neki tekst zalbe 8', 3, 7, 3);



