DROP TABLE IF EXISTS tb_record;
DROP TABLE IF EXISTS tb_document;
create table tb_record
(
   id integer not null,
   type varchar(50) not null,
   username varchar(150) not null,
   primary key(id)
);
create table tb_document
(
   id integer not null,
   name varchar(150) not null,
   location varchar(255) not null,
   record_id integer not null,
   primary key(id),
   constraint FK_DOC_REC_ID foreign key(record_id) references tb_record(id)
);