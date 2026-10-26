class Solution {
   public boolean isValid(String s) {

    // create a stack of char
    Stack<Character> stack = new Stack<>();

    // run a loop on s
    for (char ch : s.toCharArray()) {

        // on every open bracket push to stack
        if (ch == '(' || ch == '{' || ch == '[') {
            stack.push(ch);
        }

        // on every closing bracket, check for matching opening bracket
        else {
            if (stack.isEmpty()) return false;

            char top = stack.peek();

            if ((ch == ')' && top == '(') ||
                (ch == '}' && top == '{') ||
                (ch == ']' && top == '[')) {
                stack.pop();
            } else {
                return false;
            }
        }
    }

    // return if stack is empty
    return stack.isEmpty();
}
}
