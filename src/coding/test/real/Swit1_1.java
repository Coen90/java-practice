package coding.test.real;

public class Swit1_1 {
    public static int solution(int num) {
        int n = (int) Math.ceil(Math.log10(num + 1) / 2.0);
        int start = (int) Math.pow(10, n - 1);
        int end = (int) Math.pow(10, n) - 1;
        for (int i = start; i <= end; i++) {
            String s = Integer.toString(i);
            if (s.length() % 2 == 1) continue;
            int prod1 = 1, prod2 = 1;
            for (int j = 0; j < s.length() / 2; j++) {
                prod1 *= s.charAt(j) - '0';
                prod2 *= s.charAt(j + s.length() / 2) - '0';
            }
            if (prod1 == prod2 && i >= num) {
                return i;
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(solution(21));
    }
}
