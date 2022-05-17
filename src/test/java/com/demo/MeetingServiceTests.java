package com.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeetingServiceTests {
    private final int START_DAY_OF_MONTH_MEETING_1 = 18;
    private final int END_DAY_OF_MONTH_MEETING_1 = 18;
    private final int START_DAY_OF_MONTH_MEETING_2 = 18;
    private final int END_DAY_OF_MONTH_MEETING_2 = 18;

    private final int START_DAY_OF_MONTH_NEW_MEETING = 17;
    private final int END_DAY_OF_MONTH_NEW_MEETING = 17;
    private final int START_HOUR_MEETING_1 = 14;
    private final int START_MINUTES_MEETING_1 = 30;
    private final int END_HOUR_MEETING_1 = 15;
    private final int END_MINUTES_MEETING_1 = 30;
    private final int START_HOUR_MEETING_2 = 15;
    private final int START_MINUTES_MEETING_2 = 31;
    private final int END_HOUR_MEETING_2 = 16;
    private final int END_MINUTES_MEETING_2 = 31;

    private final MeetingService meetingService = new MeetingService();

    @BeforeEach
    void cleanMeetingsFromService() {
        meetingService.getMeetings().clear();
    }

    @Test
    @DisplayName("Should not add new meeting when it ends at the same time another starts.")
    void test1() {
        // given
        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 14;
        final int END_MINUTES_NEW_MEETING = 30;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add new meeting when it ends at the same time another takes place.")
    void test2() {
        // given
        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 15;
        final int END_MINUTES_NEW_MEETING = 00;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add new meeting when it starts at the same time another starts.")
    void test3() {
        // given
        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 30;
        final int END_HOUR_NEW_MEETING = 15;
        final int END_MINUTES_NEW_MEETING = 30;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add new meeting when it starts at the same time another ends.")
    void test4() {
        // given
        final int START_HOUR_NEW_MEETING = 15;
        final int START_MINUTES_NEW_MEETING = 30;
        final int END_HOUR_NEW_MEETING = 16;
        final int END_MINUTES_NEW_MEETING = 30;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add new meeting when it ends at the same time another ends.")
    void test5() {
        // given
        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 29;
        final int END_HOUR_NEW_MEETING = 15;
        final int END_MINUTES_NEW_MEETING = 31;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add new meeting when it ends one minute before another starts.")
    void test6() {
        // given
        final int START_HOUR_NEW_MEETING = 14;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 14;
        final int END_MINUTES_NEW_MEETING = 29;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(3, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add new meeting when it starts one minute after another ends.")
    void test7() {
        // given
        final int START_HOUR_NEW_MEETING = 16;
        final int START_MINUTES_NEW_MEETING = 32;
        final int END_HOUR_NEW_MEETING = 17;
        final int END_MINUTES_NEW_MEETING = 01;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(3, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add new meeting when it starts and ends between two other.")
    void test8() {
        // given
        final int START_HOUR_MEETING_2 = 16;
        final int START_MINUTES_MEETING_2 = 00;
        final int END_HOUR_MEETING_2 = 17;
        final int END_MINUTES_MEETING_2 = 00;

        final int START_HOUR_NEW_MEETING = 15;
        final int START_MINUTES_NEW_MEETING = 35;
        final int END_HOUR_NEW_MEETING = 15;
        final int END_MINUTES_NEW_MEETING = 55;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        //when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(3, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should throw exception when a new meeting takes less than fifteen minutes.")
    void test9() {
        // given
        final int START_HOUR_NEW_MEETING = 13;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 13;
        final int END_MINUTES_NEW_MEETING = 05;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        // when/then
        assertThatThrownBy(() -> meetingService.addMeeting(newMeeting))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Should throw exception when a new meeting takes more than ninety minutes.")
    void test10() {
        // given
        final int START_HOUR_NEW_MEETING = 12;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 14;
        final int END_MINUTES_NEW_MEETING = 00;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        // when/then
        assertThatThrownBy(() -> meetingService.addMeeting(newMeeting))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Should add a new meeting when there is no other previously.")
    void test11() {
        // given
        final int START_HOUR_NEW_MEETING = 12;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 12;
        final int END_MINUTES_NEW_MEETING = 20;

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        // when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(1, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add a new meeting when it takes exactly fifteen minutes")
    void test12() {
        // given
        final int START_HOUR_NEW_MEETING = 12;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 12;
        final int END_MINUTES_NEW_MEETING = 15;

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        // when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(1, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add a new meeting when it takes exactly ninety minutes")
    void test13() {
        // given
        final int START_HOUR_NEW_MEETING = 12;
        final int START_MINUTES_NEW_MEETING = 00;
        final int END_HOUR_NEW_MEETING = 13;
        final int END_MINUTES_NEW_MEETING = 30;

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        // when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(1, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should add a new meeting when it starts 10 mins before midnight and ends 10 mins after")
    void test14() {
        // given
        final int START_DAY_OF_MONTH = 17;
        final int END_DAY_OF_MONTH = 18;
        final int START_HOUR_NEW_MEETING = 23;
        final int START_MINUTES_NEW_MEETING = 50;
        final int END_HOUR_NEW_MEETING = 00;
        final int END_MINUTES_NEW_MEETING = 10;

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH,
                END_DAY_OF_MONTH,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        // when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(1, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add a new meeting when it overlaps with another that started the day before")
    void test15() {
        // given
        final int START_DAY_OF_MONTH_MEETING_1 = 17;

        final int START_HOUR_MEETING_1 = 23;
        final int START_MINUTES_MEETING_1 = 50;
        final int END_HOUR_MEETING_1 = 0;
        final int END_MINUTES_MEETING_1 = 20;
        final int START_HOUR_MEETING_2 = 2;
        final int START_MINUTES_MEETING_2 = 0;
        final int END_HOUR_MEETING_2 = 2;
        final int END_MINUTES_MEETING_2 = 30;

        final int START_DAY_OF_MONTH_NEW_MEETING = 18;
        final int END_DAY_OF_MONTH_NEW_MEETING = 18;
        final int START_HOUR_NEW_MEETING = 0;
        final int START_MINUTES_NEW_MEETING = 10;
        final int END_HOUR_NEW_MEETING = 00;
        final int END_MINUTES_NEW_MEETING = 40;

        addMeetingsByDefault(
                START_DAY_OF_MONTH_MEETING_1,
                END_DAY_OF_MONTH_MEETING_1,
                START_DAY_OF_MONTH_MEETING_2,
                END_DAY_OF_MONTH_MEETING_2,
                START_HOUR_MEETING_1,
                START_MINUTES_MEETING_1,
                END_HOUR_MEETING_1,
                END_MINUTES_MEETING_1,
                START_HOUR_MEETING_2,
                START_MINUTES_MEETING_2,
                END_HOUR_MEETING_2,
                END_MINUTES_MEETING_2);

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH_NEW_MEETING,
                END_DAY_OF_MONTH_NEW_MEETING,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        // when
        meetingService.addMeeting(newMeeting);

        // then
        assertEquals(2, meetingService.getMeetings().size());
    }

    @Test
    @DisplayName("Should not add a new meeting when it takes more than one day")
    void test16() {
        // given
        final int START_DAY_OF_MONTH = 16;
        final int END_DAY_OF_MONTH = 18;
        final int START_HOUR_NEW_MEETING = 23;
        final int START_MINUTES_NEW_MEETING = 50;
        final int END_HOUR_NEW_MEETING = 00;
        final int END_MINUTES_NEW_MEETING = 10;

        Meeting newMeeting = createMeeting(
                START_DAY_OF_MONTH,
                END_DAY_OF_MONTH,
                START_HOUR_NEW_MEETING,
                START_MINUTES_NEW_MEETING,
                END_HOUR_NEW_MEETING,
                END_MINUTES_NEW_MEETING);

        // when/then
        assertThatThrownBy(() -> meetingService.addMeeting(newMeeting))
                .isInstanceOf(RuntimeException.class);
    }

    private Meeting createMeeting(int startDayOfMonth,
                                  int endDayOfMonth,
                                  int startHourMeeting,
                                  int startMinutesMeeting,
                                  int endHourMeeting,
                                  int endMinutesMeeting) {
        return new Meeting(
                LocalDateTime.of(2022, 5, startDayOfMonth, startHourMeeting, startMinutesMeeting),
                LocalDateTime.of(2022, 5, endDayOfMonth, endHourMeeting, endMinutesMeeting),
                "tom hanks");
    }

    private void addMeetingsByDefault(int startDayOfMonthMeeting1,
                                      int endDayOfMonthMeeting1,
                                      int startDayOfMonthMeeting2,
                                      int endDayOfMonthMeeting2,
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
                LocalDateTime.of(2022, 5, startDayOfMonthMeeting1, startHourMeeting1,startMinutesMeeting1),
                LocalDateTime.of(2022, 5, endDayOfMonthMeeting1, endHourMeeting1,endMinutesMeeting1),
                "luca prodan");

        Meeting meeting2 = new Meeting(
                LocalDateTime.of(2022, 5, startDayOfMonthMeeting2, startHourMeeting2, startMinutesMeeting2),
                LocalDateTime.of(2022, 5, endDayOfMonthMeeting2, endHourMeeting2, endMinutesMeeting2),
                "ricardo iorio");

        List<Meeting> meetings = List.of(meeting1, meeting2);

        meetings.forEach(m -> meetingService.getMeetings().add(m));
    }
}
