insert into public.users
(user_id, email, family_name, given_name, is_stringer, gender, date_of_birth, username, "password")
values
('92cba104-c922-4852-a683-b32ffd21b109', 'tony_test@gmail.com', 'Wang', 'Tony', true, 'MALE', '06/21/1997', 'test1234', 'some rando password'),
('11cba104-c922-4852-a683-b32ffd21b109', 'zoe_test123@gmail.com', 'Xu', 'Zoe', false, 'FEMALE', '03/20/1996', 'test2233', 'some rando password2'),
('123ba104-c922-4852-a683-b32ffd21b109', 'jonny_test1111@gmail.com', 'Wang', 'Andrew', false, 'MALE', '12/11/1970', 'test4321', 'some rando password2222'),
('54dcec7e-2ef1-477f-bd9b-27396cc4a277', 'alan_murphy2020@gmail.com', 'Hidaki', 'Remy', false, 'FEMALE', '12/11/2004', 'testtest', 'some rando pa33332'),
('f837531f-59d4-401a-bfa3-68822983922c', 'someEmailTan@gmail.com', 'Farrell', 'Emma', false, 'FEMALE', '12/11/2014', 'testemma', 'some rando eeeee33332'),
('6db517cb-28d9-421b-b0f6-211679b09307', 'GeorgeEmail@gmail.com', 'Zhu', 'George', false, 'MALE', '12/11/1988', 'testzhu', 'some rando 33333'),
('ba9ed17a-b785-4d67-ba2a-e71051dbab3f', 'KyrstalsEmail1@gmail.com', 'Pham', 'Krystal', false, 'FEMALE', '12/11/1990', 'testpham', 'some rando 123123')
;


insert into racket
(racket_id, make, model, owner_user_id)
values
('2783e281-873a-4e72-8973-fe60663a822e', 'Yonex', 'Astrox 100ZZ', '92cba104-c922-4852-a683-b32ffd21b109'),
('944ddd9e-2582-4b33-9cdb-a5b80de052d2', 'Yonex', 'Astrox 100ZZ Kuranai', '92cba104-c922-4852-a683-b32ffd21b109'),
('93f68eff-8615-4f57-93b0-36957698d856', 'Yonex', 'Z-Force II', '92cba104-c922-4852-a683-b32ffd21b109'),

('89ae2874-9f1c-4594-bfbf-32aaf4a80ec4', 'Victor', 'Thruster TTY A Tai Tzu Ying Edition (White) TK-TTY A', '11cba104-c922-4852-a683-b32ffd21b109'),

('e1fd1e12-8fcf-47da-8b5e-e784ebd7ae8b', 'Yonex', 'Nanoflare 700', '54dcec7e-2ef1-477f-bd9b-27396cc4a277'),

('ac2fe681-ada2-4f24-ad75-b54aa23d1ec3', 'Yonex', 'Nanoflare 700', 'ba9ed17a-b785-4d67-ba2a-e71051dbab3f')
;


insert into string_entity
(id, model, color, make)
values
('71895ca2-a483-4f77-b9d7-66c7dc685a6d', 'BG80', 'WHITE', 'Yonex'),
('0c7c7698-5746-4ce5-8bff-46fb662c01ce', 'BG80 Power', 'WHITE', 'Yonex'),
('31a49689-8a67-493e-9ceb-44eddd92b44b', 'BG66 Ultimax', 'ORANGE', 'Yonex'),
('4bcbb372-784c-4154-904a-0ce5b17687fa', 'BG66 Ultimax', 'DARK_BLUE', 'Yonex')
;


insert into stringing
	(stringing_id, requester_user_id, stringer_user_id, racket_racket_id, price, main_length, cross_length, main_tension, cross_tension, status, is_completed, completed_timestamp, last_updated_timestamp, requested_timestamp, "method", notes)
