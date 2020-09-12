package CourseSchedule;

import java.util.*;

public class OverlapCourse3 {
    public static Set<String> halfWayLessons(String[][] courses) {
        Set<String> result = new HashSet<>();
        Map<String, Integer> inorder = new HashMap<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Boolean> visited = new HashMap<>();

        for (String[] course : courses) {
            String source = course[0];
            String des = course[1];
            visited.put(source, false);
            visited.put(des, false);
            if (!graph.containsKey(source)) {
                graph.put(source, new ArrayList<>());
            }
            if (!graph.containsKey(des)) {
                graph.put(des, new ArrayList<>());
            }
            graph.get(source).add(des);
            if (!inorder.containsKey(source)) {
                inorder.put(source, 0);
            }
            inorder.put(des, inorder.getOrDefault(des, 0) + 1);
        }

        for (String key : inorder.keySet()) {
            if (inorder.get(key).equals(0)) {
                LinkedList<String> temp = new LinkedList<>();
                temp.add(key);
                backtrack(key, graph, temp, result);
            }
        }

        return result;
    }

    public static void backtrack(String start, Map<String, List<String>> graph, List<String> temp, Set<String> result) {
        int size = graph.get(start).size();
        if (size == 0) {
            result.add(temp.get((temp.size() + 1) / 2 - 1));
            return;
        }
        for (int i = 0; i < size; i++) {
            String next = graph.get(start).get(i);
            temp.add(next);
            backtrack(next, graph, temp, result);
            temp.remove(temp.size() - 1);
        }

    }

    public static void main(String[] args) {
        String[][] all_courses = { { "Logic", "COBOL" }, { "Data Structures", "Algorithms" },
                { "Creative Writing", "Data Structures" }, { "Algorithms", "COBOL" },
                { "Intro to Computer Science", "Data Structures" }, { "Logic", "Compilers" },
                { "Data Structures", "Logic" }, { "Creative Writing", "System Administration" },
                { "Databases", "System Administration" }, { "Creative Writing", "Databases" },
                { "Intro to Computer Science", "Graphics" } };
        Set<String> result = halfWayLessons(all_courses);
        System.out.println("[");
        for (String c : result) {
            System.out.println(c + ", ");
        }
        System.out.println("]");
    }
}
