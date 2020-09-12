package CourseSchedule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class OverlapCourse {
    public static Map<String[], String[]> findPairs(String[][] coursePairs) {
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String[], String[]> result = new HashMap<>();
        for (String[] coursesPair : coursePairs) {
            if (!map.containsKey(coursesPair[0])) {
                map.put(coursesPair[0], new HashSet<>());
            }
            map.get(coursesPair[0]).add(coursesPair[1]);
        }

        List<String> students = new ArrayList<>(map.keySet());
        for (int i = 0; i < students.size(); i++) {
            for (int j = i + 1; j < students.size(); j++) {
                String[] key = new String[] { students.get(i), students.get(j) };
                List<String> courses = new ArrayList<>();
                for (String c1 : map.get(key[0])) {
                    if (map.get(key[1]).contains(c1)) {
                        courses.add(c1);
                    }
                }
                String[] value = new String[courses.size()];
                for (int k = 0; k < value.length; k++) {
                    value[k] = courses.get(k);
                }
                result.put(key, value);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[][] coursePairs = { { "58", "Software Design" }, { "58", "Linear Algebra" }, { "94", "Art History" },
                { "94", "Operating Systems" }, { "17", "Software Design" }, { "58", "Mechanics" },
                { "58", "Economics" }, { "17", "Linear Algebra" }, { "17", "Political Science" }, { "94", "Economics" },
                { "25", "Economics" } };
        Map<String[], String[]> result = findPairs(coursePairs);
        System.out.println("{");
        for (String[] key : result.keySet()) {
            System.out.println("[" + key[0] + ", " + key[1] + "]" + ": [");
            for (String courses : result.get(key)) {
                System.out.println(courses + " ");
            }
            System.out.println("]");
        }
        System.out.println("}");
    }
}
