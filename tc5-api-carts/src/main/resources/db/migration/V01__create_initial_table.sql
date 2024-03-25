CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TABLE IF NOT EXISTS tb_order(
    id_order            uuid DEFAULT gen_random_uuid() PRIMARY KEY,
    moment              TIMESTAMP,
    status              SMALLINT
);

CREATE TABLE IF NOT EXISTS tb_order_status(
    status SMALLINT
);

CREATE TABLE IF NOT EXISTS tb_order_product(
    id_order            uuid,
    id_product          uuid
);

CREATE TABLE IF NOT EXISTS tb_product(
    id_product      uuid,
    name            VARCHAR,
    price           BIGINT,
    description     VARCHAR,
    imageUri        TEXT,
    amount          INT
);
