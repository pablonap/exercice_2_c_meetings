package com.demo;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
//        Meeting newMeeting = new Meeting(
//                LocalDateTime.of(2022, 5, 17, 16,45),
//                LocalDateTime.of(2022, 5, 17, 17,45),
//                "tom hanks");

        Meeting newMeeting = new Meeting(
                LocalDateTime.of(2022, 5, 17, 14,00),
                LocalDateTime.of(2022, 5, 17, 15,00),
                "tom hanks");

        MeetingService meetingService = new MeetingService();
        meetingService.addMeeting(newMeeting);
    }
}
