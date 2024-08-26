package greedy_algorithm.n_meetings_in_one_room;

import java.util.*;

public class Solution {

    public static int meetingsCount(int[] start, int[] end) {
        List<Meeting> meetings = new ArrayList<>();

        // Create an array list to capture the meetings in a Data Structure.
        // This will help to sort the Meetings with their end time.
        for (int i = 0; i < start.length; i++) {
            Meeting meeting = new Meeting(start[i], end[i], i + 1);
            meetings.add(meeting);
        }

        // Sort the meetings with the [MeetingOrderByEndTime].
        meetings.sort(new MeetingOrderByEndTime());

        int count = 1, lastMET = meetings.getFirst().endTime();
        List<Integer> position = new ArrayList<>();
        position.add(meetings.getFirst().position());

        // If current meeting's start time is greater than last meeting's end time,
        // this meeting can happen.
        for (int i = 1; i < meetings.size(); i++) {
            Meeting meeting = meetings.get(i);
            if (meeting.startTime() > lastMET) {
                count++;
                lastMET = meeting.endTime();
                position.add(meeting.position());
            }
        }

        // Print out the positions of the meetings, extracted from the original array.
        System.out.println(position);
        return count;
    }

    public static void main(String[] args) {
        int[] start = { 0, 3, 1, 5, 5, 8 };
        int[] end = { 5, 4, 2, 9, 7, 9 };

        int count = meetingsCount(start, end);
        System.out.println(count); // 4
    }
}

class Meeting {

    private int startTime;
    private int endTime;
    private int position;

    Meeting() {}

    Meeting(int startTime, int endTime, int position) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.position = position;
    }

    public int startTime() {
        return this.startTime;
    }

    public int endTime() {
        return this.endTime;
    }

    public int position() {
        return this.position;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", position=" + position +
                '}';
    }
}

class MeetingOrderByEndTime implements  Comparator<Meeting> {
    @Override
    public int compare(Meeting m1, Meeting m2) {
        if (m1.endTime() == m2.endTime()) return m1.startTime() - m2.startTime();
        return m1.endTime() - m2.endTime();
    }
}
