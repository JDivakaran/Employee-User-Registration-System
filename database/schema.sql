create table department(
	id int primary key not null auto_increment,
    dept_name varchar(55)
);

create table employee(
	id INT primary key not null auto_increment,
    first_name varchar(55) not null,
    last_name varchar(55) not null,
    email varchar(55)not null unique,
    pass_word varchar(100) not null,
    mobile_no varchar(55) not null,
    department_id INT not null,
    designation varchar(55) not null,
    role varchar(55) not null,
    status varchar(55),
    constraint fk_employee_id foreign key (department_id) references department(id)
    on delete restrict
);

create table verification_token(
	id int primary key auto_increment, 
    employee_id int,
    token varchar(255),
    constraint fk_verification_id foreign key (employee_id) references employee(id)
    
);