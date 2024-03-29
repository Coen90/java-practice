# [Item 73] 추상화 수준에 맞는 예외를 던지라

수행하려는 일과 관련 없어 보이는 예외가 튀어나오면 당황스러울 것이다. 메서드가 저수준 예외를 처리하지 않고 바깥으로 전파해버릴 때 종종 일어나는 일이다.

이는 내부 구현 방식을 드러내어 윗 레벨 API를 오염시킨다.

구현 방식을 바꾸면 다른 예외가 튀어나와 기존 클라이언트 프로그램을 깨지게 할 수도 있는 것이다.

이러한 문제를 피하려면 상위 계층에서는 저수준 예외를 잡아 자신의 추상화 수준에 맞는 예외로 바꿔 던져줘야 한다.

이를 `예외번역(exception translation)` 이라고 한다.

```java
try{
    ...
} catch (LowerLevelException e) {
    throw new HigherLevelException("...");
}
```

```java
public abstract class AbstractSequentialList<E> extends AbstractList<E> {

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     *         (index < 0 || index >= size())
     */
    public E get(int index) {
        try {
            return listIterator(index).next();
        } catch (NoSuchElementException exc) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
    }
}
```

위 두가지 코드가 예외번역의 예시이다.

예외를 번역할 때 저수준 예외가 디버깅에 도움이 된다면 `예외 연쇄(exception chaining)` 를 사용하는 게 좋다.

### 예외연쇄란

- 문제의 근본 원인인 저수준 예외를 고수준 예외에 실어 보내는 방식이다.
- 예외 연쇄를 사용하면 별도의 접근자 메서드(Throwable의 getCause 메서드)를 통하여 필요할 때 언제든 저수준 예외를 꺼내 볼 수 있다.

```java
// exception chaining 예시
try{
    ...
} catch (LowerLevelException e) {
    throw new HigherLevelException(e);
}
```

- 대부분의 표준 예외는 예외 연쇄용 생성자를 갖고 있다.
- 예외 연쇄는 문제의 원인을 (getCause 메서드로) 프로그램에서 접근할 수 있게 해주며, 원인과 고수준 예외의 스택 추적 정보 통합해준다.
- 예외를 전파하는 것보다 예외 번역하는 것이 우수한 방법이지만 남용해서는 안된다.
- 가능하다면 저수준 메서드가 반드시 성공하도록하여 아래 계층에서는 예외가 발생하지 않도록 하는 것이 최선이다.
- 때로는 상위 계층 메서드의 매개변수 값을 아래 계층 메서드로 건내기 전에 미리 검사하는 방법으로 목적을 달성할 수 있다.
- 차선책
  - 아래 계층에서의 예외를 피할 수 없다면, 상위 계층에서 그 예외를 조용히 처리하여 문제를 API 호출자에까지 전파하지 않는 방법이 있다.
  - 이러한 경우 java.util.logging 같은 적절한 로깅 기능을 활용하여 기록하는 것이 좋다.
  - 클라이언트 코드와 사용자에게 문제를 전파하지 않으면서 프로그래머가 로그를 분석해 추가 조치를 취할 수 있도록 해주기 때문이다.

## 정리

- 아래 계층의 예외를 예방하거나 스스로 처리할 수 없고, 그 예외를 상위 계층을 그대로 노출하기 곤란하다면 예외 번역을 사용하라
- 예외 연쇄를 이용하면 상위 계층에는 맥락에 어울리는 고수준 예외를 던지면서 근본 원인도 함께 알려주어 오류를 분석하기에 좋다.