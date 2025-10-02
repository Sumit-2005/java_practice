import java.util.LinkedHashMap;

public class linkedHashMap {
    public static void main(String args[]){
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 120);
        lhm.put("China", 100);
        lhm.put("Spain", 40);

        ///In a LinkedHashMap all the keys are sorted in the insertion order;
        System.out.println(lhm);
    }
}
