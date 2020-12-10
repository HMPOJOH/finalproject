package com.example.Weatherbasedcontent.WWWeatherMultipleDays;

import java.util.List;

// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString), Root.class); */


public class WeatherRoot{
    public double lat;
    public double lon;
    public String timezone;
    public int timezone_offset;
    public Current current;
    public List<Hourly> hourly;
    public List<Daily> daily;

    public class Weather{
        public int id;
        public String main;
        public String description;
        public String icon;
    }

    public class Current{
        public int dt;
        public int sunrise;
        public int sunset;
        public double temp;
        public double feels_like;
        public int pressure;
        public int humidity;
        public int dew_point;
        public int uvi;
        public int clouds;
        public int visibility;
        public double wind_speed;
        public int wind_deg;
        public List<Weather> weather;
    }

    public class Weather2{
        public int id;
        public String main;
        public String description;
        public String icon;
    }

    public class Rain{
        public double _1h;
    }

    public class Hourly{
        public int dt;
        public double temp;
        public double feels_like;
        public int pressure;
        public int humidity;
        public double dew_point;
        public double uvi;
        public int clouds;
        public int visibility;
        public double wind_speed;
        public int wind_deg;
        public List<Weather2> weather;
        public double pop;
        public Rain rain;
    }

    public class Temp{
        public double day;
        public double min;
        public double max;
        public double night;
        public double eve;
        public double morn;
    }

    public class FeelsLike{
        public double day;
        public double night;
        public double eve;
        public double morn;
    }

    public class Weather3{
        public int id;
        public String main;
        public String description;
        public String icon;
    }

    public class Daily{
        public int dt;
        public int sunrise;
        public int sunset;
        public Temp temp;
        public FeelsLike feels_like;
        public int pressure;
        public int humidity;
        public double dew_point;
        public double wind_speed;
        public int wind_deg;
        public List<Weather3> weather;
        public int clouds;
        public double pop;
        public double rain;
        public double uvi;
    }
}


