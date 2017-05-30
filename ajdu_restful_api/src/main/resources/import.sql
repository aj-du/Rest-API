insert into user (first_name,last_name,email,login,password) values ("Artur","Borkowski","s12020@pjwstk.edu.pl","s12020","Haslo1234")
insert into user (first_name,last_name,email,login,password) values ("Zbychu","Kowalski","z.kowal@o2.pl","zkow","128dahh1jhg2")

insert into user_role (user_id,role) values (1,"ADMIN");
insert into user_role (user_id,role) values (1,"REG_USER");
insert into user_role (user_id,role) values (2,"REG_USER");


insert into schedule (user_id) values (1);

insert into calendar_task (name, description, schedule_id,status, date, due_date, location) values ("Fryzjer", "Umówić się na porównanie kolorów",1,"TODO", date("2017-06-04"), date("2017-06-30"), "Gdańsk - Fryzjer Trendy")
insert into calendar_task (name, description, schedule_id,status, date, location) values ("Oglądanie sali", "Obejrzeć salę weselną",1,"TODO", date("2017-02-14"), "Luzino")

insert into todo_task (name, description, status) values ("Sala weselna", "", "TODO");
insert into todo_task (name, description, status) values ("Wizyta w parafii", "", "TODO");
insert into todo_task (name, description, status) values ("Wizyta w USC", "", "TODO");
insert into todo_task (name, description, status) values ("Oprawa muzyczna wesela", "", "TODO");
insert into todo_task (name, description, status) values ("Fotograf", "", "TODO");
insert into todo_task (name, description, status) values ("Kamerzysta", "", "TODO");
insert into todo_task (name, description, status) values ("Wybór świadków", "", "TODO");
insert into todo_task (name, description, status) values ("Ustalenie listy gości", "", "TODO");
insert into todo_task (name, description, status) values ("Zaplanowanie urlopów w pracy", "", "TODO");
insert into todo_task (name, description, status) values ("Zaplanowanie podróży poślubnej", "", "TODO");
insert into todo_task (name, description, status) values ("Menu: jedzenie", "", "TODO");
insert into todo_task (name, description, status) values ("Menu: napoje", "", "TODO");
insert into todo_task (name, description, status) values ("Menu: ciasta", "", "TODO");
insert into todo_task (name, description, status) values ("Menu: tort", "", "TODO");
insert into todo_task (name, description, status) values ("Menu: napoje wysokoprocentowe", "", "TODO");
insert into todo_task (name, description, status) values ("Dekoracja: sala weselna", "", "TODO");
insert into todo_task (name, description, status) values ("Dekoracja: samochód", "", "TODO");
insert into todo_task (name, description, status) values ("Dekoracja: kościół", "", "TODO");
insert into todo_task (name, description, status) values ("Dekoracja: dom rodzinny", "", "TODO");
insert into todo_task (name, description, status) values ("Winietki", "", "TODO");
insert into todo_task (name, description, status) values ("Karty menu", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Pana Młodego: garnitur", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Pana Młodego: koszule", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Pana Młodego: buty", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Pana Młodego: krawat/mucha", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Panny Młodej: suknia ślubna", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Panny Młodej: sukienka", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Panny Młodej: welon", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Panny Młodej: dodatki", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Panny Młodej: biżuteria", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Panny Młodej: buty", "", "TODO");
insert into todo_task (name, description, status) values ("Strój Panny Młodej: bielizna", "", "TODO");
insert into todo_task (name, description, status) values ("Kwiaty: wiązanka Panny Młodej", "", "TODO");
insert into todo_task (name, description, status) values ("Kwiaty: wiązanki dla rodziców", "", "TODO");
insert into todo_task (name, description, status) values ("Kwiaty: kwiaty do butonierki", "", "TODO");
insert into todo_task (name, description, status) values ("Samochód lub inny pojazd dla Pary Młodej", "", "TODO");
insert into todo_task (name, description, status) values ("Zakup obrączek", "", "TODO");
insert into todo_task (name, description, status) values ("Nauka tańca", "", "TODO");
insert into todo_task (name, description, status) values ("Fryzjer Panny Młodej", "", "TODO");
insert into todo_task (name, description, status) values ("Fryzjer Pana Młodego", "", "TODO");
insert into todo_task (name, description, status) values ("Kosmetyczka: makijaż", "", "TODO");
insert into todo_task (name, description, status) values ("Kosmetyczka: manicure", "", "TODO");
insert into todo_task (name, description, status) values ("Wieczór kawalerski", "", "TODO");
insert into todo_task (name, description, status) values ("Wieczór panieński", "", "TODO");
insert into todo_task (name, description, status) values ("Dodatkowe atrakcje", "", "TODO");
insert into todo_task (name, description, status) values ("Podziękowania dla gości", "", "TODO");
insert into todo_task (name, description, status) values ("Księga pamiątkowa", "", "TODO");


