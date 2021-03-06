package CourseSchedule;

import java.util.*;

public class OverlapCourse3 {
    public static List<String> getMidCourses(String[][] preCourses){
        Map<String, List<String>> courseGraph = new HashMap<>();
        Map<String, Integer> indegree = new HashMap<>();
        for(String[] preCourse : preCourses){
            if(courseGraph.containsKey(preCourse[0])){
                courseGraph.get(preCourse[0]).add(preCourse[1]);
            }else{
                List<String> cList = new ArrayList<>();
                cList.add(preCourse[1]);
                courseGraph.put(preCourse[0], cList);
            }
            indegree.put(preCourse[1], indegree.getOrDefault(preCourse[1], 0) + 1);
            indegree.put(preCourse[0], indegree.getOrDefault(preCourse[0], 0));
        }
        // find root
        List<String> root = new ArrayList<>();
        for(String key : indegree.keySet()){
            if(indegree.get(key) == 0){
                root.add(key);
            }
        }
        // find path
        List<String> path;
        Set<String> ans = new HashSet<>();
        for(int i = 0; i < root.size(); i++){
            path = new ArrayList<>();
            String cur = root.get(i);
            path.add(cur);
            CreatePath(cur, path, courseGraph, ans);
        }
        return new ArrayList<>(ans);
    }

    private static void CreatePath(String cur, List<String> path, Map<String, List<String>> courseGraph, Set<String> ans){
        if(!courseGraph.containsKey(cur)){
            ans.add(path.get((path.size() + 1) / 2 - 1));
        }else{
            for(String next : courseGraph.get(cur)){
                path.add(next);
                CreatePath(next, path, courseGraph, ans);
                path.remove(path.size() - 1);
            }
        }
    }

    private static void forTest(List<String> ans){
        for(String str : ans)
            System.out.println(str+" ");
    }

    public static void main(String[] args){
        String[][] all_courses = {{"Logic", "COBOL"},{"Data Structures", "Algorithms"},{"Creative Writing", "Data Structures"},{"Algorithms", "COBOL"},{"Intro to Computer Science", "Data Structures"},{"Logic", "Compilers"},{"Data Structures", "Logic"},{"Creative Writing", "System Administration"},{"Databases", "System Administration"},{"Creative Writing", "Databases"},{"Intro to Computer Science", "Graphics"}};
        forTest(getMidCourses(all_courses));  
    }
}

/*Students may decide to take different "tracks" or sequences of courses in the Computer Science curriculum. There may be more than one track that includes the same course, but each student follows a single linear track from a "root" node to a "leaf" node. In the graph below, their path always moves left to right.

Write a function that takes a list of (source, destination) pairs, and returns the name of all of the courses that the students could be taking when they are halfway through their track of courses.

Sample input:
all_courses = [
    ["Logic", "COBOL"],
    ["Data Structures", "Algorithms"],
    ["Creative Writing", "Data Structures"],
    ["Algorithms", "COBOL"],
    ["Intro to Computer Science", "Data Structures"],
    ["Logic", "Compilers"],
    ["Data Structures", "Logic"],
    ["Creative Writing", "System Administration"],
    ["Databases", "System Administration"],
    ["Creative Writing", "Databases"],
    ["Intro to Computer Science", "Graphics"],
]

Sample output (in any order):
          ["Data Structures", "Creative Writing", "Databases", "Intro to Computer Science"]

All paths through the curriculum (midpoint *highlighted*):

*Intro to C.S.* -> Graphics
Intro to C.S. -> *Data Structures* -> Algorithms -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> COBOL
Intro to C.S. -> *Data Structures* -> Logic -> Compiler
Creative Writing -> *Databases* -> System Administration
*Creative Writing* -> System Administration
Creative Writing -> *Data Structures* -> Algorithms -> COBOL
Creative Writing -> *Data Structures* -> Logic -> COBOL
Creative Writing -> *Data Structures* -> Logic -> Compilers

Visual representation:

                    ____________
                    |          |
                    | Graphics |
               ---->|__________|
               |                          ______________
____________   |                          |            |
|          |   |    ______________     -->| Algorithms |--\     _____________
| Intro to |   |    |            |    /   |____________|   \    |           |
| C.S.     |---+    | Data       |   /                      >-->| COBOL     |
|__________|    \   | Structures |--+     ______________   /    |___________|
                 >->|____________|   \    |            |  /
____________    /                     \-->| Logic      |-+      _____________
|          |   /    ______________        |____________|  \     |           |
| Creative |  /     |            |                         \--->| Compilers |
| Writing  |-+----->| Databases  |                              |___________|
|__________|  \     |____________|-\     _________________________
               \                    \    |                       |
                \--------------------+-->| System Administration |
                                         |_______________________|

Complexity analysis variables:

n: number of pairs in the input

*/
