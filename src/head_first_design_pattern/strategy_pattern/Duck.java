package head_first_design_pattern.strategy_pattern;

public abstract class Duck {

    final FlyBehavior flyBehavior;
    final QuackBehavior quackBehavior;

    Duck(FlyBehavior flyBehavior, QuackBehavior quackBehavior) {
        this.flyBehavior = flyBehavior;
        this.quackBehavior = quackBehavior;
    }

    void performQuack() {
        quackBehavior.quack();
    }

    void performFly() {
        flyBehavior.fly();
    }

    void swim() {
        System.out.println("duck swim");
    }

    void display() {
        System.out.println("duck display");
    }
}
