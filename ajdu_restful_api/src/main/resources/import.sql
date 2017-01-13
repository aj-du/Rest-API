insert into role (role_name) values ("ADMIN");
insert into role (role_name) values ("REG_USER");
insert into role (role_name) values ("ADD_USER");
insert into role (role_name) values ("ORG_USER");

insert into user (first_name,last_name,email,login,password) values ("Artur","Borkowski","s12020@pjwstk.edu.pl","s12020","Haslo1234")
insert into user (first_name,last_name,email,login,password) values ("Zbychu","Kowalski","z.kowal@o2.pl","zkow","128dahh1jhg2")

insert into user_role (user_id,role_id) values (1,1);
insert into user_role (user_id,role_id) values (1,2);
insert into user_role (user_id,role_id) values (2,2);