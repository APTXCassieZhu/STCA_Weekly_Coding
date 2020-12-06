import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



import org.apache.http.client.utils.URLEncodedUtils;
class Result {
    
    /*
     * Complete the 'process_actions' function below.
     *
     * The function accepts STRING_ARRAY input_lines as parameter.
     */
    public static double STRIPE_PROCESS_FEE = 0.02;
    public static void process_actions(List<String> input_lines) {
    // Write your code here
        int N = Integer.valueOf(input_lines.get(0));
        Map<String, Double> feeOfCard = new HashMap<>();
        for(int i = 1; i <= N; i++){
            String input = input_lines.get(i);
            int index = input.indexOf(" ");
            feeOfCard.put(input.substring(0, index), Double.valueOf(input.substring(index+1)));
        }
        int M = Integer.valueOf(input_lines.get(N+1));
        HashMap<String, Double> charges = new HashMap<>();
        HashMap<String, Charge> map = new HashMap<>();
        HashMap<String, Double> balances = new HashMap<>();
        for(int i = N+2; i < M+N+2; i++){
            String action = input_lines.get(i);
            String action_type = action.substring(1, action.indexOf("?")).toLowerCase();
            
            if(action_type.equals("charge")){
                //List<NameValuePair> params = URLEncodedUtils.parse(action), StandardCharsets.UTF_8);
                String[] infos = action.split("&");
                String network = "", merchant_id = "", charge_id = "";
                int amount = 0;
                for(String info : infos){
                    int index = info.indexOf("=");
                    if(info.charAt(index - 1) == 'k'){
                        network = info.substring(index+1);
                    }else if(info.charAt(index - 1) == 't'){
                        amount = Integer.valueOf(info.substring(index+1));
                    }else if(info.charAt(index - 1) == 'd'){
                        int in = info.indexOf("_");
                        if(info.charAt(in - 1) == 't'){
                            merchant_id = info.substring(index+1);
                        }else if(info.charAt(in - 1) == 'e'){
                            charge_id = info.substring(index+1);
                        }
                    }
                }
                Charge c = new Charge(network, amount, merchant_id, charge_id);
                map.put(charge_id, c);
                double rate = feeOfCard.get(network) / 100;
                double fee = amount - amount * (rate + STRIPE_PROCESS_FEE);
                //System.out.println(charge_id+" "+fee+" "+rate);
                charges.put(charge_id, fee);
            }else if(action_type.equals("payout")){
                Payout p = new Payout(action.substring(action.indexOf(("="))+1));
                System.out.println(p.merchant_id+", "+(int)Math.ceil(balances.get(p.merchant_id)));
            }else if(action_type.equals("confirm")){
                Confirm conf = new Confirm(action.substring(action.indexOf(("="))+1));
                Charge c = map.get(conf.charge_id);
                balances.putIfAbsent(c.merchant_id, 0.0);
                balances.put(c.merchant_id, balances.get(c.merchant_id)+charges.get(c.charge_id));
            }else if(action_type.equals("refund")){
                Refund r = new Refund(action.substring(action.indexOf(("="))+1));
                Charge c = map.get(r.charge_id);
                balances.putIfAbsent(c.merchant_id, 0.0);
                balances.put(c.merchant_id, balances.get(c.merchant_id)-c.amount*STRIPE_PROCESS_FEE);
            }
        }
    }

}
class Action{
    String action;
}
class Charge extends Action{
    String action;
    String network;     // card network of the credit card
    int amount;         // payment amount   0 ~ 4,294,967,295
    String merchant_id;
    String charge_id;
    Charge(String network, int amount, String merchant_id, String charge_id){
        this.network = network;
        this.amount = amount;
        this.merchant_id = merchant_id;
        this.charge_id = charge_id;
        this.action = "charge";
    }
}
class Payout extends Action{
    String action;
    String merchant_id;
    Payout(String merchant_id){
        this.merchant_id = merchant_id;
        this.action = "payout";
    }
}
class Confirm extends Action{
    String action;
    String charge_id;
    Confirm(String charge_id){
        this.charge_id = charge_id;
        this.action = "confirm";
    }
}
class Refund extends Action{
    String action;
    String charge_id;
    Refund(String charge_id){
        this.charge_id = charge_id;
        this.action = "refund";
    }
}

public class Solution {