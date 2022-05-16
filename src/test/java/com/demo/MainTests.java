package com.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTests {
    @Test
    @DisplayName("Should not add new meeting when it ends at the same time another starts.")
    void test1() {
        // given
        MeetingService meetingService = new MeetingService();

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(14, 00, 14, 30);

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

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(14, 00, 15, 00);

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

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(14, 30, 15, 30);

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

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(15, 30, 16, 30);

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

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(14, 29, 15, 31);

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

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(14, 00, 14, 29);

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

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(16, 32, 17, 01);

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

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                16,
                00,
                17,
                00);
        Meeting newMeeting = createMeeting(15, 35, 15, 55);

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

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(13, 00, 13, 05);

        assertThatThrownBy(() -> meetingService.addMeeting(newMeeting))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("Should throw exception when a new meeting takes more than ninety minutes.")
    void test11() {
        // given
        MeetingService meetingService = new MeetingService();

        addMeetingsByDefault(meetingService,
                14,
                30,
                15,
                30,
                15,
                31,
                16,
                31);
        Meeting newMeeting = createMeeting(12, 00, 14, 00);

        assertThatThrownBy(() -> meetingService.addMeeting(newMeeting))
                .isInstanceOf(RuntimeException.class);
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
