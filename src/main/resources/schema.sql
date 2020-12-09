CREATE TABLE CONTENT (
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  IMAGE VARCHAR(500),
  URL VARCHAR(500)
 );

CREATE TABLE SCENARIO (
   ID BIGINT AUTO_INCREMENT PRIMARY KEY,
   DESCRIPTION VARCHAR(500),
   SEASONID BIGINT,
   WEATHERSYMBOLID BIGINT,
   TEMPERATUREID BIGINT,
   DEPARTMENTID BIGINT
 );

 CREATE TABLE CONTENTBYSCENARIO (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    CONTENTID BIGINT,
    SCENARIOID BIGINT
 );

 CREATE TABLE WEATHERSYMBOL (
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

 CREATE TABLE TEMPERATURE (
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

  ALTER TABLE SCENARIO ADD FOREIGN KEY (WEATHERSYMBOLID) REFERENCES WEATHERSYMBOL(ID);
  ALTER TABLE SCENARIO ADD FOREIGN KEY (DEPARTMENTID) REFERENCES DEPARTMENT(ID);
  ALTER TABLE SCENARIO ADD FOREIGN KEY (SEASONID) REFERENCES SEASON(ID);
  ALTER TABLE SCENARIO ADD FOREIGN KEY (TEMPERATUREID) REFERENCES TEMPERATURE(ID);

  ALTER TABLE CONTENTBYSCENARIO ADD FOREIGN KEY (CONTENTID) REFERENCES CONTENT(ID);
  ALTER TABLE CONTENTBYSCENARIO ADD FOREIGN KEY (SCENARIOID) REFERENCES SCENARIO(ID);

  ALTER TABLE SEASONPERCOUNTRY ADD FOREIGN KEY (SEASONID) REFERENCES SEASON(ID);