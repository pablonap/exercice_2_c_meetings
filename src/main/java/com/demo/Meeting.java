package com.demo;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Meeting {
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private int startingTimeInMinutes;
    private int endingTimeInMinutes;
    private String tenantName;

    public Meeting(LocalDateTime fromDateTime, LocalDateTime toDateTime, String tenantName) {
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.tenantName = tenantName;

        LocalTime startingTime = fromDateTime.toLocalTime();
        int startingMinutes = startingTime.getHour() * 60
                + startingTime.getMinute();

        LocalTime endingTime = toDateTime.toLocalTime();
        int endingMinutes = endingTime.getHour() * 60
                + endingTime.getMinute();

        this.startingTimeInMinutes = startingMinutes;
        this.endingTimeInMinutes = endingMinutes;
    }

    public LocalDateTime getFromDateTime() {
        return fromDateTime;
    }

    public void setFromDateTime(LocalDateTime fromDateTime) {
        this.fromDateTime = fromDateTime;
    }

    public LocalDateTime getToDateTime() {
        return toDateTime;
    }

    public void setToDateTime(LocalDateTime toDateTime) {
        this.toDateTime = toDateTime;
    }

    public int getStartingTimeInMinutes() {
        return startingTimeInMinutes;
    }

    public void setStartingTimeInMinutes(int startingTimeInMinutes) {
        this.startingTimeInMinutes = startingTimeInMinutes;
    }

    public int getEndingTimeInMinutes() {
        return endingTimeInMinutes;
    }

    public void setEndingTimeInMinutes(int endingTimeInMinutes) {
        this.endingTimeInMinutes = endingTimeInMinutes;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}
