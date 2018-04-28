CREATE TABLE buslocationservice( id                 int(20) NOT NULL, queryTime timestamp, PRIMARY KEY(id));



CREATE TABLE busdb.`busLocation`
(
   `queryTime`    timestamp(0) not null,
   `endBus`           varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL,
   `lowPlate`         varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL,
   `plateNo`          varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL,
   `plateType`        varchar(1) CHARACTER SET utf8 COLLATE utf8_bin NULL,
   `remainSeatCnt`    int(20) NULL,
   `routeId`          varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL,
   `stationId`        varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL,
   `stationSeq`       varchar(20) CHARACTER SET utf8 COLLATE utf8_bin NULL,
   PRIMARY KEY(queryTime)
)
ENGINE InnoDB
COLLATE 'utf8_bin'
ROW_FORMAT DEFAULT