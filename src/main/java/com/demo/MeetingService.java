package com.demo;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingService {
    private List<Meeting> meetings = new ArrayList<>();
    {
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

    public boolean isInvalid(Meeting newMeeting) {
        final int MIN_DURATION = 15;
        final int MAX_DURATION = 90;

        long timeDifference = Duration.between(newMeeting.getFromDateTime(), newMeeting.getToDateTime()).toMinutes();

        if (timeDifference < MIN_DURATION || timeDifference > MAX_DURATION) {
            throw new RuntimeException("Time duration must be between 15 and 90 minutes");
        }

        return meetings.stream()
                .anyMatch(m -> {
                    if (newMeeting.getStartingTimeInMinutes() >= m.getStartingTimeInMinutes()
                            && newMeeting.getStartingTimeInMinutes() <= m.getEndingTimeInMinutes()
                            || newMeeting.getEndingTimeInMinutes() >= m.getStartingTimeInMinutes()
                            && newMeeting.getEndingTimeInMinutes() <= m.getEndingTimeInMinutes()
                    ) {
                        return true;
                    } else {
                        return false;
                    }
                });
    }

    public void addMeeting(Meeting newMeeting) {
        if (!isInvalid(newMeeting)) {
            System.out.println(">>> adding newMeeting");
            meetings.add(newMeeting);
        }
    }
}
