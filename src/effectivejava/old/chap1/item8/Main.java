package effectivejava.old.chap1.item8;

public class Main {

    public static void main(String[] args) throws Throwable {

        int testCode = 9;

        if(testCode == 1) {
            FinalizerTest finalizerTest = new FinalizerTest();
            finalizerTest.hello();
            System.gc();
            Thread.sleep(1000l);
            System.gc();
        } else if (testCode == 2) { // finalize 예외만 발생
            FinalizerTest finalizerTest = null;
            try {
                finalizerTest = new FinalizerTest();
                finalizerTest.hello();
            } finally {
                finalizerTest.finalize();
            }
        } else if (testCode == 3) { // hello와 close예외 둘 다 보여줌
            try (FinalizerTest finalizerTest = new FinalizerTest()) {
                finalizerTest.hello();
            }
        } else if (testCode == 4) { // hello에서 예외발생 후 죽음
            FinalizerTest finalizerTest = new FinalizerTest();
            finalizerTest.hello();
            finalizerTest.close();
        } else if (testCode == 5) {// close에서만 예외발생
            FinalizerTest finalizerTest = null;
            try {
                finalizerTest = new FinalizerTest();
                finalizerTest.hello();
            } finally {
                finalizerTest.close();
            }
        }

    }

}
