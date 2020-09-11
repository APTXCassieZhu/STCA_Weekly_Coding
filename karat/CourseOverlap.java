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
import java.util.*;
public class CourseOverlap{
    public static Map<String[], List<String>> findOverlap(String[][] coursePairs){
        if(coursePairs == null || coursePairs.length == 0)  return null;
        Map<String, List<String>> courses = new HashMap<>();
        for(String[] course: coursePairs){
            if(courses.containsKey(course[0])){
                courses.get(course[0]).add(course[1]);
            }else{
                List<String> courseList = new ArrayList<>();
                courseList.add(course[1]);
                courses.put(course[0], courseList);
            }
        }
        // keyset 不能直接cast成string array ！！！！！！！！！！！！！！！！！！！！！！！！
        String[] students = courses.keySet().toArray(new String[courses.keySet().size()]);  

        Map<String[], List<String>> ans = new HashMap<>();
        for(int i = 0; i < students.length; i++){
            for(int j = i + 1; j < students.length; j++){
                List<String> overlap = new ArrayList<>();
                for(String c1 : courses.get(students[i])){
                    for(String c2 : courses.get(students[j])){
                        if(c1.equals(c2)){
                            overlap.add(c1);
                        }
                    }
                }
                ans.put(new String[]{students[i], students[j]}, overlap);
            }
        }
        return ans;
    }

    private static void forTest(Map<String[], List<String>> ans){
        for(String[] key: ans.keySet()){
            System.out.print(key[0]+" "+key[1]+": ");
            for(String course : ans.get(key))
                System.out.print(course+" ");
            System.out.println();
        }
    }
    public static void main(String[] args){
        String[][] coursePairs = new String[][]{{"58", "Software Design"},{"58", "Linear Algebra"},{"94", "Art History"},{"94", "Operating Systems"},{"17", "Software Design"},{"58", "Mechanics"},{"58", "Economics"},
        {"17", "Linear Algebra"},{"17", "Political Science"},{"94", "Economics"},{"25", "Economics"}};

        forTest(findOverlap(coursePairs));
    }
}