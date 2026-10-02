class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 && j >= 0) {
            int x = a.charAt(i--) - '0';
            int y = b.charAt(j--) - '0';

            int sum = x + y + c;
            sb.append(sum % 2);
            c = sum / 2;
        }

        while (i >= 0) {
            int x = a.charAt(i--) - '0';

            int sum = x + c;
            sb.append(sum % 2);
            c = sum / 2;
        }

        while (j >= 0) {
            int y = b.charAt(j--) - '0';

            int sum = y + c;
            sb.append(sum % 2);
            c = sum / 2;
        }

        if (c != 0)
            sb.append(c);

        return sb.reverse().toString();
    }
}