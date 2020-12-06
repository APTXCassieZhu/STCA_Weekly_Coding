import java.util.*;

public class FetchItemsToDisplay{
    public static List<String> fetch(List<List<String>> items, int sortParameter, int sortOrder, int itemsPerPage, int pageNumber){
        int order = sortOrder == 0 ? 1 : -1;
        Collections.sort(items, (a,b) -> (a.get(sortParameter).compareTo(b.get(sortParameter))) * order);
        int total = items.size();
        int totalPage = total / itemsPerPage;
        
    }
    
    
    public static void main(String[] args) {
        
    }
}