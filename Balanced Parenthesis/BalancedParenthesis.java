import java.util.*;

public class BalancedParenthesis {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String tempCase = "";

        while (!tempCase.equalsIgnoreCase("quit")) {
            System.out.print("Enter test case (enter quit to stop): ");
            tempCase = keyboard.nextLine();

            if (!tempCase.equalsIgnoreCase("quit")) {
                if (isBalanced(tempCase))
                    System.out.println(tempCase + " Is balanced ");
                else
                    System.out.println(tempCase + " Is not balanced ");
            }
        }
    }


    public static Boolean isBalanced(String input) {
        Deque<Character> stack = new ArrayDeque<Character>();

        for (int i = 0; i < input.length(); i++) {
            char specificChar = input.charAt(i);

            if (specificChar == '(' || specificChar == '[' || specificChar == '{') {

                stack.push(specificChar);
                continue;
            }

            if (stack.isEmpty())
                return false;
            char check;
            switch (specificChar) {
                case ')':
                    check = stack.pop();
                    if (check == '{' || check == '[')
                        return false;
                    break;

                case '}':
                    check = stack.pop();
                    if (check == '(' || check == '[')
                        return false;
                    break;

                case ']':
                    check = stack.pop();
                    if (check == '(' || check == '{')
                        return false;
                    break;
            }
        }

        return (stack.isEmpty());
    }
}