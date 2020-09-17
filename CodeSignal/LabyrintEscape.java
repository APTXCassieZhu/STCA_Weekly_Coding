public class LabyrintEscape{
    public static boolean laybyrinthEscape(int n, int m, int[][] obstacles, int[][] teleports){
        int[] curPos = new int[]{teleports[0][0], teleports[0][1]};
        for(int[] tele: teleports){
            // check if teleports backwards (only right)
            int[] start = new int[]{tele[0], tele[1]};
            int[] end = new int[]{tele[2], tele[3]};
            if(curPos[1] > tele[1] || !check(obstacles, curPos, start) || !check(obstacles, start, end))  return false;
            curPos[0] = tele[2];
            curPos[1] = tele[3];
        }
        if(!check(obstacles, curPos, new int[]{n-1, m-1}))  return false;
        return true;
    }

    public static boolean check(int[][] obstacles, int[] start, int[] end){
        for(int[] o: obstacles){
            if((o[0] >= start[0] && o[0] <= end[0] && o[1] >= start[1] && o[1] <= end[1]) || 
            (o[0] <= start[0] && o[0] >= end[0]&& o[1] >= start[1] && o[1] <= end[1])   ||
            (o[0] <= start[0] && o[0] >= end[0]&& o[1] <= start[1] && o[1] >= end[1])   ||
            (o[0] >= start[0] && o[0] <= end[0]&& o[1] <= start[1] && o[1] >= end[1])){
                return false;
            }    
        }
        return true;
    }

    public static void main(String[] args){
        // int[][] obstacles = new int[][]{{2,0},{1,0}};
        // int[][] teleports = new int[][]{{0,1,1,1},{1,2,0,2},{0,3,2,1}};
        // System.out.print(laybyrinthEscape(3, 4, obstacles, teleports));
        int[][] obstacles = new int[][]{{1,1}};
        int[][] teleports = new int[][]{{0,2,0,1},{0,3,2,0}};
        System.out.print(laybyrinthEscape(3, 4, obstacles, teleports));
    }
}