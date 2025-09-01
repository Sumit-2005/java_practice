import java.util.Stack;

public class isDuplicate {

    public static boolean isDuplicate(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while (s.peek() != '(') {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // duplicate
                } else {
                    s.pop(); // remove the opening '('
                }
            } else {
                // push everything including '('
                s.push(ch);
            }
        }
        return false; // no duplicates found
    }

    public static void main(String args[]) {
        String str1 = "((a+b))";
        String str2 = "(a+b)";
        System.out.println(isDuplicate(str1)); // true
        System.out.println(isDuplicate(str2)); // false
    }
}
