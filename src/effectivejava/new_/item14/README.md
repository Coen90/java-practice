# Item14
## Comparable을 구현할지 고려하라

Comparable 인터페이스는 compareTo 메서드 단 하나만 가지고 있다.

Object의 메서드가 아니지만 몇 가지를 제외하면 Object의 equals와 같다.

1. compareTo는 동치성 비교와 순서까지 비교가 가능하며 제네릭하다.
2. Comparable을 구현했다는 것은 그 클래스의 인스턴스들에는 자연적인 순서(natural order)가 있음을 뜻한다.

Comparable을 구현한 객체들의 배열은 Arrays.sort나 Collections.sort를 사용해 간단하게 정렬할 수 있다.

Comparable을 구현하면 검색, 극단값 계산, 자동 정렬되는 컬렌션 관리 등을 간단하게 할 수 있다.

### compareTo 메서드의 일반 규약

> 이 객체와 주어진 객체의 순서를 비교한다. 이 객체가 주어진 객체보다 작으면 음의 정수를, 같으면 0을, 크면 양의 정수를 반환한다.

- x, y에 대해 s.compareTo(y) == -y.compareTo(x)를 만족한다.(예외가 발생하면 두 경우 다 발생해야 한다)
  - 두 객체 참조의 순서를 바꿔도 예상한 결과가 나와야 한다.
- x.compareTo(y) > 0 && y.compareTo(z) > 0이면 x.compareTo(z) > 0이다.(추이성 보장)
  - 추이성 : 첫 번째가 두번째보다 크고, 두번째가 세번째보다 크면 첫번째가 세번째보다 커야 한다.
- (❌필수 아님!❌) x.compareTo(y) == 00이면 x.equals(y) 여야 한다.(equals와 일관성)
  - 크기가 같은 객체들끼리는 어떤 객체와 비교하더라도 항상 같아야 한다.
  - 필수는 아니지만 권고가 되며, 지키지 않는다면 그 내용을 문서에 명시해야 한다.
  - 컬렉션이 구현한 인터페이스는 equals 메서드 규약을 따른다.
    - 규약을 따르지 않은 BigDecimal. TreeSet은 compareTo로 비교하기 때문에 TreeSet에 BigDecimal을 넣으면 중복된 값이 들어갈 수 없지만 Set은 들어갈 수 있음! 

기존 클래스를 확장한 구체 클래스에서 새로운 값 컴포넌트를 추가했다면 compareTo 규약을 지키기 어려울 수 있다.

이런 경우에는 클래스를 확장하지 않고 클래스 내부에 기존 클래스의 인스턴스를 가리키는 필드를 둔다. 이후 내부 인스턴스를 반환하는 `뷰` 메서드를 제공한다.

- compareTo에서 기본 타입 필드를 비교할 때는 `>` `<` `=` 등의 연산자를 사용하지말고 `Type.compare` 메서드를 사용하자.

- 클래스의 가장 핵심적인 필드부터 비교해 나가자.

- 비교자 생성 메서드를 사용해 메서드 체이닝 방식으로 비교자를 생성할 수 있다.(약간의 성능 저하가 발생할 수 있음)

    ```
    //compareTo 메서드를 사용한 비교자
    @Override
    public int compare(PhoneNumber o1, PhoneNumber o2) {
        int result = Short.compare(o1.areaCode, o2.areaCode);
        if (result == 0) {
            result = Short.compare(o1.prefix, o2.prefix);
            if (result == 0) {
                result = Short.compare(o1.lineNum, o2.lineNum);
            }
        }
        return result;
    }
    
    //비교자 생성 메서드를 사용한 비교자
    @Override
    public int compare(PhoneNumber o1, PhoneNumber o2) {
        return Comparator.comparingInt((PhoneNumber pn) -> pn.areaCode) //pn의 타입을 알려줘야 한다. 아래부터는 타입 추론 가능
                .thenComparing(pn -> pn.prefix)
                .thenComparing(pn -> pn.lineNum)
                .compare(o1, o2);
    }
  ```

객체 참조용 비교자 생성 메서드도 있는데, 자세한 사용방법은 그리 중요하진 않은것 같아 사용 예시만 확인해 보고 넘어가겠다.

```java
Comparator<Object> comparing = Comparator.comparing(o -> o.hashCode());
Comparator<Object> comparing1 = Comparator.comparing(o -> o.hashCode(), (o1, o2) -> {
    return o2 - o1;
});
System.out.println(comparing.compare(1, 2)); //-1
System.out.println(comparing1.compare(1, 2)); //1
```

사실 위 예시에서 사용한 comparing1 에서 사용한 `o2 - o1`은 사용하면 안되는 방식이라고 한다..! (코딩테스트에서 자주 사용하던 방법인데 알아둬야겠다)

이유는 정수 오버플로우를 일으키거나 부동소수점 계산 방식에 따른 오류를 낼 수 있다. 그러니 아래와 같은 방법을 사용하도록 하자.

```java
Comparator<Object> comparator = new Comparator<>() {
    @Override
    public int compare(Object o1, Object o2) {
        return Integer.compare(o1.hashCode(), o2.hashCode());
    }
};
Comparator<Object> comparator1 = Comparator.comparingInt(Object::hashCode);
```

## 결론

`>` `<` 비교는 하지말고, compare에서 `-`를 사용한 연산 대신 래퍼타입 변수의 compare를 사용해 비교하자.

객체 비교자 생성 메서드도 있으니 취향에 맞는 방법을 사용하자~

대신 성능이 중요하다면 그냥 래퍼타입의 compare를 사용하자