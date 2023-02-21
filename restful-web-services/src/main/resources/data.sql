insert into user_details(id,birth_date,name)
values(1001, current_date(), 'Rodo');

insert into user_details(id,birth_date,name)
values(1002, current_date(), 'Ravi');

insert into user_details(id,birth_date,name)
values(1003, current_date(), 'Sara');

insert into post(id,description,user_id)
values(2001, 'Rodo learns AWS', 1001);

insert into post(id,description,user_id)
values(2002, 'Ravi learns AWS', 1002);

insert into post(id,description,user_id)
values(2003, 'Sara learns AWS', 1003);