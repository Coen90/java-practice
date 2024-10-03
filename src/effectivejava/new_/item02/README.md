# ITEM02
## 생성자에 매개변수가 많다면 빌더를 고려하라

정적 팩터리와 생성자는 선택적 매개변수가 많을 때 적절히 대응하기 어렵다.

이를 위해 점층적 생성자 패턴도 쓸 수 있지만 매개변수가 많아지면 클라이언트 코드를 작성하거나 읽기 어렵다.

자바빈즈패턴(매개변수가 없는 생성자로 객체를 만든 후 세터로 매개변수의 값을 설정하는 방식)도 단점이 있다.

객체 하나를 만들기 위해 메서드를 여러 개 호출해야 하며, 객체가 완전히 생성되기 전까지는 일관성이 무너진 상태에 놓인다.

또한 불변으로 만들 수 있다는 치명적인 단점이 있다.

점층적 생성자 패턴의 안정성과 자바빈즈패턴의 가독성을 겸비한 빌더 패턴이 있다.

빌더의 세터 메서드들은 빌더 자신을 반환하기 때문에 연쇄적(chaining)으로 호출할 수 있다.

빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기 좋다.

## 빌더 패턴 예시

Pizza.Builder 클래스는 재귀적 타입 한정을 이용하는 제네릭 타입이다.

여기에 추상 메서드인 self를 더해 하위 클래스에서는 형변환하지 않고도 메서드 연쇄를 지원할 수 있다.

```java
public abstract class Pizza {
    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping) {
            toppings.add(topping);
            return self();
        }

        abstract Pizza build();

        // 하위 클래스가 자신(this)을 반환하도록 하기 위해 self() 메서드를 추가
        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
```

- 뉴욕피자는 size를 필수로 받는다.

```java
public class NewYorkPizza extends Pizza{
    public enum Size {SMALL, MEDIUM, LARGE}
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NewYorkPizza build() {
            return new NewYorkPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NewYorkPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }

    public Size getSize() {
        return size;
    }
}
```

- 칼조네는 소스여부를 필수로 받는다.

```java
public class Calzone extends Pizza{
    private final boolean sauceInside;

    public static class Builder extends Pizza.Builder<Builder> {
        private final boolean sauceInside;

        public Builder(boolean sauceInside) {
            this.sauceInside = sauceInside;
        }

        @Override
        Calzone build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    Calzone(Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public boolean isSauceInside() {
        return sauceInside;
    }
}
```