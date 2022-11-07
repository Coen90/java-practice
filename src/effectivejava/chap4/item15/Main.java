package effectivejava.chap4.item15;

/**
 * 정보은닉의 장점
 * - 시스템 개발 속도를 높인다.
 * - 시스템 관리 비용을 낮춘다.
 * - 정보 은닉 자체가 성능을 높여주지는 않지만, 성능 최적화에 도움을 준다.
 * - 소프트웨어 재사용성을 높인다.
 * - 큰 시스템을 제작하는 난이도를 낮춘다.
 */
public class Main {

    public static void main(String[] args) {
        AccessModifierTest test = new AccessModifierTest();
        System.out.println(test.packagePrivateName);
        System.out.println(test.protectedName);
        System.out.println(test.publicName);

        test.VALUE[0] = "나는 해커다";
        String[] testValue1 = test.VALUE;
        for (String s : testValue1) {
            System.out.println("s = " + s);
        }

    }
}
