class Solution {
    public String decodeString(String s) {
        Stack<Integer> dig = new Stack<>();
        Stack<String> str = new Stack<>();

        StringBuilder sb = new StringBuilder();
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');

            } else if (c == '[') {
                dig.push(num);
                str.push(sb.toString());
                num = 0;
                sb = new StringBuilder();

            } else if (c == ']') {
                int time = dig.pop();
                String prev = str.pop();
                StringBuilder temp = new StringBuilder(prev);
                for (int i = 0; i < time; i++) {
                    temp.append(sb);
                }
                sb = temp;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }
}