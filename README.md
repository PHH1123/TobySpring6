# 토비의 스프링6
격주 단위로 개인 학습 후 스터디 진행

- 강의 프로젝트
  - 스프링 - 6
  - 스프링 부트 - 3
  - JDK - 17

- 내 프로젝트
  - 스프링 - 7.0.9
  - 스프링 부트 - 4.1.1
  - JDK - 25

## Week 1~2
### Gradle

---
- 현재 프로젝트 빌드는 Gradle(기본값)이다.
- Gradle로 빌드를 하게 되면 더 느리기도 하고 출력 결과에 현재는 불필요한 결과들이 많이 출력된다.

### 스프링 부트

---
- 스프링 버전과 스프링 부트 버전의 차이를 구분하지 않고 말하는 사람이 있다.
- 서로 의미는 통하겠지만 정확히 알고 사용하는 것이 좋다.

### 필드 자료형 - 소수

---
- 부동 소수점 (Double)
  - Double형은 부동 소수점으로 메모리에는 효율적이다.
  - 하지만 계산에서 오차가 발생할 수 있다.
- 고정 소수점 (BigDecimal)
  - `java.math.BigDecimal`
  - 절대 오차가 생기면 안되는 금액 계산 같은 경우에는 고정 소수점 방식을 사용한다.

### JSON - ObjectMapper

---
- JSON 형식의 데이터를 자바 객체로 변환하기 위해 Jackson 라이브러리의 ObjectMapper를 사용한다.
- 강의 버전에서는 사용하지 않는 데이터는 ignore 처리를 해줘야 한다.
  - `@JsonIgnoreProperties(ignoreUnknown = true)`
  - `Jackson 3.0` 부터는 자동으로 필드로 선언되지 않은 필드는 ignore 처리가 된다.




