package com.zhj.rebook.entity;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/8/14 0014.
 */
public class Income {
    private Calendar calendar;
    private String incomeName;
    private Double incomeMoney;

    public Income(Calendar calendar, String incomeName, Double incomeMoney) {
        this.calendar = calendar;
        this.incomeName = incomeName;
        this.incomeMoney = incomeMoney;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Double getIncomeMoney() {
        return incomeMoney;
    }

    public void setIncomeMoney(Double incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    public String getIncomeName() {
        return incomeName;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    @Override
    public String toString() {
        return "Income{" +
                "calendar=" + calendar +
                ", incomeName='" + incomeName + '\'' +
                ", incomeMoney=" + incomeMoney +
                '}';
    }
}
