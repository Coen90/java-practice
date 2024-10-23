package effectivejava.new_.item06;

public class AutoBoxingTest {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(System.currentTimeMillis() - start);

        long start2 = System.currentTimeMillis();
        long sum2 = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum2 += i;
        }
        System.out.println(System.currentTimeMillis() - start2);
    }
}