--     (stringing_id, requester_user_id, stringer_user_id, racket_racket_id, price, string_mains_id, string_crosses_id, main_length, cross_length, main_tension, cross_tension, status, is_completed, completed_timestamp, last_updated_timestamp, requested_timestamp, "method", notes)
values
('c74c371f-385b-4a4c-ba9b-314aab9c1111', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '93f68eff-8615-4f57-93b0-36957698d856', 0,  3.5, 3.25, 26, 28, 'COMPLETED', true, '5/19/2023 00:00:00', '5/19/2023 00:00:00', '5/19/2023 00:00:00', 'FOURKNOT', 'could have done 3 for crosses probably. Could do 3.25 for mains but thats sketchy'), --tony 100zz
('3dc4f3be-a4c0-4cbc-a292-05c40849e423', '54dcec7e-2ef1-477f-bd9b-27396cc4a277', '92cba104-c922-4852-a683-b32ffd21b109', 'e1fd1e12-8fcf-47da-8b5e-e784ebd7ae8b', 0,  3.6, 3.3, 25, 27, 'COMPLETED', true, '6/18/2023 00:00:00', '6/18/2023 00:00:00', '6/18/2023 00:00:00', 'FOURKNOT', 'Forgot to put in extra string at the top crossovers..again'), --remy NF700
('b10d7698-1d18-4d01-a934-46c12fc38ec0', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '2783e281-873a-4e72-8973-fe60663a822e', 0,  3.4, 3.1, 25, 27, 'COMPLETED', true, '6/19/2023 00:00:00', '6/19/2023 00:00:00', '6/19/2023 00:00:00', 'FOURKNOT', 'Forgot to put in extra string at the top crossovers..again'), --tony 100zz
('b6f9dd0f-bf04-4b84-a05e-6dc0ab33f915', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '2783e281-873a-4e72-8973-fe60663a822e', 0,  3.4, 3.1, 26, 28, 'COMPLETED', true, '7/26/2023 00:00:00', '7/26/2023 00:00:00', '7/26/2023 00:00:00', 'FOURKNOT', 'Twisted a string on one of the pull throughs. I should add extra string at EVERY hole crossing to make it easier in the future'), --tony 100zz
('1165aa59-a5c6-4b9f-8469-d691fbe974ca', '11cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '89ae2874-9f1c-4594-bfbf-32aaf4a80ec4', 0,  3.5, 3.25, 25, 27, 'COMPLETED', true, '7/29/2023 00:00:00', '7/29/2023 00:00:00', '7/29/2023 00:00:00', 'FOURKNOT', 'No problems, top of racket is too narrow for fixed clamps, required a flying clamp to finish off'), --zoe TTY Thruster
('4d15850b-a329-42cc-bab4-681d294ce35a', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '2783e281-873a-4e72-8973-fe60663a822e', 0,  3.4, 3.1, 25, 27, 'COMPLETED', true, '8/19/2023 00:00:00', '8/19/2023 00:00:00', '8/19/2023 00:00:00', 'FOURKNOT', 'Fucked up the last tie off knot at the end a little bit. Still success. Added the extra pull strings to the bottom cover holes. somewhat useful.'), --tony 100zz
('87565199-13b1-4923-9cd8-76f3a0d9c8a5', 'ba9ed17a-b785-4d67-ba2a-e71051dbab3f', '92cba104-c922-4852-a683-b32ffd21b109', 'ac2fe681-ada2-4f24-ad75-b54aa23d1ec3', 15.00,  3.5, 3.25, 24, 26, 'COMPLETED', true, '9/15/2023 00:00:00', '9/15/2023 00:00:00', '9/15/2023 00:00:00', 'FOURKNOT', 'Should continue using 3.25 and leave enough space at the end of cross starting to pull it one last time'), --krystal NF700
('0a376308-eed6-410a-8a32-96fa37fcd903', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '93f68eff-8615-4f57-93b0-36957698d856', 0, 3.4, 3.1, 26, 28, 'COMPLETED', true, '11/19/2023 00:00:00', '11/19/2023 00:00:00', '11/19/2023 00:00:00', 'FOURKNOT', 'Fucked up top knot, fucked up side supports') --tony 100zz
-- todo placeholder data for when we re-implement string entities
-- ('c74c371f-385b-4a4c-ba9b-314aab9c1111', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '93f68eff-8615-4f57-93b0-36957698d856', 0, '0c7c7698-5746-4ce5-8bff-46fb662c01ce', '0c7c7698-5746-4ce5-8bff-46fb662c01ce', 3.5, 3.25, 26, 28, 'COMPLETED', true, '5/19/2023 00:00:00', '5/19/2023 00:00:00', '5/19/2023 00:00:00', 'FOURKNOT', 'could have done 3 for crosses probably. Could do 3.25 for mains but thats sketchy'), --tony 100zz
-- ('3dc4f3be-a4c0-4cbc-a292-05c40849e423', '54dcec7e-2ef1-477f-bd9b-27396cc4a277', '92cba104-c922-4852-a683-b32ffd21b109', 'e1fd1e12-8fcf-47da-8b5e-e784ebd7ae8b', 0, '0c7c7698-5746-4ce5-8bff-46fb662c01ce', '0c7c7698-5746-4ce5-8bff-46fb662c01ce', 3.6, 3.3, 25, 27, 'COMPLETED', true, '6/18/2023 00:00:00', '6/18/2023 00:00:00', '6/18/2023 00:00:00', 'FOURKNOT', 'Forgot to put in extra string at the top crossovers..again'), --remy NF700
-- ('b10d7698-1d18-4d01-a934-46c12fc38ec0', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '2783e281-873a-4e72-8973-fe60663a822e', 0, '0c7c7698-5746-4ce5-8bff-46fb662c01ce', '0c7c7698-5746-4ce5-8bff-46fb662c01ce', 3.4, 3.1, 25, 27, 'COMPLETED', true, '6/19/2023 00:00:00', '6/19/2023 00:00:00', '6/19/2023 00:00:00', 'FOURKNOT', 'Forgot to put in extra string at the top crossovers..again'), --tony 100zz
-- ('b6f9dd0f-bf04-4b84-a05e-6dc0ab33f915', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '2783e281-873a-4e72-8973-fe60663a822e', 0, '0c7c7698-5746-4ce5-8bff-46fb662c01ce', '0c7c7698-5746-4ce5-8bff-46fb662c01ce', 3.4, 3.1, 26, 28, 'COMPLETED', true, '7/26/2023 00:00:00', '7/26/2023 00:00:00', '7/26/2023 00:00:00', 'FOURKNOT', 'Twisted a string on one of the pull throughs. I should add extra string at EVERY hole crossing to make it easier in the future'), --tony 100zz
-- ('1165aa59-a5c6-4b9f-8469-d691fbe974ca', '11cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '89ae2874-9f1c-4594-bfbf-32aaf4a80ec4', 0, '0c7c7698-5746-4ce5-8bff-46fb662c01ce', '0c7c7698-5746-4ce5-8bff-46fb662c01ce', 3.5, 3.25, 25, 27, 'COMPLETED', true, '7/29/2023 00:00:00', '7/29/2023 00:00:00', '7/29/2023 00:00:00', 'FOURKNOT', 'No problems, top of racket is too narrow for fixed clamps, required a flying clamp to finish off'), --zoe TTY Thruster
-- ('4d15850b-a329-42cc-bab4-681d294ce35a', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '2783e281-873a-4e72-8973-fe60663a822e', 0, '0c7c7698-5746-4ce5-8bff-46fb662c01ce', '0c7c7698-5746-4ce5-8bff-46fb662c01ce', 3.4, 3.1, 25, 27, 'COMPLETED', true, '8/19/2023 00:00:00', '8/19/2023 00:00:00', '8/19/2023 00:00:00', 'FOURKNOT', 'Fucked up the last tie off knot at the end a little bit. Still success. Added the extra pull strings to the bottom cover holes. somewhat useful.'), --tony 100zz
-- ('87565199-13b1-4923-9cd8-76f3a0d9c8a5', 'ba9ed17a-b785-4d67-ba2a-e71051dbab3f', '92cba104-c922-4852-a683-b32ffd21b109', 'ac2fe681-ada2-4f24-ad75-b54aa23d1ec3', 15.00, '0c7c7698-5746-4ce5-8bff-46fb662c01ce', '0c7c7698-5746-4ce5-8bff-46fb662c01ce', 3.5, 3.25, 24, 26, 'COMPLETED', true, '9/15/2023 00:00:00', '9/15/2023 00:00:00', '9/15/2023 00:00:00', 'FOURKNOT', 'Should continue using 3.25 and leave enough space at the end of cross starting to pull it one last time'), --krystal NF700
-- ('0a376308-eed6-410a-8a32-96fa37fcd903', '92cba104-c922-4852-a683-b32ffd21b109', '92cba104-c922-4852-a683-b32ffd21b109', '93f68eff-8615-4f57-93b0-36957698d856', 0, '4bcbb372-784c-4154-904a-0ce5b17687fa', '4bcbb372-784c-4154-904a-0ce5b17687fa', 3.4, 3.1, 26, 28, 'COMPLETED', true, '11/19/2023 00:00:00', '11/19/2023 00:00:00', '11/19/2023 00:00:00', 'FOURKNOT', 'Fucked up top knot, fucked up side supports') --tony 100zz

;


