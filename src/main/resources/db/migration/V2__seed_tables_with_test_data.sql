insert into public.users
(user_id, email, family_name, given_name, gender, date_of_birth, username, "password")
values
('92cba104-c922-4852-a683-b32ffd21b109', 'tony_test@gmail.com', 'Wang', 'Tony', 'MALE', '06/20/1997', 'test1234', 'some rando password'),
('11cba104-c922-4852-a683-b32ffd21b109', 'tony_test123@gmail.com', 'TestWang', 'TestTony', 'MALE', '06/20/1995', 'test2233', 'some rando password2'),
('123ba104-c922-4852-a683-b32ffd21b109', 'jonny_test1111@gmail.com', 'Walker', 'Jonny', 'MALE', '12/11/1988', 'test4321', 'some rando password2222'),
('54dcec7e-2ef1-477f-bd9b-27396cc4a277', 'alan_murphy2020@gmail.com', 'Murphy', 'Alan', 'MALE', '12/11/2004', 'testtest', 'some rando pa33332'),
('f837531f-59d4-401a-bfa3-68822983922c', 'someEmailTan@gmail.com', 'Tan', 'Michelle', 'FEMALE', '12/11/2004', 'test4334', 'some rando eeeee33332')
;


insert into racket
(racket_id, make, model, owner_user_id)
values
('2783e281-873a-4e72-8973-fe60663a822e', 'Yonex', 'Astrox 100ZZ', '11cba104-c922-4852-a683-b32ffd21b109'),
('944ddd9e-2582-4b33-9cdb-a5b80de052d2', 'Yonex', 'Astrox 100ZZ', '11cba104-c922-4852-a683-b32ffd21b109'),
('89ae2874-9f1c-4594-bfbf-32aaf4a80ec4', 'Victor', 'Thruster 15F', '11cba104-c922-4852-a683-b32ffd21b109'),
('e1fd1e12-8fcf-47da-8b5e-e784ebd7ae8b', 'Yonex', 'Astrox 88D Pro', '123ba104-c922-4852-a683-b32ffd21b109'),
('ac2fe681-ada2-4f24-ad75-b54aa23d1ec3', 'Yonex', 'Nanoflare 800', 'f837531f-59d4-401a-bfa3-68822983922c')
;



insert into stringing
	(price, requester_user_id, cross_length, cross_tension, main_length, main_tension, is_completed, completed_timestamp, last_updated_timestamp, requested_timestamp, stringer_user_id, stringing_id, "method", notes, string_name, racket_racket_id)
values
(15, '11cba104-c922-4852-a683-b32ffd21b109', 3.1,27,3.4,25,true, '11/19/2023 21:32:06', '11/19/2023 21:32:06', '11/17/2023 10:25:55', '92cba104-c922-4852-a683-b32ffd21b109', 'c74c371f-385b-4a4c-ba9b-314aab9c1111', 'TWOKNOT', 'no notes at this time Test 123444','BG80P', '2783e281-873a-4e72-8973-fe60663a822e'),
(20.04, '11cba104-c922-4852-a683-b32ffd21b109', 3.1,27,3.4,25,false, '11/19/2023 21:32:06', '11/19/2023 21:32:06', '11/17/2023 10:25:55', '92cba104-c922-4852-a683-b32ffd21b109', 'cccc371f-385b-4a4c-ba9b-314aab9c1111', 'TWOKNOT', 'notes tbd','BG80P', '2783e281-873a-4e72-8973-fe60663a822e'),
(25, '123ba104-c922-4852-a683-b32ffd21b109', 3.1,27,3.4,25,false, '12/22/2023 21:32:06', '12/22/2023 21:32:06', '12/19/2023 10:25:55', '92cba104-c922-4852-a683-b32ffd21b109', '0ea5959e-b841-469c-ba61-6ea1d7dc5aeb', 'FOURKNOT', 'this is user 123ba104 Astrox 88D Pro','BG66U', 'e1fd1e12-8fcf-47da-8b5e-e784ebd7ae8b'),
(20, 'f837531f-59d4-401a-bfa3-68822983922c', 3.1,29,3.1,27,true, '12/25/2023 11:32:06', '12/25/2023 11:32:06', '12/22/2023 10:25:55', '92cba104-c922-4852-a683-b32ffd21b109', '260a6b42-2e93-4fa9-87ae-d540a550cd22', 'FOURKNOT', 'Michelle Tans Nanoflare 800','BG66U', 'ac2fe681-ada2-4f24-ad75-b54aa23d1ec3'),
(25, 'f837531f-59d4-401a-bfa3-68822983922c', 3.2,28,3.3,26,true, '11/15/2023 21:32:06', '11/15/2023 21:32:06', '11/13/2023 10:25:55', '92cba104-c922-4852-a683-b32ffd21b109', '1bdf0dae-01aa-4ccc-a9e8-7643e60a6079', 'FOURKNOT', 'Michelle Tans Nanoflare 800 first stringing','BG80P', 'ac2fe681-ada2-4f24-ad75-b54aa23d1ec3')
;


