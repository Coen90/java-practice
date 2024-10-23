# 피보나치 수열
## 피보나치 수열이란?

피보나치 수열은 앞의 두 수를 더해서 다음 수를 만드는 수열이다. 

처음 두 항은 1과 1로 시작한다.

1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, ...

재귀를 사용해 구현한 피보나치 수열은 다음과 같다.

```java
private static int fibonacci(int i) {
    if (i  <= 1) {
        return i;
    }
    return fibonacci(i - 2) + fibonacci(i - 1);
}
```

재귀를 사용했을 때 단점은 call stack 카운트가 어마어마하게 늘어나 stack overflow가 발생할 수 있다.

파라미터 별 call stack count  
10 = 177   
15 = 1973  
20 = 21891  

위와 같이 엄청나게 늘어난다.