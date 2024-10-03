package effectivejava.old.chap6.item40;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            s.add(new Bigram('a', 'a'));
        }

        System.out.println(s.size());
    }
}
