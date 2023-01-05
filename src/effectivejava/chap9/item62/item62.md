# [ITEM62] 다른 타입이 적절하다면 문자열 사용을 피하라

> 문자열은 텍스트를 표현하도록 설계되었고, 그 일을 아주 멋지게 해낸다.

하지만 원래 의도하지 않은 용도로 쓰이는 경향이 있고, 이번 아이템에서는 문자열을 쓰지 않아야 할 사례를 다룬다.

## 문자열은 다른 값 타입을 대신하기에 접합하지 않다.

많은 사람들이 데이터를 받을 때 주로 문자열을 사용한다. ~~(우리회사가 그럼... DTO가 전부 String...)~~

하지만 문자열은 다른 값 타입을 대신하기에 적합하지 않다.

입력받을 데이터가 진짜 문자열일 때만 그렇게 하는게 좋다. 받은 데이터가 수치형이라면 `int` `float` `BigInteger`등 적당한 수치 타입으로 변환해야 한다.

`YES/NO` 질문의 답이라면 `boolean` 으로 변환해야 한다. 

기본 타입이든 참조 타입이든 적절한 값 타입이 있다면 그것을 사용하고, 없다면 새로 하나 작성해라.

## 문자열은 열거 타입을 대신하기에 적합하지 않다.

상수를 열거할 때는 문자열보다 열거타입이 월등히 낫다.

문자열은 혼합타입을 대신하기에 적합하지 않다.

여러 요소가 혼합된 데이터를 하나의 문자열로 표현하는 것은 대체로 좋지 않은 생각이다.

각 요소를 개별로 접근하려면 문자열을 파싱해야 해서 느리고, 귀찮고, 오류 가능성도 커진다.

적절한 `equals`, `toString`, `compareTo` 메서드를 제공할 수 없고, String 기능에만 의존해야 한다.

그렇기에 차라리 전용 클래스를 새로 만드는 것이 낫고, 이러한 클래스들은 보통 private 정적 멤버 클래스로 선언한다.

## 문자열은 권한을 표현하기에 적합하지 않다.

ex) 쓰레드 지역변수 기능을 설계하는데, 이는 각 쓰레드가 자신만의 변수를 갖게 해주는 기능이다.

자바 2 이전에는 직접 구현해서 사용해야 했었는데, 종국에는 모두 같은 설계에 이르렀다. 클라이언트가 제공한 문자열 키로 쓰레드별 지역변수를 식별했던 것이다.

```java
public class ThreadLocal {
    private ThreadLocal() { }
    
    public static void set(String key, Object value);
    
    public static Object get(String key);
}
```
이 방식은 문제가 있다.

쓰레드 구분용 문자열 키가 전역 이름공간에서 공유된다는 점이다.

위의 방식이 의도대로 동작하려면 각 클라이언트가 고유한 키를 제공해야 한다.

두개 이상의 클라이언트가 서로 소통하지 못해 같은 키를 쓰게 된다면, 의도치 않게 변수를 공유하게 되며, 결국 두 클라이언트 모두 제대로 된 기능을 제공하지 못한다.

보안 또한 취약하다. 악의적인 클라이언트가 의도적으로 같은 키를 사용하여 다른 클라이언트의 값을 가져올 수 있다.

이 API는 문자열ㄷ ㅐ신 위조할 수 없는 키를 사용하면 해결되는데, 이 키를 권한(capacity) 라고도 한다.

```java
public class ThreadLocal {
    private ThreadLocal() { }

    public static class Key {
        Key() { }
    }
    
    public static Key getKey() {
        return new Key();
    }

    public static void set (Key key, Object value);
    public static Object get(Key key);
}
```

이 방법은 앞의 방법에서 보았던 문제점을 모두 해결해주지만, 개선이 필요하다.

`get` 과 `set` 은 정적 메서드일 이유가 없으니 Key클래스의 인스턴스 메서드로 변경한다.

이렇게 되면 `Key`는 더이상 쓰레드 ㅇ지역변수를 구분하기 위한 키가 아닌, 그 자체가 쓰레드 지역변수가 된다.

그렇다면 지금의 톱레벨 클래스 `ThreadLocal`은 할일이 없어지므로 중첩클래스인 `Key`의 이름을 `ThreadLocal`로 변경한다.

그럼 아래와 같이 변경된다.

```java
public final class ThreadLocal {
    public ThreadLocal();
    public void set(Object value);
    public Object get();
}
```

