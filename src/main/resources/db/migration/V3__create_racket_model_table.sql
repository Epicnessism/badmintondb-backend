CREATE TABLE public.racket_model (
   racket_model_id uuid NOT NULL,
   make varchar(255) NULL,
   model varchar(255) NULL,
   CONSTRAINT racket_model_pkey PRIMARY KEY (racket_model_id)
);


insert into racket_model
(racket_model_id, make, model)
values
    ('2783e281-873a-4e72-8973-fe60663a822e', 'Yonex', 'Astrox 100ZZ'),
    ('944ddd9e-2582-4b33-9cdb-a5b80de052d2', 'Yonex', 'Astrox 100ZZ Kuranai'),
    ('b0338945-1b40-449c-874d-739bb118001a', 'Yonex', 'Astrox 77'),
    ('cfb6a5aa-5b96-4212-a789-2c580e25fa53', 'Yonex', 'Astrox 88'),

    ('93f68eff-8615-4f57-93b0-36957698d856', 'Yonex', 'Z-Force II'),

    ('89ae2874-9f1c-4594-bfbf-32aaf4a80ec4', 'Victor', 'Thruster TTY A Tai Tzu Ying Edition (White) TK-TTY A'),

    ('e1fd1e12-8fcf-47da-8b5e-e784ebd7ae8b', 'Yonex', 'Nanoflare 700'),
    ('ac2fe681-ada2-4f24-ad75-b54aa23d1ec3', 'Yonex', 'Nanoflare 800')
;