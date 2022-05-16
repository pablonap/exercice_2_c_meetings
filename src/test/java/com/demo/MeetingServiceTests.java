package com.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingServiceTests {
    private final int START_HOUR_MEETING_1 = 14;
    private final int START_MINUTES_MEETING_1 = 30;
    private final int END_HOUR_MEETING_1 = 15;
    private final int END_MINUTES_MEETING_1 = 30;
    private final int START_HOUR_MEETING_2 = 15;
    private final int START_MINUTES_MEETING_2 = 31;
    private final int END_HOUR_MEETING_2 = 16;
    private final int END_MINUTES_MEETING_2 = 31;

    @Test
    @DisplayName("Should not add new meeting when it ends at the same time another starts.")
    void test1() {
        // given
        final MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 14;
        final int END_MINUTES_NEW_MEETING = 30;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add new meeting when it ends at the same time another takes place.")
    void test2() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 15;
        final int END_MINUTES_NEW_MEETING = 00;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add new meeting when it starts at the same time another starts.")
    void test3() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 30;
        final int END_HOUR_NEW_MEETING = 15;
        final int END_MINUTES_NEW_MEETING = 30;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add new meeting when it starts at the same time another ends.")
    void test4() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 15;
        final int START_MINUTES_NEW_MEETING = 30;
        final int END_HOUR_NEW_MEETING = 16;
        final int END_MINUTES_NEW_MEETING = 30;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add new meeting when it ends at the same time another ends.")
    void test5() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 29;
        final int END_HOUR_NEW_MEETING = 15;
        final int END_MINUTES_NEW_MEETING = 31;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add new meeting when it ends one minute before another starts.")
    void test6() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 14;
        final int END_MINUTES_NEW_MEETING = 29;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(3, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add new meeting when it starts one minute after another ends.")
    void test7() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 16;
        final int START_MINUTES_NEW_MEETING = 32;
        final int END_HOUR_NEW_MEETING = 17;
        final int END_MINUTES_NEW_MEETING = 01;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(3, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add new meeting when it starts and ends between two other.")
    void test9() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_MEETING_2 = 16;
        final int START_MINUTES_MEETING_2 = 00;
        final int END_HOUR_MEETING_2 = 17;
        final int END_MINUTES_MEETING_2 = 00;

        final int START_HOUR_NEW_MEETING = 15;
        final int START_MINUTES_NEW_MEETING = 35;
        final int END_HOUR_NEW_MEETING = 15;
        final int END_MINUTES_NEW_MEETING = 55;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(3, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should throw exception when a new meeting takes less than fifteen minutes.")
    void test10() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 13;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 13;
        final int END_MINUTES_NEW_MEETING = 05;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        // when/then
        assertThatThrownBy(() -> meetingService.addMeeting(newMeeting))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Should throw exception when a new meeting takes more than ninety minutes.")
    void test11() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 12;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 14;
        final int END_MINUTES_NEW_MEETING = 00;

        addMeetingsByDefault(meetingService,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        // when/then
        assertThatThrownBy(() -> meetingService.addMeeting(newMeeting))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Should add a new meeting when there is no other previously.")
    void test12() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 12;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 12;
        final int END_MINUTES_NEW_MEETING = 20;

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        // when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(1, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add a new meeting when it takes exactly fifteen minutes")
    void test13() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 12;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 12;
        final int END_MINUTES_NEW_MEETING = 15;

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        // when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(1, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add a new meeting when it takes exactly ninety minutes")
    void test14() {
        // given
        MeetingService meetingService = new MeetingService();

        final int START_HOUR_NEW_MEETING = 12;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 13;
        final int END_MINUTES_NEW_MEETING = 30;

        Meeting newMeeting = createMeeting(START_HOUR_NEW_MEETING, START_MINUTES_NEW_MEETING, END_HOUR_NEW_MEETING, END_MINUTES_NEW_MEETING);

        // when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(1, meetingService.getMeetings().size());
    }

    private Meeting createMeeting( int startHourMeeting,
                                   int startMinutesMeeting,
                                   int endHourMeeting,
                                   int endMinutesMeeting) {
        return new Meeting(
                LocalDateTime.of(2022, 5, 17, startHourMeeting, startMinutesMeeting),
                LocalDateTime.of(2022, 5, 17, endHourMeeting, endMinutesMeeting),
                "tom hanks");
    }

    private void addMeetingsByDefault(MeetingService meetingService,
                                      int startHourMeeting1,
                                      int startMinutesMeeting1,
                                      int endHourMeeting1,
                                      int endMinutesMeeting1,
                                      int startHourMeeting2,
                                      int startMinutesMeeting2,
                                      int endHourMeeting2,
                                      int endMinutesMeeting2
                                     ) {
        Meeting meeting1 = new Meeting(
                LocalDateTime.of(2022, 5, 18, startHourMeeting1,startMinutesMeeting1),
                LocalDateTime.of(2022, 5, 18, endHourMeeting1,endMinutesMeeting1),
                "luca prodan");

        Meeting meeting2 = new Meeting(
                LocalDateTime.of(2022, 5, 18, startHourMeeting2, startMinutesMeeting2),
                LocalDateTime.of(2022, 5, 18, endHourMeeting2, endMinutesMeeting2),
                "ricardo iorio");

        List<Meeting> meetings = List.of(meeting1, meeting2);

        meetings.forEach(m -> meetingService.getMeetings().add(m));
    }
}
