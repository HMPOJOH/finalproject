package com.example.Weatherbasedcontent.SMHI;

import java.util.Date;

public class TimeSeries {
    private Date validTime;
    private Parameters[] parameters;

    public Date getValidTime() {
        return validTime;
    }

    public Parameters[] getParameters() {
        return parameters;
    }


}