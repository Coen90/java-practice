# Item07
## 다 쓴 객체 참조를 해제하라.

C 계열 언어처럼 직접 메모리를 관리해야하는 언어와 다르게 GC를 갖춘 자바를 사용하더라도 메모리 관리에 신경써야 한다.

```java
public class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e;
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        return elements[--size];
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```

위 코드에서 메모리 누수가 발생하는 경우가 있는데, pop 메서드에서 배열에서 객체를 꺼내고 나서 해당 객체를 다 쓴 후에도 스택에서 꺼내진 객체들을 참조하고 있기 때문이다.

이 스택을 사용하는 프로그램은 점차 메모리 사용량이 늘어나 OutOfMemoryError를 일으킬 가능성이 크다.

이러한 문제를 해결하기 위해 다 쓴 참조를 해제해야 한다.

위 스택은 간단하게 객체 참조를 null로 만들어 해제할 수 있다.

```java
public Object pop() {
    if (size == 0) {
        throw new EmptyStackException();
    }
    Object result = elements[--size];
    elements[size] = null; // 다 쓴 참조 해제
    return result;
}
```
아래는 실제 자바 라이브러리에서 사용하는 Stack 클래스의 pop 메서드이다.

```java
//Stack.java
public synchronized E pop() {
    E       obj;
    int     len = size();

    obj = peek();
    removeElementAt(len - 1);

    return obj;
}
```

```java
//Vector.java
public synchronized void removeElementAt(int index) {
    if (index >= elementCount) {
        throw new ArrayIndexOutOfBoundsException(index + " >= " +
                                                 elementCount);
    }
    else if (index < 0) {
        throw new ArrayIndexOutOfBoundsException(index);
    }
    int j = elementCount - index - 1;
    if (j > 0) {
        System.arraycopy(elementData, index + 1, elementData, index, j);
    }
    modCount++;
    elementCount--;
    elementData[elementCount] = null; /* to let gc do its work */
}
```

다 쓴 객체 참조를 null로 처리하면 GC가 해당 객체를 회수할 수 있다.

또한 해당 객체를 다시 사용하려고 할 때 NullPointerException이 발생할 수 있다.

하지만, 다 쓴 참조를 해제하는 가장 좋은 방법은 그 참조를 담은 변수를 유효 범위 밖으로 밀어내는 것이다.

변수의 범위를 최소가 되게 정의한다면 이 일은 자연스럽게 이루어진다.

상기 Stack 클래스는 스택이 자기 메모리를 직접 관리하기 때문에 메모리누수에 취약하다.

메모리 누수에 취약한 이유는 elements 배열로 저장소 풀을 만들어 원소를 관리하고, 비활성된 영역은 사용되지 않지만 GC는 이 사실을 알지 못하기 때문이다.

자기 메모리를 직접 관리하는 클래스라면 프로그래머가 메모리 누수에 주의해야 한다.

캐시 역시 메모리 누수를 일으키는 주범이다.

캐시 외부에서 키를 참조하는 동안만 엔트리가 살아 있는 캐시가 필요한 상황이라면 WeakHashMap을 사용해 캐시를 만들면 좋다.

메모리 누수의 세 번째 주범은 리스너 혹은 콜백이라 부르는 것들이다.

클라이언트가 콜백을 등록만 하고 명확히 해지하지 않는다면 콜백은 쌓여가는데, 콜백을 약한 참조로 저장하면 가비지 컬렉터가 수거해간다. ex) WeakHashMap에 키로 저장
