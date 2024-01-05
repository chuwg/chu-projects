# gRPC Proto Architecture

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
src/main/proto/파일명.proto
</div>

### 순서
<div style="padding: 10px;border: 1px solid yellow;">
1. ProtoArchitectureGuide <br/>
2. ServerArchitectureGuide <br/>
3. ClientArchitectureGuide
</div>

### 사용법
<div style="border:1px solid blue;padding:10px;">
<p>
build.gradle 파일에 gRPC 관련 dependencies 추가 <br />
main/proto/파일명.proto 파일 생성 <br />
파일명.proto 에서 service & message 설정
</p>

<p>
Gradle>Tasks 를 활용해서 other/<b>generateProto</b> 실행<br />
build/generated/source/proto/main/grpc 경로에 Service명Grpc (여기서는 ProductInfoGrpc) 파일이 생성되었는지 확인한다. 
build/generated/source/proto/main/java 경로에 Service명OuterClass (여기서는 ProductInfoOuterClass) 파일이 생성되었는지 확인한다.
</p>
<p>
Gradle Tasks 를 활용하여 publishing/<b>publishToMavenLocal</b> 실행<br /> 
build/libs/ 경로에 있는 <br />
artifactId-version-plain.jar 파일이 생성되었는지 확인한다.<br />
(build.gradle에서 54번 line에 publishing에서 설정해준 artifactId와 version이 이름으로 사용된다.)
</p>
</div>