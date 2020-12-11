package com.example.Weatherbasedcontent.WWWeatherMultipleDays;

import java.util.ArrayList;
import java.util.List;


public class WeatherRoot{
    public String cod;
    public int message;
    public int cnt;
    public ArrayList<Object> list;


    public City city;
    public class Main{
        public double temp;
        public double feels_like;
        public double temp_min;
        public double temp_max;
        public int pressure;
        public int sea_level;
        public int grnd_level;
        public int humidity;
        public double temp_kf;
    }

    public class Weather{
        public int id;
        public String main;
        public String description;
        public String icon;
    }

    public class Clouds{
        public int all;
    }

    public class Wind{
        public double speed;
        public int deg;
    }

    public class Sys{
        public String pod;
    }

    public class Snow{
        public double _3h;
    }

    public class Rain{
        public double _3h;
    }

    public class List{
        public int dt;
        public Main main;
        public ArrayList<Object> weather;
        public Clouds clouds;
        public Wind wind;
        public int visibility;
        public double pop;
        public Sys sys;
        public String dt_txt;
        public Snow snow;
        public Rain rain;
    }

    public class Coord{
        public double lat;
        public double lon;
    }

    public class City{
        public int id;
        public String name;
        public Coord coord;
        public String country;
        public int population;
        public int timezone;
        public int sunrise;
        public int sunset;
    }
}

