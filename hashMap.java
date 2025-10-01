import java.util.*;

public class hashMap {
    public static void main(String args[]){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("India", 120);
        map.put("Spain", 70);
        map.put("Portugal", 40);
        Set<String> keys = map.keySet();
        for(String k : keys){
            System.out.println(k+"="+map.get(k));
        }
    }
}
