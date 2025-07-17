CREATE TABLE "colmeia"."jogo_console" (
    jogo_id UUID NOT NULL,
    console_id UUID NOT NULL,
    PRIMARY KEY (jogo_id, console_id)
);

ALTER TABLE "colmeia"."jogo_console"
    ADD CONSTRAINT fk_jogoconsole_jogo
        FOREIGN KEY (jogo_id)
            REFERENCES "colmeia"."jogo" (id)
            ON DELETE CASCADE;

ALTER TABLE "colmeia"."jogo_console"
    ADD CONSTRAINT fk_jogoconsole_console
        FOREIGN KEY (console_id)
            REFERENCES "colmeia"."console" (id)
            ON DELETE CASCADE;