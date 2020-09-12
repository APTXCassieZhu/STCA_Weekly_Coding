package Domain;

import java.util.HashMap;
import java.util.Map;

public class Domain1 {
    public static String[] countDomain(String[] domains) {
        Map<String, Integer> frequency = new HashMap<>();
        for (String domain : domains) {
            String[] temp = domain.split(" ");
            int fre = Integer.parseInt(temp[0]);
            String[] subdomains = temp[1].split("\\.");
            String cur = "";
            for (int i = subdomains.length - 1; i >= 0; i--) {
                cur = subdomains[i] + (cur.length() == 0 ? "" : ".") + cur;
                frequency.put(cur, frequency.getOrDefault(cur, 0) + fre);
            }
        }
        String[] result = new String[frequency.keySet().size()];
        int i = 0;
        for (String domain : frequency.keySet()) {
            result[i++] = frequency.get(domain) + " " + domain;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] domains = { "900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org" };
        String[] result = countDomain(domains);
        System.out.println("[");
        for (String s : result) {
            System.out.println(s + ", ");
        }
        System.out.println("]");
    }
}
