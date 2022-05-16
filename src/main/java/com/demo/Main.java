package com.demo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class Meeting {
    private LocalDateTime fromDateTime;
    private LocalDateTime toDateTime;
    private String tenantName;

    public Meeting(LocalDateTime fromDateTime, LocalDateTime toDateTime, String tenantName) {
        this.fromDateTime = fromDateTime;
        this.toDateTime = toDateTime;
        this.tenantName = tenantName;
    }
}

public class Main {
    private static List<Meeting> meetings = new ArrayList<>();

    public static void saveMeeting(Meeting meeting) {
        final int MIN_DURATION = 15;
        final int MAX_DURATION = 90;

        // logic: if validation doesn't get pass throw exception, if not add the meeting.
        // TODO: validate that the meeting takes between 15 and 90 minutes.


        meetings.add(meeting);

    }

    public static void main(String[] args) {
        Meeting meeting1 = new Meeting(
                LocalDateTime.of(2022, 5, 18, 14,30),
                LocalDateTime.of(2022, 5, 18, 15,30),
                "luca prodan");

        Meeting meeting2 = new Meeting(
                LocalDateTime.of(2022, 5, 18, 15,30),
                LocalDateTime.of(2022, 5, 18, 16,30),
                "ricardo iorio");

        meetings.add(meeting1);
        meetings.add(meeting2);

        System.out.println(meetings);
    }
}
