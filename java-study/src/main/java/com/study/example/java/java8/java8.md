# java 8 study

## 함수형 인터페이스 (Functional Interface)

- 추상 메소드를 1개만 가지고 있는 인터페이스
- SAM(Single Acstract Method) 인터페이스
- @FunctionalInterface 가진 인터페이스


## 람다 표현식 (Lambda Expressions)
- 함수형 인터페이스의 인스턴스를 만드는 방법으로 쓰일 수 있다.
- 코드를 줄일 수 있다.
- 메소드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.

## 자바에서 함수형 프로그래밍
- 함수를 First class object로 사용할 수 있다.
- 순수 함수 (Pure function)
  + 사이드 이팩트가 없다. (함수 밖에 있는 값을 변경하지 않는다.)
  + 상태가 없다. (함수 밖에 있는 값을 사용하지 않는다.)
- 고차 함수 (Higher-Order Function)
  + 함수가 함수를 매개변수로 받을 수 있고 함수를 리턴할 수도 있다.
- 불변성

## 자바에서 제공해주는 함수형 인터페이스
Java가 기본으로 제공하는 함수형 인터페이스  
자바에서 미리 정의해둔 자주 사용할만한 함수 인터페이스

### Function<T, R>
- T 타입을 받아서 R 타입을 리턴하는 함수 인터페이스
  - R apply(T t)
- 함수 조합용 메소드
  - andThen : 앞에 있는 함수 후 뒤에 있는 함수
  - compose : 뒤에 있는 함수 후 앞에 있는 함수

### BiFunction<T, U, R>
- 두 개의 값(T, U)를 받아서 R 타입을 리턴하는 함수 인터페이스
  - R apply(T t, U u)

### Consumer<T>
- T 타입을 받아서 아무값도 리턴하지 않는 함수 인터페이스
  - void Accept(T t)
- 함수 조합용 메소드
  - andThen

### Supplier<T>
- T 타입의 값을 제공하는 함수 인터페이스
  - T get()

### Predicate<T>
- T 타입을 받아서 boolean을 리턴하는 함수 인터페이스
  - boolean test(T t)
- 함수 조합용 메소드
  - And
  - Or
  - Negate : Not

### UnaryOperator<T>
- Function<T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 리턴하는 함수
인터페이스
- Function 입력값과 결과값의 타입이 동일할때

### BinaryOperator<T>
- BiFunction<T, U, R>의 특수한 형태로, 동일한 타입의 입렵값 두개를 받아 리턴하는 함수
인터페이스
- BiFunction 3개의 타입이 동일할때

## 람다 표현식
- (인자 리스트) -> { 바디 }
- 인자 리스트
  - 인자가 없을 때: ()
  - 인자가 한개일 때: (one) 또는 one
  - 인자가 여러개 일 때: (one, two)
  - 인자의 타입은 생략 가능, 컴파일러가 추론(infer)하지만 명시할 수도 있다. (Integer one,
  Integer two)
- 바디
  - 화상표 오른쪽에 함수 본문을 정의한다.
  - 여러 줄인 경우에 { }를 사용해서 묶는다.
  - 한 줄인 경우에 생략 가능, return도 생략 가능

- 변수 캡처 (Variable Capture)
  - 로컬 변수 캡처
    - final이거나 effective final 인 경우에만 참조할 수 있다.
    - 그렇지 않을 경우 concurrency 문제가 생길 수 있어서 컴파일가 방지한다.
  - effective final
    - 이것도 역시 자바 8부터 지원하는 기능으로 “사실상" final인 변수.
    - final 키워드 사용하지 않은 변수를 익명 클래스 구현체 또는 람다에서 참조할 수
    있다.
  - 익명 클래스 구현체와 달리 ‘쉐도윙’하지 않는다.
    - 익명 클래스는 새로 스콥을 만들지만, 람다는 람다를 감싸고 있는 스콥과 같다.

## 메소드 레퍼런스
- 람다가 하는 일이 기존 메소드 또는 생성자를 호출하는 거라면, 메소드 레퍼런스를 사용해 매우 간결하게 표현할 수 있다.
- 메소드 참조 하는 방법
  - 스태틱 메소드 참조 - 타입::스태틱메소드
  - 특정 객체의 인스턴스 메소드 참조 - 객체 레퍼런스::인스턴스 메소드
  - 생성자 참조 - 타입::new
  - 임의객체의 인스턴스 메소드 참조 - 타입::인스턴스 메소드

## 기본 메소드(Default Method)

- 인터페이스에 메소드 선언이 아니라 구현체를 제공하는 방법
- 해당 인터페이스를 구현한 클래스를 깨트리지 않고 새 기능을 추가할 수 있다.
- 기본 메소드는 구현체가 모르게 추가된 기능으로 그만큼 리스트가 있다.
  - 컴파일 에러는 아니지만 구현체에 따라 런타임 에러가 발생할수 있다.
  - 반드시 문서화 할것
- Object가 제공하는 기능(eqauls, hasCode 등)은 기본 메소드로 제공할수 없다.
  - 구현체가 재정의해야 한다.
