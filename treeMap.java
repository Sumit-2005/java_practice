import java.util.TreeMap;

public class treeMap {
    public static void main(String args[]){
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("India", 120);
        tm.put("China", 100);
        tm.put("Spain", 40);

        System.out.println(tm);
    }
}