drop table if exists MESTO;

drop table if exists OGLAS;

drop table if exists RASA;

drop table if exists ZIVOTINJA;

/*==============================================================*/
/* Table: MESTO                                                 */
/*==============================================================*/
create table MESTO
(
   ID                   int not null auto_increment,
   NAZIV_MESTA          varchar(50),
   primary key (ID)
);

/*==============================================================*/
/* Table: OGLAS                                                 */
/*==============================================================*/
create table OGLAS
(
   ID                   int not null auto_increment,
   RASA_ID              int,
   ZIVOTINJA_ID         int not null,
   MESTO_ID             int not null,
   NASLOV               varchar(50) not null,
   OPIS                 varchar(250) not null,
   CENA                 decimal(19,5),
   primary key (ID)
);

/*==============================================================*/
/* Table: RASA                                                  */
/*==============================================================*/
create table RASA
(
   ID                   int not null auto_increment,
   ZIVOTINJA_ID         int not null,
   IME                  varchar(50),
   primary key (ID)
);

/*==============================================================*/
/* Table: ZIVOTINJA                                             */
/*==============================================================*/
create table ZIVOTINJA
(
   ID                   int not null auto_increment,
   IME                  varchar(50),
   primary key (ID)
);

alter table OGLAS add constraint FK_OGLAS_MORA_BITI_ZA_ZIVOTINJU foreign key (ZIVOTINJA_ID)
      references ZIVOTINJA (ID) on delete restrict on update restrict;

alter table OGLAS add constraint FK_OGLAS_MOZE_IMATI_RASU_ALI_NE_MORA_AKO_ZIVOTINJA_NEMA_RASE foreign key (RASA_ID)
      references RASA (ID) on delete restrict on update restrict;

alter table OGLAS add constraint FK_SVAKI_OGLAS_MORA_IMATI_MESTO_U_KOME_SE_NALAZI foreign key (MESTO_ID)
      references MESTO (ID) on delete restrict on update restrict;

alter table RASA add constraint FK_SVAKA_RASA_IMA_ZIVOTINJU foreign key (ZIVOTINJA_ID)
      references ZIVOTINJA (ID) on delete restrict on update restrict;
