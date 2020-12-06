import java.util.*;

public class IPO {
    // list user ids of all users who did not get even one share after the shares have been allocated
    public static int[] getUnallottedUsers(int[][] bids, int totalShares) {
        // Id, shares, price, timestamp

        List<Integer> list = new ArrayList<>();

        // Id - original shares
        Map<Integer, Integer> shareMap = new HashMap<>();
        for (int[] bid : bids) {
            shareMap.put(bid[0], bid[1]);
        }

        Arrays.sort(bids, (a, b) -> (a[2] != b[2] ? b[2] - a[2] : a[3] - b[3]));

        for (int[] bid : bids) {
            if (totalShares == 0) {
                break;
            } else {
                int alloted = bid[1] < totalShares ? bid[1] : totalShares;
                bid[1] -= alloted;
                totalShares -= alloted;
            }
        }

        Arrays.sort(bids, (a, b) -> (a[0] - b[0]));
        for (int[] bid : bids) {
            if (bid[1] == shareMap.get(bid[0])) {
                list.add(bid[0]);
            }
        }

        int[] users = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            users[i] = list.get(i);
        }
        return users;
    }


    public static void main(String args[]) {
        int[][] bids = new int[][] {
                {1, 5, 5, 0},
                {2, 7, 8, 1},
                {3, 7, 5, 1},
                {4, 10, 3, 3}
        };

        getUnallottedUsers(bids, 18);
    }
}