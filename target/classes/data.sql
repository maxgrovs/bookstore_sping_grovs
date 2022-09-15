INSERT INTO books (name, author, isbn, date, cost)
VALUES ('Onegin', 'A. Pushkin', '798-5-15825-119-2', '2002-10-20', 6),
       ('Anna Karenin-5', 'Leo Tolstoy', '798-5-18909-839-2', '1936-11-21', 76),
       ('Anna Karenin-2', 'Leo Tolstoy', '798-5-65233-994-2', '1906-01-08', 656),
       ('Stihi', 'A. Pushkin', '798-5-46444-964-2', '1971-03-12', 5),
       ('G. Potter', 'J. Rouling', '798-5-33274-405-2', '1945-01-15', 88),
       ('Exercisebookin a cage', 'N. Frankov', '798-5-57180-433-2', '1932-04-05', 33),
       ('Martin Iden', 'Jeke London', '798-5-87131-879-2', '1985-02-22', 88),
       ('Anna Karenin-3', 'Leo Tolstoy-13', '798-5-32051-300-2', '1959-01-13', 2),
       ('Anna Karenina', 'Leo Tolstoy', '798-5-32069-660-2', '2004-03-29', 1),
       ('1984', 'George Orwell', '798-5-50907-711-2', '2009-08-21', 5),
       ('ULYSSES', 'James Joyce', '798-5-59510-943-2', '1902-12-23', 100),
       ('Hadji Murat', 'Leo Tolstoy', '798-5-49857-937-2', '1964-06-08', 98),
       ('mu mu', 'Turgenev', '798-5-26560-716-2', '1931-02-08', 6654),
       ('The Cossacks', 'Leo Tolstoy', '798-5-58154-278-2', '1912-04-01', 454),
       ('maskarad', 'Michail Lermontov', '798-5-55569-785-2', '1981-09-09', 3),
       ('Emma', 'J. Osten', '798-5-17105-496-2', '1947-02-19', 55),
       ('Rassvet', 'I. Bezdomniy', '798-5-86226-504-2', '2008-05-14', 43),
       ('Hamlet', 'William Shakespeare ', '798-5-94443-188-2', '1920-11-11', 233),
       ('LOLITA', 'Vladimir Nabokov', '798-5-15384-712-2', '1987-03-31', 54),
       ('the beauty and the beast', 'S. Pero', '798-5-91669-317-2', '1980-05-29', 55),
       ('Dracula', 'Bram Stoker', '798-5-99074-378-2', '1953-12-18', 1000),
       ('war and peace', 'Lev Tolstoy', '798-5-53716-255-2', '2004-01-22', 400);

INSERT INTO role (role)
VALUES ('Admin'),
       ('Manager'),
       ('Customer');

INSERT INTO public.users (first_name, last_name, role_id, password)
VALUES ('Sveta', 'Ivanova', 1, '1'),
       ('Jhon', 'Dou', 2, '2'),
       ('Ivan', 'Bezdomniy', 3, '3');