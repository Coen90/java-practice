package effectivejava.new_.item03;

import java.io.Serial;
import java.io.Serializable;

public class SerializableElvis implements Serializable {
    public static final SerializableElvis INSTANCE = new SerializableElvis("Elvis Presley", "42", "The King");

    String name;
    String age;
    String nickname;

    private SerializableElvis(String name, String age, String nickname) {
        if (INSTANCE != null) {
            throw new IllegalStateException("This instance is already created.");
        }
        this.name = name;
        this.age = age;
        this.nickname = nickname;
    }

    @Serial
    private Object readResolve() {
        return INSTANCE;
    }
}
