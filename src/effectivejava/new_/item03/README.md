# ITEM03
## private 생성자나 열거 타입으로 싱글턴임을 보증하라

>싱글턴이란 인스턴스를 오직 하나만 생성할 수 있는 클래스를 말한다.

싱글턴의 전형적인 예로는 함수와 같은 무상태 객체나 설계상 유일해야 하는 시스템 컴포넌트를 들 수 있다.

- 클래스를 싱글턴으로 만들면 이를 사용하는 클라이언트를 테스트하기가 어려워질 수 있다.

## 싱글턴을 만드는 방식

보통 두 방식 중 하나로 공통적인 특징은 다음과 같다.
- 생성자는 private으로 감춘다
- 유일한 인스턴스에 접근할 수 있는 수단으로 public static 멤버를 하나 마련한다.

1. public static 멤버가 final 필드인 방식
```java
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }
}
```

private 생성자는 public static final 필드인 Elvis.INSTANCE를 초기화할 때 딱 한 번만 호출된다.

드러난 생성자가 없기 때문에 리플렉션을 사용해 private 생성자를 호출하는 경우를 제외하면 하나뿐임이 보장된다.

이 조차 막으려면 다음과 같이 수정하면 된다.

```java
public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
        if (INSTANCE != null) {
            throw new IllegalStateException("This instance is already created.");
        }
    }
}
```

장점
- 해당 클래스가 싱글턴임이 API에 명백히 드러난다.
- 간결함

2. 정적 팩터리 메서드를 public static 멤버로 제공하는 방식

```java
public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    public static Elvis getInstance() {
        return INSTANCE;
    }
    
    private Elvis() {
        if (INSTANCE != null) {
            throw new IllegalStateException("This instance is already created.");
        }
    }
}
```

항상 같은 객체의 참조를 반환하므로 하나뿐임이 보장된다.(첫번째 방법과 동일하게 리플렉션으로 private 생성자를 호출 할 수 있다는 점은 동일)

장점
- API를 바꾸지 않고도 싱글턴이 아니게 변경할 수 있다.
- 정적 팩터리를 제네릭 싱글턴 팩터리로 만들 수 있다.
- 정적 팩터리의 메서드 참조를 공급자(supplier)로 사용할 수 있다. *(이부분은 이해가 잘 안됩니다.)*

## 싱글턴을 만드는 세번째 방법

원소가 하나인 열거타입을 선언하는 것이다.

```java
public enum Elvis {
    INSTANCE;
    public void leaveTheBuilding() {
        System.out.println("Whoa baby, I'm outta here!");
    }
}
```

public 필드 방식과 비슷하지만, 더 간결하고 추가 노력 없이 직렬화할 수 있으며, 아주 복잡한 직렬화 상황이나 리플렉션 공격에서도 제2의 인스턴스가 생기는 일을 완벽히 막아준다.

대부분 상황에서는 원소가 하나뿐인 열거 타입이 싱글턴을 만드는 가장 좋은 방법이다.

단 Enum 외의 클래스를 상속해야 한다면 사용불가!

---

## 직렬화

상기 두 가지 방식으로 만든 싱글턴 클래스를 직렬화하려면 단순히 Serializable을 구현한다고 해서 문제가 해결되지 않는다

모든 인스턴스 필드를 transient(?) 라고 선언하고 readResolve 메서드를 제공해야 한다.

그렇지 않으면 인스턴스를 역직렬화할 때 마다 새로운 인스턴스가 만들어진다.

```java
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    @Serial
    private Object readResolve() {
        return INSTANCE;
    }
}
```

