package Meeting;

public class MeetingRoom1 {
    public static boolean canSchedule(int[][] meetings, int start, int end) {
        for (int[] meeting : meetings) {
            if (start < meeting[1] && end > meeting[0]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] meetings = { { 1300, 1500 }, { 930, 1200 }, { 830, 845 } };
        System.out.println(canSchedule(meetings, 844, 900));
    }
}
