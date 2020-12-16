INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Sunny');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Rain');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Snow');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Windy');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Sleet');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('All weather');

INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Women');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Men');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Kids');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('H&M Home');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Sport');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Accessories');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('All departments');

INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Hot');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Warm');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Cold');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Very cold');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Average temperature');


INSERT INTO SEASON (DESCRIPTION) VALUES ('Summer');
INSERT INTO SEASON (DESCRIPTION) VALUES ('Winter');
INSERT INTO SEASON (DESCRIPTION) VALUES ('Spring');
INSERT INTO SEASON (DESCRIPTION) VALUES ('Autumn');

INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Hot, Men','SummerDay.jpg',1,1,1,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, Men','SummerDay.jpg',1,1,2,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Spring, Sunny, average temperature, Men','SpringDay.jpg',1,1,4,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, cold, Men','RainyDay.jpg',4,3,3,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, very cold, Men','WinterDay.jpg',2,3,4,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Hot, women','SummerDay.jpg',1,1,1,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, women','SummerDay.jpg',1,1,2,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Spring, Sunny, average temperature, women','SpringDay.jpg',1,1,4,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, Rain, kids','RainyDay.jpg',4,2,3,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, very cold, women','Winterday.jpg',2,3,4,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), women','Winterday.jpg',2,6,3,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), men','Winterday.jpg',2,6,3,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), kids','Winterday.jpg',2,6,3,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), H&M Home','Winterday.jpg',2,6,3,4);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), Sport','Winterday.jpg',2,6,3,5);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), accessories','Winterday.jpg',2,6,3,6);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, snow, men','Winterday.jpg',2,3,3,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, snow, kids','Winterday.jpg',2,3,3,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, men','SummerDay.jpg',1,1,2,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, kids','SummerDay.jpg',1,1,2,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, H&M Home','SummerDay.jpg',1,1,2,4);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, sport','SummerDay.jpg',1,1,2,5);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, accessories','SummerDay.jpg',1,1,2,6);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, Rain, women','RainyDay.jpg',4,2,5,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, Rain, men','RainyDay.jpg',4,2,5,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, Rain, accessories','RainyDay.jpg',4,2,5,6);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, snow, women','WinterDay.jpg',2,3,3,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), very cold, women','WinterDay.jpg',2,6,4,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud),avg temp, women','WinterDay.jpg',2,6,5,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud),avg temp, men','WinterDay.jpg',2,6,5,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud),avg temp, kids','WinterDay.jpg',2,6,5,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, sunny,avg temp, women','WinterDay.jpg',2,1,5,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, sunny,avg temp, men','WinterDay.jpg',2,1,5,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, sunny,avg temp, kids','WinterDay.jpg',2,1,5,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, rain,avg temp, women','WinterDay.jpg',2,2,5,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, rain,avg temp, men','WinterDay.jpg',2,2,5,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, rain,avg temp, kids','WinterDay.jpg',2,2,5,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(clouds),very cold, women','WinterDay.jpg',2,6,4,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(clouds),very cold, men','WinterDay.jpg',2,6,4,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(clouds),very cold, kids','WinterDay.jpg',2,6,4,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Hot but clouds, women','SummerDay.jpg',1,6,1,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Hot but clouds, men','SummerDay.jpg',1,6,1,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Hot but clouds, kids','SummerDay.jpg',1,6,1,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, Sunny, cold, women',' ',2,1,3,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, Sunny, cold, men',' ',2,1,3,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, Sunny, cold, kids',' ',2,1,3,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, All(clouds), warm, women','SummerDay.jpg',1,6,2,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, All(clouds), warm, men','SummerDay.jpg',1,6,2,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, All(clouds), warm, kids','SummerDay.jpg',1,6,2,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Rain, warm, women','RainyDay.jpg',1,2,2,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Rain, warm, men','RainyDay.jpg',1,2,2,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Rain, warm, kids','RainyDay.jpg',1,2,2,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, All(clouds), warm, men','SummerDay.jpg',1,6,2,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, All(clouds), warm, men','WinterDay.jpg',2,6,2,2);


INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SE',1,'2021-06-01','2021-08-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SE',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SE',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SE',4,'2021-09-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('DK',1,'2021-06-01','2021-08-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('DK',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('DK',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('DK',4,'2021-09-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('UK',1,'2021-06-01','2021-08-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('UK',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('UK',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('UK',4,'2021-09-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('ES',1,'2021-06-01','2021-09-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('ES',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('ES',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('ES',4,'2021-10-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('IT',1,'2021-06-01','2021-09-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('IT',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('IT',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('IT',4,'2021-10-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('CA',1,'2021-06-01','2021-08-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('CA',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('CA',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('CA',4,'2021-09-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('US',1,'2020-12-01','2021-12-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('US',2,'2021-01-01','2021-02-28');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('US',3,'2021-03-01','2021-04-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('US',4,'2020-09-01','2020-12-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('AU',1,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('AU',2,'2021-06-01','2021-09-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('AU',3,'2021-10-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('AU',4,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('TH',1,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('TH',2,'2021-06-01','2021-09-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('TH',3,'2021-10-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('TH',4,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('IN',1,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('IN',2,'2021-06-01','2021-09-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('IN',3,'2021-10-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('IN',4,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SG',1,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SG',2,'2021-06-01','2021-09-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SG',3,'2021-10-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SG',4,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('GB',1,'2021-06-01','2021-08-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('GB',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('GB',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('GB',4,'2021-09-01','2021-11-30');

--INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=source[/21/f8/21f8033ed4cd662d8e4464abbab57bd353de12dc.jpg],origin[dam],category[men_swimweear],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0769483005.html','Text to show');
--INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=source[/d5/c2/d5c2edea1733d101e38b6891a9b5dda6843a3846.jpg],origin[dam],category[men_accessories_sunglasses],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0888077002.html','Text2 to show');
--INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=source[/15/d1/15d1feb2c8a630be596f7b880ecd235cbe91007c.jpg],origin[dam],category[men_jacketscoats_jackets],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0905401003.html','Text3 to show');
--INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F20%2Fc0%2F20c01d9317b8b6ad199c6a3468c0fa53236698b1.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_hoodiessweatshirts_hoodies%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0917818001.html','Text4 to show');
--INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F44%2F11%2F4411906142799cd6d7a9a5f9fafe3325b9281624.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_accessories_hatsandgloves%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0557048001.html','Text5 to show');
--INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F17%2F1e%2F171ee680ed7f25efa9936d7e658b4f825dd7aac0.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_jacketscoats_jackets%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0819500006.html','Text6 to show');
--INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=source[/ed/9a/ed9a41fb39cd7f8be80629a18c89560b1e9e916d.jpg],origin[dam],category[ladies_swimwear_swimsuits],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0636505001.html','Text7 to show');

-- Fall Rainy NULL Kids ¨¨¨v
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('RubberBoots', 'https://lp2.hm.com/hmgoepprod?set=source[/43/68/43683d8712388e9f4ba946f982f8a02ce86c29be.jpg],origin[dam],category[kids_boy8y_shoes_boots],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]', 'https://www2.hm.com/sv_se/productpage.0902058001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('RainJacket', 'https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F2a%2Fd2%2F2ad2700201c5abd55b86fb68aebf59389aa674f8.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bkids_babygirl_outdoor%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/fullscreen]', 'https://www2.hm.com/sv_se/productpage.0867828002.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Overalls', 'https://lp2.hm.com/hmgoepprod?set=source[/fe/19/fe19a06ea9af5acc3dd730e3e1073de5d665903b.jpg],origin[dam],category[kids_girl8y_function],type[DESCRIPTIVESTILLLIFE],res[z],hmver[2]&call=url[file:/product/fullscreen]', 'https://www2.hm.com/sv_se/productpage.0867829002.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Umbrella', 'https://lp2.hm.com/hmprod?hmver=1&set=quality%5B79%5D%2Csource%5B%2Fmodel%2F2016%2FD00+0401222+002+90+6724.jpg%5D%2Ctype%5BSTILLLIFE_FRONT%5D&call=url[file:/product/main]', 'https://www2.hm.com/sv_se/productpage.0401222002.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Socks', 'https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fd2%2Fde%2Fd2de877e5e131ac9eebaed6fecaeff7c9cc0c079.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_socks%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]', 'https://www2.hm.com/en_gb/productpage.0783707096.html');
-- Winter NULL NULL NULL ¨¨¨v
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Hat', 'https://lp2.hm.com/hmgoepprod?set=source[/30/94/3094d77510b0000b1f4ceb65cb02fa1f59b524c9.jpg],origin[dam],category[ladies_accessories_hats_beanies],type[DESCRIPTIVESTILLLIFE],res[z],hmver[2]&call=url[file:/product/main]', 'https://www2.hm.com/en_us/productpage.0904450001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Scarf', 'https://lp2.hm.com/hmgoepprod?set=source[/b3/58/b3585ca0bfe2311c085cd9b3c50026d0ccf57ef3.jpg],origin[dam],category[ladies_accessories_hatsscarvesgloves_scarves],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]', 'https://www2.hm.com/en_us/productpage.0757903024.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Gloves', 'https://lp2.hm.com/hmgoepprod?set=source[/2c/70/2c70ebf0fab79605f023b619fb25920b8f80b974.jpg],origin[dam],category[men_accessories_hatsandgloves],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]', 'https://www2.hm.com/en_us/productpage.0727697001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('3 piece', 'https://lp2.hm.com/hmgoepprod?set=source[/39/43/3943a8d515cd07e48b83353ae0de5ccae843a3c5.jpg],origin[dam],category[men_accessories_hatsandgloves],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]', 'https://www2.hm.com/en_us/productpage.0557048002.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('ThickSocks', 'https://lp2.hm.com/hmprod?hmver=1&set=quality%5B79%5D%2Csource%5B%2Fmodel%2F2016%2FD00+0418122+001+90+7417.jpg%5D%2Ctype%5BSTILLLIFE_FRONT%5D&call=url[file:/product/main]', 'https://www2.hm.com/en_gb/productpage.0418122001.html');
-- Summer Sunny Hot Women ¨¨¨v
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Shades', 'https://lp2.hm.com/hmgoepprod?set=source[/41/84/4184382a9468946a21c93eb6e629474eaaed6bea.jpg],origin[dam],category[ladies_accessories_sunglasses],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]', 'https://www2.hm.com/en_gb/productpage.0879995001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Beach bag', 'https://lp2.hm.com/hmgoepprod?set=source[/7a/29/7a292ed3043026e88c3703e9d274aa7855700d1d.jpg],origin[dam],category[],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]', 'https://www2.hm.com/sv_se/productpage.0883685002.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('SwimSuit', 'https://lp2.hm.com/hmgoepprod?set=source[/3f/ef/3fefb4de4c4ae65e4af1e35e901878652dc52f28.jpg],origin[dam],category[ladies_maternity_swimwear],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]', 'https://www2.hm.com/en_gb/productpage.0690513001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('SunHat', 'https://lp2.hm.com/hmgoepprod?set=source[/43/7b/437bc8e1294172c48f970f8f443cccc42ff8baa3.jpg],origin[dam],category[ladies_accessories_hatsscarvesgloves_hats],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]', 'https://www2.hm.com/en_gb/productpage.0616763007.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Sandals', 'https://lp2.hm.com/hmgoepprod?set=source[/90/f6/90f689ec40799d02723b88bb0a10f69ff358aff8.jpg],origin[dam],category[Ladies_shoes_flipflops],type[DESCRIPTIVESTILLLIFE],res[z],hmver[2]&call=url[file:/product/main]', 'https://www2.hm.com/sv_se/productpage.0892254002.html');
--Springe none average men
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('ShirtJacket','https://lp2.hm.com/hmgoepprod?set=source[/d6/22/d62294472c066930a5b067e9623f1454e9252d5b.jpg],origin[dam],category[],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0934392002.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('LightJacket','https://lp2.hm.com/hmgoepprod?set=source[/90/23/9023ca60b64aff10e4ab857fc7ca4021bae42016.jpg],origin[dam],category[men_jacketscoats_jackets],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0899020001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('DenimJacket','https://lp2.hm.com/hmgoepprod?set=source[/25/35/25357c0ee63be50aa3f0c66db8e7d7aea02c43ce.jpg],origin[dam],category[],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0917357001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('WhiteSneakers','https://lp2.hm.com/hmgoepprod?set=source[/da/13/da132ab119cd61e62d281cd77452d424342e3e0c.jpg],origin[dam],category[men_shoes_sneakers],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0728830001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('LowSneakers','https://lp2.hm.com/hmgoepprod?set=source[/42/55/425504fe7308a182a224f21ffbfea4e1fdb750af.jpg],origin[dam],category[men_shoes_sneakers],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0843982001.html');
--Winter snowing cold men
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('WhiteWinterJacket','https://lp2.hm.com/hmgoepprod?set=source[/d7/b1/d7b181d83aac2c1b2cd92591d46f6585d58db009.jpg],origin[dam],category[men_jacketscoats_puffer],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0925969006.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('CamoWinterJacket','https://lp2.hm.com/hmgoepprod?set=source[/c5/12/c51298fbbac7d8b2250ebfe181a2fa6ea5851462.jpg],origin[dam],category[men_jacketscoats_parkas],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0931508001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('BrownBoots','https://lp2.hm.com/hmgoepprod?set=source[/9d/9b/9d9b57b391c0abe5e19c0114f9a3278c8821b573.jpg],origin[dam],category[],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0690545009.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('BlackBoots','https://lp2.hm.com/hmgoepprod?set=source[/b8/5a/b85aea61d880191ca0947c5eb23a9e35338a49f4.jpg],origin[dam],category[men_shoes_boots],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0906348001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('YellowHat','https://lp2.hm.com/hmgoepprod?set=source[/14/c0/14c0e998ef50b3c9e636a75977521530e3ca10a2.jpg],origin[dam],category[men_accessories_hatscaps_beanie],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0742742021.html');
--19 Summer, sunny, max temp, men
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('BlackPatternSwimShorts','https://lp2.hm.com/hmgoepprod?set=source[/84/4e/844ebb4916d4fe4c973fa7f545f27f4f2883afae.jpg],origin[dam],category[men_swimweear],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0685601007.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('PinkSwimShorts','https://lp2.hm.com/hmgoepprod?set=source[/58/10/5810de75aabb56b88bb93badd70fe86cc11dc38c.jpg],origin[dam],category[men_swimweear],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0719629023.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('BrownShades','https://lp2.hm.com/hmgoepprod?set=source[/dd/08/dd08fb7a01174400966c5e501b125c0b264a2fb1.jpg],origin[dam],category[men_accessories_sunglasses],type[DESCRIPTIVESTILLLIFE],res[z],hmver[2]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0741387001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Slippers','https://lp2.hm.com/hmgoepprod?set=source[/12/43/1243f99fc4fcd5f5fc5d48beeeb63d0fedd9e2e5.jpg],origin[dam],category[],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0875328002.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Hat','https://lp2.hm.com/hmgoepprod?set=source[/b7/1f/b71fcb9e43e54d4cdbfbfa73ca9026faf7a13c7d.jpg],origin[dam],category[men_accessories_hatscaps],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0762331004.html');
--Rainy unisex
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Umbrella','https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F8b%2Fa8%2F8ba8f6de89a445605a15a50a89ac1e291d726d64.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_accessories_other%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/en_gb/productpage.0367376002.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('PatternUmbrella','https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fe4%2Fe8%2Fe4e83176f45cc2f492c49aa06115a1be745fe294.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_accessories_other%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/en_ie/productpage.0289597010.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('GreenRainCoat','https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2Fe2%2F46%2Fe246d67166669a6dbe3df3c9a2218d3b3799cf3d.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_jacketscoats_coats%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/en_us/productpage.0851866001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('BlueRainCoat','https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F39%2Fff%2F39ff60887346d25b468a9e094089dc9e5bcce2a0.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_jacketscoats_coats%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','http://www2.hm.com/en_us/productpage.0656004001.html');
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('UmbrellaLetters','https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F8a%2F8a%2F8a8a643cfc2f280d398a20c9195e0be21711ae1c.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bladies_accessories_other%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Chmver%5B2%5D&call=url[file:/product/main]','https://www2.hm.com/en_asia5/productpage.0289597008.html');

--Summer Sunny Hot Men
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Swim shorts', 'https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F47%2Fcd%2F47cd9fa9e03e5888ed02f8d0b6687809525d44bc.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_swimweear%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B2%5D&call=url[file:/product/main]', 'https://www2.hm.com/en_asia2/productpage.0685604093.html');

--Winter Very Cold Men
INSERT INTO CONTENT (TEXT,IMAGE,URL) VALUES ('Winter Jacket', 'https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F8c%2Fc5%2F8cc520662a7b88dc90b796072e8ce3ee91505843.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_jacketscoats_jackets%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]', 'https://www2.hm.com/sv_se/productpage.0762174001.html');

--INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (1,1);
--INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (2,2);
--INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (3,3);
--INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (4,3);
--INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (5,4);
--INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (6,5);
--INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (7,6);

-- Fall Rainy NULL Kids ¨¨¨v
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (1,9);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (2,9);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (3,9);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (4,9);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (5,9);
-- Winter NULL NULL NULL ¨¨¨v
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (6,11);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (7,11);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (8,11);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (9,11);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (10,11);
-- Summer Sunny Hot Women ¨¨¨v
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (11,6);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (12,6);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (13,6);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (14,6);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (15,6);
-- Summer Sunny Hot Men ¨¨¨v
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (16,1);

--Winter Very Cold Men
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (17,5);

INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (18,3);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (19,3);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (20,3);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (21,3);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (22,3);

INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (23,5);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (24,5);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (25,5);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (26,5);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (27,5);

INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (28,19);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (29,19);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (30,19);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (31,19);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (32,19);

INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (33,24);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (34,24);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (35,24);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (36,24);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (37,24);

INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (33,25);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (34,25);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (35,25);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (36,25);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (37,25);




INSERT INTO CITY (NAME) VALUES ('Stockholm');
INSERT INTO CITY (NAME) VALUES ('Göteborg');
INSERT INTO CITY (NAME) VALUES ('Malmö');
INSERT INTO CITY (NAME) VALUES ('Umeå');
INSERT INTO CITY (NAME) VALUES ('Köpenhamn');
INSERT INTO CITY (NAME) VALUES ('Sydney');
INSERT INTO CITY (NAME) VALUES ('Ottawa');
INSERT INTO CITY (NAME) VALUES ('London');

INSERT INTO CITY (NAME) VALUES ('Rom');
INSERT INTO CITY (NAME) VALUES ('New York');
INSERT INTO CITY (NAME) VALUES ('Bangkok');
INSERT INTO CITY (NAME) VALUES ('Atlanta');
INSERT INTO CITY (NAME) VALUES ('Singapore');
INSERT INTO CITY (NAME) VALUES ('Pune');
INSERT INTO CITY (NAME) VALUES ('Miami');

