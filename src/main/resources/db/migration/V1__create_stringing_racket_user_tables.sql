CREATE TABLE public.users (
	date_of_birth timestamp(6) NOT NULL,
	user_id uuid NOT NULL,
	email varchar(255) NULL,
	family_name varchar(255) NULL,
	gender varchar(255) NULL,
	given_name varchar(255) NULL,
	"password" varchar(255) NOT NULL,
	username varchar(255) NOT NULL,
	is_stringer bool,
	CONSTRAINT users_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying, 'OTHER'::character varying])::text[]))),
	CONSTRAINT users_pkey PRIMARY KEY (user_id),
	CONSTRAINT users_username_key UNIQUE (username)
);

CREATE TABLE public.string_entity (
	id uuid NOT NULL,
	color varchar(255) NOT NULL,
	make varchar(255) NULL,
	model varchar(255) NOT NULL,
	CONSTRAINT string_entity_color_check CHECK (((color)::text = ANY (ARRAY[('WHITE'::character varying)::text, ('BLACK'::character varying)::text, ('ORANGE'::character varying)::text, ('BLUE'::character varying)::text, ('DARK_BLUE'::character varying)::text]))),
	CONSTRAINT string_entity_pkey PRIMARY KEY (id)
);

CREATE TABLE public.racket (
	owner_user_id uuid NULL,
	racket_id uuid NOT NULL,
	rackets_user_id uuid NULL,
	make varchar(255) NULL,
	model varchar(255) NULL,
	CONSTRAINT racket_pkey PRIMARY KEY (racket_id),
	CONSTRAINT fkp38ju6lsjdlrh4d16e6cl3m4u FOREIGN KEY (owner_user_id) REFERENCES public.users(user_id),
	CONSTRAINT fkqabsst0nya5kp31yw66g1yhtl FOREIGN KEY (rackets_user_id) REFERENCES public.users(user_id)
);

CREATE TABLE public.stringing (
	cross_length int4 NULL,
	cross_tension int4 NOT NULL,
	is_completed bool NULL,
	main_length int4 NULL,
	main_tension int4 NOT NULL,
	price float8 NULL,
	completed_timestamp timestamp(6) NULL,
	last_updated_timestamp timestamp(6) NULL,
	requested_timestamp timestamp(6) NOT NULL,
	racket_racket_id uuid NOT NULL,
	requester_user_id uuid NULL,
-- 	string_mains_id uuid NOT NULL,
-- 	string_crosses_id uuid NOT NULL,
	stringer_user_id uuid NOT NULL,
	stringing_id uuid NOT NULL,
	"method" varchar(255) NULL,
	notes varchar(255) NULL,
	status varchar(255) NULL,
	CONSTRAINT stringing_method_check CHECK (((method)::text = ANY ((ARRAY['TWOKNOT'::character varying, 'FOURKNOT'::character varying, 'OTHER'::character varying])::text[]))),
	CONSTRAINT stringing_pkey PRIMARY KEY (stringing_id),
	CONSTRAINT stringing_status_check CHECK (((status)::text = ANY ((ARRAY['CREATED'::character varying, 'PENDING'::character varying, 'REJECTED'::character varying, 'DELIVERED'::character varying, 'IN_PROGRESS'::character varying, 'CANCELED'::character varying, 'FAILED'::character varying, 'COMPLETED'::character varying])::text[]))),
	CONSTRAINT fk2vfsimuargu0kpg6an1eh9ilg FOREIGN KEY (stringer_user_id) REFERENCES public.users(user_id),
	CONSTRAINT fk535qodmlu1ghkvftq3d22x64v FOREIGN KEY (requester_user_id) REFERENCES public.users(user_id),
-- 	CONSTRAINT fk6lyb4f9k0it6figmdrgm8mwta FOREIGN KEY (string_mains_id) REFERENCES public.string_entity(id),
-- 	CONSTRAINT fkcskf3biqubs93o41yj2tjrt90 FOREIGN KEY (string_crosses_id) REFERENCES public.string_entity(id),
	CONSTRAINT fkrf3b5hcpp6f1uft87bjj05ju5 FOREIGN KEY (racket_racket_id) REFERENCES public.racket(racket_id)
);
