CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE greeting_request (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    idioma VARCHAR(50) NOT NULL,
    fecha_creacion TIMESTAMP NOT NULL DEFAULT NOW(),
    fecha_actualizacion TIMESTAMP NOT NULL DEFAULT NOW()
);