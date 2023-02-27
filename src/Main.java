import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
    public static class Equals {
        private int number;
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Equals equals = (Equals) o;

            if (number != equals.number) return false;
            return Objects.equals(name, equals.name);
        }

        @Override
        public int hashCode() {
            int result = number;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        public Equals(int number, String name) {
            this.number = number;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Equals e1 = new Equals(1, "hyuntae");
        Equals e2 = new Equals(1, "hyuntae");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e1 == e2);
        System.out.println(e1.equals(e2));

        Set<Equals> set = new HashSet<>();

        set.add(e1);
        set.add(e2);

        System.out.print("Set.size = ");
        System.out.println(set.size());

    }
}