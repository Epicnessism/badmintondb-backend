insert into public.users
(user_id, email, family_name, given_name, gender, date_of_birth, username, "password")
values
('92cba104-c922-4852-a683-b32ffd21b109', 'tony_test@gmail.com', 'Wang', 'Tony', 'MALE', '06/20/1997', 'test1234', 'some rando password'),
('11cba104-c922-4852-a683-b32ffd21b109', 'tony_test123@gmail.com', 'TestWang', 'TestTony', 'MALE', '06/20/1995', 'test2233', 'some rando password2')
;


insert into racket
(racket_id, make, model, owner_user_id)
values
('92cba111-c922-4852-a683-b32ffd21b109', 'Yonex', 'Astrox 100ZZ', '11cba104-c922-4852-a683-b32ffd21b109')
;



--insert into stringing
--	(price, requester_user_id, cross_length, cross_tension, main_length, main_tension, is_completed, completed_timestamp, last_updated_timestamp, requested_timestamp, stringer_user_id, stringing_id, "method", notes, string_name, racket_racket_id)
--values (15, '11cba104-c922-4852-a683-b32ffd21b109', 3.1,7,3.4,25,true, '11/19/2023 21:32:06', '11/19/2023 21:32:06', '11/17/2023 10:25:55', '92cba104-c922-4852-a683-b32ffd21b109', 'c74c371f-385b-4a4c-ba9b-314aab9c1111', 'TWOKNOT', 'no notes at this time Test 123444','BG80P', '92cba111-c922-4852-a683-b32ffd21b109'),
--(20.04, '11cba104-c922-4852-a683-b32ffd21b109', 3.1,7,3.4,25,false, '11/19/2023 21:32:06', '11/19/2023 21:32:06', '11/17/2023 10:25:55', '92cba104-c922-4852-a683-b32ffd21b109', 'cccc371f-385b-4a4c-ba9b-314aab9c1111', 'TWOKNOT', 'notes tbd','BG80P', '92cba111-c922-4852-a683-b32ffd21b109')
--;


