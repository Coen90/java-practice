package coding_test.theory.fibonacci;

public class Fibonacci {
    private static int call = 0;

    public static void main(String[] args) {
        System.out.println(new Fibonacci().fibonacci(15));
        System.out.println("콜 스택 = " + call);
    }

    private int fibonacci(int i) {
        call++;
        if (i  <= 1) {
            return i;
        }
        return fibonacci(i - 2) + fibonacci(i - 1);
    }
}
