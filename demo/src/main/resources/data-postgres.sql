INSERT INTO client(id, email, password, name, last_name, address, city, country, phone_number,
    verification_code, enabled)
    VALUES ( '1', 'isatestmail202c2@gmail.com', 'ftn', 'Nemanja', 'Radojcic', 'ftn', 'Negotin',
        'Serbia', '0640052376', null, true);

INSERT INTO instructor(id, address, city, country, email, last_name, name, password, phone_number)
    VALUES ( '2', 'Alekse Santica', 'Novi Sad', 'Serbia', 'wwwwwww@gmail.com', 'Peric', 'Ilija',
        'perica', '0647758876');

INSERT INTO instructor_adventure(id, address, default_equipment, instructor_biography,
        max_count_of_participants, name, pricelist, promotional_description, rules_of_conduct, terms_of_use, instructor_id)
    VALUES ( '4', 'Ledinci', 'gggggg', 'Nesto', '22', 'Pecanje', '300$', 'hhhhhhhh', 'bbbbbbb',
        'vvvvvvvv', '2');
