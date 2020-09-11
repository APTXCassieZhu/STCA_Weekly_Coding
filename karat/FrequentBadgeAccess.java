// 找出经常进出保密室的员工 [three or more times in a one-hour period]
//returns each time that they badged in during that period. 
//(If there are multiple one-hour periods where this was true, just return the first one.)

// input: [['James', '1300'], ['Martha', '1600'], ['Martha', '1620'], ['Martha', '1530']] 
// output (in any order): {'Martha': ['1600', '1620', '1530']}

import java.util.*;

public class FrequentBadgeAccess{

    public static List<Map<String, Set<String>>> findFreqAccess(String[][] timelines){
        if(timelines == null || timelines.length == 0)  return null;
        Arrays.sort(timelines, (a, b) -> a[0].equals(b[0]) ? timeDiff(a[1], b[1]) : a[0].compareTo(b[0]));
        // for test
        for(String[] time : timelines)
            System.out.println(time[0]+" "+time[1]);
            
        String curName = timelines[0][0];
        int badged = 1;
        List<Map<String, Set<String>>> ans = new ArrayList<>();
        Map<String, Set<String>> map = new HashMap<>();
        for(int i = 1; i < timelines.length; i++){
            if(timelines[i][0] == curName){                
                if(timeDiff(timelines[i][1], timelines[i-1][1]) < 60){   
                    badged++;
                    if(map.containsKey(curName)){
                        map.get(curName).add(timelines[i][1]);
                        map.get(curName).add(timelines[i-1][1]);
                    }else{
                        Set<String> timeSet = new HashSet<>();
                        timeSet.add(timelines[i][1]);
                        timeSet.add(timelines[i-1][1]);
                        map.put(curName, timeSet);
                    }  
                }else{
                    if(map.size() != 0 && badged >= 3){
                        ans.add(map);
                    } 
                    badged = 1;
                    map = new HashMap<>();
                }              
            }else if(timelines[i][0] != curName){
                if(map.size() != 0 && badged >= 3){
                    ans.add(map);
                } 
                badged = 1;
                curName = timelines[i][0];
                map = new HashMap<>();
            }
        }
        return ans;        
    }

    private static int timeDiff(String t1, String t2){
        int time1 = Integer.valueOf(t1);
        int time2 = Integer.valueOf(t2);
        int hour1 = time1 / 100;
        int hour2 = time2 / 100;
        int min1 = time1 % 100;
        int min2 = time2 % 100;
        return hour1 * 60 + min1 - (hour2 * 60 + min2);
    }

    private static void forTest(List<Map<String, Set<String>>> ans){
        for(int i = 0; i < ans.size(); i++){
            for(String curName :ans.get(i).keySet()){
                System.out.print(curName+": ");
                for(String str : ans.get(i).get(curName)){
                    System.out.print(str+" ");
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args){
        String[][] timelines = new String[][]{{"Martha", "1620"}, {"James", "1300"}, {"Martha", "1600"}, {"Martha", "1530"}};
        //findFreqAccess(timelines);
        String[][] timelines2 = new String[][]{{"John", "730"}, {"John", "830"}, {"John", "835"},{"John", "855"},{"John", "915"},{"John", "930"}, {"John", "940"},
        {"John", "1615"},{"John", "1640"},{"John", "1630"},{"Paul", "1355"},{"Jennifer", "1910"},{"Paul", "1315"},{"Paul", "1405"},{"Jennifer", "1335"},{"Jennifer", "730"},{"Jennifer", "5"}};
        forTest(findFreqAccess(timelines2));        
    }
}

// Given a list of people who enter and exit, find the people who entered without their badge and who exited without their badge.
// 整个hashmap， for loop走一下record，如果map没有contains这个人，那他状态必须是enter，如果contains，新状态必须和原来相反。
// 没有enter就exit 存一个list， enter了连续两次的存另一个list，就好了
