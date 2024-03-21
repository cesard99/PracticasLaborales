/*
 Navicat Premium Data Transfer

 Source Server         : postgreSQL
 Source Server Type    : PostgreSQL
 Source Server Version : 90515 (90515)
 Source Host           : localhost:5432
 Source Catalog        : PL
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 90515 (90515)
 File Encoding         : 65001

 Date: 14/03/2024 14:48:14
*/


-- ----------------------------
-- Sequence structure for firma_digital_id_firma_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."firma_digital_id_firma_seq";
CREATE SEQUENCE "public"."firma_digital_id_firma_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Sequence structure for usser_id_usuario_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."usser_id_usuario_seq";
CREATE SEQUENCE "public"."usser_id_usuario_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for firma_digital
-- ----------------------------
DROP TABLE IF EXISTS "public"."firma_digital";
CREATE TABLE "public"."firma_digital" (
  "id_firma" int4 NOT NULL DEFAULT nextval('firma_digital_id_firma_seq'::regclass),
  "texto" varchar(700) COLLATE "pg_catalog"."default" NOT NULL,
  "firma" varchar(700) COLLATE "pg_catalog"."default" NOT NULL,
  "id_usuario" int4 NOT NULL,
  "llave_privada" varchar(2000) COLLATE "pg_catalog"."default" NOT NULL,
  "llave_publica" varchar(2000) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of firma_digital
-- ----------------------------

-- ----------------------------
-- Table structure for usser
-- ----------------------------
DROP TABLE IF EXISTS "public"."usser";
CREATE TABLE "public"."usser" (
  "nombre" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "contra" varchar(100) COLLATE "pg_catalog"."default" NOT NULL,
  "id_usuario" int4 NOT NULL DEFAULT nextval('usser_id_usuario_seq'::regclass)
)
;

-- ----------------------------
-- Records of usser
-- ----------------------------
INSERT INTO "public"."usser" VALUES ('Cesar', 'q04H8KCed6lFErJqXcnZVA==', 1);

-- ----------------------------
-- Function structure for select_all_text
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."select_all_text"();
CREATE OR REPLACE FUNCTION "public"."select_all_text"()
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE 
	listtext refcursor;
BEGIN 
	OPEN listtext FOR 
			Select * from digital_sign;
		RETURN listtext;
		END;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for select_all_usser
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."select_all_usser"();
CREATE OR REPLACE FUNCTION "public"."select_all_usser"()
  RETURNS "pg_catalog"."refcursor" AS $BODY$DECLARE 
	listusers refcursor;
BEGIN 
	OPEN listusers FOR 
			Select * from usser;
		RETURN listusers;
		END;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for text_insert
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."text_insert"("text_0" varchar, "firma_1" varchar, "id_usuario_2" int4, "llave_3" varchar, "llave_4" varchar);
CREATE OR REPLACE FUNCTION "public"."text_insert"("text_0" varchar, "firma_1" varchar, "id_usuario_2" int4, "llave_3" varchar, "llave_4" varchar)
  RETURNS "pg_catalog"."void" AS $BODY$BEGIN
insert into firma_digital (texto,firma,id_usuario,llave_privada,llave_publica)values("text_0","firma_1",id_usuario_2,"llave_3","llave_4");
END;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Function structure for usser_insert
-- ----------------------------
DROP FUNCTION IF EXISTS "public"."usser_insert"("usuario_0" varchar, "contrasena_1" varchar);
CREATE OR REPLACE FUNCTION "public"."usser_insert"("usuario_0" varchar, "contrasena_1" varchar)
  RETURNS "pg_catalog"."void" AS $BODY$BEGIN
insert into usser(nombre, contra )values("usuario_0","contrasena_1");
END;$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."firma_digital_id_firma_seq"
OWNED BY "public"."firma_digital"."id_firma";
SELECT setval('"public"."firma_digital_id_firma_seq"', 5, true);

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
ALTER SEQUENCE "public"."usser_id_usuario_seq"
OWNED BY "public"."usser"."id_usuario";
SELECT setval('"public"."usser_id_usuario_seq"', 5, true);

-- ----------------------------
-- Primary Key structure for table firma_digital
-- ----------------------------
ALTER TABLE "public"."firma_digital" ADD CONSTRAINT "firma_digital_pkey" PRIMARY KEY ("id_firma");

-- ----------------------------
-- Primary Key structure for table usser
-- ----------------------------
ALTER TABLE "public"."usser" ADD CONSTRAINT "usser_pkey" PRIMARY KEY ("id_usuario");

-- ----------------------------
-- Foreign Keys structure for table firma_digital
-- ----------------------------
ALTER TABLE "public"."firma_digital" ADD CONSTRAINT "fk_usuario" FOREIGN KEY ("id_usuario") REFERENCES "public"."usser" ("id_usuario") ON DELETE NO ACTION ON UPDATE NO ACTION;
