package effectivejava.new_.item02;

public class Main {
    public static void main(String[] args) {
        Name name = new Name.Builder("Park", "Hyuntae")
                .middleName("M")
                .nickName("H")
                .build();
        System.out.println(name.getFirstName());
        System.out.println(name.getLastName());
        System.out.println(name.getMiddleName());
        System.out.println(name.getNickName());

        NewYorkPizza pizza = new NewYorkPizza.Builder(NewYorkPizza.Size.LARGE)
                .addTopping(Pizza.Topping.HAM)
                .addTopping(Pizza.Topping.MUSHROOM)
                .build();
        System.out.println(pizza.toppings);
        System.out.println(pizza.getSize());

        Calzone calzone = new Calzone.Builder(true)
                .addTopping(Pizza.Topping.ONION)
                .addTopping(Pizza.Topping.SAUSAGE)
                .build();
        System.out.println(calzone.toppings);
        System.out.println(calzone.isSauceInside());
    }
}
