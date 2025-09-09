import java.util.Stack;

class solution {
    public static int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i=0; i<tokens.length; i++){
            if(tokens[i] == "+"){
                int first = s.pop();
                int sec = s.pop();
                s.push(sec+first);
            }else if(tokens[i] == "-"){
                int first = s.pop();
                int sec = s.pop();
                s.push(sec-first);
            }else if(tokens[i] == "*"){
                int first = s.pop();
                int sec = s.pop();
                s.push(sec*first);
            }else if(tokens[i] == "/"){
                int first = s.pop();
                int sec = s.pop();
                s.push(sec/first);
            }else{
                int intValue = Integer.valueOf(tokens[i]);
                s.push(intValue);
            }
        }
        return s.peek();
    }

    public static void main(String args[]){
        String tokens[] = {"4","13","5","/","+"};
        System.out.println(evalRPN(tokens));
    }
}