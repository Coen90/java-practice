package head_first_design_pattern.strategy_pattern;

public class Main {

    public static void main(String[] args) {
    Duck mallarDuck = new MallardDuck();
    mallarDuck.performQuack(); // Quack!!
    mallarDuck.performFly(); // Food Duck
    mallarDuck.display(); // 물오린데요

    Duck rubberDuck = new RubberDuck();
    rubberDuck.performQuack(); // Squeak!!
    rubberDuck.performFly(); // I Can Not Fly :(
    rubberDuck.display(); // duck display
    }
}




