public class WinFruit{
    public static int winFruit(String[][] codeList, String[] shoppingCart){
        if(codeList == null || codeList.length == 0)   
            return 1;
        if(shoppingCart == null || shoppingCart.length == 0)   
            return 0;
        int j = 0, k = 0;
        for(int i=0; i<shoppingCart.length; i++){
            if(j == codeList.length)    return 1;
            if(shoppingCart[i].equals(codeList[j][k]) || codeList[j][k].equals("anything")){
                k++;
                if(k == codeList[j].length){
                    j++;
                    k = 0;
                }    
            }else{
                // restart to match
                k = codeList[j][0].equals("anything") ? 1 : 0;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        String[][] codeList1 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList2 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        String[][] codeList3 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        String[][] codeList4 = { { "apple", "apple" }, { "apple", "apple", "banana" } };
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        String[][] codeList5 = { { "apple", "apple" }, { "banana", "anything", "banana" } };
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList6 = { { "apple", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        String[][] codeList7= { { "anything", "apple" }, { "banana", "anything", "banana" }  };
        String[] shoppingCart7 = {"orange", "grapes", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        System.out.println(winFruit(codeList1, shoppingCart1));
        System.out.println(winFruit(codeList2, shoppingCart2));
        System.out.println(winFruit(codeList3, shoppingCart3));
        System.out.println(winFruit(codeList4, shoppingCart4));
        System.out.println(winFruit(codeList5, shoppingCart5));
        System.out.println(winFruit(codeList6, shoppingCart6));
        System.out.println(winFruit(codeList7, shoppingCart7));
    }
}