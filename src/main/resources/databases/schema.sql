CREATE TABLE "PEDIDOS"(
      "ID" INTEGER PRIMARY KEY NOT NULL,
      "EMAIL" VARCHAR(255) NOT NULL,
      "FULLNAME" VARCHAR(255) NOT NULL,
      "TEL" VARCHAR(255) NOT NULL,
      "PERSONAS" INTEGER NOT NULL,
      "ARROZ" INTEGER NOT NULL,
      "FECHA" DATE NOT NULL,
      "MOMENTO" VARCHAR(255) NOT NULL,
      "CIUDAD" VARCHAR(255) NOT NULL,
      "DIR1" VARCHAR(255) NOT NULL,
      "PRECIO" NUMBER DEFAULT NULL,
      "ESTADO" VARCHAR(255) NOT NULL
);

CREATE TABLE "USER"(
    "USERNAME" VARCHAR(63) PRIMARY KEY NOT NULL,
    "PASSWORD" VARCHAR(255) NOT NULL
);

CREATE TABLE "ROLE"(
    "ROLE_ID" INTEGER IDENTITY PRIMARY KEY NOT NULL,
    "NAME" VARCHAR(63) NOT NULL,
    "DESCRIPTION" VARCHAR (255) NOT NULL
)

CREATE TABLE "USER_ROLE"(
    "USERNAME" VARCHAR(63) FOREIGN KEY,
    "ROLE_ID" INTEGER FOREIGN KEY,
    PRIMARY KEY("USERNAME",ROLE_ID),
    CONSTRAINT "USER_SUB_ID_FK"
        FOREIGN KEY ("USERNAME")
        REFERENCES "USER" ("USERNAME"),
    CONSTRAINT "ROLE_SUB_ID_FK"
        FOREIGN KEY ("ROLE_ID")
        REFERENCES "ROLE" ("ROLE_ID")
)