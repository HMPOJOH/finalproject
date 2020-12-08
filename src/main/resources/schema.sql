CREATE TABLE PRODUCT (
  ID BIGINT PRIMARY KEY,
  WEATHERCATID BIGINT NOT NULL,
  DEPARTMENTID BIGINT NOT NULL,
  SEASONID BIGINT NOT NULL,
  IMAGE VARCHAR(500),
  IMAGESIZE BIGINT NOT NULL,
  URL VARCHAR(500)
 );

 CREATE TABLE WEATHERCAT (
   ID BIGINT AUTO_INCREMENT PRIMARY KEY,
   DESCRIPTION VARCHAR(500)
 );

 CREATE TABLE DEPARTMENT (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    DESCRIPTION VARCHAR(500)
 );

 CREATE TABLE SEASON (
      ID BIGINT AUTO_INCREMENT PRIMARY KEY,
      DESCRIPTION VARCHAR(500)
 );

 CREATE TABLE SEASONPERCOUNTRY (
       ID BIGINT AUTO_INCREMENT PRIMARY KEY,
       COUNTRYID VARCHAR(2),
       SEASONID BIGINT,
       DATEFROM DATE,
       DATETO DATE
  );

 CREATE TABLE CITY (
      ID BIGINT AUTO_INCREMENT PRIMARY KEY,
      NAME VARCHAR(100),
      LONG VARCHAR(100),
      LAT VARCHAR(100),
      COUNTRYID VARCHAR(2)
 );

  ALTER TABLE PRODUCT ADD FOREIGN KEY (WEATHERCATID) REFERENCES WEATHERCAT(ID);
  ALTER TABLE PRODUCT ADD FOREIGN KEY (DEPARTMENTID) REFERENCES DEPARTMENT(ID);
  ALTER TABLE PRODUCT ADD FOREIGN KEY (SEASONID) REFERENCES SEASON(ID);
  ALTER TABLE SEASONPERCOUNTRY ADD FOREIGN KEY (SEASONID) REFERENCES SEASON(ID);