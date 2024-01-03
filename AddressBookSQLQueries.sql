-- UC 1 create db
create database address_book_service;
show databases;
use address_book_service;

-- UC 2 add table address book
create table address_book (
	id int auto_increment primary key, 
    first_name varchar(50), 
    last_name varchar(50), 
    address varchar(50), 
    state varchar(50), 
    zip varchar(6), 
    phone_number varchar(10), 
    email varchar(50)
);

alter table address_book
add column city varchar(50) after address;


-- UC 3 adding data
insert into address_book(first_name, last_name, address, city, state, zip, phone_number, email)
values
	('John', 'Doe', 'Raj Nagar', 'Ghaziabad', 'Uttar Pradesh', '200101', '8686868686', 'john@example.com'),
    ('Jane', 'Doe', 'Medchal', 'Hyderabad', 'Telangana', '201003', '8686868686', 'john1@example.com'),
    ('Johny', 'Doe', 'Rajendra Nagar', 'Bhopal', 'Madhya Pradesh', '200104', '8686868686', 'john2@example.com'),
    ('Hank', 'Doe', 'Raj Nagar', 'Ghaziabad', 'Uttar Pradesh', '200101', '8686868686', 'john3@example.com'),
    ('Walt', 'Doe', 'Medchal', 'Hyderabad', 'Telangana', '201003', '8686868686', 'john4@example.com'),
    ('Will', 'Doe', 'Rajendra Nagar', 'Bhopal', 'Madhya Pradesh', '200104', '8686868686', 'john5@example.com'),
    ('Amy', 'Doe', 'Raj Nagar', 'Ghaziabad', 'Uttar Pradesh', '200101', '8686868686', 'john6@example.com'),
    ('Dre', 'Doe', 'Medchal', 'Hyderabad', 'Telangana', '201003', '8686868686', 'john7@example.com'),
    ('Ryan', 'Doe', 'Rajendra Nagar', 'Bhopal', 'Madhya Pradesh', '200104', '8686868686', 'john8@example.com'),
    ('Sam', 'Doe', 'Raj Nagar', 'Ghaziabad', 'Uttar Pradesh', '200101', '8686868686', 'john9@example.com'),
    ('Tammy', 'Doe', 'Medchal', 'Hyderabad', 'Telangana', '201003', '8686868686', 'john0@example.com'),
    ('Simon', 'Doe', 'Rajendra Nagar', 'Bhopal', 'Madhya Pradesh', '200104', '8686868686', 'john10@example.com'),
    ('Arthur', 'Doe', 'Raj Nagar', 'Ghaziabad', 'Uttar Pradesh', '200101', '8686868686', 'john11@example.com'),
    ('Ben', 'Doe', 'Medchal', 'Hyderabad', 'Telangana', '201003', '8686868686', 'john12@example.com'),
    ('Dane', 'Doe', 'Rajendra Nagar', 'Bhopal', 'Madhya Pradesh', '200104', '8686868686', 'john13@example.com'),
    ('Mike', 'Doe', 'Raj Nagar', 'Ghaziabad', 'Uttar Pradesh', '200101', '8686868686', 'john14@example.com');
    
    
set SQL_SAFE_UPDATES = 0;

-- UC 4 update existing contact based on name
update address_book
set 
    address = 'Shatabdi Chowk',
    city = 'Nagpur',
    state = 'Maharashtra',
    zip = '400921',
    phone_number = '9999000099',
    email = 'mike@example.com'
WHERE
    first_name = 'Mike' AND last_name = 'Doe';
    
    
-- UC 5 deleting existing contact based on name
delete from address_book where first_name = 'Dane' and last_name = 'Doe';

select * from address_book;


-- UC 6 retrieving contact based on city and state
select * from address_book where city = 'Ghaziabad' and state = 'Uttar Pradesh';


-- UC 7 getting the count 
select city, count(city) as city_count from address_book group by city;
select state, count(state) as state_count from address_book group by state;


-- UC 8 retireving the contacts alphabatically for given city
select * from address_book where city = 'Ghaziabad' order by first_name, last_name;
select * from address_book where city = 'Hyderabad' order by first_name, last_name;