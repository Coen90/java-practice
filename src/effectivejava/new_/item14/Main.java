package effectivejava.new_.item14;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Comparator<Object> comparing = Comparator.comparing(o -> o.hashCode());
        Comparator<Object> comparing1 = Comparator.comparing(o -> o.hashCode(), (o1, o2) -> {
            return o2 - o1;
        });
        System.out.println(comparing.compare(1, 2)); //
        System.out.println(comparing1.compare(1, 2));

        Comparator<Object> comparator = new Comparator<>() {
            @Override
            public int compare(Object o1, Object o2) {
                return Integer.compare(o1.hashCode(), o2.hashCode());
            }
        };

        Comparator<Object> comparator1 = Comparator.comparingInt(Object::hashCode);

        System.out.println(comparator.compare(1, 2));
        System.out.println(comparator1.compare(1, 2));
    }

    public static class PhoneNumber implements Comparator<PhoneNumber> {
        private final short areaCode, prefix, lineNum;

        public PhoneNumber(int areaCode, int prefix, int lineNum) {
            this.areaCode = rangeCheck(areaCode, 999, "지역 코드");
            this.prefix = rangeCheck(prefix, 999, "프리픽스");
            this.lineNum = rangeCheck(lineNum, 9999, "가입자 번호");
        }

        private static short rangeCheck(int val, int max, String arg) {
            if (val < 0 || val > max) {
                throw new IllegalArgumentException(arg + ": " + val);
            }
            return (short) val;
        }

        public short getAreaCode() {
            return areaCode;
        }

        public short getPrefix() {
            return prefix;
        }

        public short getLineNum() {
            return lineNum;
        }

//        @Override
//        public int compare(PhoneNumber o1, PhoneNumber o2) {
//            int result = Short.compare(o1.areaCode, o2.areaCode);
//            if (result == 0) {
//                result = Short.compare(o1.prefix, o2.prefix);
//                if (result == 0) {
//                    result = Short.compare(o1.lineNum, o2.lineNum);
//                }
//            }
//            return result;
//        }

        @Override
        public int compare(PhoneNumber o1, PhoneNumber o2) {
            return Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode)
                    .thenComparing(pn -> pn.prefix)
                    .thenComparing(pn -> pn.lineNum)
                    .compare(o1, o2);
        }
    }
}
