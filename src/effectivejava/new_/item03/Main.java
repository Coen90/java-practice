package effectivejava.new_.item03;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //리플렉션을 사용하여 private 생성자 호출
//        Class<Elvis> clazz = Elvis.class;
//        Constructor<Elvis> constructor = clazz.getDeclaredConstructor();
//        constructor.setAccessible(true);
//        Elvis testInstance = constructor.newInstance();

        //엘비스 직렬화
        SerializableElvis elvis = SerializableElvis.INSTANCE;
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("book.obj"))) {
            out.writeObject(elvis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("book.obj"))) {
            SerializableElvis serializableElvis = (SerializableElvis) in.readObject();
            System.out.println(elvis == serializableElvis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
