INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Sunny');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Rain');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Snow');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Windy');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('Sleet');
INSERT INTO WEATHERSYMBOL (DESCRIPTION) VALUES ('All');

INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Women');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Men');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Kids');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('H&M Home');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Sport');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('Accessories');
INSERT INTO DEPARTMENT (DESCRIPTION) VALUES ('All');

INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Hot');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Warm');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Cold');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Very cold');
INSERT INTO TEMPERATURE (DESCRIPTION) VALUES ('Average');


INSERT INTO SEASON (DESCRIPTION) VALUES ('Summer');
INSERT INTO SEASON (DESCRIPTION) VALUES ('Winter');
INSERT INTO SEASON (DESCRIPTION) VALUES ('Spring');
INSERT INTO SEASON (DESCRIPTION) VALUES ('Autumn');

INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Hot, Men',' ',1,1,1,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, Men',' ',1,1,2,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Spring, Sunny, average temperature, Men',' ',1,1,4,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, cold, Men',' ',2,3,3,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, very cold, Men',' ',2,3,3,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Hot, women',' ',1,1,1,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, women',' ',1,1,2,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Spring, Sunny, average temperature, women',' ',1,1,4,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, Rain, kids',' ',4,2,5,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, very cold, women',' ',2,3,3,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), women',' ',2,6,3,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), men',' ',2,6,3,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), kids',' ',2,6,3,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), H&M Home',' ',2,6,3,4);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), Sport',' ',2,6,3,5);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, all(cloud), accessories',' ',2,6,3,6);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, snow, men',' ',2,3,3,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Winter, snow, kids',' ',2,3,3,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, men',' ',1,1,2,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, kids',' ',1,1,2,3);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, H&M Home',' ',1,1,2,4);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, sport',' ',1,1,2,5);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Summer, Sunny and Warm, accessories',' ',1,1,2,6);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, Rain, women',' ',4,2,5,1);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, Rain, men',' ',4,2,5,2);
INSERT INTO SCENARIO (DESCRIPTION,BACKGROUND,SEASONID, WEATHERSYMBOLID,TEMPERATUREID,DEPARTMENTID) VALUES ('Autumn, Rain, accessories',' ',4,2,5,6);


INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SE',1,'2021-06-01','2021-08-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SE',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SE',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('SE',4,'2021-09-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('UK',1,'2021-06-01','2021-08-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('UK',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('UK',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('UK',4,'2021-09-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('ES',1,'2021-06-01','2021-09-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('ES',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('ES',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('ES',4,'2021-10-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('CA',1,'2021-06-01','2021-08-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('CA',2,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('CA',3,'2021-04-01','2021-05-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('CA',4,'2021-09-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('AU',1,'2020-12-01','2021-03-31');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('AU',2,'2021-06-01','2021-09-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('AU',3,'2021-10-01','2021-11-30');
INSERT INTO SEASONPERCOUNTRY (COUNTRYID,SEASONID,DATEFROM,DATETO) VALUES ('AU',4,'2021-04-01','2021-05-31');

INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=source[/21/f8/21f8033ed4cd662d8e4464abbab57bd353de12dc.jpg],origin[dam],category[men_swimweear],type[LOOKBOOK],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0769483005.html','Text to show');
INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=source[/d5/c2/d5c2edea1733d101e38b6891a9b5dda6843a3846.jpg],origin[dam],category[men_accessories_sunglasses],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0888077002.html','Text2 to show');
INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=source[/15/d1/15d1feb2c8a630be596f7b880ecd235cbe91007c.jpg],origin[dam],category[men_jacketscoats_jackets],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0905401003.html','Text3 to show');
INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F20%2Fc0%2F20c01d9317b8b6ad199c6a3468c0fa53236698b1.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_hoodiessweatshirts_hoodies%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0917818001.html','Text4 to show');
INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F44%2F11%2F4411906142799cd6d7a9a5f9fafe3325b9281624.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_accessories_hatsandgloves%5D%2Ctype%5BDESCRIPTIVESTILLLIFE%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0557048001.html','Text5 to show');
INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=quality%5B79%5D%2Csource%5B%2F17%2F1e%2F171ee680ed7f25efa9936d7e658b4f825dd7aac0.jpg%5D%2Corigin%5Bdam%5D%2Ccategory%5Bmen_jacketscoats_jackets%5D%2Ctype%5BLOOKBOOK%5D%2Cres%5Bm%5D%2Chmver%5B1%5D&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0819500006.html','Text6 to show');
INSERT INTO CONTENT (IMAGE,URL,TEXT) VALUES ('https://lp2.hm.com/hmgoepprod?set=source[/ed/9a/ed9a41fb39cd7f8be80629a18c89560b1e9e916d.jpg],origin[dam],category[ladies_swimwear_swimsuits],type[DESCRIPTIVESTILLLIFE],res[z],hmver[1]&call=url[file:/product/main]','https://www2.hm.com/sv_se/productpage.0636505001.html','Text7 to show');

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


INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (1,1);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (2,2);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (3,3);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (4,3);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (5,4);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (6,5);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (7,6);
-- Fall Rainy NULL Kids ¨¨¨v
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (8,9);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (9,9);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (10,9);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (11,9);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (12,9);
-- Winter NULL NULL NULL ¨¨¨v
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (13,11);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (14,11);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (15,11);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (16,11);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (17,11);
-- Summer Sunny Hot Women ¨¨¨v

INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (18,6);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (19,6);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (20,6);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (21,6);
INSERT INTO CONTENTBYSCENARIO (CONTENTID, SCENARIOID) VALUES (22,6);



INSERT INTO CITY (NAME, LATITUDE, LONGITUDE, COUNTRYID) VALUES ('Stockholm',59.325117, 18.071093, 'SE');
INSERT INTO CITY (NAME, LATITUDE, LONGITUDE, COUNTRYID) VALUES ('Göteborg',57.707232, 11.967017, 'SE');
INSERT INTO CITY (NAME, LATITUDE, LONGITUDE, COUNTRYID) VALUES ('Malmö',55.60617, 13.006, 'SE');
INSERT INTO CITY (NAME, LATITUDE, LONGITUDE, COUNTRYID) VALUES ('Umeå',63.830490, 20.265303, 'SE');
INSERT INTO CITY (NAME, LATITUDE, LONGITUDE, COUNTRYID) VALUES ('Köpenhamn',55.682,  2.524, 'SE');




