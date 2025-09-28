import java.util.*;

public class heap {
    // static class Heap{
    //     ArrayList<Integer> arr = new ArrayList<>();

    //     public void add(int data){
    //         //Add At Last
    //         arr.add(data);

    //         //index of child and parent;
    //         int x = arr.size()-1;
    //         int par = (x-1)/2;

    //         //swap if parent > child
    //         while (x > 0 && arr.get(x) < arr.get(par)){
    //             int temp = arr.get(x);
    //             arr.set(x, arr.get(par));
    //             arr.set(par, temp);

    //             x = par;
    //             par = (x-1)/2;
    //         }
    //     }

    //     public int peek(){
    //         return arr.get(0);
    //     }

    //     private void heapify2(int i){
    //         //get left, right and minIdx
    //         int left = 2*i + 1;
    //         int right = 2*i +2;
    //         int minIdx = i;

    //         //check size and set minIdx
    //         if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
    //             minIdx = left;
    //         }

    //         if(right < arr.size() && arr.get(right) < arr.get(minIdx)){
    //             minIdx = right;
    //         }

    //         //swap if necessary (also call recursive)
    //         if(minIdx != i){
    //             int temp = arr.get(i);
    //             arr.set(i, arr.get(minIdx));
    //             arr.set(minIdx, temp);

    //             heapify(minIdx);
    //         }

    //     }
        
    //     public int remove(){
    //         //get data from 0 idx
    //         int data = arr.get(0);

    //         //swap 1st and last idx
    //         int temp = arr.get(0);
    //         arr.set(0, arr.get(arr.size()-1));
    //         arr.set(arr.size()-1, temp);

    //         //remove
    //         arr.remove(arr.size()-1);

    //         //heapify
    //         heapify(0);
    //         return data;

    //     }

    //     public boolean isEmpty(){
    //         return arr.size() == 0;
    //     }
    // }

    public static void heapify(int[] arr, int i, int size){
        int left = 2*i+1;
        int right = 2*i+2;
        int maxIdx = i;

        if(left < size && arr[left] > arr[maxIdx]){
            maxIdx = left;
        }

        if(right < size && arr[right] > arr[maxIdx]){
            maxIdx = right;
        }

        if(maxIdx != i){
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void heapSort(int arr[]){
        int n = arr.length;
        for(int i=n/2; i>=0; i--){
            heapify(arr,i, n);
        }

        for(int i=n-1; i>0; i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr,0,i);
        }
    }

    static class Point implements Comparable<Point>{
        int x;
        int y;
        int distSq;
        int idx;

        public Point(int x, int y, int distSq, int idx){
            this.x = x;
            this.y = y;
            this.distSq = distSq;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2){
            return this.distSq - p2.distSq;
        }
    }

    public static void main(String args[]){
        int pts[][] = {{3,3}, {5,-1}, {-2, 4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0; i<pts.length; i++){
            int distSq = pts[i][0]*pts[i][0] + pts[i][1]*pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], distSq, i));
        }

        for(int i=0; i<k; i++){
            System.out.println("C" + pq.remove().idx);
        }
    }
}