[//]: # (----------------------------------------------------------------------------------)




## Week 3~4

### 오브젝트와 의존관계

#### 클래스
오브젝트를 만들기 위한 청사진

#### 오브젝트
프로그램을 실행했을 때 실제 동작하는 것 

오브젝트는 클래스의 인스턴스 또는 배열(Array)이다.

#### 인스턴스
런타임에서의 클래스의 실체

#### 오브젝트와 인스턴스의 관계
오브젝트는 인스턴스의 상위 개념

#### 의존관계
`A -> B` A는 B를 의존한다. 라고 표현

여기서 A는 B를 사용하므로 `Client`라고 볼 수 있고,

B는 A에게 무엇을 제공해주므로 `Supplier`라고 볼 수 있다. 

여기서 의존 관계는 `클래스 의존관계`와 `오브젝트 의존관계`가 있다.

##### 클래스 의존관계
클래스 의존관계는 코드로 직접 확인할 수 있다.
##### 오브젝트 의존관계
오브젝트 의존관계는 런타임에서 동적으로 달라질 수 있으므로 한 번에 파악하기 힘들다.

### 관심사의 분리
굉장히 오래된 개발 방법이고 현재까지 사용 중이다.

여러 가지의 로직들이 분리되지 않고 하나로 묶여있는 것인데
예를 들어, 비즈니스 로직과 DB에 쿼리를 날리는 게 한 클래스 또는 한 메서드안에 묶여있는 것이다.

이러면 코드를 이해하기 굉장히 힘들어지므로 관심사가 서로 다른 것들은 메서드별, 클래스별, 패키지별로 분리하는 것이 좋고, 심하게는 서버를 나눌 수도 있다.

#### 관심사의 분리 효과
- 재사용성
  - 만약 서비스를 다른 곳에 판매해서 사용하게 된다면 해당 메서드를 

#### 관심사의 분리 방법

##### 추상 클래스
- Abstract 클래스를 만들어서 Abstract 메서드를 만드는 것
- 단점으로는 굉장히 강한 결합을 만든다. 
- 예를 들어, 추가적인 정책으로 추상 메서드가 생긴다면 추상 클래스를 상속한 모든 자식 클래스에 추상 메서드를 구현해야 한다.

##### 인터페이스
- 인터페이스를 만들고 구현 클래스를 만들어 사용
- 대부분의 경우 상속보다는 인터페이스를 구현하여 사용하는 방식을 더 많이 사용한다.


### 객체지향
#### OCP(Open-Closed Principle) 
`개방 폐쇄 원칙`은 `확장은 열려있고, 변경은 닫혀있다.` 라는 의미이다.

쉽게 말하면 `클래스를 확장하는 것은 허용`되지만 확장 함에 따른 `다른 클래스에서 변경이 발생하면 안된다`는 의미이다.

#### 높은 응집도, 낮은 결합도
##### 응집도
응집도는 한 클래스 안에 관련된 기능이 모여있는 것을 말한다.

- `높은 응집도`는 한 클래스 안에 관련된 기능이 있어 변경이 필요하다면 해당하는 클래스만 변경하면 되므로 비용이 낮다.
- 반대로, `낮은 응집도`는 하나의 기능의 변경이 필요할 때 다른 클래스의 변경도 필요하므로 비용이 높아진다.

##### 결합도
결합도는 클래스 안에 다른 클래스를 의존하는 것을 말한다.

- 결합도는 완전히 제거하기 어렵다. 
- 하지만 결합도를 낮게 유지하는 것은 가능하다.
- `높은 결합도`는 다른 클래스의 인스턴스를 직접 생성하여 사용 사용하는 것을 예로 들 수 있다.
  이 경우 클래스의 변경이 필요하다면 인스턴스가 사용하는 메서드까지 모두 바꿔야 할 수 있다.
- `낮은 결합도`는 인터페이스를 사용하여 구현 클래스만 바꿔 사용할 수 있고,
  `더 낮은 결합도`는 구현 클래스도 이를 호출하는 클라이언트 쪽에서 넘겨주는 방식으로 사용할 수 있다.

#### 전략 패턴
상황에 따라 다른 알고리즘을 사용하는 것이다.

상황에 따라 `AImpl.java` 를 사용할 수 있고, `BImpl.java`를 사용할 수 있다.

#### IoC(Inversion of Control)
제어의 역전은 우리가 직접 객체를 관리하지 않고 다른 누군가에게 관리를 이전하는 것을 말한다.

- 우리는 직접 `Main` 메서드에서 인스턴스를 생성하고 이를 넘겨줄 수 있다.
- 하지만 `ObjectFactory`라는 클래스에 인스턴스를 생성하는 역할을 넘기면 이를 제어의 역전이라고 말한다.
- 보통 프레임워크는 이러한 객체 관리를 개발자가 하지 않고 프레임워크가 관리한다. 그래서 프레임워크의 기본은 제어의 역전이다.

##### 스프링 프레임워크 관점
- 스프링 프레임워크에서는 제어의 역전이 조금 다르다.
- 스프링 프레임워크는 IoC를 사용하지만 `객체의 생성`, `생명 주기 관리`가 주이다.
- 그러므로, 스프링 프레임워크는 IoC이면서 이를 더 자세하게 `DI(Dependency Injection)`라고 부른다.
- 정확히는 `IoC를 하기 위해 DI를 한다고 보면 될 것 같다.`

#### 싱글톤 패턴
싱글톤 패턴은 하나의 인스턴스만 만들어서 공유하는 것이다.
- 싱글톤 패턴을 간단하게 `static 정적 변수`로 만들어서 `getInstance()`를 통해 사용할 수 있다.
- 하지만 싱글톤 패턴은 결합성이 높아지고 인스턴스를 private으로 만들기 때문에 상속이 어려워 객체지향에서 좋지 않으며 테스트하기가 힘들다.

##### 스프링의 싱글톤 패턴
- 스프링은 싱글톤 패턴을 사용하지만 static으로 만드는 등의 방식이 아니다.
- 스프링 컨테이너를 통해 관리한다.
- 그래서 인터페이스를 이용한 DI를 통해 결합성을 해결하고, public 생성자를 사용하기 때문에 상속이 가능하며, 테스트에서는 new로 인스턴스를 생성하거나 또는 mock을 사용하여 해결했다.

#### 데코레이터 패턴
데코레이터 패턴은 이미 만들어진 클래스에 기능을 데코(추가)하는 것을 말한다.

- 기존 클래스를 수정하거나 상속할 필요가 없다.
- 단순히 기존 클래스와 똑같은 인터페이스를 구현하고 기존 클래스를 호출한 후 추가하면 된다.
- 단점으로는 빈에 등록해야하는 객체가 하나 더 늘어난다.

#### DIP(Dependency Injection Principal)
의존성 역전 원칙은 다음을 지켜야 한다.
1. 상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안 된다.
   둘 모두 추상화에 의존해야 한다.
2. 추상화는 구체적인 사항에 의존해서는 안 된다.
   구체적인 사항은 추상화에 의존해야 한다.

- `상위 수준의 모듈은 하위 수준의 모듈에 의존해서는 안 된다.`의 뜻은 `A`가 구현 클래스 `B`를 호출한다고 했을 때
- `A`는 구현 클래스 `B`가 아닌 인터페이스 `I`를 의존해야 한다.
- 그리고 `I`는 하위 수준의 모듈이 아닌 `상위 수준의 모듈`에 있어야 한다.
  - **잘못된 구조** - 인터페이스 `ExRateProvider`가 `하위 모듈`에 들어가 있다.
    ```
    ├── Client.java
    ├── ObjectFactory.java
    ├── exrate
    │   ├── CachedExRateProvider.java
    │   ├── ExRateDate.java
    │   ├── ExRateProvider.java
    │   ├── SimpleExRateProvide.java
    │   └── WebApiExRateProvider.java
    └── payment
        ├── Payment.java
        └── PaymentService.java
    ```
  - **옳은 구조** - 인터페이스 `ExRateProvider`가 `상위 모듈`에 들어가 있다.
    ```
    ├── Client.java
    ├── ObjectFactory.java
    ├── exrate
    │   ├── CachedExRateProvider.java
    │   ├── ExRateDate.java
    │   ├── SimpleExRateProvide.java
    │   └── WebApiExRateProvider.java
    └── payment
        ├── ExRateProvider.java
        ├── Payment.java
        └── PaymentService.java
    ```
- 굳이 이렇게까지 지키지 않아도 충분히 좋은 코드이다.
- 하지만 의존성 역전 원칙을 지켜야 이상적인 코드라고 할 수 있다.

### 스프링 빈 컨텍스트
- 빈 컨텍스트는 스프링 빈을 관리하는 화물이라고 보면 된다.
- 빈은 자바의 오브젝트를 래핑한 거라고 생각하면 된다.
- 자바에서 빈은 컴포넌트를 보고 만들었기 때문에 `빈을 컴포넌트라고 부르기도 한다.`
- 최초 애플리케이션이 실행되면 빈이 생성되고 기본 `싱글톤` 방식으로 하나만 만들어져서 사용된다.
  - 정확히는 최초 호출 시 생성되는데 스프링 부트가 자동으로 해준다.
    그리고 DI를 하면서 연관된 빈 모두 빈을 생성하게 된다. 그래서 최초 하나의 빈을 호출하면 다른 빈도 다 생성하게 된다.

#### 실제 사용
- 빈을 생성(등록)하기 위해서는 구성 정보(Configuration)가 필요하다.

##### 빈 등록 방법
  - 구성 정보는 `@Configuration` 어노테이션으로 등록할 수 있다.
    - 빈으로 등록하기 위해서는 메서드 위에 `@Bean` 어노테이션을 사용한다.
    - 또는 빈으로 등록할 클래스 위에 `@Component` 어노테이션을 사용할 수 있다.
      - 이 경우에는 구성 정보에서 빈을 확인해야 하기 때문에 `@ComponentScan` 어노테이션을 사용해야 한다.
  - 빈 컨텍스트를 가져오는 방법은 다양한 방법이 있지만 그 중에서 `AnnotationConfigApplicationContext`를 사용할 수 있다.
    - `BeanContext`와 `ApplicationContext`는 같은 의미이다.
  - `getBean()`: 빈 컨텍스트를 통해 빈을 가져올 수 있다.

### ENUM
ENUM은 상수 역할을 하는 식별자들의 집합을 이루는 자료형이다.

- ENUM은 참조형이며, 실제 객체는 힙에 저장된다.
- 필드를 가질 수 있으며,
- 메서드를 선언할 수 있다.
- `TimeUnit`은 `ENUM`이면서 메서드(`sleep`)를 가지고 있다.




[//]: # (----------------------------------------------------------------------------------)





## Week 5~6

### 테스트
#### 수동 테스트의 한계
- 프린트된 메시지를 수동으로 확인하는 방법은 불편하다. 
- 사용자 웹 UI까지 개발한 뒤에 확인하는 방법은 테스트가 실패했을 때 확인할 코드가 많다. 
- 테스트할 대상이 많아질 수록 검증하는데 시간이 오래 걸리고 부정확하다.

#### 자동 테스트
- 개발한 코드에 대한 검증 기능을 코드로 작성한다.
- 자동으로 테스트를 수행하고 결과를 확인한다.
- 테스팅 프레임워크를 활용한다.
- 테스트 작성과 실행도 개발 과정의 일부이다.
> 토비(이일민) 개발자는 자동 테스트를 `개발자가 만드는 테스트`라고 부르는 걸 좋아한다고 한다.

#### 내가 느끼는 자동 테스트
- 자동 테스트는 개발 과정에서 없어서는 안 될 존재이다.
- 하지만 자동 테스트에 신경을 많이 쓰게 되면 오히려 수동 테스트를 하기 싫어지는 것 같다.
- 테스트를 구현하는 실력이 좋으면 괜찮겠지만 그게 아니라면 수동 테스트로 직접 확인하는 것도 중요한 것 같다.

#### 테스트의 구성 요소
- JUnit은 테스트끼리 영향을 주지 않기 위해 하나의 테스트마다 개별적으로 인스턴스를 만들어서 사용한다.
- 테스트에서 `검증할 대상(객체)`을 `SUT(System Under Test)`라고 한다.
- 테스트를 수행하는 동안 SUT가 의존하고 있는 또 다른 종류의 대상이 있는데 이를 `협력자(Collaborator)`라고 한다.
- 테스트를 수행하는데 SUT 외에 협력자가 있으면 협력자에 의해 테스트가 바뀔 수 있다.
  그래서 협력자를 조작하여 내가 미리 정해둔 결과를 주도록 만든 객체를 `스텁(Stub)`이라고 한다. 
- 스텁의 상위 개념으로 `테스트 더블(Test Double)` 또는 `임포스터(Impostor)`는 진짜인 척하는 모듈이다.
  하위 개념으로 아래가 있다.
  - 더미(Dummy): 자리만 채우는 객체이다.
  - **스텁(Stub)**: 미리 정해둔 결과를 주는 객체이다.
  - **스파이(Spy)**: 스텁처럼 동작하며 자신의 호출을 기록하는 객체이다. (스텁 + 기록)
  - **목(Mock)**: 어떤 호출에 따른 결과를 미리 설정하고 그 상호작용을 검증하는 객체이다. 
  - 페이크(Fake): 인메모리 DB처럼 실제로 동작하는 간단한 객체이다.

### 단위 테스트
- 단위 테스트는 제일 작은 테스트이다.
- 테스트 하려는 대상을 제외하고 모든 걸 다 목으로 만들면 그게 단위 테스트라고 생각했다.
- 그래서 `@SpringBootTest`로 스프링 컨테이너를 띄우고 테스트 하려는 대상을 @Autowired로 가져왔다.
- 그리고 가끔 DB를 타야하는 테스트도 필요해서 같은 테스트 클래스 안에 DB도 타니까 @MockitoSpyBean으로 만들어 어떤 곳은 결과값을 설정하고 어떤 곳은 실제 DB가 타도록 만들었다.
- 강의를 보면서 클로드에게 꼬리질문을 하며 알게된 건 단위 테스트는 스프링 컨텍스트를 띄우면 안된다.
- 토비 개발자도 강의 중 스프링 컨테이너를 띄우는 테스트를 만들면서 이는 스프링 컨테이너 테스트라고 했다. 그리고 이 방법을 자주 사용한다고 했다.
- 그리고 스프링 컨테이너를 쓰지 않고 직접 인스턴스를 생성하여 쓰는 게 제일 빨라서 좋다고 했다.

#### 스프링 컨텍스트를 띄우는 테스트 요소
목과 스파이를 생성하지만 스프링 컨텍스트에 빈으로 등록함
- `@MockitoBean`
- `@MockitoSpyBean`

#### 순수 단위 테스트 요소
순수 자바 Mockito 라이브러리만 사용하고 스프링 컨테이너는 사용하지 않음
- `@ExtendWith(MockitoExtension.class)`
- `@Mock`
- `@InjectMocks`
- `@Captor`

### 학습 테스트
학습 테스트는 쉽게 말하면 학습을 하기 위해 테스트를 작성하는 것이다.
영어로 `Learning Test`라고도 한다.

> 직접 만들지 않은 코드, 라이브러리, 레거시 시스템 대한 테스트
> 테스트 대상의 사용방법을 익히고 동작방식을 확인하는데 유용하다.
> 외부 기술, 서비스가 버전이 올라갔을 때 이전과 동일하게 동작하는지 확인할 수도 있다.
>
> -토비의 스프링6-

### 도메인 모델 아키텍처 패턴과 테스트의 관련
서비스를 만들다보면 도메인 로직과 비즈니스 로직을 어디에 둘 지를 결정해야 한다.

#### 트랜잭션 스크립트 - 서비스 메서드
서비스에다가 `서비스 로직과 도메인 로직 모두` 작성하는 것이다.
전통적으로 현재까지 많이 사용되고 있는 패턴이다.

#### 도메인 모델 - 도메인 모델 오브젝트
`도메인과 관련된 로직`은 도메인에 작성하는 것이다.
서비스 로직과 분리되어 서비스는 더 가벼워 질 것이고, 테스트하기에도 더 편해질 것이다.
하지만 설계와 개발이 조금 더 어려워질 수 있다.

### 테스트 작성
#### 테스트 양식
```java
@Test
void test() {
  // 준비(given)
  // 실행(when)
  // 검증(then)
}
```



[//]: # (----------------------------------------------------------------------------------)




## Week 7~8

### 템플릿
> 코드 중에서 변경이 거의 일어나지 않으며 일정한 패턴으로 유지되 특성을 가진 부분을
> 자유롭게 변경되는 성질을 가진 부분으로부터 독립시켜서 효과적으로 활용할 수 있도록 하는 방법
>
> -토비의 스프링6-

`변경이 거의 일어나지 않는 부분`은 `템플릿(Template)`을 말하며,
`자유롭게 변경되는 부분`은 `콜백(Callback)`을 말한다.

#### 템플릿 메서드 패턴
템플릿 메서드 패턴은 상속을 이용한 방법이다.
즉, 슈퍼 클래스에 템플릿을 만들고 서브 클래스에서 메서드를 오버라이딩해서 구현하는 방식이다.

상속보다 더 안전하고 좋은 합성이라는 게 생겨서 상속이 필요한 몇몇 경우 아니면 굳이 사용하진 않는다.

#### 스프링이 제공하는 템플릿
- `RestTemplate`: API를 요청하는 기능을 템플릿 패턴을 이용하여 제공한다.
- `JdbcTemplate`: Java Database Connectivity 기술을 템플릿 패턴을 이용하여 제공한다.
- `JmsTemplate`: Java Message Service 기술을 템플릿 패턴을 이용하여 제공한다.
- `TransactionTemplate`: 트랜잭션 기술을 템플릿 패턴을 이용하여 제공한다.
- `JpaTemplate`: Java Persistence Api 기술을 템플릿 패턴을 이용하여 제공한다.
- `HibernateTemplate`: Hibernate 기술을 템플릿 패턴을 이용하여 제공한다. 

### 콜백
콜백은 실행할 함수를 전달해주는 것이다.
자바에서는 콜백을 사용하게 되면 `SAM(Single Abstract Method)`이라는 하나의 메서드만 가진 인터페이스의 오브젝트를 정의해서 사용 또는 `익명 클래스`를 사용하거나 `람다` 오브젝트를 사용한다.
그리고 콜백으로 템플릿의 메서드를 구현하는 것을 `메서드 주입` 또는 `메서드 호출 주입(method call injection)`이라고 부른다.
콜백을 사용하지 않고 

#### 전략 패턴
전략 패턴은 합성을 이용한 방법으로 다양한 구현체를 바꿔 사용하는 것이다.

#### 디폴트 콜백
쉽게 말해, 기본 콜백을 정의해놓는 것이다.
위에서 봤듯이 구현 오브젝트 또는 익명 클래스, 람다 함수 모두 가능하다.

### RestTemplate & RestClient
`RestTemplate`이 표준이었지만 템플릿 메서드 패턴을 활용했었기 때문에 오버로딩으로 수많은 메서드가 만들어졌다.
`RestClient`는 체이닝 패턴을 사용했으며 간결하고 사용하기 편해져 공식적으로 `RestTemplate`은 `Deprecated` 되었으며, `RestClient`를 사용하면 된다.

#### RestTemplate 사용 코드
```java
public BigDecimal getExRate(String currency) {
    String url = "https://open.er-api.com/v6/latest/" + currency;

    return restTemplate.getForObject(url, ExRateDate.class)
            .rates()
            .get("KRW");
}
```

#### RestClient 사용 코드
```java
public BigDecimal getExRate(String currency) {
    String url = "https://open.er-api.com/v6/latest/" + currency;

    return restClient.get()
            .uri(url)
            .retrieve()
            .body(ExRateDate.class)
            .rates()
            .get("KRW");
}
```

### try-with-resources
자바7부터 `try-with-resources`라는 구문이 추가되었다.

기존에 스트림을 열면 `close()`로 닫아줘야 한다.
하지만 `try-with-resources` 구문을 사용하면 자동으로 `close()` 해준다.

`AutoCloseable 인터페이스`의 `close() 메서드`를 구현한 클래스만 사용할 수 있다.

#### 코드
```java
try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
    
}
```






[//]: # (----------------------------------------------------------------------------------)






## Week 9~10

### 예외

> In computer programming, several programming language mechanisms exist for exception handling. The term exception is typically used to denote a data structure storing information about an exceptional condition. One mechanism to transfer control, or raise an exception, is known as a throw; the exception is said to be thrown. Execution is transferred to a catch.
> 
> [위키피디아 - Exception handling(programming)](https://en.wikipedia.org/wiki/Exception_handling_(programming))

> - 예외는 정상적인 프로그램 흐름을 방해하는 사건
> - 예외적인 상황에서만 사용
> - 많은 경우 예외는 프로그램 오류, 버그 때문에 발생
> 
> -토비의 스프링6-

#### Error
- 시스템에 **비정상적인 상황**이 발생한 경우
- **OutOfMemoryError**
- **ThreadDeath**

#### 체크 예외(Exception)
- **catch나** **throws**가 `필수`
- 초기 라이브러리의 잘못된 예외 설계/사용
- 복구할 수 없다면 **RuntimeException**이나 적절한 추상화 레벨의 예외로 감싸서 던질 것

#### 언체크 예외(RuntimeException)
- **catch**나 **throws**가 `선택`

#### 예외가 발생했을 때 대처
- 예외 상황을 복구해서 정상적인 흐름으로 전환이 가능하도록
  - **재시도**
  - **대안**
    - 예외가 발생하는 흐름이 아닌 다른 흐름으로 대처가 가능한가?
- 버그인가?
  - 코드의 버그?
  - **클라이언트**의 버그?
    - 클라이언트가 이해할 수 있는 예외 메시지를 넘긴다.
- **제어할 수 없는 예외상황**
  - DB에 문제가 생겼거나
  - 그 외 개발자가 제어할 수 없는 예외 상황

#### 예외를 잘못 다룬 코드
**예외를 캐치하고 아무 것도 안함**
```java
try {
    // 로직
} catch(Exception e) {
}
```

**예외를 받아서 그냥 콘솔에 띄우기만 함**
```java
try {
    // 로직
} catch(Exception e) {
    e.printStackTrace();
}
```

**무의미하고 무책임한 throws**
```java
public void method1() throws Exception {
    method2();
}

public void method2() throws Exception {
    method3();
}

public void method3() throws Exception {
    throw new Exception();
}
```

### JPA관련 간단한 용어 정리
- JPA(Java Persistence API)는 자바에서 데이터베이스와 데이터를 주고받을 수 있는 도구
  - 현재는 프로젝트 명이 바뀌어서 Jakarta Persistence API로 바뀜
- DataSource
  - 최하위 레벨로, DB랑 연결하기 위한 커넥션
  - 싱글톤으로 관리됨
  - JDBC안에 포함된 인터페이스
- EntityManager
  - JPA의 핵심 인터페이스
  - 여기서 쿼리나 트랜잭션 모든 로직을 정의
  - 팩토리 메서드인 `EntityManagerFactory`에서 생성
- ORM
  - JPA의 표준 추상화
  - 객체와 RDB의 데이터를 매핑해주는 개념
- Hibernate
  - JPA(ORM)의 구현체
- Repository
  - DB랑 데이터를 주고받기 위한 자바에서 맨처음 호출하는 클래스

#### 구조
**Repository** -> **EntityManager** -> **Hibernate** -> **DataSource** -> **DB**

### Smart Factory Bean
팩토리 클래스를 정의하고 빈으로 등록하면 일반적으로는 팩토리 클래스가 주입된다.
`org.springframework.beans.factory.SmartFactoryBean` 인터페이스를 구현한 클래스를 빈으로 등록해두면 해당 팩토리의 팩토리 메서드를 통해 객체가 주입된다.
정확히는 `SmartFactoryBean.getObject()`에 반환되는 오브젝트가 나오는 것이다.

하지만 과거 xml 시절에 사용하던 방식이고 현재는 `@Configuration`, `@Bean` 어노테이션 조합을 통해 직접 팩토리 클래스에서 생성한 후 주입하므로 자주 사용되지 않는다.

### 더블 브레이스 초기화(Double Brace Initialization)
객체를 생성함과 동시에 값을 초기화 또는 로직을 수행하도록 해주는 문법

일단 `안티패턴`이다.

`{}` 이것을 브라켓이라고 하는데
첫 번째 브라켓은 객체의 생성자를 이용한 생성을
두 번째 브라켓은 객체의 로직을 선언한다.

**인터페이스를 익명 클래스로 생성**
```java
Map<Integer, String> map = new HashMap<>() {{
    put(1, "영수");
    put(2, "별이");
}};
```

**클래스를 익명 클래스로 생성**
```java
HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter() {{
            setDatabase(Database.H2);
            setGenerateDdl(true);
            setShowSql(true);
}};
```

#### 단점
- 익명 클래스를 생성하기 때문에 불필요한 메모리만 잡아먹는다.
- 이것보다는 차라리 팩토리 패턴을 사용하는 게 더 좋다고 한다.





[//]: # (----------------------------------------------------------------------------------)






# 쉬운코드
쉬운코드 백발백중 영상 한 개 정리

## Week 1~2
### 컨텍스트 스위칭

---
#### 컨텍스트 스위칭(Context Switching)이란?
CPU/코어에서 실행 중이던 프로세스/스레드가 다른 프로세스/스레드로 교체되는 것

#### 컨텍스트 스위칭을 하는 이유
여러 프로세스/스레드를 동시에 실행시키기 위해서

#### 컨텍스트 스위칭을 실행하는 방법
- OS 커널(kernel)에서 컨텍스트 스위칭을 발생시킨다.
- OS 커널은 하드웨어를 직접 조작할 수 있는 인터페이스이다.

#### 컨텍스트 스위칭의 종류
- Process Context Switching: **다른 프로세스**끼리의 스위칭
- Thread Context Switching:**같은 프로세스**의 **스레드**들끼리의 스위칭
- 둘의 공통점
  - 커널에서 실행됨
  - CPU의 레지스터 상태를 교체
    - 여기서 상태를 교체한다는 것은 **데이터를 교체**한다는 의미
    - 컨텍스트 스위칭을 한다는 것은 다른 컨텍스트로 교체한다는 것인데
    - 이러한 컨텍스트 스위칭은 엄청나게 많이 반복한다.
    - 그리고 스위칭 전에 스레드의 데이터들을 어딘가에 잠시 저장해둔다.
- 둘의 차이점
  - Thread Context Switching: 같은 프로세스에서 컨텍스트 스위칭은 같은 메모리 공간을 사용하므로 바꿔줄 필요가 없다.
  - Process Context Switching: 하지만 다른 프로세스끼리의 컨텍스트 스위칭은 메모리(MMU, TLB) 주소 관련 처리를 추가로 수행해야 한다.
- 동작 과정
  - Thread Context Switching
    같은 프로세스에서 T1과 T2가 실행 중이라고 가정
    1. T1에서 I/O 발생 또는 Time Slice 시간이 다해 컨텍스트 스위칭을 해야 하므로 커널 모드 진입
    2. T1의 CPU 레지스터 상태 저장
    3. T2의 CPU 레지스터 상태 로딩
    4. 이번에는 T2가 1번의 과정을 거침
    5. T2의 CPU 레지스터 상태 저장
    6. T1의 CPU 레지스터 상태 로딩
    7. 이후 반복
  - Process Context Switching
    다른 프로세스 P1(T1)과 P2(T2)가 실행 중이라고 가정
    Thread Context Switching에서 메모리 처리 로직이 추가 됨
    1. T1에서 I/O 발생 또는 Time Slice 시간이 다해 컨텍스트 스위칭을 해야 하므로 커널 모드 진입
    2. T1의 CPU 레지스터 상태 저장
    3. T2의 CPU 레지스터 상태 로딩
    4. MMU가 P2의 메모리를 보도록 설정
    5. TLB를 비움
    6. 이번에는 T2가 1번의 과정을 거침 
    7. T2의 CPU 레지스터 상태 저장
    8. T1의 CPU 레지스터 상태 로딩
    9. MMU가 P1의 메모리를 보도록 설정
    10. TLB를 비움
    11. 이후 반복
#### 스레드 컨텍스트 스위칭이 빠른 이유
- 같은 프로세스에서 컨텍스트 스위칭이 동작하기 때문에 메모리 주소 관련 처리는 하지 않기 때문

#### 컨텍스트 스위칭이 미치는 영향
- CPU에서 자주 쓰는 데이터는 메모리의 접근을 반복하지 않고 CPU 캐시에 저장을 한다.
- 그런데 컨텍스트 스위칭을 하게 되면 이전 스레드에서 캐시에 저장했던 데이터들이 의미가 없어진다.
  - 같은 프로세스의 경우에는 캐시에 저장된 데이터들이 유효한 경우가 아예 없지는 않을 것이다.
- 그래서 이를 **캐시 오염**이라고 한다.
- 어떠한 CPU 아키텍처는 컨텍스트 스위칭이 발생하면 캐시를 비워버린다고 한다.
- 그러므로, 컨텍스트 스위칭이 자주 발생하는 것은 좋지 않다.

### Reference
- [쉬운코드 - 컨텍스트 스위칭 뽀개기!](https://youtu.be/Xh9Nt7y07FE?si=oBcY82piIwePi32y)




[//]: # (----------------------------------------------------------------------------------)




## Week 3~4

### 모니터(Monitor)
모니터 전에 뮤텍스 락과 세마포어에 대해 조금 알고 있어야 함
#### 뮤텍스 락

---

- 상호 배제를 하는 방법이다.
- 하나의 공유 자원을 대상으로 한다.

```java
accquire() {
    while (lock == true) ;
    lock = true;
}

release() {
    lock = false;
}
```

여기서 `while (lock == true)`는 락이 false가 되기 전까지 무한히 반복한다.
이를 `바쁜 대기(busy wait)`라고 한다.

#### 세마포어

---

- 여러 공유 자원을 대상으로 한다.

```java
wait() {
    while (S <= 0) ;
    S--;
}

signal() {
    S++;
}
```

- 세마포어는 S개 만큼의 공유 자원을 동시에 사용할 수 있다.
>이해가 안가는 부분
>- 뮤텍스의 `lock()`은 `일단 잠근다.`
>- 세마포어의 비슷해보이는 `wait()`은 `일단 대기 상태`로 들어간다.
>- 뮤텍스는 잠그지 못하면 대기 상태와 비슷하게 들어간다.
>- 세마포어는 일단 대기 상태로 들어간다.
>- 이럴거면 메서드명을 둘다 똑같이 lock()또는 wait() 중 하나로 통일하지 많은 곳에서 왜 두 개로 나뉘어서 헷갈리게 하는 지 이해가 안된다.
>
> 그리고 부르는 사람마다 다르지만 `다익스트라`의 모국어에 근거해 `wait`과 `signal`을 `P`, `V`로 명명하기도 한다.
> 내가 운영체제를 들었을 때에는 `P`, `V`로 썼었다.

##### 실제 세마포어는 더 좋은 방식을 사용한다.
- `wait busy`는 세마포어에도 동일하게 발생한다.
- 이를 해결하기 위해 대기 중인 스레드는 `대기 큐`에 넣고 `잠재운다.`
- 잠재우는 건 운영체제 커널에서 제공하는 기능이다. CPU의 스케줄링 안에 포함하지 않는다.
> 실제로 세마포어는 잘 사용되지 않는다.
> 
> 더 좋은 동기화 기법인 `모니터(Monitor)`라는 기법이 있기 때문이다.

##### 실행 순서를 제어하기 위한 동기화
- 동기화는 `상호배제를 위한 동기화`도 있지만 `실행 순서를 제어하기 위한 동기화`도 있다.
- 아래는 `스레드1 실행 -> 스레드2 실행`이 이루어져야 하는 상황이다.
  - S는 0으로 고정이다.
  - 스레드1의 실행 순서
    1. 임계 구역 실행
    2. signal 메서드 실행
  - 스레드2의 실행 순서
    1. wait 메서드 실행
    2. 임계 구역 실행
- 이렇게 되면 스레드2가 먼저 실행되어도 반드시 대기 큐에 들어가게 될 것이고
- 스레드1이 먼저 실행 되어도 wait 메서드를 거치지 않으므로 바로 실행이 될 것이다.

#### 모니터

---

- 세마포어는 `wait`과 `signal`로만 상호 배제와 조건 변수를 구현해야 한다.
- 이는 굉장히 복잡하고 실수하기 쉽다.
- 그래서 모니터라는 기법이 나왔는데,
- 모니터는 상호 배제는 뮤텍스 락을 이용하고, 조건 변수는 `wait`과 `signal`을 이용한다.

##### 상호 배제
- 모니터에서 상호 배제는 뮤텍스 락을 이용한다.
- 그리고 뮤텍스 락에서 `바쁜 대기(busy wait)`을 해결하기 위해 당연히 큐를 이용한다.
- 여기서 큐는 `entry queue`라고도 하고 `외부 큐` 등 다양하게 불린다.

##### 조건 변수
- 조건 변수는 말 그대로 조건이다.
- 만약 `A 스레드가 통과하기 위해서는 B 스레드가 무조건 통과해야 한다.`라는 조건이 있을 때
- `A 스레드`는 `while()`을 통해 `wait()`메서드가 호출된다. (이때 `lock`도 반납된다.)
- 이렇게 `A 스레드`를 `조건 큐`에 넣어놓고 재운 후 `B 스레드`가 `통과`하면 `signal()`메서드를 호출하여 `A 스레드`의 큐를 꺼내며 깨워주는 방식이다.
- 그래서 조건 개수만큼의 큐를 가질 수 있다.
- 여기서 큐는 `waiting queue` 또는 `내부 큐` 등 다양하게 불린다.

##### 자바에서의 모니터
- 자바에서는 객체마다 모니터를 하나씩 가지고 있다.
  - 정확히는 Object 클래스가 `wait(), notify(), notifyAll()`를 가지고 있으며 이게 모니터에서 제공하는 메서드이다.
    - `synchronized` 키워드 없이 사용할 경우 `IllegalMonitorStateException`예외를 발생한다.
  - 그런데 정말 하나씩 가지고 있기 때문에 두개 이상의 조건 변수를 가질 수는 없다.
  - 여러 개의 조건 변수를 가지기 위해서는 별도의 구현이 필요하다.
- 자바에서는 뮤텍스 락을 정말 쉽게 `synchronized` 키워드를 사용해서 구현할 수 있다.
  - 이것은 메서드 선언부와 메서드 내부에 달 수 있다. (아래 코드 예시 참고)
  - `클래스 레벨`과 `오브젝트 레벨`이 있다.
    - 클래스 레벨은 `모든 인스턴스`에 대해 동시 접근을 제한한다.
      - 단 오브젝트 레벨로 선언된 경우와는 별개로 작동한다.
      - 즉, 클래스 레벨과 오브젝트 레벨이 동시에 있는 경우 클래스 레벨이 실행되면서 오브젝트 레벨이 동시에 실행이 가능
    - 오브젝트 레벨은 `같은 오브젝트`에 한해서 동시 접근을 제한한다.
- 자바에서 `signal()`을 한다고 반드시 넣은 순서대로(`FIFO`) **보장되지 않는다.**
- 그래서 자바에서는 `waiting queue`나 `entry queue`가 아니라 `waiting set`, `entry set`이라고 부른다.
```java
class BoundedBuffer {
    private final int[] buffer = new int[5];
    private int count = 0;

    public synchronized void produce(int item) throws InterruptedException {
        while (count == 5) {
            System.out.println("Produce 대기 상태");
            wait();
        }
        buffer[count++] = item;
        notifyAll();
    }

    public void consume() throws InterruptedException {
        int item = 0;
        synchronized (this) {
            while (count == 0) {
                System.out.println("Consume 대기 상태");
                wait();
            }
            item = buffer[--count];
            notifyAll();
        }
        System.out.println("Consume: " + item);
    }
}

// java25 ↑
void main() throws InterruptedException {
    BoundedBuffer buffer = new BoundedBuffer();

    Thread consumer = new Thread(() -> {
        try {
            buffer.consume();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });

    Thread producer = new Thread(() -> {
        try {
            buffer.produce(100);
            buffer.produce(200);
            buffer.produce(300);
            buffer.produce(400);
            buffer.produce(500);
            buffer.produce(600);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    });

    consumer.start();
    producer.start();

    consumer.join();
    producer.join();
    System.out.println("완료");
}
```

### References
- [쉬운코드 - BJ.10 모니터](https://youtu.be/Dms1oBmRAlo?si=VlppzcQ9AqUgug0Q)
- [혼자 공부하는 컴퓨터구조 + 운영체제](https://www.hanbit.co.kr/books/혼자-공부하는-컴퓨터-구조-운영체제?code=B9177037040)





[//]: # (----------------------------------------------------------------------------------)




## Week 5~6

### 스레드 풀(Thread Pool)
스레드 풀은 `미리 여러 개의 스레드를 생성`하여 만들어 놓고 `재사용`하는 곳이다.
즉, 스레드가 필요하면 스레드 풀에서 스레드를 주고 사용이 끝나면 다시 `스레드 풀에 반납`한다.

스레드를 생성하는 데 시간이 적지 않게 소요된다.
만약, 요청마다 스레드를 생성하게 되는 경우에는 요청 처리가 더 오래 걸릴 것이다.

그리고 처리 속도보다 더 빠르게 요청이 들어오면 최악의 경우 아래처럼 진행될 것이다.
- `스레드가 계속 생성` (스레드 수 증가)
- `컨텍스트 스위칭`이 더 자주 발생
- `CPU 오버헤드` 증가로 CPU time 낭비
- `메모리가 점점 고갈`되어 어느 순간 서버 전체가 응답 불가능 상태에 빠짐

#### 스레드 풀 사례
여러 개의 동시 작업 처리
- `thread per request` 모델 (웹서버)
- `task`를 `subtask`로 나누어서 동시에 처리
- 순서 상관없이 `동시 실행`이 가능한 task 처리

### 스레드 풀 팁
#### 몇 개의 스레드가 적당할까?
스레드 풀에 몇개의 스레드를 만들어 놓는 게 좋을까?
- `CPU Bound` 작업이라면 `CPU 코어 개수`만큼이 좋을 것이다.
- `I/O Bound` 작업이라면 `상황마다 다르므로` 직접 찾아야 한다.
  성능 테스트를 해보고 계속 늘려보면서 찾아가는 게 가장 좋아보이긴 한다.

#### 스레드 풀의 큐 사이즈 확인하기
자바의 `Executors` 클래스는 다양한 형태의 스레드 풀을 제공한다.
그 중 `newFixedThreadPool(int nThreads)` 메서드는 nThreads 개수만큼의 스레드를 생성한다.
하지만 스레드의 개수만큼 모두 사용하고 또 스레드를 요청하면 해당 요청은 대기 큐에 들어간다.
근데 대기 큐의 크기는 `Integer.MAX_VALUE`이므로 계속 대기 큐에 넣게 되면 `OutOfMemory`가 먼저 발생할 것이다.

그러므로 이 부분을 잘 알고 실무에서는 스레드 풀의 `대기 큐의 크기 제한`을 걸어 놓는 것이 좋다.
`생성자`를 통해 직접 스레드 풀을 생성하면 된다.
```java
public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              RejectedExecutionHandler handler);
```


#### pool의 개념은 스레드 풀만 있는 게 아니다.
pool이라는 용어는 스레드 풀에서만 사용하는 게 아니다.
`Connection Pool`과 `Process Pool`도 있다.
여기서 `Connection Pool`은 `TCP 연결`을 하기 위한 풀도 있고 `DB 커넥션`을 연결하기 위한 풀도 있다.

### References
- [쉬운코드 - BJ.18 스레드 풀(thread pool)](https://youtu.be/B4Of4UgLfWc?si=8PZFmMuCa7W64Q4t)




[//]: # (----------------------------------------------------------------------------------)




## Week 7~8

### Stored Function
- 사용자가 정의한 함수
- DBMS에 저장되고 사용하는 함수
- SQL의 `select`, `insert`, `update`, `delete`문에서 사용할 수 있다.

#### 언제 사용하는 것이 좋을까?
- `비즈니스 로직`은 `자주 변경`될 수 있으므로 `유지보수`가 간편하고 `테스트`하기 쉬운 서버에서 관리하는 것이 좋다.
- 그렇다면 `함수`에는 비즈니스 로직을 담는 코드보다는 `util 함수`를 사용하는 것이 가장 좋아보인다.
- 아래 예제에서 `1번은 비즈니스 로직이 약간` 들어가 있고, `2번은 util`이다. `3번은 완변한 비즈니스 로직`이다.

#### 문법
함수 작성 중 `세미콜론(;)`이 나오게 되면 RDBMS는 함수 작성을 마친줄 안다.
그래서 `delimiter $$`를 달아줘서 $$가 나오면 함수 작성을 마치게 한다.
마지막으로 밑에 `delimiter ;`를 작성하여 원래대로 돌려준다.
변수 선언은 `DECLARE` 또는 `@변수명`으로 작성할 수 있다.
`@변수명`은 세션에서 유지되는 사용자 지정 변수이다.
```mysql
delimiter $$
CREATE FUNCTiON [DB이름.]함수이름([인자 타입])
RETURNS 반환자료타입
BEGIN
    DECLARE 변수명 타입;
    RETURN 반환값;
END
$$
delimiter ;
```

#### 함수 삭제
```sql
DROP FUNCTION stored_function_name;
```

#### 등록된 함수 확인
```mysql
SHOW FUNCTION STATUS where DB = 'db_name';
```

#### 등록된 함수 상세 확인
```mysql
SHOW CREATE FUNCTION function_name;
```

#### 예제1
- 임직원의 ID를 열자 정수로 랜덤하게 발급하고 싶다.
- ID의 맨 앞자리는 1로 고정이다.
NO SQL은 mysql에서 사용하는 문법이다.
```mysql
delimiter $$
CREATE FUNCTION id_generator()
RETURNS int
NO SQL
BEGIN
    RETURN (1000000000 + floor(rand() * 1000000000));
END
$$
delimiter ;
```

#### 예제2
- 부서의 ID를 파라미터로 받으면 해당 부서의 평균 연봉을 알려주는 함수
READS SQL DATA 는 mysql에서 사용하는 문법이다.
```mysql
delimiter $$
CREATE FUNCTION dept_avg_salary(d_id int)
RETURNS int
READS SQL DATA 
BEGIN 
    DECLARE avg_sal int;
    select avg(salary) into avg_sal
                        from employee
                        where dept_id = d_id;
    RETURN avg_sal;
END
$$
delimiter ;
```

- 변수 선언 생략
```mysql
delimiter $$
CREATE FUNCTION dept_avg_salary(d_id int)
RETURNS int
READS SQL DATA 
BEGIN 
    select avg(salary) into @avg_sal
                        from employee
                        where dept_id = d_id;
    RETURN @avg_sal;
END
$$
delimiter ;
```

#### 예제3
- 졸업 요건 중 하나인 토익 800이상을 충족하는지 검사
```mysql
delimiter $$
CREATE FUNCTION toeic_pass_fail(toeic_score int)
RETURNS int
NO SQL
BEGIN
    DECLARE pass_fail char(4);
    IF toeic_score is null THEN SET pass_fail = 'fail';
    ELSEIF toeic_score < 800 THEN SET pass_fail = 'fail';
    ELSE SET pass_fail = 'pass';
    END IF;
    RETURN pass_fail;
END
$$
delimiter ;
```

### Stored Procedure
- 사용자가 정의한 함수
- DBMS에 저장되고 사용하는 함수
- 구체적인 하나의 태스크(task)를 수행한다.

#### 문법
- 인자로 `IN`, `OUT`, `INOUT`을 설정할 수 있으며 기본값은 `IN`이다.
- RETURN을 사용할 수 없다.
- 반환해야 한다면 인자로 `OUT` 또는 `INOUT`을 사용한다.
```mysql
delimiter $$
CREATE PROCEDURE [DB이름.]프로시저이름([IN, OUT, INOUT] 인자 타입)
BEGIN
    
END
$$
delimitier ;
```

#### 예제1
- 두 정수의 곱셈 결과를 가져오는 프로시저
```mysql
delimiter $$
CREATE PROCEDURE product(IN a int, IN b int, OUT result int)
BEGIN
    SET result = a * b;
END
$$
delimiter ;

call product(5, 7, @result);
select @result;
```

#### 예제2
- 두 정수를 맞바꾸는 프로시저
```mysql
delimiter $$
CREATE PROCEDURE swap(INOUT a int, INOUT b int)
BEGIN
    set @temp = a;
    set a = b;
    set b = @temp;
END
$$
delimiter ;

set @a = 5, @b = 7;
call swap(@a, @b);
select @a, @b;
```

#### 예제3
- 각 부서별 평균 연봉을 가져오는 프로시저
```mysql
delimiter $$
CREATE PROCEDURE get_dept_avg_salary()
BEGIN 
    select dept_id, avg(salary)
    from employee
    group by dept_id;
END
$$
delimiter ;

call get_dept_avg_salary();
```

#### 예제4
- 사용자가 프로필 닉네임을 바꾸면 이전 닉네임을 로그에 저장하 새 닉네임으로 업데이트하는 프로시저
```mysql
delimiter $$
CREATE PROCEDURE change_nickname(user_id int, new_nickname varchar(30))
BEGIN 
    insert into nickname_logs(
         select id, nickname, now() from users where id = user_id
    );
    update users set nickname = new_nickname where id = user_id;
END
$$
delimiter ;

select * from users;
select * from nickname_logs;
```

### Function VS Procedure
- 둘 모두 반환 값을 줄 수는 있으나, `Function은 반환 값 한 개`, `Procedure는 반환 값 여러 개`이다.
- 가장 큰 차이점 두 개가 있다.
  - SQL문에서 사용할 수 있느냐 없느냐
    - 함수 `select func() from ...;`
    - 프로시저 `call proc();`
  - 트랜잭션을 사용하느냐 안하느냐
    - 함수는 멱등성이 있는 조회 쿼리 외에는 변경이 되는 쿼리를 선언은 할 수 있지만 실행하기는 어렵다.
      - 쿼리문 안에서 호출 ❌ `select user_name, log_and_return_count('조회함') from users`
      - 단독으로 호출 ✅ `set @result_count = log_and_return_count('단독 실행')`
    - `함수의 목적` 자체가 `사이드 이펙트가 없는` 유틸이다.
      - 그래서 트랜잭션을 사용해서 `커밋과 롤백`이 가능하다면 사이드 이펙트가 반드시 생긴다.
    - `프로시저의 목적`은 반대로 `사이드 이펙트를 일으키는 것`이다.
      - 그래서 트랜잭션을 사용하고 `커밋과 롤백`이 가능하다.

MySQL, Oracle, SQL Server, PostgreSQL의 공통적인 부분을 기준

|                  |                   FUNCTION                    |                PROCEDURE                |
|:----------------:|:---------------------------------------------:|:---------------------------------------:|
|    create 문법     |              CREATE FUNCTION ...              |          CREATE PROCEDURE ...           |
| return 키워드로 값 반환 |     가능<br/>(MySQL, SQL Server는 값 반환라면 필수)     | 불가능<br/>(SQL server는 상태코드 반환용으로 사용 가능)  |
|   파라미터 값(들) 반환   | 일부 가능<br/>(Oracle 가능하나 권장 안 함, PostgreSQL 가능) |         가능<br/>(값(들)을 반환하려면 필수)         |
|  값을 꼭 반환해야 하나?   |                      필수                       |                  필수 아님                  |
|    SQL문에서 호출     |                      가능                       |                   불가능                   |
|     트랜잭션 사용      |            대부분 불가능<br/>(Oracle 가능)            |                   가능                    |
|     주 사용 목적      |                    복잡한 계산                     |                 비즈니스 로직                 |

#### 비즈니스 로직 관점에서 프로시저의 단점 요약

3티어 아키텍처는 `프론트 - WAS - DB` 이다.
일반적으로 `비즈니스 로직`은 `WAS` 또는 `DB`에 작성된다.

DB에 비즈니스 로직을 작성하는 것의 장단점을 말해보면
(아래부터 DB 프로시저를 쓴다는 것은 DB에 비즈니스 로직을 둔다는 것이다)

##### 장점 - DB 프로시저를 작성한다면?
- 네트워크 응답 속도가 빨라진다.
  - WAS에서 `쿼리를 여러 번` 보내는 걸 `프로시저 한 번`으로 해결하거나
  - 수 많은 데이터를 응답하는데 프로시저에서 `필터링`하고 응답하는 것이다.
- 애플리케이션에 `Transparent`하다.
  - WAS에 비즈니스 로직이 있고 여러 인스턴스를 사용한다고 했을 때, 인스턴스 하나하나 확인하고 재기동해줘야 한다.
  - 하지만, DB 프로시저를 이용하면 DB만 교체하면 되므로 `한 번에` 바꿀 수 있다.
  - 이 부분은 **단점**으로 작용할 수 있다.(아래에서 확인)
- `여러 서비스`에서 `재사용` 가능하다.
  - `스프링`으로 작성된 서버 말고도 `Django` 또는 `nodejs` 서버가 하나씩 있다 했을 때, `각 프레임워크에 맞는 언어`로 비즈니스 로직을 작성해야 하지만 프로시저를 이용하면 그럴 필요가 없다.
- 민감한 정보에 대한 접근을 제한할 수 있다.
  - 데이터를 모두 DB에서 처리하고 저장하므로 서버에서의 `접근을 제한`할 수 있다.
  - 이 부분은 쉽게 **뚫릴 수 있다.**(아래에서 확인)

##### 단점 - DB 프로시저를 작성한다면?
- 유지보수 비용이 커진다.
  - WAS와 프로시저를 작성하기 위한 문법을 **모두 알아야**하므로 비용이 커진다.
  - 프로시저의 **이름**이나 **인수**가 바뀌게되면 `WAS`도 고치며 `버전 관리`를 둘 다 해줘야 하므로 비용이 커진다.
- `DB 서버 추가`가 **간단하지 않다.**
  - 급격히 증가하는 트래픽으로 DB 서버를 추가했다. 하지만 텅 빈 DB이기 때문에 메인 DB에서 `복제`를 해야한다. 복제를 하는데 드는 시간은 굉장히 오래 걸린다. 몰려오는 트래픽과 DB 복제는 동시에 작업이 불가능하다.
  - 🤔 **WAS라면?**
    - WAS 서버 인스턴스를 늘리는 건 굉장히 쉽다. `오토 스케일링`을 이용하면 자동으로 자원을 보고 알아서 인스턴스 수를 줄여주고 늘려준다.
- 프로시저가 항상 Transparent한 건 아니다.
  - 프로시저의 Body만 변경이 되면 Transparent 하다.
  - 하지만 프로시저의 이름이나 인수가 바뀌면 프로시저를 호출하는 WAS도 바꿔줘야 한다.
- Transparent가 무조건 좋은 건 아니다.(`장점 - 애플리케이션에 Transparent하다.`의 단점)
  - 만약, 프로시저를 바꿨는데 버그가 발생했다면 WAS 인스턴스가 여러 대인 경우 모든 서버에서 버그가 발생하는 것이다.
  - 반대로 WAS에 비즈니스 로직을 작성하면 버그 발생률이 `1/N`으로 줄게된다.
  - (그런데 이 부분은 틀리진 않았지만 애초에 테스트를 잘하고 버그가 없게 만들어야 하므로 약간 과장된 것 같다)
- 민감한 정보에 대한 접근을 **완벽하게 제한할 순 없다.**
  - 만약 악의적인 개발자가 프로시저에 값을 **반환**하도록 해서 사용하면 그냥 뚫리는 것이다.
  - 그러므로 `담당자`나 `개발자`에게만 DB 혹은 테이블 `권한을 허용`하고 `민감한 정보`는 `암호화`하며, `보안 서약서` 등을 통해 `정책적`으로 보안을 강화하는 것이 좋다.

##### WAS에서 응답 속도 향상하는 방법?
- `비동기`를 활용한다.
- `레디스`와 같은 `캐시`를 활용한다.

##### 내가 생각하는 DB에 비즈니스 로직 작성하는 것의 단점
`테스트`가 가장 큰 이유이다.
- 자바는 테스트 프레임워크로 **JUnit**을 제공한다.
- 테스트를 작성하기 굉장히 쉬우며, **모킹**이라는 기능도 제공하고 관련 자료도 많다.
- 그리고 JUnit을 활용하여 테스트를 작성할 줄 아는 인력이 많다.
- 또, **디버깅**이 굉장히 쉽다.

### Trigger
- 데이터베이스에서 어떤 이벤트(insert, update, delete)가 발생했을 때 자동적으로 실행되는 프로시저(procedure)

#### 문법
- `이전/이후`: `BEFORE` 또는 `AFTER`
- `쿼리문`: `INSERT`, `UPDATE`, `DELETE`
- `단위`: `FOR EACH ROW`, `FOR EACH STATEMENT`(PostgreSQL에서 가능, MySQL X, 쿼리문 단위)
```mysql
delimiter $$
이전/이후 쿼리문
ON 테이블 FOR 단위
BEGIN
    로직
END
$$
delimiter ;
```

#### 예시1
- USER의 닉네임 변경 UPDATE 발생 시 업데이트 전에 로그를 남기기
```mysql
delimiter $$
CREATE TRIGGER log_user_nickname_trigger
BEFORE UPDATE
ON users FOR EACH ROW 
BEGIN 
  INSERT into users_log values(OLD.id, OLD.nickname, now());
END
$$
delimiter ;
```

#### 예시2
- 사용자가 마트에서 상품을 구매할 때마다 지금까지 누적된 구매 비용을 구하는 트리거
```mysql
delimiter $$
CREATE TRIGGER sum_buy_prices_trigger
AFTER INSERT
ON buy FOR EACH ROW 
BEGIN 
  DECLARE total INT;
  DECLARE _user_id INT DEFAULT NEW.user_id;
  
  select sum(price) into total from buy where user_id = _user_id;
  update user_buy_stats set price_sum = total where user_id = _user_id;
END
$$
delimiter ;
```

#### 다양한 쿼리를 한 번에 적용 (INSERT or UPDATE or DELETE)
- 직원의 데이터가 변동될 때마다 `update_avg_empl_salary()` 함수 실행
  - `update_avg_empl_salary()` 함수는 부서의 평균 연봉을 구하는 함수
- `MySQL`은 **불가능**하며, `PostgreSQL`은 **가능**하다.
- `PostgreSQL`은 함수를 부를 때 `EXECUTE FUNCTION` (`MySQL`은 `call`) 
```postgresql
CREATE TRIGGER avg_empl_salary_trigger
  AFTER INSERT or UPDATE or DELETE
  ON employee
  FOR EACH ROW
  EXECUTE FUNCTION update_avg_empl_salary();
```

#### FOR EACH STATEMENT 사용(MySQL은 불가능)
- `FOR EACH ROW`는 각 행마다 트리거를 실행한다.
- 만약, `UPDATE employee SET salary = 1.5 * salary WHERE dept_id = 1003;`을 실행하면?
  - 부서 번호가 1003인 직원의 연봉을 1.5배 인상
  - 부서 번호가 1003인 직원이 5명 -> 트리거는 5번 실행
  - 한 번만 실행 되면 되는 트리거를 직원 수만큼 실행
- `FOR EACH STATEMENT`는 변하는 행마다가 아닌 `쿼리마다`로 바꾼다. 
```postgresql
CREATE TRIGGER avg_empl_salary_trigger
  AFTER INSERT or UPDATE or DELETE
  ON employee
  FOR EACH STATEMENT 
  EXECUTE FUNCTION update_avg_empl_salary();
```

#### 상세 조건을 설정할 수 있다.(MySQL은 불가능)
- 새로운 닉네임이 기존 닉네임과 중복되지 않으면 트리거를 실행한다.
```postgresql
CREATE TRIGGER log_user_nickname_trigger
BEFORE UPDATE
    ON users
    FOR EACH ROW
    WHEN (NEW.nickname IS DISTINCT FROM OLD.nickname)
    EXECUTE FUNCTION log_user_nickname();
```

#### 트리거의 단점
- 트리거는 소스 코드로 발견할 수 없기 때문에 파악하기 어려우며, 문제가 생겼을 때 대응하기 힘들어 유지보수가 힘들다.
- 트리거가 연쇄적으로 작용할 수 있어 순환이 될 수 있다.

### References
- [쉬운코드 - BJ.39 Stored function](https://youtu.be/I1jjR58Rzic?si=wGhrt3BEXxNqFfcC)
- [쉬운코드 - BJ.40-1 Stored Procedure](https://youtu.be/m2jx18yg8EA?si=j5fKbDGzPcdmVAE1)
- [쉬운코드 - BJ.40-2 Stored Procedure](https://youtu.be/SOLm-GXFzG8?si=dWZVA4mkHmWCvNnU)
- [쉬운코드 - BJ.41 SQL trigger](https://youtu.be/mEeGf4ZWQKI?si=b3n8iRAfmg9pOJYl)





[//]: # (----------------------------------------------------------------------------------)




## Week 9~10

### Serializability

> 직렬화(直列化) 또는 시리얼라이제이션(serialization)은 컴퓨터 과학에서 데이터 구조나 객체를 다른 컴퓨터 환경에서 사용하도록 저장, 전송, 재구성할 수 있는 포맷으로 변환하는 과정이다.
> 
> 오브젝트를 직렬화하는 과정은 오브젝트를 마샬링한다고도 한다. 반대로, 일련의 바이트로부터 데이터 구조를 추출하는 일은 역직렬화 또는 디시리얼라이제이션(deserialization)이라고 한다.
> 
> [위키피디아 - 직렬화](https://ko.wikipedia.org/wiki/%EC%A7%81%EB%A0%AC%ED%99%94)

> 직렬화 성질(Serializability), 즉 직렬화 가능성에 관한 설명이다.
> 
> 중앙 집중식 및 분산형 데이터베이스, 트랜잭션 처리(트랜잭션 관리) 및 다양한 트랜잭션 애플리케이션(예: 트랜잭션 메모리 및 소프트웨어 트랜잭션 메모리)의 동시성 제어에서 트랜잭션 스케줄은 결과(예: 결과 데이터베이스 상태)가 다음과 같은 경우 직렬화가 가능하다. 즉, 시간이 겹치지 않고 순차적으로 실행된 트랜잭션의 결과와 동일하다. 트랜잭션은 일반적으로 동시에 실행된다(겹침). 이것이 가장 효율적인 방법이기 때문이다. 직렬화 가능성은 동시 트랜잭션 실행에 대한 주요 정확성 기준이다. 이는 트랜잭션 간 격리의 최고 수준으로 간주되며 동시성 제어에 필수적인 역할을 한다. 따라서 모든 범용 데이터베이스 시스템에서 지원된다. SS2PL(강력한 2단계 잠금)은 1970년대 초기부터 대부분의 데이터베이스 시스템(다양한 변형)에서 널리 사용되는 직렬화 메커니즘이다.
>
> [위키피디아 - 직렬화 성질](https://ko.wikipedia.org/wiki/%EC%A7%81%EB%A0%AC%ED%99%94_%EC%84%B1%EC%A7%88)

#### 시나리오
**K가 H에게 20만원을 이체할 때, H도 ATM에서 본인 계좌에 30만원을 입금한다면?**

아래처럼 4개의 스케줄이 나온다.
![직렬화_시나리오_이미지](/readme-images/9-10/serializability1.png)

여기서 숫자는 트랜잭션1, 2를 나타내고

r은 Read, w는 Write, c는 Commit이다.

스케줄1은 트랜잭션 1을 끝내고 트랜잭션 2를 순차적으로 수행하므로 직렬 스케줄(Serial Schedule)이다.

마찬가지로 스케줄2도 트랜잭션 2를 끝내고 트랜잭션 1을 순차적으로 수행하므로 직렬 스케줄이다.

스케줄3과 4는 트랜잭션 1을 수행하는 도중 트랜잭션 2가 수행된다.

그러므로 스케줄3, 4는 비직렬 스케줄(Non-serial Schedule)이다.

##### 직렬 스케줄과 비직렬 스케줄
직렬 스케줄은 트랜잭션이 순차적으로 실행된다.
비직렬 스케줄은 트랜잭션이 사이에 다른 트랜잭션이 실행된다.

여기서 알아두어야 하는 것은 `Read/Write` 하는 과정이 `I/O` 하는 과정이라는 것이다.

`I/O`는 CPU의 개입이 없다.

즉, RAM과 SSD(또는 HDD)사이에서의 작업이다.
그러면 CPU는 그냥 대기하게 된다.

**직렬 스케줄**은 트랜잭션 하나하나마다 계속 `대기`를 하게 되고,
**비직렬 스케줄**은 트랜잭션 사이에 다른 트랜잭션이 실행될 수 있으므로 `I/O`로 인해 `대기`를 하게 되면 `다른 트랜잭션` 작업을 하러간다.

그래서 일반적으로 직렬 스케줄은 느리고 비직렬 스케줄은 빠르다. 실제로 직렬 스케줄은 굉장히 느려 사용하지 못한다.

##### 비직렬 스케줄의 문제
비직렬 스케줄은 결과를 예상할 수 없다.

아래는 `데이터 A에 10을 더하는 트랜잭션1`, `10을 빼는 트랜잭션2` 시나리오다.
- 트랜잭션1이 데이터 A를 Read 했다.(A=10)
- 비직렬 스케줄이기 때문에 다음 트랜잭션2도 데이터 A를 Read 수행을 하러 갔다.(A=10)
- 트랜잭션1이 데이터 A의 Write를 수행했다.(A <- 10+10)
  - (그렇다면 트랜잭션2에 있는 Read된 데이터 A는 무슨 값인가? -> 10)
- 트랜잭션2도 데이터 A의 Write를 수행했다.(A <- 10-10)

원하는 결과는 10이지만, 실제 결과는 0이다.
이렇게 값을 잃어버리는 것을 `Lost Update`라고 한다.

##### 비직렬 스케줄 해결 방법
그래서 나온 아이디어는 `직렬 스케줄과 비직렬 스케줄이 동일(equivalent)하면 된다` 라는 것에서 나왔다.
그렇다면 비직렬 스케줄이 `Serializability` 속성을 가지면 된다.

###### Conflict
충돌은 세 종류가 있다.
- Read -> Write
- Write -> Read
- Write -> Write
- ❌ Read -> Read는 충돌이 아니다. (변하지 않기 때문, 멱등성)

충돌하기 위한 필수 조건은 아래와 같다.
- 서로 다른 트랜잭션에 소속
- 같은 데이터에 접근
- 최소 하나는 Write Operation(쓰기 작업)

###### Conflict Equivalent
충돌 동등하기 위한 필수 조건은 아래와 같다.
- 두 스케줄은 같은 트랜잭션들을 가진다.
- 모든 충돌 연산의 순서도 양쪽 스케줄 모두 동일하다.

###### Conflict Serializable
비직렬 스케줄이 직렬 스케줄과 충돌 동등하다면 충돌 직렬 가능하다고 한다.

##### 헷갈리는 부분은 왜 갑자기 충돌이 나왔는가?
값이 변하는 이유는 충돌의 순서에 따라 달라지기 때문이다.

직렬 스케줄도 충돌이 가능하다.
하지만 직렬 스케줄은 충돌의 순서가 다른 트랜잭션의 개입이 없기 때문에 원하는 결과가 나온다.

비직렬 스케줄은 다른 트랜잭션의 개입이 존재할 수 있다. 그러므로 결과가 달라질 수 있다.

##### 충돌 예시
![충돌1](/readme-images/9-10/conflict1.png)
- `r2(H) -> w1(H)` 는 읽기 후 쓰기 충돌이다.
- `w2(H) -> r1(H)` 는 쓰기 후 읽기 충돌이다.
- `w2(H) -> w1(H)` 는 쓰기 후 쓰기 충돌이다.

##### 충돌 동등 예시
![충돌동등1](/readme-images/9-10/conflict_equivalent.png)
- 스케줄3(`Non-serial Schedule`)의 충돌 순서
  - Read -> Write 충돌 (`r2(H) -> w1(H)`)
  - Write -> Read 충돌 (`w2(H) -> r1(H)`)
  - Write -> Write 충돌 (`w2(H) -> w1(H)`)
- 스케줄2(`Serial Schedule`)의 충돌 순서
  - Read -> Write 충돌 (`r2(H) -> w1(H)`)
  - Write -> Read 충돌 (`w2(H) -> r1(H)`)
  - Write -> Write 충돌 (`w2(H) -> w1(H)`)

비직렬 스케줄인 스케줄3과 직렬 스케줄인 스케줄2의 모든 충돌 연산의 순서가 동일하다.
그러므로 스케줄3은 충돌 동등하다.
그러므로 스케줄3은 충돌 직렬화 가능하다.

##### 충돌 직렬화 O/X 예시
위의 충돌 동등 예시는 충돌 직렬화 가능 케이스이다.

반대로 충돌 직렬화가 불가능한 케이스는 아래이다.

###### 비직렬 스케줄4와 직렬 스케줄2
![충돌직렬화1](/readme-images/9-10/conflict_serializable1.png)
- 스케줄4(`Non-serial Schedule`)의 충돌 순서
  - Read -> Write 충돌 (`r1(H) -> w2(H)`)
  - Read -> Write 충돌 (`r2(H) -> w1(H)`)
  - Write -> Write 충돌 (`w2(H) -> w1(H)`)
- 스케줄2(`Serial Schedule`)의 충돌 순서
  - Read -> Write 충돌 (`r2(H) -> w1(H)`)
  - Write -> Read 충돌 (`w2(H) -> r1(H)`)
  - Write -> Write 충돌 (`w2(H) -> w1(H)`)
- 두 스케줄은 충돌 연산의 순서가 동일하지 않으므로 직렬화가 불가능하다.

###### 비직렬 스케줄4와 직렬 스케줄1
![충돌직렬화2](/readme-images/9-10/conflict_serializable2.png)
- 스케줄4(`Non-serial Schedule`)의 충돌 순서
  - Read -> Write 충돌 (`r1(H) -> w2(H)`)
  - Read -> Write 충돌 (`r2(H) -> w1(H)`)
  - Write -> Write 충돌 (`w2(H) -> w1(H)`)
- 스케줄1(`Serial Schedule`)의 충돌 순서
  - Read -> Write 충돌 (`r1(H) -> w2(H)`)
  - Write -> Read 충돌 (`w1(H) -> r2(H)`)
  - Write -> Write 충돌 (`w1(H) -> w2(H)`)
- 두 스케줄은 충돌 연산의 순서가 동일하지 않으므로 직렬화가 불가능하다.

### Recoverability

`Recoverability`하다는 것은 복구 가능 즉, rollback이 가능한 것을 말한다.

#### 시나리오
**K가 H에게 20만원을 이체할 때 H도 본인에게 30만원을 입금했는데 만약 에러가 발생해 `rollback` 된다면?**

##### Unrecoverable Schedule
![복구가능성_시나리오1](/readme-images/9-10/recoverability1.png)
- 트랜잭션1이 먼저 커밋되고, 트랜잭션 2가 이후에 롤백되는 상황이다.
- 커밋이 되면 지속성(Durability)에 의해 롤백이 불가능하다.
- 그래서 복구 불가능한 스케줄이다.
- DB에서는 이를 허용하지 않는다.

##### Recoverable Schedule
그렇다면 복구 가능한 스케줄은?

###### Cascading rollback
- 둘다 커밋 되거나
- 둘다 롤백 되거나
- 그런데 이는 비용이 클 것이다.

###### Cascadeless Schedule 
이 방법은 `Commit/Rollback` 된 데이터만 `읽기를 허용`하자는 것이다.
`cascadeless schedule`을 `avoid cascading rollback`이라고도 부른다.

**Commit**된 데이터 읽기

![cascadeless1](/readme-images/9-10/cascadeless1.png)

**Rollback**된 데이터 읽기

![cascadeless2](/readme-images/9-10/cascadeless2.png)

###### Strict Schedule
cascadeless를 뚫는 또 다른 시나리오가 있다.

**H 사장님이 3만원이던 피자 가격을 2만원으로 낮추려는데 K 직원도 동일한 피자의 가격을 실수로 1만원으로 낮추려고 했을 때**

❌ 불가능, **Cascadeless Schedule**

![strict_schedule1](/readme-images/9-10/strict_schedule1.png)
- 위는 `cascacdeless schedule`이라고 할 수 있다.
- 하지만 `쓰기`를 막지 않으면 위처럼 `H 사장님 트랜잭션2`가 아예 사라지게 된다.
- 그래서 `Strict Schedule`은 `Commit/Rollback` 된 데이터만 `읽기/쓰기`를 허용 하는 것이다.

✅ **Strict Schedule**

![strict_shcedule2](/readme-images/9-10/strict_schedule2.png)
- 이렇게 하면 rollback할 때 recovery가 쉬워진다.
- 트랜잭션을 이전 상태로만 되돌리면 된다.

### Transaction Isolation Levels
> Of the four ACID properties in a DBMS (Database Management System), the isolation property is the one most often relaxed. When attempting to maintain the highest level of isolation, a DBMS usually acquires locks on data which may result in a loss of concurrency, or implements multiversion concurrency control. This requires adding logic for the application to function correctly.
> 
> [위키피디아 - Isolation](https://en.wikipedia.org/wiki/Isolation_(database_systems)#Isolation_levels)

RDBMS에서는 아래 상황들을 해결하기 위한 다양한 격리 레벨을 제공한다.

#### 표준 SQL 기준

##### Dirty Read
![dirty-read](/readme-images/9-10/dirty_read.png)
- x = 10이고 y = 20이다. 
- 트랜잭션1은 x에 y를 더하고
- 트랜잭션2는 y의 값을 70으로 바꿨다가 롤백을 한다.
- 결과는 x=80, y=20이 된다.
- 정상적인 상황이라면 x=30, y=20이어야 한다.

`Dirty Read는 commit되지 않은 결과를 반영하는 것이다.`

##### Non-repeatable Read
![non-repeatable-read](/readme-images/9-10/nonrepeatable_read.png)
- x = 10이다.
- 트랜잭션1은 x를 두 번 읽는다.
- 트랜잭션2는 x의 값을 50으로 바꾼다.
- 트랜잭션1은 x의 값이 처음에는 10이었는데, 두 번째 읽을 때는 50이다.

`Non-repeatable Read는 같은 데이터의 값이 달라지는 것이다.`
`Fuzzy Read`라고도 한다.

트랜잭션은 `ACID` 중 `isolation`에 의하면 트랜잭션끼리는 서로 `격리`되어야 한다.
그런데 Read만 했음에도 불구하고 값이 바뀌었다.
이는 발생해서는 안되는 일이다.

##### Phantom Read
![phantom-read](/readme-images/9-10/phantom-read.png)
- t1 튜플은 v = 10인 데이터를 가진다.
- t2 튜플은 v = 50인 데이터를 가진다.
- 트랜잭션1은 v = 10인 데이터를 두 번 읽는다.
- 트랜잭션2는 t2 튜플의 v를 50으로 바꾼다.
- 처음 v = 10인 데이터를 읽을 때는 t1만 나왔는데 두 번째 읽을 때는 t1, t2가 나온다.

`Phantom Read는 없던 데이터가 생기는 것이다.`

위와 `Non-repeatable Read`와 마찬가지로 읽기만 했는데도 데이터가 바뀌었다.

##### Non-repeatable Read와 Phantom Read의 차이
- `Non-repeatable Read`는 값이 바뀌는 것이고 
- `Phantom Read`는 값이 생기는 것

#### SQL 확장 예시

##### Dirty Write
![dirty-write](/readme-images/9-10/dirty_write.png)
- x = 0이다.
- 트랜잭션1은 x의 값을 10으로 바꾼 뒤 **rollback**한다.
- 트랜잭션2는 x의 값을 100으로 바꾼 뒤 **rollback**한다.
- 동작 과정은 트랜잭션1이 **rollback**할 때 `0`이 되었다가
- 트랜잭션2가 **rollback**을 하면 `0 -> 10`으로 바뀐다.
- 그럼 최종 값은 `10`이 된다.
- 만약 여기서 트랜잭션2가 롤백하지 않는다면 x는 0이 되었을 것이고 트랜잭션2는 무시될 것이다.

`rollback 시 정상적인 recovery는 정말 중요하기 때문에 모든 isolation levels에서 Dirty Write를 허용하면 안된다.`

##### Lost Update
![lost-update](/readme-images/9-10/lost_update.png)
- x = 50이다.
- 트랜잭션1은 x에 50을 더한다.
- 트랜잭션2는 x에 150을 더한다.
- 위처럼 트랜잭션1이 나중에 커밋하면서 트랜잭션2의 변경 사항은 잃어버리게 된다.

`Lost Update는 값을 덮어 쓰는 것이다.`

##### Dirty Read 확장
![dirty-read-expand](/readme-images/9-10/dirty_read_expand.png)
- x = 50, y = 50이다.
- 트랜잭션1은 x가 y에 40을 이체한다.
- 트랜잭션2는 x와 y를 읽는다.
- 트랜잭션2는 x와 y의 합이 60이지만, 실제 x와 y의 합은 100이다.

`Dirty Read는 Rollback이 일어나지 않아도 발생할 수 있다.`

##### Read Skew
![read-skew](/readme-images/9-10/read_skew.png)
- x = 50, y = 50이다.
- 트랜잭션1은 x와 y를 읽는다.
- 트랜잭션2는 x가 y에 40을 이체한다.
- 트랜잭션1은 y의 합이 140이지만, 실제 x와 y의 합은 100이다.

`Read Skew는 Inconsistent한 데이터를 읽는 것이다.`

##### Write Skew
![write-skew](/readme-images/9-10/write_skew.png)
- x = 50, y = 50이다.
- 트랜잭션1은 x에서 80을 인출한다.
- 트랜잭션2는 y에서 90을 인출한다.
- 제약 사항으로는 x + y는 0보다 커야 한다.
- 트랜잭션1 기준 결과는 x + y = 20이고
- 트랜잭션2 기준 결과는 x + y = 10이다.
- 하지만 모두 커밋하고 나서 실제 결과는 -70이다.

`Write Skew는 Inconsistent한 데이터를 쓰는 것이다.`

##### Phantom Read 확장
![phantom-read-expand](/readme-images/9-10/phantom_read_expand.png)
- 튜플 t1의 v = 7이다.
- cnt는 튜플의 v값이 10 초과하는 튜플의 개수이다.
- 트랜잭션1은 v > 10인 데이터와 cnt를 읽는다.
- 트랜잭션2는 v = 15 튜플 t2를 추가하고 cnt를 1 증가한다.
- 트랜잭션1은 처음 v > 10을 읽었을 때는 0이지만 cnt를 읽을 때는 값이 1이다.

#### Snapshot Isolation
![snapshot-isolation](/readme-images/9-10/snapshot_isolation.png)
- x = 50, y = 50이다.
- 트랜잭션1은 x가 y에 40을 이체한다.
- 트랜잭션2는 y에 100을 입금한다.
- 결과는 트랜잭션1이 롤백된다.

`스냅샷 격리`는 **트랜잭션이 시작**할 때 **스냅샷**을 찍는다.
그리고 스냅샷을 기준으로 수행한다.
만약 동일한 데이터를 수정하면 `먼저 커밋된 트랜잭션이 반영`되고 나중에 커밋하려고 하는 트랜잭션은 실제 값과 스냅샷 값을 비교하고 다르면 롤백된다.

이는 `낙관적 락`과 같은 개념이다.

#### RDBMS의 Isolation Levels

##### MySQL (InnoDB)
| Isolation Levels | Dirty Read | Non-repeatable Read | Phantom Read |
|:----------------:|:----------:|:-------------------:|:------------:|
| Read uncommitted |     O      |          O          |      O       |
|  Read committed  |     X      |          O          |      O       |
| Repeatable read |     X      |          X          |      O       |
| Serializable |     X      |          X          |      X       |

##### Oracle
- 오라클은 Read uncommitted와 Repeatable read를 제공하지 않는다.
- Repeatable read를 사용할 거라면 Serializable을 사용하면 된다.

| Isolation Levels | Dirty Read | Non-repeatable Read | Phantom Read |
|:----------------:|:----------:|:-------------------:|:------------:|
| Read uncommitted |     -      |          -          |      -       |
|  Read committed  |     X      |          O          |      O       |
| Repeatable read |     -      |          -          |      -       |
| Serializable |     X      |          X          |      X       |

##### SQL Server
| Isolation Levels | Dirty Read | Non-repeatable Read | Phantom Read |
|:----------------:|:----------:|:-------------------:|:------------:|
| Read uncommitted |     O      |          O          |      O       |
|  Read committed  |     X      |          O          |      O       |
| Repeatable read  |     X      |          X          |      O       |
|     Snapshot     |     X      |          X          |      X       |
|   Serializable   |     X      |          X          |      X       |

##### PostgreSQL
- 다른 RDBMS들은 Repeatable read에서 Phantom Read가 가능하지만 PostgreSQL은 불가능하다. 

| Isolation Levels | Dirty Read | Non-repeatable Read | Phantom Read | Serialization Anomaly |
|:----------------:|:----------:|:-------------------:|:------------:|:---------------------:|
| Read uncommitted |     O      |          O          |      O       |           O           |
|  Read committed  |     X      |          O          |      O       |           O           |
| Repeatable read |     X      |          X          |      X       |           O           |
| Serializable |     X      |          X          |      X       |           X           |

### 2PL

#### Exclusive Lock / Shared Lock

##### Exclusive Lock
`Write Lock` 또는 `Exclusive Lock`이라고 한다.

보통 쓰기 연산을 할 때 배타 락을 걸어 다른 트랜잭션에서 해당 데이터에 읽기/쓰기 연산 또는 공유 락/배타 락을 걸지 못하도록 한다.  
(읽기 연산에도 Exclusive Lock을 걸 수 있다.)

##### Shared Lock
`Read Lock` 또는 `Shared Lock`이라고 한다.

읽기 연산을 할 때 공유 락을 걸어 다른 트랜잭션에서 쓰기 연산 또는 배타 락을 걸지 못하도록 한다.
(읽기 연산이나 공유 락을 거는 것은 가능하다)

##### 시나리오1
![exclusive-lock](/readme-images/9-10/2PL1.png)
- 트랜잭션1은 x를 읽는다.
- 트랜잭션2는 x를 20으로 바꾼다.
- 제일 먼저, 트랜잭션1이 x에 공유 락을 건다.
- 다음으로 트랜잭션2가 x에 배타 락을 건다. 하지만 공유 락이 걸려 있어 블록 상태가 된다.
- 트랜잭션1이 언락을 하고 나면, 블록이던 트랜잭션2가 락을 획득하여 쓰기 연산을 수행한다.

`쓰기 락은 어떠한 락과도 같이 사용할 수 없다.`

##### 시나리오2
![shared-lock](/readme-images/9-10/2PL2.png)
- 트랜잭션1과 트랜잭션2는 x를 읽는다.
- 트랜잭션1이 x에 공유 락을 건다.
- 트랜잭션2도 x에 공유 락을 건다.
- 모두 동시에 읽기 연산을 수행하고 락을 반납한다.

`공유 락끼리는 동시에 락을 소유할 수 있다.`

##### 배타락/공유락 호환성
|                | Shared-Lock | Exclusive-Lock |
|:--------------:|:-----------:|:--------------:|
|  **Shared-Lock**   |      O      |       X        |
| **Exclusive-Lock** |      X      |       X        |

#### 락을 써도 생기는 문제 `동시성`
![nonserializable](/readme-images/9-10/2PL3.png)
- 트랜잭션1과 트랜잭션2는 x와 y의 합을 x에 저장한다.
- 충돌 연산의 순서가 직렬 스케줄과 달라 직렬화될 수 없다.
- 또, 흐름만 보더라도 `Write Skew`가 발생한다.

![serializable](/readme-images/9-10/2PL4.png)
- 둘의 순서만 바꾸어주어도 이게 해결된다.
- 이 것을 `2PL` 프로토콜이라고 부른다.

#### 2PL 프로토콜
`2PL(two-phase locking)` 프로토콜은 tx에서 모든 Lock 연산을 Unlock 연산보다 먼저 수행되도록 하는 것이다.
즉, 모든 Lock 연산 이후에 Unlock 연산을 수행하도록 하는 것이다.

여기서 **Lock** 연산을 수행하는 구간을 `Expanding phase` 또는 `Growing phase` 라고 부르며,
**Unlock** 연산을 수행하는 구간을 `Shrinking phase` 또는 `Contracting phase`라고 부른다.

##### 데드락
![2PL-deadlock](/readme-images/9-10/2PL5_deadlock.png)
- 트랜잭션1는 x와 y의 합을 y에 저장한다.
- 트랜잭션2는 x와 y의 합을 x에 저장한다.
- 서로 처음에 공유 락을 건다.
- 그리고 나중에 쓰기 락을 거는데 공유 락이 있어 블록 상태가 된다.
- 하지만 서로 놓아주지 못해 데드락 상태에 빠지게 된다.

##### Conservative 2PL
![conservative-2pl](/readme-images/9-10/conservative-2PL.png)
- 처음부터 사용할 모든 자원에 락을 취득하고 트랜잭션을 시작하는 것이다.
- 데드락에 안전하다.
- 실용적이지 않다.

##### Strict 2PL(S2PL)
![s2pl](/readme-images/9-10/s2pl.png)
- `Strict Schedule`을 보장하는 2PL이다.
- `Recoverability`를 보장한다.
- `Exclusive Lock`을 `커밋/롤백`될 때 반환한다.

##### Strong Strict 2PL(SS2PL)
![ss2pl](/readme-images/9-10/ss2pl.png)
- `Strict Schedule`을 보장하는 2PL이다.
- `Recoverability`를 보장한다.
- `Exclusive Lock`과 `Shared Lock`을 `커밋/롤백`될 때 반환한다.
- `S2PL`보다 구현이 쉽다.

### MVCC 가기 전 흐름 정리

결국엔 모두 동시성을 제어하는 게 목적이다.

- Isolation Levels는 총 네 개(Read Uncommitted, Read Committed, Repeatable Read, Serializable)이다.
- `Isolation Levels`는 Dirty Read, Non-repeatable Read, Phantom Read 등을 막을 수 있는 레벨을 정의한 `명세`같은 것이다.
- 실제로 저걸 `구현한 메커니즘`은 `배타 락`과 `공유 락`을 이용한 `S2PL`, `SS2PL` 또는 `스냅샷`을 이용한 `MVCC`이다.
- 그럼 여기서 `애플리케이션`에서 적용하는 동시성 제어는?
  - 일반적으로 DB 기본 격리 수준은 Repeatable Read(MySQL/InnoDB) 또는 Read Committed(PostgreSQL, Oracle, SQL Server)이다.
  - 이것은 쓰기 연산의 경우 S2PL로 배타 락을 커밋/롤백 까지만 유지해 막았지만 읽기 연산은 공유 락을 엄격하게 걸지 않았다.
    - 마지막 공유 락 부분은 정확히 InnoDB는 MVCC를 사용해 공유 락 자체를 사용하지 않음
  - 그래서 `Lost Update`나 `Write Skew`가 발생할 수 있다.
  - 그러면 이를 격리 수준을 Serializable로 올려 가장 강한 격리 수준을 사용하도록 만들면 되는 거 아닌가?
    - 모든 곳에 그렇게 적용하면 엄청 느려질 것이다.
    - 만약, 적용할 거라면 부분적으로 적용하는 것이 좋다.
    - 그래서 비관적 락 또는 낙관적 락 또는 원자적/상태 UPDATE 방식으로 애플리케이션에서 동시성을 제어한다.

  
### MVCC

#### MVCC란?
> 다중 버전 동시성 제어(multiversion concurrency control, MCC, MVCC), 다중 버전 병행 수행 제어는 데이터베이스 관리 시스템이 일반적으로 사용하는 동시성 제어 방식으로, 데이터베이스로의 동시 접근을 제공하고 프로그래밍 언어에서 트랜잭셔널 메모리를 구현한다.
> 
> [위키피디아 - 다중 버전 동시성 제어](https://ko.wikipedia.org/wiki/%EB%8B%A4%EC%A4%91_%EB%B2%84%EC%A0%84_%EB%8F%99%EC%8B%9C%EC%84%B1_%EC%A0%9C%EC%96%B4)

쉽게 말해, `MVCC(MultiVersion Concurrency Control)`는 스냅샷을 통해 동시성을 제어하는 방법이다.

#### MVCC를 사용하는 이유

공유 락을 먼저 취득하면 그 데이터의 배타 락을 취득하지 못한다.
반대로 배타 락을 먼저 취득하더라도 공유 락을 취득하지 못한다.

이 것은 퍼포먼스를 낮추는 원인이 된다.

> 그렇다면 MVCC는 무엇이고 사용하게 되면 퍼포먼스를 증가할 수 있을까?

결론부터 먼저 말하면, MVCC는 공유 락을 사용하지 않으며, read와 write는 서로 블록하지 않기 때문에 배타 락과 동시에 사용할 수 있다.
즉, 배타 락을 취득한 데이터에 대해 읽기가 가능하고 공유 락을 사용하지 않기 때문에 Read한 데이터에 대해서도 배타 락을 취득하는 게 가능해진다.

> MVCC: 데이터를 읽을 때 **특정 시점 기준**으로 **가장 최근에 Commit**된 데이터 읽는다.
> 
> MySQL에서는 특정 시점 기준으로 Read하는 것을 `Consistent Read`라고 한다.

- 공유 락 사용

  |           | Read | Write |
  |:---------:|:----:|:-----:|
  | **Read**  |  O   |   X   |
  | **Write** |  X   |   X   |
- MVCC 사용

  |           | Read | Write |
  |:---------:|:----:|:-----:|
  | **Read**  |  O   |   O   |
  | **Write** |  O   |   X   |

MVCC는 스냅샷을 찍어 비교를 통해 동시성을 제어한다.
예를 들어, 격리 수준이 Read Committed인 경우의 MVCC는 Read를 했을 때의 스냅샷을 찍는다. 그리고 Write를 하면 바로 바뀌는 것이 아니라 별도의 공간에 저장한다. 그리고 나중에 커밋을 하게 되면 그때 실제 DB에 반영한다.
(격리 수준에 따라 MVCC 방식이 달라진다)(또한, 실제로 Write를 하면 별도 공간에 저장되는 것은 기존의 데이터들이다. 즉, 진짜로 데이터가 즉시 바뀌는 것이고 이전 버전을 별도 공간에 저장하고 문제가 발생하면 이전 버전으로 undo, rollback 하는 것이다.)

#### Read Uncommitted MVCC

- MySQL에서 해당 격리 수준에서는 MVCC가 적용되지 않는다.
- PostgreSQL에서는 Read Committed와 똑같은 MVCC가 적용된다.

#### Read Committed MVCC

Read하는 시간을 기준으로 그 전 Commit된 데이터를 읽는다.

##### PostgreSQL

![postgresql-read-committed2](/readme-images/9-10/postgre_read1.png)
- 트랜잭션1이 먼저 배타 락을 취득해 작동한다.
- 별도 공간에 x=10, y=50을 저장하고 커밋한 후 배타 락을 반납한다.

![postgresql-read-committed1](/readme-images/9-10/postgre_read2.png)
- 위에서 반납된 배타 락을 트랜잭션2가 취득한다.
  - 격리 수준이 `Read Committed`라서 이미 `read(x) -> 50`에서 가져와 잘못된 것을 잡지 못한다.
  - 사실 상 Read Committed으로는 다른 트랜잭션의 동시 변경을 잡지 못한다.(대기는 별도 배타 락으로 동작하므로 작동함)
- 이후 별도 공간에 x=80을 저장하고 커밋한 후 배타 락을 반납한다.
- 최종 결과는 x=80, y=50이다.
- 우리가 예상했던 결과는 x=40, y=50이다.
- `Lost Update`가 발생한 것이다.

#### Repeatable Read MVCC

트랜잭션 시작 시간을 기준으로 그 전에 Commit된 데이터를 읽는다.

##### PostgreSQL

![postgresql-repeatable-read1](/readme-images/9-10/postgre-repeatable1.png)
- 제일 먼저 `Read Committed`때와 마찬가지로 트랜잭션1이 동작한다.

![postgresql-repeatable-read2](/readme-images/9-10/postgre-repeatable2.png)
- 트랜잭션2는 격리 수준이 `Repeatable Read`이다.
- 그래서 같은 데이터에 먼저 Update한 트랜잭션이 Commit하면 나중 트랜잭션은 롤백이 되고, 애플리케이션에서 재시도 로직이 필요할 수 있다.
- 이런 특징을 `First-Updater-Win`이라고 한다.

##### MySQL

- 제일 먼저, MySQL은 Repeatable Read에서 `Lost Update`와 `Write Skew`를 막아주지 못한다.
- 그래서 `SQL`에 `FOR UPDATE` 키워드를 사용하여 `배타 락`을 취득하여 사용해야 한다.
- 여기서 `FOR UPDATE/SHARE`를 이용하여 `배타 락을 취득`하는 걸 `Locking Read`라고 한다.
  - 락을 이용하지 않고 스냅샷을 읽는 것을 `Consistent Read`라고 한다.
- 또, 원래 `Repeatable Read`는 **트랜잭션이 시작했을 때**를 기준으로 커밋된 데이터를 읽는다.
- 하지만 `Locking Read`방식을 사용하면 **가장 최근의 커밋된 데이터**를 읽는다.
- 추가로 `FOR SHARE` 키워드는 공유 락을 취득하는 키워드이다.

###### MySQL Lost Update 해결
![mysql-repeatable-read-lostupdate](/readme-images/9-10/mysql-repeatable-lostupdate.png)
- 트랜잭션1은 x를 `Locking Read`를 통해 배타 락을 취득한다.
- 트랜잭션2도 x에 `Locking Read`를 하지만 트랜잭션1이 먼저 배타 락을 취득하여 **블록**된다.
- 트랜잭션1은 x=80을 쓰고 커밋한 후 배타 락을 반납한다.
- 트랜잭션2는 x를 읽는다. 그런데 `Repeatable Read`는 트랜잭션 시작에서 값을 읽어와 x=50이어야 하지만 `Locking Read(FOR UPDATE)`에서는 **가장 최근에 커밋**된 데이터를 읽어온다. 그러므로 x=80을 읽어온다.
- 이후 x=40을 쓰고 y에도 `Locking Read`를 통해 읽어오며 배타 락을 취득한다.
- 마찬가지로 y=50을 쓰고 커밋한다.

###### MySQL Write Skew 해결
![mysql-repeatable-read-writeskew](/readme-images/9-10/mysql-repeatable-writeskew.png)
- 트랜잭션1은 x를 `Locking Read`를 통해 배타 락을 취득한다.
- 트랜잭션2도 x에 `Locking Read`를 하지만 트랜잭션1이 먼저 배타 락을 취득하여 **블록**된다.
- 트랜잭션1은 y도 `Locking Read`를 통해 배타 락을 취득한다.
- 트랜잭션1은 x=20을 쓰고 커밋한 후 배타 락을 반납한다.
- 트랙잭션2는 x를 읽는다. `Locking Read`이기 때문에 **가장 최근 커밋**된 x를 읽는다. 그러므로 20이다.
- 트랜잭션2는 y도 `Locking Read`를 통해 배타 락을 취득한다.
- 트랜잭션2는 y=30을 쓰고 커밋한 후 배타 락을 반납한다.

##### PostgreSQL의 격리 수준이 `Repeatable Read`일 때 `FOR UPDATE` MySQL과의 동작 차이
- 대부분의 DB에서도 `FOR UPDATE`, `FOR SHARE` 문법이 있어 직접 락을 취득할 수 있다.
- 하지만 PostgreSQL은 MySQL과 동작 방식이 조금 다르다.
- PostgreSQL은 격리 수준이 `Repeatable Read`인 경우 같은 데이터를 먼저 Update하는 다른 트랜잭션이 있으면 롤백을 한다.
- 이것은 `FOR UPDATE/SHARE`를 쓴다고 해도 달라지지 않는다.
- 그래서 `PostgreSQL은 격리 수준이 Repeatable Read 이상인 경우에 FOR UPDATE를 사용할 때 재시도 로직이 필요하다.`

#### Serializable MVCC

- **MySQL**에서는 `autocommit`이 꺼진 트랜잭션 안의 `Select 쿼리`에 대해 **Shared Lock**으로 동작한다.
  - 배타 락으로도 동작할 수 있지만 성능 상의 이유로 `Shared Lock`을 사용한다고 한다.
  - 하지만 Shared Lock을 사용하므로 `데드락`의 위험이 있다.
- **PostgreSQL**에서는 `SSI(Serializable Snapshot Isolation)` 기법이 적용된 MVCC로 동작한다.

### References
- [쉬운코드 - BJ 43.1 Concurrency Control, Serializability](https://youtu.be/DwRN24nWbEc?si=2RFSCzRTltN0i_7N)
- [쉬운코드 - BJ 43.2 Concurrency Control, Recoverability](https://youtu.be/89TZbhmo8zk?si=dF4T2Ph6prsn-87y)
- [쉬운코드 - BJ 44 Isolation Levels](https://youtu.be/bLLarZTrebU?si=jyrc6jUHyDizaWMM)
- [쉬운코드 - BJ 45 Lock, 2PL](https://youtu.be/0PScmeO3Fig?si=W3OYlOTwy9GdZhrP)
- [쉬운코드 - BJ 46.1 MVCC](https://youtu.be/wiVvVanI3p4?si=xtTVRkCLfmAn8fRK)
- [쉬운코드 - BJ 46.2 MVCC](https://youtu.be/-kJ3fxqFmqA?si=JcTE5T1V2aWUxGCI)



