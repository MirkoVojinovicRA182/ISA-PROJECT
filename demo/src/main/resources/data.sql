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

insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, pricelist, terms_of_use, instructor_id)
 values (1, 'Pecanje u Obrovcu', 'Kanal DTD', 'Uživajte na pecanju u Obrovcu', 'Trenutno nedostupna', 10, 'Pravila', 'Pecaljka/Ručak', 'Cenovnik', 'Uslovi otkaza rezervacije', 1);
insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, pricelist, terms_of_use, instructor_id)
values (2, 'Pecanje u Mladenovu', 'Dunavac Mladenovo', 'Uživajte na pecanju u Mladenovu', 'Trenutno nedostupna', 5, 'Pravila', 'Pecaljka/Ručak', 'Cenovnik', 'Uslovi otkaza rezervacije', 1);
insert into instructor_adventure(id, name, address, promotional_description, instructor_biography, max_count_of_participants, rules_of_conduct, default_equipment, pricelist, terms_of_use, instructor_id)
values (3, 'Pecanje u Silbašu', 'Kanal DTD', 'Uživajte na pecanju u Silbašu', 'Trenutno nedostupna', 7, 'Pravila', 'Pecaljka/Ručak', 'Cenovnik', 'Uslovi otkaza rezervacije', 1);

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

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id)
values (1, '2021-02-01T08:00:00.00', '2021-02-01T09:00:00.00', 3, 1);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id)
values (2, '2022-02-01T08:00:00.00', '2022-02-01T09:00:00.00', 3, 1);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id)
values (3, '2020-02-01T08:00:00.00', '2020-02-01T09:00:00.00', 3, 2);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id)
values (4, '2023-02-01T08:00:00.00', '2023-02-01T09:00:00.00', 3, 3);

insert into adventure_reservation (id, start_time, end_time, client_id, adventure_id)
values (5, '2018-02-01T08:00:00.00', '2018-02-01T09:00:00.00', 3, 2);

