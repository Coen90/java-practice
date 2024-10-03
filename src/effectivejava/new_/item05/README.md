# ITEM05
## 자원을 직접 명시하지 말고 의존 객체 주입을 사용하라

### 정적 유틸리티를 잘못 사용한 예
```java
public class SpellChecker {
    private static final Lexicon dictionary = ...;

    private SpellChecker() {
    }

    public static boolean isValid(String word) {}

    public static List<String> suggestions(String typo) {}
}
```

### 싱글턴을 잘못 사용한 예
```java
public class SpellChecker {
    private final Lexicon dictionary = ...;

    private SpellChecker() {
    }

    public static SpellChecker INSTANCE = new SpellChecker();

    public static boolean isValid(String word) {}

    public static List<String> suggestions(String typo) {}
}
```

### 두 방식의 문제점

- 사전을 단 하나만 사용한다고 가정하는 점에서 그리 훌륭하지 않다.

- 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스나 싱글턴 방식이 적합하지 않다.

- 물론 위 코드에서 `final`을 제거하고 `Lexicon`을 변경하도록 수정할 수 있지만, 멀티스레드 환경에서 문제가 될 수 있다.

> 사용하는 자원에 따라 동작이 달라지는 클래스에는 정적 유틸리티 클래스나 싱글턴 방식이 적합하지 않다!

그럼 어떻게 처리해야할까?

답은 생각보다 단순하다. 의존 객체 주입을 사용하면 된다.

인스턴스를 생성할 때 생성자에 필요한 자원을 넘겨주는 방식이다.

### 의존 객체 주입을 사용한 예
```java
public class SpellChecker {
    private final Lexicon dictionary;

    public SpellChecker(Lexicon dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary); //의존 객체 주입
    }

    public boolean isValid(String word) {}

    public List<String> suggestions(String typo) {}
}
```

위 방식을 사용하면 불변을 보장하여 여러 클라이언트가 의존 객체들을 안심하고 공유할 수 있기도 하다.

의존 객체 주입은 생성자, 정적팰터리, 빌더 모두에 똑같이 응용이 가능하다

이 패턴의 변형으로, 생성자에 자원 팩토리를 넘겨주는 방식도 있다.

```java
public static Mosaic create(Supplier<? extends Tile> tileFactory) {
    return new Mosaic(tileFactory.get());
}
```

`Supplier<T>` 인터페이스가 팩터리를 표현한 완벽한 예라고 한다.

- `Supplier<T>`를 입력으로 받는 메서드는 일반적으로 한정적 와일드카드를 사용해 팩터리의 타입 매개변수를 제한해야 한다.

- 클라이언트는 자신이 명시한 타입의 하위 타입이라면 무엇이든 생성할 수 있는 팩터리를 넘길 수 있다.

---

의존 객체 주입은 유연성과 테스트 용이성을 개선해준다.

하지만 의존성이 수천 개나 되는 큰 프로젝트에서는 코드를 어지럽게 만들 수 있다는 점도 함께 알고 있어야 한다.

결론 : 그러니 스프링을 사용하자~