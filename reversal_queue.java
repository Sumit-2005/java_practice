import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reversal_queue {
    
    public static void queueReversal(Queue<Integer> q){
        Stack<Integer> s = new Stack<>();
        int size = q.size();
        for(int i=0; i<size; i++){
            s.push(q.remove());
        }

        for(int i=0; i<size; i++){
            q.add(s.pop());
        }
    }
    
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        queueReversal(q);
        //Print Queue
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
