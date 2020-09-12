package CourseSchedule;

// 找到两两学生之间的overlap courses

// input:                                               output:
// student_course_pairs_1 = [                           find_pairs(student_course_pairs_1) =>
//   ["58", "Software Design"],                         {
//   ["58", "Linear Algebra"],                              [58, 17]: ["Software Design", "Linear Algebra"]
//   ["94", "Art History"],                                 [58, 94]: ["Economics"]
//   ["94", "Operating Systems"],                           [58, 25]: ["Economics"]
//   ["17", "Software Design"],                             [94, 25]: ["Economics"]
//   ["58", "Mechanics"],                                   [17, 94]: []
//   ["58", "Economics"],                                   [17, 25]: []
//   ["17", "Linear Algebra"],                          }
//   ["17", "Political Science"],
//   ["94", "Economics"],
//   ["25", "Economics"],
// ]

// time complexity O(n^3)   

import java.util.*;

public class OverlapCourse {
    public static Map<String[], String[]> findPairs(String[][] coursePairs) {
        if(coursePairs == null || coursePairs.length == 0)  return null;
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
                List<String> overlap = new ArrayList<>();
                for (String c1 : map.get(key[0])) {
                    if (map.get(key[1]).contains(c1)) {
                        overlap.add(c1);
                    }
                }
                String[] value = overlap.toArray(new String[overlap.size()]);
                result.put(key, value);
            }
        }
        return result;
    }

    private static void forTest(Map<String[], String[]> ans){
        for(String[] key: ans.keySet()){
            System.out.print(key[0]+" "+key[1]+": ");
            for(String course : ans.get(key))
                System.out.print(course+" ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[][] coursePairs = { { "58", "Software Design" }, { "58", "Linear Algebra" }, { "94", "Art History" },
                { "94", "Operating Systems" }, { "17", "Software Design" }, { "58", "Mechanics" },
                { "58", "Economics" }, { "17", "Linear Algebra" }, { "17", "Political Science" }, { "94", "Economics" },
                { "25", "Economics" } };
        Map<String[], String[]> result = findPairs(coursePairs);
        forTest(result);
    }
}
