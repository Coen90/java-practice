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
15 = 1,973  
20 = 21,891  
30 = 2,692,537  

위와 같이 엄청나게 늘어난다.

재귀를 사용하지 않고 DP를 사용하면 반복적인 연산을 아낄수 있다.

다음은 DP를 사용한 피보나치 계산이다.

```java
private int fibonacci(int n) {
    if (dp[n] != -1) {
        return dp[n];
    }
    if (n <= 1) {
        return n;
    }
    return dp[n] = (fibonacci(n - 2) + fibonacci(n - 1)) % 1_234_567;
}
```

DP를 사용한 피보나치의 콜스택은 다음과 같다

20 = 39

30 = 59

어마어마한 차이이다.

DP를 사용하기 위해서는 메모이제이션(memoization) 이라는 기법을 사용하게 된다.  

간단하게 말하면 한 번 풀었던 부분의 답을 저장해두는 것이다.

규칙을 잘 찾아내어 규칙적으로 적어놨다가 반복적으로 필요할때 잘 꺼내쓰면 된다..!