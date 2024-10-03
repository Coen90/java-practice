package effectivejava.old.chap8.item53;

public class Main {

    public static void main(String[] args) {
        varargsTest(1, 2, 3, 4, 5);
//        varargsTest();
        System.out.println("args = " + args);
        min(1);
    }

    public static int varargsTest(int... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("인수가 1개 이상 필요합니다.");
        int min = args[0];
        for (int i = 1; i < args.length; i++)
            if (args[i] < min)
                min = args[i];
        return min;
    }

    static int min(int firstArgs, int... remainingArgs) {
        int min = firstArgs;
        for (int arg : remainingArgs)
            if (arg < min)
                min = arg;
        return min;
    }
}

