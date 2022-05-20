package com.demo;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MeetingService {
    private List<Meeting> meetings = new ArrayList<>();

    private boolean isInvalid(Meeting newMeeting) {
        final int MIN_DURATION = 15;
        final int MAX_DURATION = 90;

        long timeDifference = Duration.between(newMeeting.getFromDateTime(), newMeeting.getToDateTime()).toMinutes();

        if (timeDifference < MIN_DURATION || timeDifference > MAX_DURATION) {
            throw new RuntimeException("Time duration must be between 15 and 90 minutes");
        }

        return meetings.stream()
                .anyMatch(m -> {
                    return (newMeeting.getStartingTimeInMinutes() >= m.getStartingTimeInMinutes()
                            && newMeeting.getStartingTimeInMinutes() <= m.getEndingTimeInMinutes()
                            || newMeeting.getEndingTimeInMinutes() >= m.getStartingTimeInMinutes()
                            && newMeeting.getEndingTimeInMinutes() <= m.getEndingTimeInMinutes()
                    );
                });
    }

    public void addMeeting(Meeting newMeeting) {
        if (!isInvalid(newMeeting)) {
            meetings.add(newMeeting);
        }
    }

    public List<Meeting> getMeetings() {
        return meetings;
    }
}
