package effectivejava.old.chap4.item15;

public class AccessModifierTest {

    private String privateName = "현태"; // 선언된 클래스에서만 접근 가능
    String packagePrivateName = "ヒョンテ"; // 선언된 클래스가 포함된 패키지에서 접근 가능
    protected String protectedName = "炫炱"; // package private의 범위를 포함하여 상속받은 하위클래스에서 접근 가능
    public String publicName = "Hyuntae"; // 다른 패키지에서 접근 가능
    public static final String[] VALUE = {"안녕", "하십니까"};

}
