package CourseSchedule;

import java.util.HashMap;
import java.util.Map;

// 输入{{A, B}, {C, D}, {B, C}, {E, F}, {D, E}, {F, G}}, 输出 D.
public class OverlapCourse2 {
    public static char findMediumCourse(char[][] courses) {
        int[] count = new int[26];
        Map<Character, Character> map = new HashMap<>();
        for (char[] course : courses) {
            count[course[0] - 'A']++;
            count[course[1] - 'A']++;
            map.put(course[0], course[1]);
        }
        char start = 'A';
        for (int i = 0; i < 26; i++) {
            if (count[i] == 1) {
                start = (char) ('A' + i);
                break;
            }
        }
        int middleCourse = map.keySet().size() / 2;
        while (middleCourse-- > 0) {
            start = map.get(start);
        }
        return start;
    }

    public static void main(String[] args) {
        char[][] courses = { { 'A', 'B' }, { 'C', 'D' }, { 'B', 'C' }, { 'E', 'F' }, { 'D', 'E' }, { 'F', 'G' } };
        System.out.println(findMediumCourse(courses));
    }
}
