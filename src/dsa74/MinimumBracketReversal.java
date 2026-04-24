package dsa74;

import java.util.*;

public class MinimumBracketReversal {

    public static int countMinReversals(String expr) {

        int len = expr.length();

        if(len % 2 != 0)
            return -1;

        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < len; i++) {
            char ch = expr.charAt(i);

            if(ch == '{') {
                stack.push(ch);
            }
            else {
                if(!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    stack.push(ch);
            }
        }

        int open = 0, close = 0;

        while(!stack.isEmpty()) {
            if(stack.pop() == '{')
                open++;
            else
                close++;
        }

        return (open + 1) / 2 + (close + 1) / 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input expression
        System.out.print("Enter expression with { and }: ");
        String expr = sc.nextLine();

        int result = countMinReversals(expr);

        if(result == -1)
            System.out.println("Not possible");
        else
            System.out.println("Minimum reversals needed = " + result);

        sc.close();
    }
}
