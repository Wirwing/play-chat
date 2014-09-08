# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "user" ("id" BIGSERIAL PRIMARY KEY,"username" VARCHAR(254) NOT NULL,"password" VARCHAR(254) NOT NULL,"loginDateTime" TIMESTAMP);

# --- !Downs

drop table "user";

