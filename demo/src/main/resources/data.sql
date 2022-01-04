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