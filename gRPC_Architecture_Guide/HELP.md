### gRPC의 장점
1. 구조화된 데이터를 *직렬화*합니다.
2. 언어에 구애받지 않는 *플랫폼 중립적*입니다.
3. 확장 가능한 메커니즘인 *프로토콜 버퍼*를 사용해서 *서비스 인터페이스*를 정의한다.

### gRPC를 사용하는 순서
1. *프로토콜 버퍼*를 사용해 *서비스 인터페이스를 정의*합니다.
2. 선택한 프로그래밍 언어에 대한 서버와 클라이언트 코드를 생성합니다.
3. 저수준 통신 추상화를 제공함으로써 서버와 클라이언트의 로직 단순화합니다.
4. 서버에서는 원격으로 제공되는 메서드의 로직을 구현하고 서비스를 바인딩하는 gRPC 서버를 실행합니다.
5. 클라이언트에서는 원격 gPRC 서버에 연결하고 생성된 클라이언트 코드를 사용해 원격 메서드를 호출합니다.

### 참고하는 순서
1. ProtoArchitectureGuide
2. ServerArchitectureGuide
3. ClientArchitectureGuide

### 빌드하기
1. ServerArchitectureGuide Application 실행이 된 상태에서
2. ClientArchitectureGuide Application 실행하시면 
3. http://localhost:8080/productinfo 접속 시 helloWorld! 가 출력되며 <br />
콘솔창에는 StubService에 setName, setDescription, setPrice 가 출력됩니다. 
