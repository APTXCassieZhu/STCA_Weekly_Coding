package Meeting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// calculate spare time of meeting room
public class MeetingRoom2 {
    public static List<int[]> spareTime(int[][] meetings) {
        Arrays.sort(meetings, ((a, b) -> a[0] - b[0]));
        List<int[]> result = mergeMeeting(meetings);
        List<int[]> output = new ArrayList<>();
        int start = 0;
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i)[0] > start) {
                output.add(new int[] { start, result.get(i)[0] });
            }
            start = result.get(i)[1];
        }
        if (start < 2400) {
            output.add(new int[] { start, 2400 });
        }
        return output;
    }

    private static List<int[]> mergeMeeting(int[][] meetings) {

        List<int[]> result = new ArrayList<>();
        int[] curMeeting = meetings[0];
        for (int[] meeting : meetings) {
            if (curMeeting[1] >= meeting[0]) {
                curMeeting[1] = Math.max(curMeeting[1], meeting[1]);
            } else {
                result.add(curMeeting);
                curMeeting = meeting;
            }
        }
        result.add(curMeeting);
        return result;
    }

    public static void main(String[] args) {
        int[][] meetings = { { 1300, 1500 }, { 930, 1300 }, { 830, 845 } };
        for (int[] time : spareTime(meetings)) {
            System.out.println("[" + time[0] + ", " + time[1] + "]");
        }
    }
}