- 본인이 수정할 수 있는 인터페이스에만 기본 메소드를 제공 할수 있다.
- 인터페이스를 상속 받는 인터페이스에서 다시 추상 메소드로 변경할 수 있다.
- 인터페이스 구현체가 재정의 할 수도 있다.

## 스태틱 메소드
- 해당 타입 관련 헬퍼 또는 유틸리티 메소드를 제공할때 인터페이스에 스태틱 메소드를 제공할 수 있다.


## Stream API

### Stream
- 데이터를 담고 있는 저장소(컬렉션)이 이낟.
- 스트림이 처리하는 데이터 소스를 변경하지 않는다.
- 스트림으로 처리하는 데이터는 오직 한번만 처리한다.
- 무제한 일 수도 있다.
- 중개 오퍼레이션은 근본적으로 lazy하다.
- 손쉽게 병렬 처리 가능

### 스트림 파이프라인
- 0 또는 다수의 중개 오퍼레이션(intermediate operation)과 한개의 종료 오퍼레이션(terminal operation)으로 구성
- 스트림 데이터 소스는 오직 종료 오퍼레이션을 실행할 때에만 처리한다.
### 중개 오퍼레이션(intermediate operation)
- Stream을 리턴
- Stateless / Stateful 오퍼레이션으로 더 상세하게 구분할 수도 있다.
  (대부분은 Stateless지만 distinct나 sorted처럼 이전 소스 데이터를 참조해야 하는 경우는 stateful 오퍼레이션)
- ex) filter, map, limit, skip , sorted ...
### 종료 오퍼레이션(terminal operation)
- Stream을 리턴하지 않음
- ex) collect, allMatch, count, forEach, min, max ...

## Optional 소개
- 메소드에서 작업 중 특별한 상황에서 값을 제대로 리턴할수 없는 경우 선택할수 있는 방법
  - 예외를 던진다(비싸다, 스택트레이스를 찍으니깐)
  - null을 리턴한다(비용문제는 없지만 코드를 주의해야한다.)
  - Optional을 리턴한다.(클라이언트에 코드에게 명시적으로 빈값일수도 있다는걸 알려주고, 빈값인 경우에 대한 처리를 강제한다.)
- Optional : 오직 값 한개가 들어 있을수도 없을 수도 있는 컨테이너
- 주의할 것
  - 리턴 값으로만 쓰기를 권장(메소드 매개변수 타입, 맵의 키 타입, 인스턴스 필드 타입으로 쓰지말자)
  - Optional을 리턴하는 메소드에서 null을 리턴하지 말자
  - 프리미티브 타입용 Optional 따로 존재(OptionalInt, OptionalLong ...)
  - Collection, Map, Stream, Array, Optional은 Optional로 감싸지 말 것.

## Date/Time API


### 자바 8에 새로운 날짜와 시간 API가 생긴 이유

- 그 전까지 사용하던 java.util.Date 클래스는 mutable하기 때문에 thread safe 하지 않다.
- 클래스 이름이 명확하지 않다. Date인데 시간까지 다룬다.
- 버그 발생할 여지가 많다.(타입 안정성이 없고, 월이 0부터 시작..)
- 날짜 시간 처리에 복잡한 애플리케이션에서는 보통 Joda Time을 쓰곤 했다.


- Instant.now() : 현재 UTC(GMT)를 리턴
- Universal Time Coordinated == Greenwich Mean Time
- 인류용 일시를 표현하는 방법
  - LocalDateTime.now() : 현재 시스템 Zone에 해당하는 일시를 리턴
  - LocalDateTime.of() : 로컬의 특정 일시를 리턴
  - ZonedDateTime.of() : 특정 Zone의 특정 일시를 리턴
- 기간을 표현하는 방법
  - Period / Duration : between
- 파싱 또는 포매팅

```
        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println(dateTime.format(dateTimeFormatter));

        LocalDate parse = LocalDate.parse("07/15/1982", dateTimeFormatter);
        System.out.println(parse);
```
- 레거시 API 지원
  - GregorianCalendar와 Date 타입의 인스턴스를 Instant나 ZonedDateTime으로 변환가능
  - java.util.TimeZone에서 java.time.ZoneId로 상호 변환 가능

## CompletableFuture : 자바 Concurrent 프로그래밍 소개
### 자바 Concurrent 프로그래밍

- Concurrent 소프트웨어 : 동시에 여러 작업을 할 수 있는 소프트웨어
- 자바에서 지원하는 Concurrent 프로그래밍
  - 멀티프로세싱(ProcessBuilder)
  - 멀티쓰레드
- 자바 멀티쓰레드 프로그래밍
  - Thread/Runnable
- Thread 상속
```
    static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Thread : " + Thread.currentThread().getName());
        }
    }
```
- Runnable 구현 또는 람다
```
Thread thread = new Thread(() -> System.out.println("world : " + Thread.currentThread().getName()));

```
- 쓰레드 주요 기능
  - sleep : 현재 쓰레드 멈춰두기
  - interrupt : 다른 쓰레드 깨우기 / 쓰레드를 깨워서 interruptedException 발생
  - join : 다른 쓰레드가 끝날때까지 기다린다.

