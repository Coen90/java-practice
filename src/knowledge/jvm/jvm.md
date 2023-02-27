# JVM 

## Heap
Heap은 JVM에서 실행되는 Java 프로그램에 할당되는 메모리 영역 중 하나입니다.  
객체들의 인스턴스를 저장하고 관리하는 영역입니다.  
Heap 영역은 크게 Young, Old, Permanent 세 영역으로 나뉩니다.

1. Young 영역
- JVM Heap에서 가장 작은 영역으로, 새로 생성된 객체들이 할당됩니다.
- Young 영역은 세 영역으로 나뉩니다. Eden, Survivor 0, Survivor 1
- Eden 영역은 새로 생성된 객체들이 할당되는 곳입니다. Eden 영역이 가득차면, 살아남은 객체들은 Survivor 0, Survivor 1 영역 중 하나로 이동합니다.
- 이 영역들 둥 하나는 항상 비어있습니다. 객체들은 살아남은 횟수를 기록하며, 살아남은 횟수가 일정 이상 되는 객체는 Old 영역으로 이동합니다.

2. Old 영역
- Old 영역은 크게 Large Object Space와 Tenured 영역으로 나뉜다.
- Large Object Space는 큰 객체들이 할당되는 공간입니다.
- Tenured 영역은 Old 영역에서 살아남은 객체들이 할당되는 공간입니다. Old 영역이 가득차면 GC가 Old 영역에서 살아남은 객체들을 제거하면서 메모리를 해제합니다.

3. Permanent 영역
- JVM 내부에서 클래스 정보, 메소드 정보 등의 메타데이터가 저장되는 공간입니다.
- 자바8 부터 Permanent 영역이 제거되고, MetaSpace라는 새로운 영역이 추가되었습니다.
- MetaSpace는 Classloader가 로드한 class 들의 metadata가 저장되는 공간이다.
- Permenant는 Heap영역이었지만 MetaSpace는 Native Memory에 위치한다.  


## GC

위에서 이야기한 바와 같이 Heap에서는 GC가 일어난다.

Young 영역에서 발생하는 GC는 Minor GC, Old 영역에서 발생하는 GC는 Major GC 혹은 Full GC 라고 한다.

1. Minor GC
- 새로운 객체가 Eden 영역에 할당될 때, Eden 영역이 가득 차면 Minor GC가 발생한다.
- 대상은 Eden 영역에 존재하는 모든 객체, Survivor 영역에 존재하는 더 이상 참조되지 않는 개체 모두이다.
- 살아남은 객체들은 다른 Survivor 영역으로 이동한다.

2. Major GC(Full GC)
- Old 역역이 가득 차게 되면 Major GC가 발생한다.
- Major GC가 발생하면 Young 영역을 포함한 전체를 대상으로 GC가 수행된다.
- Young 영역이 비어있어도 GC의 대상이 된다.

GC는 실행되는 동안 객체의 레퍼런스 관계를 변경할 수 없기 때문에 JVM의 모든 쓰레드를 일시 중지시키는데, 이를 STOP THE WORLD라고 한다.

