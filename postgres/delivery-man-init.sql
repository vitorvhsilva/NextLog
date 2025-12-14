CREATE TABLE delivery_man (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    nome   VARCHAR(100) NOT NULL,
    email  VARCHAR(150) NOT NULL UNIQUE,
    estado VARCHAR(2)   NOT NULL
);

CREATE TABLE working_schedule (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    delivery_man_id UUID NOT NULL,
    dia VARCHAR(10) NOT NULL,
    horario_entrada TIME NOT NULL,
    horario_saida   TIME NOT NULL,

    CONSTRAINT fk_delivery_man
        FOREIGN KEY (delivery_man_id)
        REFERENCES delivery_man(id)
        ON DELETE CASCADE
);