insert into address (city, country, line1, line2, postal_code, region) values ("Gdansk", "PL","Sala Weselna \"Olimp\"","Kartuska 123","80-012","pomorskie");
insert into address (city, country, line1, line2, postal_code, region) values ("Wejherowo", "PL","Restauracja \"Nova\"","Lęborska 12H","80-240","pomorskie");

insert into organization (name,login,password,email,address_id) values ("Sala Weselna \"Olimp\"","olimp_gda","salaweslna123a","olimp_gdansk@firma.pl",1);

insert into category (name) values ("Sala weselna");
insert into category (name) values ("Zespół");
insert into category (name) values ("Catering");
insert into category (name) values ("Obsługa");
insert into category (name) values ("Fotografia");
insert into category (name) values ("Film");
insert into category (name) values ("Fryzjer");
insert into category (name) values ("Kwiaciarnia");
insert into category (name) values ("Wystrój");
insert into category (name) values ("Samochód");
insert into category (name) values ("Koordynacja");
insert into category (name) values ("Hotel");
insert into category (name) values ("Transport");
insert into category (name) values ("Odzież");
insert into category (name) values ("Atrakcje dodatkowe");

insert into service (name, cost, organization_id) values ("pierwsza",1200.00,1);
insert into service (name, cost, organization_id) values ("druga",1350.00,1);
insert into service (name, cost, organization_id) values ("trzecia",1050.00,1);

insert into service_category (service_id, category_id) values (3,1);
insert into service_category (service_id, category_id) values (3,4);
insert into service_category (service_id, category_id) values (2,4);
insert into service_category (service_id, category_id) values (1,3);
insert into service_category (service_id, category_id) values (1,2);
insert into service_category (service_id, category_id) values (1,1);

insert into organization_category (organization_id, category_id) values (1,1);
insert into organization_category (organization_id, category_id) values (1,2);
insert into organization_category (organization_id, category_id) values (1,3);
insert into organization_category (organization_id, category_id) values (1,4);

insert into package (user_id) values (1);

insert into package_service (package_id, service_id) values (1,1);
insert into package_service (package_id, service_id) values (1,2);
insert into package_service (package_id, service_id) values (1,3);

insert into blog (title,description,user_id) values ("Na ostatni guzik","Nazywam się Anna Nowak. Jestem mężatką od 5 lat, ale do dziś pamiętam, jak wielkim stresem była dla mnie i mojego męża organizacja naszego ślubu. Wszystko udało się znakomicie, ale ile nas to kosztowało, to tylko my wiemy. Od tamtego czasu pomagałam w przygotowaniach wesela kilku kuzynom i koleżankom. Tworząc ten blog chcę wykorzystać to spore doświadczenie i pomóc także Wam. Wszystko po to, aby ten wyjątkowy dzień był niezapomniany.\nMam nadzieję, że znajdziecie tu inspirujące i pomocne treści, które pomogą Wam zorganizować wasz ślub marzeń.", 1);
insert into blog (title,description,user_id) values ("Jak zorganizowałem swoje własne wesele","Nazywam się Zbyszek. Z żoną zorganizowaliśmy sami całe przedsiewziecie.... blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah blah .", 2);

insert into post(title,content,blog_id) values("Welon ślubny – potrzeba czy fanaberia?","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1);
insert into post(title,content,blog_id) values("Jakie auto do kościoła? A może dorożka...?","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 2);
insert into post(title,content,blog_id) values("Tyle pieniędzy za ślub?! A miało być co łaska!","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 2);
insert into post(title,content,blog_id) values("Sala weselna w swojskim klimacie","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\nLorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", 1);

insert into comment(content,user_id,post_id) values("Osobiście uwielbiam takie niestandardowe kolorowe suknie, ale nie każdemu pasują", 1, 1);
insert into comment(content,user_id,post_id) values("kurcze no nie wiem nie przypadł mi ten pomysł go gustu, jakoś tak nie do końca", 2, 1);
insert into comment(content,user_id,post_id) values("Wiecie może kiedy będą następne takie targi, bo te niestety przegapiłam ", 1, 1);
insert into comment(content,user_id,post_id) values("Nieźle Zbychu! ", 1, 2);
insert into comment(content,user_id,post_id) values("A dzięki dzięki :D", 2, 2);
insert into comment(content,user_id,post_id) values("Oj tam, taka tradycja. Co ludzie powiedzą.", 1, 3);