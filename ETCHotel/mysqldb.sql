DROP DATABASE IF EXISTS `insurance`;
CREATE DATABASE `insurance` DEFAULT CHARACTER SET utf8;
USE insurance;

/* 'ContractTime' */
CREATE TABLE contract_time (
  id INTEGER,
  name VARCHAR(50) NOT NULL,
  numMonths INTEGER,
  PRIMARY KEY (id)
) ;

/* 'Currency' */
CREATE TABLE currency (
  id INTEGER,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
) ;

/* 'Period' */
CREATE TABLE period (
  id INTEGER,
  name VARCHAR(50) NOT NULL,
  PRIMARY KEY (id)
) ;

/* 'Сотрудник' */
CREATE TABLE employee
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    fullname VARCHAR(50) NOT NULL,
    status VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
) ;

/* 'Клиент' */
CREATE TABLE client
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    fullname VARCHAR(50) NOT NULL,
    contact VARCHAR(50) NOT NULL,
    address VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
) ;

/* 'Программы страхования' */
CREATE TABLE program_table
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    content VARCHAR(500) NOT NULL,
    objects VARCHAR(500) NOT NULL,
    PRIMARY KEY (id)
) ;

/* 'Заявка' */
CREATE TABLE declaration
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    fullName VARCHAR(50),
    contact VARCHAR(50),
    address VARCHAR(50),
    insurance_opt_id INTEGER,
    period_id INTEGER,
    contract_time_id INTEGER,
    currency_id INTEGER,
    sum_insured DOUBLE,
    date VARCHAR(50),
    client_id INTEGER NOT NULL,
    employee_id INTEGER NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (period_id) REFERENCES period (id),
    FOREIGN KEY (currency_id) REFERENCES currency (id),
    FOREIGN KEY (client_id) REFERENCES client (id),
    FOREIGN KEY (employee_id) REFERENCES employee (id)
) ;

/* 'Договор' */
CREATE TABLE contract
(
    id INTEGER NOT NULL AUTO_INCREMENT,
    client_id INTEGER NOT NULL,
    programtype_id INTEGER NOT NULL,
    currency_id INTEGER NOT NULL,
    sum DOUBLE,
    sumPayment DOUBLE,
    end_date VARCHAR(100),
    full_name VARCHAR(100),
    programmName VARCHAR(100),
    currencyName VARCHAR(30),
    objects VARCHAR(100),
    employee_id INTEGER NOT NULL,
    periodName VARCHAR(50),
    PRIMARY KEY (id),
    FOREIGN KEY (currency_id) REFERENCES currency (id),
    FOREIGN KEY (employee_id) REFERENCES employee (id),
    FOREIGN KEY (programtype_id) REFERENCES program_table (id)
) ;


/* 'Срок действия договора' */
insert into contract_time values (1, '1 месяц', 1);
insert into contract_time values (2, '6 месяцев', 6);
insert into contract_time values (3, '1 год', 12);
insert into contract_time values (4, '3 года', 36);

/* 'Валюта' */
insert into currency values (1, 'BYN');
insert into currency values (2, 'USD');

/* 'Порядок выплаты платежей' */
insert into period values (1, 'Единовременно');
insert into period values (2, 'В 2 этапа');
insert into period values (3, 'Ежеквартально');

/* 'Клиент' */
insert into client values (1, 'Ivan Ivanov', '+375333089988', 'Minsk');

/* 'Сотрудник' */
insert into employee values (1, 'admin', 'admin', 'Admin', 'employee');

/* 'Программы страхования' */
insert into program_table values (1, 'Комплексное страхование квартиры онлайн', 'Страхование квартиры онлайн без волокиты и горы документов для тех, кто любит свой дом и хочет познать дзен. Вы сами определяете страховую сумму и валюту договора, а если что-то случится, мы компенсируем ущерб.', 'Квартира, имущество, ответственность перед соседями.');

insert into program_table values (2, 'Комплексное страхование квартиры и дома онлайн', 'Удобная и надежная страховка для тех, кто теплое время года проводит на даче, а зимой живет в городе. Оформите страхование квартиры и дома онлайн за несколько минут без бюрократии и лишних вопросов. Мы предлагаем гибкие условия, высокие выплаты, спокойствие и умиротворение — настоящий дзен в мире страхования.', 'Квартира, дом, имущество в квартире, имущество в доме, ответственность перед соседями.');

insert into program_table values (3, 'Страхование дома и имущества', 'Выгодная страховка для тех, кто живет в доме и ценит безмятежность и умиротворение. Выбирайте сумму и оформляйте страхование дачи или дома онлайн за пару минут. Без оценки стоимости и описи имущества.', 'Дом, имущество.');

insert into program_table values (4, 'Комплексное краткосрочное страхование квартиры онлайн', 'Удобная и надежная страховка для тех, кто теплое время года проводит на даче, а зимой живет в городе. Оформите страхование квартиры и дома онлайн за несколько минут без бюрократии и лишних вопросов. Мы предлагаем гибкие условия, высокие выплаты, спокойствие и умиротворение — настоящий дзен в мире страхования.', 'Квартира, имущество, ответственность перед соседями.');


/* 'Заявка' */
insert into declaration values (1, 'Ivan Ivanov', '80339988770', 'Minsk', 1, 1, 1, 1, 100000, '2022-02-02', 1, 1);

/* 'Договор' */
insert into contract values (1, 1, 1, 1, 100000, 320, '2023-02-03', 'Ivan Ivanov', '', 'BYN', 'Квартира, имущество, ответственность перед соседями.', 1, 'Единовременно');

