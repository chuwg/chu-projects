# gRPC Server Architecture

### Setting
<div style="border: 1px solid red;padding:10px;">
Language : Java <br />
Version : 21 <br />
JDK : Open JDK 21 <br />
SpringBoot : 3.2.1 <br />
Package : Jar <br />
Dependencies : SpringBoot DevTools
</div>

### 사용하는 파일
<div style="border: 1px solid green;padding:10px;">
build.gradle <br />
ProductInfoImpl.java<br />
ProductInfoServer.java<br />
ServerArchitectureGuideApplication.java

</div>

### 순서
<div style="padding: 10px;border: 1px solid yellow;">
1. ProtoArchitectureGuide <br/>
2. ServerArchitectureGuide <br/>
3. ClientArchitectureGuide
</div>

### 사용법
<div style="border:1px solid blue;padding:10px;">
> gradle tasks build>build 를 사용해서 build 후<br />
ServerArchitectureGuideApplication 실행합니다.
</div>

ServerArchitectureGuide에 있는
application.properties -> application.yml 로 변경을 하였습니다.
(yaml 과 yml은 똑같습니다.)

### yml 을 사용한 이유?
<div style="border:1px solid gold;padding:10px;">
src/main/resources/application.yml<br /><br />
properties 형식 <br />
<pre>
spring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl
spring.datasource.username=username
spring.datasource.password=password
</pre>

yml 형식 <br />
<pre>
spring:
    datasource:
        driver-class-name: oracle.jdbc.driver.OracleDriver
        url: jdbc:oracle:thin:@localhost:1521:orcl
        username: username
        password: password
</pre>
yml을 사용하는 것이 더 구조를 파악하기 쉽고, 중복되는 코드가 줄어들기 때문에 yml을 사용하는 것이 더 좋다고 생각합니다.
<br /><br />
**주의**
    <p>
    properties와 yml을 함께 사용하면 properties 파일이 우선순위가 높아 yml 파일에서 설정한 내용이 덮어씌워질 수 있으므로 한쪽만 사용하는 것을 권장합니다.
    </p>
</div>

--- 

### 2024.1.16 변경 내역

패키지 생성
main/java/com/tistory/roobistory/serverarchitecturegiode/gRPC
main/java/com/tistory/roobistory/serverarchitecturegiode/repository
main/java/com/tistory/roobistory/serverarchitecturegiode/domain
main/java/com/tistory/roobistory/serverarchitecturegiode/service

파일 이동
main/java/com/tistory/roobistory/serverarchitecturegiode/gRPC
ProductInfoImpl.java
ProductInfoServer.java

이동 중 ServerArchitectureGuideApplication.java 에 사용되어 있는 start() 메서드와 blockUntilShutdown() 메서드에 public 추가

파일 추가
domain/Product.java
repository/ProductRepository

dependency 추가
https://mvnrepository.com/artifact/org.projectlombok/lombok
compileOnly 'org.projectlombok:lombok:1.18.30'
