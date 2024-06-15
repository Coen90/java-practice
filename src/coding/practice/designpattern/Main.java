package coding.practice.designpattern;

public class Main {

    public static void main(String[] args) {
        Person hyuntae = new Person.Builder()
                .name("현태")
                .address("산호아파트")
                .age(34)
            .build();
        System.out.println("hyuntae = " + hyuntae.getName());
        System.out.println("hyuntae = " + hyuntae.getAddress());
        System.out.println("hyuntae = " + hyuntae.getAge());
    }
}
