insert into user (first_name,last_name,gender,email,login,password, active) values ("Jan","Nowak","M","jnowak@pjwstk.edu.pl","s12020","Haslo1234", true)
insert into user (first_name,last_name,gender,email,login,password, active) values ("Anna","Kowalska","M","akowal@o2.pl","zkow","password", true)

insert into user_role (user_id,role) values (1,"ADMIN");
insert into user_role (user_id,role) values (1,"REG_USER");
insert into user_role (user_id,role) values (2,"REG_USER");

insert into schedule (user_id) values (1);
insert into schedule (user_id) values (2);

insert into calendar_task (title, description, schedule_id,status, start, end, location) values ("Fryzjer", "Umówić się na porównanie kolorów",1,"TODO", date("2017-06-04"), date("2017-06-30"), "Gdańsk - Fryzjer Trendy")
insert into calendar_task (title, description, schedule_id,status, start, location) values ("Oglądanie sali", "Obejrzeć salę weselną",1,"TODO", date("2017-02-14"), "Luzino")

insert into todo_task (title, description, status) values ("Sala weselna", "", "TODO");
insert into todo_task (title, description, status) values ("Wizyta w parafii", "", "TODO");
insert into todo_task (title, description, status) values ("Wizyta w USC", "", "TODO");
insert into todo_task (title, description, status) values ("Oprawa muzyczna wesela", "", "TODO");
insert into todo_task (title, description, status) values ("Fotograf", "", "TODO");
insert into todo_task (title, description, status) values ("Kamerzysta", "", "TODO");
insert into todo_task (title, description, status) values ("Wybór świadków", "", "TODO");
insert into todo_task (title, description, status) values ("Ustalenie listy gości", "", "TODO");
insert into todo_task (title, description, status) values ("Zaplanowanie urlopów w pracy", "", "TODO");
insert into todo_task (title, description, status) values ("Zaplanowanie podróży poślubnej", "", "TODO");
insert into todo_task (title, description, status) values ("Menu: jedzenie", "", "TODO");
insert into todo_task (title, description, status) values ("Menu: napoje", "", "TODO");
insert into todo_task (title, description, status) values ("Menu: ciasta", "", "TODO");
insert into todo_task (title, description, status) values ("Menu: tort", "", "TODO");
insert into todo_task (title, description, status) values ("Menu: napoje wysokoprocentowe", "", "TODO");
insert into todo_task (title, description, status) values ("Dekoracja: sala weselna", "", "TODO");
insert into todo_task (title, description, status) values ("Dekoracja: samochód", "", "TODO");
insert into todo_task (title, description, status) values ("Dekoracja: kościół", "", "TODO");
insert into todo_task (title, description, status) values ("Dekoracja: dom rodzinny", "", "TODO");
insert into todo_task (title, description, status) values ("Winietki", "", "TODO");
insert into todo_task (title, description, status) values ("Karty menu", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Pana Młodego: garnitur", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Pana Młodego: koszule", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Pana Młodego: buty", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Pana Młodego: krawat/mucha", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Panny Młodej: suknia ślubna", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Panny Młodej: sukienka", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Panny Młodej: welon", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Panny Młodej: dodatki", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Panny Młodej: biżuteria", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Panny Młodej: buty", "", "TODO");
insert into todo_task (title, description, status) values ("Strój Panny Młodej: bielizna", "", "TODO");
insert into todo_task (title, description, status) values ("Kwiaty: wiązanka Panny Młodej", "", "TODO");
insert into todo_task (title, description, status) values ("Kwiaty: wiązanki dla rodziców", "", "TODO");
insert into todo_task (title, description, status) values ("Kwiaty: kwiaty do butonierki", "", "TODO");
insert into todo_task (title, description, status) values ("Samochód lub inny pojazd dla Pary Młodej", "", "TODO");
insert into todo_task (title, description, status) values ("Zakup obrączek", "", "TODO");
insert into todo_task (title, description, status) values ("Nauka tańca", "", "TODO");
insert into todo_task (title, description, status) values ("Fryzjer Panny Młodej", "", "TODO");
insert into todo_task (title, description, status) values ("Fryzjer Pana Młodego", "", "TODO");
insert into todo_task (title, description, status) values ("Kosmetyczka: makijaż", "", "TODO");
insert into todo_task (title, description, status) values ("Kosmetyczka: manicure", "", "TODO");
insert into todo_task (title, description, status) values ("Wieczór kawalerski", "", "TODO");
insert into todo_task (title, description, status) values ("Wieczór panieński", "", "TODO");
insert into todo_task (title, description, status) values ("Dodatkowe atrakcje", "", "TODO");
insert into todo_task (title, description, status) values ("Podziękowania dla gości", "", "TODO");
insert into todo_task (title, description, status) values ("Księga pamiątkowa", "", "TODO");


insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Sala Weselna \"Olimp\"","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Restauracja \"Nova\"","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Zespół Companieros","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Alabama Band","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Biała Perła","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Agata Malinowska","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Jan Zięba","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Kazimierz Nowacki","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Karolina Miś","Dummy Street 99","80-001","pomorskie");
insert into address (city, line1, line2, postal_code, region) values ("Dummy City","Hotel Perfect","Dummy Street 99","80-001","pomorskie");

insert into organization (name,login,password,active,email,address_id, phone_number) values ("Sala Weselna \"Olimp\"","olimp_gda","salaweslna123a",true,"olimp_gdansk@firma.pl",1, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Restauracja \"Nova\"","restauracjanova","password",true,"restauracjanoca@firma.pl",2, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Companieros - Zespół weselny","companieros","password",true,"companieros@firma.pl",3, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Zespół ALABAMA","alabama","password",true,"alabama@firma.pl",4, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Biała Perła","b_perla","password",true,"b_perla@firma.pl",5, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Salon Fryzjerski \"Agata\"","fryzjer_agata","password",true,"fryzjer_agata@firma.pl",6, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Fryzjer Johny","johnyyy","password",true,"johnyyy@firma.pl",7, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Usługi Foto-Video Kazimierz","kazik_foto","password",true,"kazik_foto@firma.pl",8, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Fotografia u Karoliny","karolina1988","password",true,"foto_karola@firma.pl",9, "58 999-99-99");
insert into organization (name,login,password,active,email,address_id, phone_number) values ("Hotel Perfect ***","perfect_hotel","password",true,"perfect@firma.pl",10, "58 999-99-99");



insert into category (name) values ("Sala weselna");
insert into category (name) values ("Muzyka");
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
insert into category (name) values ("Inne");

insert into service (name,description, cost, organization_id) values ("Wynajem sali weselnej (24h)","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",12000.00,1);
insert into service (name,description, cost, organization_id) values ("Wynajem sali z obsługą (24h)","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",18500.00,1);
insert into service (name,description, cost, organization_id) values ("Wynajem kuchni (24h)","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",8500.00,1);
insert into service (name,description,cost, organization_id) values ("Pokoje Hotelowe","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",750.00,1);
insert into service (name,description, cost, organization_id) values ("Parking","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",700.00,1);
insert into service (name,description, cost, organization_id) values ("Menu Weselne standard","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",10000.00,2);
insert into service (name,description, cost, organization_id) values ("Menu Weselne premium","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",14000.00,2);
insert into service (name,description, cost, organization_id) values ("Menu Weselne standard + alkohol","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",15000.00,2);
insert into service (name,description, cost, organization_id) values ("Menu Weselne premium + alkohol","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",20000.00,2);
insert into service (name,description, cost, organization_id) values ("Oprawa muzyczna wesela","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",4000.00,3);
insert into service (name,description, cost, organization_id) values ("Oprawa muzyczna wesela + poprawiny","",5000.00,3);
insert into service (name,description, cost, organization_id) values ("Wyprowadzenie Panny Młodej","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",300.00,3);
insert into service (name,description, cost, organization_id) values ("Oprawa muzyczna wesela","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",3700.00,4);
insert into service (name,description, cost, organization_id) values ("Oprawa muzyczna wesela z poprawinami","",4900.00,4);
insert into service (name,description, cost, organization_id) values ("Trąbka na ślubie","",300.00,4);
insert into service (name,description, cost, organization_id) values ("Sala weselna z obsługą","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",8500.00,5);
insert into service (name,description, cost, organization_id) values ("Pakiet hotelowy","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",3000.00,5);
insert into service (name,description, cost, organization_id) values ("Pakiet hotelowy VIP","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",5000.00,5);
insert into service (name,description, cost, organization_id) values ("Loki","",200.00,6);
insert into service (name,description, cost, organization_id) values ("Koki","",220.00,6);
insert into service (name,description, cost, organization_id) values ("Farbowanie","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",120.00,6);
insert into service (name,description, cost, organization_id) values ("Strzyżenie (włosy krótkie)","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",80.00,6);
insert into service (name,description, cost, organization_id) values ("Strzyżenie (włosy długie)","Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",130.00,6);
insert into service (name,description, cost, organization_id) values ("Strzyżenie","",50.00,7);
insert into service (name,description, cost, organization_id) values ("Golenie","Lorem ipsum dolor sit amet.",40.00,7);
insert into service (name,description, cost, organization_id) values ("Mycie","",20.00,7);
insert into service (name,description, cost, organization_id) values ("Filmowanie ślubu i wesela (1 kamera)","Lorem ipsum dolor sit amet.",1200.00,8);
insert into service (name,description, cost, organization_id) values ("Filmowanie ślubu i wesela (2 kamery)","Lorem ipsum dolor sit amet.",1800.00,8);
insert into service (name,description, cost, organization_id) values ("Zdjęcia ze ślubu i wesela (1000 sztuk)","Lorem ipsum dolor sit amet.",1000.00,8);
insert into service (name,description, cost, organization_id) values ("Sesja ślubna ","Lorem ipsum dolor sit amet.",500.00,8);
insert into service (name,description, cost, organization_id) values ("Zdjęcia na ślubie","Lorem ipsum dolor sit amet.",500.00,9);
insert into service (name,description, cost, organization_id) values ("Zdjęcia z przygotowań Pary Młodej","Lorem ipsum dolor sit amet.",150.00,9);
insert into service (name,description, cost, organization_id) values ("Zdjęcia z wesela","Lorem ipsum dolor sit amet.",1500.00,9);
insert into service (name,description, cost, organization_id) values ("Sesja ślubna","Lorem ipsum dolor sit amet.",400.00,9);
insert into service (name,description, cost, organization_id) values ("Pakiet weselny (oszczędzasz 350 PLN!)","Lorem ipsum dolor sit amet.",2200.00,9);
insert into service (name,description, cost, organization_id) values ("Sala bankietowa","Lorem ipsum dolor sit amet.",15000.00,10);
insert into service (name,description, cost, organization_id) values ("Catering Pakiet Srebrny","Lorem ipsum dolor sit amet.",8000.00,10);
insert into service (name,description, cost, organization_id) values ("Catering Pakiet Złoty","Lorem ipsum dolor sit amet.",13000.00,10);
insert into service (name,description, cost, organization_id) values ("Pokoje gościnne - pakiet weselny","Lorem ipsum dolor sit amet.",10000.00,10);

insert into opinion (rate, content, service_id, user_id) values (5, "Sala przestronna, miła obsługa, wyposażona w światła, niezła akustyka. Kierownik sali pełni rolę mistrza ceremonii, co jest bardzo przydatne przy weselu. Polecamy!!!", 2,1);
insert into opinion (rate, content, service_id, user_id) values (3, "Sala taka sobie. Klimatyzacja była zepsuta na naszym weselu i ludzie tonęli we własnym pocie. 3/5", 2,2);


insert into service_category (service_id, category_id) values (3,1);
insert into service_category (service_id, category_id) values (3,4);
insert into service_category (service_id, category_id) values (2,4);
insert into service_category (service_id, category_id) values (1,3);
insert into service_category (service_id, category_id) values (1,2);
insert into service_category (service_id, category_id) values (1,1);
insert into service_category (service_id, category_id) values (4,12);
insert into service_category (service_id, category_id) values (5,12);
insert into service_category (service_id, category_id) values (5,13);
insert into service_category (service_id, category_id) values (5,15);
insert into service_category (service_id, category_id) values (6,3);
insert into service_category (service_id, category_id) values (7,3);
insert into service_category (service_id, category_id) values (8,3);
insert into service_category (service_id, category_id) values (9,3);
insert into service_category (service_id, category_id) values (10,2);
insert into service_category (service_id, category_id) values (11,2);
insert into service_category (service_id, category_id) values (12,2);
insert into service_category (service_id, category_id) values (13,2);
insert into service_category (service_id, category_id) values (14,2);
insert into service_category (service_id, category_id) values (15,2);
insert into service_category (service_id, category_id) values (16,1);
insert into service_category (service_id, category_id) values (16,4);
insert into service_category (service_id, category_id) values (17,12);
insert into service_category (service_id, category_id) values (18,12);
insert into service_category (service_id, category_id) values (19,7);
insert into service_category (service_id, category_id) values (20,7);
insert into service_category (service_id, category_id) values (21,7);
insert into service_category (service_id, category_id) values (22,7);
insert into service_category (service_id, category_id) values (23,7);
insert into service_category (service_id, category_id) values (24,7);
insert into service_category (service_id, category_id) values (25,7);
insert into service_category (service_id, category_id) values (26,7);
insert into service_category (service_id, category_id) values (27,6);
insert into service_category (service_id, category_id) values (28,6);
insert into service_category (service_id, category_id) values (29,5);
insert into service_category (service_id, category_id) values (30,5);
insert into service_category (service_id, category_id) values (31,5);
insert into service_category (service_id, category_id) values (32,5);
insert into service_category (service_id, category_id) values (33,5);
insert into service_category (service_id, category_id) values (34,5);
insert into service_category (service_id, category_id) values (35,5);
insert into service_category (service_id, category_id) values (35,6);
insert into service_category (service_id, category_id) values (36,1);
insert into service_category (service_id, category_id) values (36,4);
insert into service_category (service_id, category_id) values (37,3);
insert into service_category (service_id, category_id) values (38,3);
insert into service_category (service_id, category_id) values (39,12);



insert into organization_category (organization_id, category_id) values (1,1);
insert into organization_category (organization_id, category_id) values (1,3);
insert into organization_category (organization_id, category_id) values (1,4);
insert into organization_category (organization_id, category_id) values (1,12);
insert into organization_category (organization_id, category_id) values (2,3);
insert into organization_category (organization_id, category_id) values (3,2);
insert into organization_category (organization_id, category_id) values (4,2);
insert into organization_category (organization_id, category_id) values (5,1);
insert into organization_category (organization_id, category_id) values (5,4);
insert into organization_category (organization_id, category_id) values (5,3);
insert into organization_category (organization_id, category_id) values (5,12);
insert into organization_category (organization_id, category_id) values (6,7);
insert into organization_category (organization_id, category_id) values (7,7);
insert into organization_category (organization_id, category_id) values (8,5);
insert into organization_category (organization_id, category_id) values (8,6);
insert into organization_category (organization_id, category_id) values (9,5);
insert into organization_category (organization_id, category_id) values (10,1);
insert into organization_category (organization_id, category_id) values (10,3);
insert into organization_category (organization_id, category_id) values (10,4);
insert into organization_category (organization_id, category_id) values (10,12);



insert into package (user_id) values (1);
insert into package (user_id) values (2);

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

insert into media (fileurl, media_type, title, user_id) values ("./dummy/images/profile.jpg", "IMAGE", "Profilowe", 1);
