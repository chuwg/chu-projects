package com.tistory.roobistory.serverarchitectureguide;
import ProtoArchitectureGuide.ProductInfoGrpc;
import ProtoArchitectureGuide.ProductInfoOuterClass;
import io.grpc.Status;
import io.grpc.StatusException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductInfoImpl extends ProductInfoGrpc.ProductInfoImplBase {
    // 플러그인에 의해 생성된 추상클래스 (ProductInfoGrpc.ProductInfoImplBase)를 확장하여
    // AddProduct 와 GetProduct 메서드에 비즈니스 로직을 추가합니다.
    // AddProduct, GetProduct 는 Protoarchitectureguide 에서 proto 파일로 정의한 부분입니다.
    private final Map<String, ProductInfoOuterClass.Product> productMap = new HashMap<>();

    @Override
    // addProduct 메서드는 Product 를 파라미터로 사용합니다.
    // Product 클래스는 서비스 정의에 의해 생성된 ProductInfoOuterClass 클래스에 선언되어 있습니다.

    public void addProduct(ProductInfoOuterClass.Product request,
                           io.grpc.stub.StreamObserver<ProductInfoOuterClass.ProductID> responseObserver) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        request = request.toBuilder().setId(randomUUIDString).build();
        productMap.put(randomUUIDString, request);
        ProductInfoOuterClass.ProductID id
                = ProductInfoOuterClass.ProductID.newBuilder().setValue(randomUUIDString).build();
        responseObserver.onNext(id);
        responseObserver.onCompleted();
    }

    @Override
    // getProduct 메서드는 ProductID 를 파라미터로 사용합니다.
    // addProduct 상황과 마찬가지로 ProductInfoOuterClass 클래스에 선언되어 있습니다.
    // responseObserver 는 클라이언트에게 응답을 보내고 스트림을 닫는데 사용합니다.
    public void getProduct(ProductInfoOuterClass.ProductID request,
                           io.grpc.stub.StreamObserver<ProductInfoOuterClass.Product> responseObserver) {
        String id = request.getValue();
        if (productMap.containsKey(id)) {
            responseObserver.onNext((ProductInfoOuterClass.Product) productMap.get(id));
            // 클라이언트에 응답을 보냅니다.
            responseObserver.onCompleted();
            // 스트림을 닫아 클라이언트 호출을 종료합니다.
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
            // 클라이언트에게 에러를 보냅니다.
        }
    }
}
