# 1장 - 사용자 수에 따른 규모 확장성

한 명의 사용자를 지원하는 시스템에서 시작하여, 최종적으로 몇백만 사용자를 지원하는 시스템을 설계한다.

## 단일서버

- 사용자가 적은 경우, 단일 서버로 충분하다.
- 웹 앱, 데이터베이스, 캐시 등 모두 서버 한 대에서 실행된다.

## 데이터베이스

사용자가 늘어나면 서버 하나로는 충분하지 않아 여러 서버를 두어야 한다.

웹/모바일 트래픽 처리와 데이터베이스용 서버를 분리한다.

### 데이터베이스 선택

관계형 데이터베이스와 NoSQL 데이터베이스 중 어떤 것을 선택할지 결정해야 한다.

NoSQL은 Key-Value Store, Document Store, Column Store, Graph Store 로 나뉜다.

대부분의 개발자에게는 SQL이 최선이지만 아래와 같은 경우 NoSQL을 선택을 고려할 수 있다.

- 아주 낮은 응답 지연시간(Latency)이 요구됨
- 다루는 데이터가 비정형(unstructured)이라 관계형 데이터가 아님
- 데이터를 직렬화하거나 역직렬화 할 수 있기만 하면 됨
- 아주 많은 양의 데이터를 저장할 필요가 있음

## 수직적 규모 확장(Scale up) vs 수평적 규모 확장(Scale out)

서버로 유입되는 트래픽의 양이 적을때는 수직적 확장이 좋은 선택이며 가장 큰 장점은 단순함이다.

단점
- 한 대의 서버에 CPU나 메모리를 무한대로 증설할 수 없다.
- 장애에 대한 자동복구(failover)방안이나 다중화(re-dundancy) 방안을 제시하지 않는다. 장애 발생 시 서비스는 완전히 중단된다.
- 