### Executors
- 고수준(High-Level) Concurrency 프로그래밍
  - 쓰레드를 만들고 관리하는 작업을 애플리케이션에서 분리
  - 그런 기능을 Executors에게 위임
- Executors가 하는 일
  - 쓰레드 만들기 : 애플리케이션이 사용할 쓰레드 풀을 만들어 관리한다.
  - 쓰레드 관리 : 쓰레드 생명 주기 관리
  - 작업 처리 및 실행 : 쓰레드로 실행할 작업을 제공할 수 있는 API 제공
- 주요 인터페이스
  - Executor: execute(Runnable)
  - ExecutorService : Executor 상속 받은 인터페이스로 Callable도 실행 할수 있으며, Executor를 종료 시키거나 여러 Callable을 동시에 실행하는 등의 기능 제공
  - ScheduledExecutorService : ExecutorService를 상속 받은 인터페이스로 특정 시간 이후에 또는 주기적으로 작업 실행
- ExecutorService로 작업 실행
```
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Thread : " + Thread.currentThread().getName());
            }
        });
        executorService.submit(() -> {
            System.out.println("Thread : " + Thread.currentThread().getName());
        });

```

- ExecutorService로 작업 멈추기
```
        executorService.shutdown(); //처리 중인 작업 기다렸다가 종료
        executorService.shutdownNow(); // 당장 종료
```

### Callable과 Future
- Callable : Runable과 유사하지만 작업의 결과를 받을 수 있다.
- Future
  - 비동기적인 작업의 현재 상태를 조회하거나 결과를 가져올 수 있다.
- 결과 가져오기 get()
  - 블록킹 콜
  - 타임아웃을 설정할수 있다.
- 작업 상태 확인 isDone() : 완료 시 true 리턴
- 작업 취소 cancel()
  - 취소 했으면 true 리턴
- 여러 작업 동시에 실행 invokeAll()
  - 동시에 실행한 작업 중에 제일 오래걸리는 작업만큼 시간이 걸림
- 여러 작업 중에 하나라도 먼저 응답이 오면 끝내기 invokeAny()
  - 동시에 실행 한 작업 중에 제일 짧게 걸리는 작업만큼 시간이 걸림
  - 블록킹 콜

## CompletableFuture
- 자바에서 비동기 프로그래밍을 가능케하는 인터페이스
- Future로는 하기 어렵던 작업들
  - Future를 외부에서 완료 시킬수 없다. 취소하거나 get()에 타임아웃을 설정할 수는 있다.
  - 블로킹코드(get())을 사용하지 않고는 작업이 끝났을때 콜백을 실행할수 없다.
  - 여러 Futrue를 조합 할수 없다.
  - 예외 처리용 API를 제공하지 않는다.
- 비동기로 작업 실행
  - runAsync() : 리턴값이 없는 경우
  - supplyAsync() : 리턴값이 있는 경우
  - 원하는 Executor(쓰레드풀)을 사용해서 실행 가능(기본은 ForkJoinPool)
- 콜백 제공
  - thenApply(Function) : 리턴값을 받아서 다른 값으로 바꾸는 콜백
  - thenAccept(Consumer) : 리턴값을 또 다른 작업을 처리하는 콜백(리턴없이)
  - thenRun(Runnable) : 리턴값 받고 다른 작업을 처리하는 콜백
  - 콜백 자체를 또 다른 쓰레드에서 실행 할 수 있다.
- 조합
  - thenCompose() : 두 작업이 서로 이어서 실행하도록 조합
  - thenCombine() : 두 작업을 독립적으로 실행하도 둘다 종료 했을때 콜백 실행
  - allOf() : 여러 작업을 모두 실행하고 모든 작업 결과에 콜백 실행
  - anyOf() : 여러 작업 중에 가장 빨리 끝난 하나의 결과에 콜백 실행
- 예외처리
  - exeptionally()
  - handle()
  
## Metaspace
- JVM의 여러 메모리 영역 중에 PermGen 메모리 영역이 없어지고 Metaspace 영역이 생겼다.
- PermGen
  - permanent generation, 클래스 메타데이터를 담는 곳.
  - Heap 영역에 속함
  - 기본값으로 제한된 크기를 가지고 있음.
  - -XX:PermSize=N, PermGen 초기 사이즈 설정
  - -XX:MaxPermSize=N, PermGen 최대 사이즈 설정
- Metaspace
  - 클래스 메타데이터를 담는 곳
  - Heap 영역이 아니라, Native 메모리 영역이다.
  - 기본값으로 제한된 크기를 가지고 있지 않다.(필요한 만큼 계속 늘어난다.)
  - 자바 8부터는 PermGen 관련 Java 옵션은 무시한다.
  - -XX:MetaspaceSize=N, Metaspace 초기 사이즈 설정
  - -XX:MaxMetaspaceSize=N, Metaspace 최대 사이즈 설정