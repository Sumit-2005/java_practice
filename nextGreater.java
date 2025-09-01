import java.util.Stack;

public class nextGreater {
    public static void main(String args[]){
        int arr[] = {6, 8, 0, 1, 3};
        int nextGreater[] = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        int n = arr.length;
        for(int i = n-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nextGreater[i] = -1;
            }else{
                nextGreater[i] = arr[s.peek()];
            }

            s.push(i);
        }

        for(int i = 0; i< n; i++){
            System.out.print(nextGreater[i]+ " ");
        }
        System.out.println();
    }
}
