package Domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Domain3 {
    public static String[] AdsConversion(String[] completedUserId, String[] adClicks, String[] allUserIp) {
        HashSet<String> userIdSet = new HashSet<>();
        for (String user : completedUserId) {
            userIdSet.add(user);
        }
        Map<String, List<String>> adTextMap = new HashMap<>();
        Map<String, String> ipUserMap = new HashMap<>();
        for (String adClick : adClicks) {
            String[] parsed = adClick.split(",");
            String text = parsed[2];
            String ip = parsed[0];
            adTextMap.putIfAbsent(text, new ArrayList<>());
            adTextMap.get(text).add(ip);
        }

        for (String userIp : allUserIp) {
            String[] userAndIp = userIp.split(",");
            ipUserMap.putIfAbsent(userAndIp[1], userAndIp[0]);
        }

        String[] result = new String[adTextMap.keySet().size()];
        int i = 0;
        for (String text : adTextMap.keySet()) {
            List<String> clicks = adTextMap.get(text);
            int buyer = 0;
            for (String user : clicks) {
                if (userIdSet.contains(ipUserMap.get(user))) {
                    buyer++;
                }
            }
            result[i++] = buyer + " of " + clicks.size() + " " + text;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] completedId = { "3123122444", "234111110", "8321125440", "99911063" };
        String[] adClicks = { "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
                "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
                "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
                "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
                "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
                "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens" };
        String[] allUser = { "User_ID,IP_Address", "2339985511,122.121.0.155", "234111110,122.121.0.1",
                "3123122444,92.130.6.145", "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
                "8321125440,82.1.106.8", "99911063,92.130.6.144" };
        String[] result = AdsConversion(completedId, adClicks, allUser);
        System.out.println("[");
        for (String s : result) {
            System.out.println(s);
        }
        System.out.println("]");

    }
}
