import java.util.*;
public class hashSet {
    
    public static int unionCount(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }

        return set.size();
    }

    public static int intersectionCount(int[] arr1, int[] arr2){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        int count = 0;
        for(int i=0; i<arr2.length; i++){
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
        return count;
    }
    
    public static void main(String args[]){
        int[] arr1 = {1,2,6,9,4};
        int[] arr2 = {1,3,7,5,0};
        System.out.println(unionCount(arr1, arr2));
        System.out.println(intersectionCount(arr1, arr2));
    }
}
