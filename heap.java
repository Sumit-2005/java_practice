import java.util.ArrayList;

public class heap {
    static class Heap{
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data){
            //Add At Last
            arr.add(data);

            //index of child and parent;
            int x = arr.size()-1;
            int par = (x-1)/2;

            //swap if parent > child
            while (x > 0 && arr.get(x) < arr.get(par)){
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x-1)/2;
            }
        }

        public int peek(){
            return arr.get(0);
        }

        private void heapify(int i){
            //get left, right and minIdx
            int left = 2*i + 1;
            int right = 2*i +2;
            int minIdx = i;

            //check size and set minIdx
            if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
                minIdx = left;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minIdx)){
                minIdx = right;
            }

            //swap if necessary (also call recursive)
            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }

        }
        
        public int remove(){
            //get data from 0 idx
            int data = arr.get(0);

            //swap 1st and last idx
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //remove
            arr.remove(arr.size()-1);

            //heapify
            heapify(0);
            return data;

        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
    }

    public static void main(String args[]){
        Heap h = new Heap();
        h.add(4);
        h.add(2);
        h.add(6);
        h.add(1);

        while(!h.isEmpty()){
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
