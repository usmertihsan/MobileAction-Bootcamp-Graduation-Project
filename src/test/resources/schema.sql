CREATE TABLE IF NOT EXISTS public.cty_city
(
    id bigint NOT NULL,
    create_date timestamp without time zone,
    update_date timestamp without time zone,
    city_lat double precision,
    city_lon double precision,
    city_name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cty_city_pkey PRIMARY KEY (id)
)