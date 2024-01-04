package com.tistory.roobistory.grpcserver;

import grpcproto.GrpcProto;
import grpcproto.ProductInfoGrpc;
import io.grpc.Status;
import io.grpc.StatusException;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProductInfoImpl extends ProductInfoGrpc.ProductInfoImplBase {
    private Map productMap = new HashMap<String, GrpcProto.Product>();

    @Override
    public void addProduct(GrpcProto.Product request,
                           io.grpc.stub.StreamObserver<GrpcProto.ProductID> responseObserver) {
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        request = request.toBuilder().setId(randomUUIDString).build();
        productMap.put(randomUUIDString, request);
        GrpcProto.ProductID id
                = GrpcProto.ProductID.newBuilder().setValue(randomUUIDString).build();
        responseObserver.onNext(id);
        responseObserver.onCompleted();
    }

    @Override
    public void getProduct(GrpcProto.ProductID request,
                           io.grpc.stub.StreamObserver<GrpcProto.Product> responseObserver) {
        String id = request.getValue();
        if (productMap.containsKey(id)) {
            responseObserver.onNext((GrpcProto.Product) productMap.get(id));
            responseObserver.onCompleted();
        } else {
            responseObserver.onError(new StatusException(Status.NOT_FOUND));
        }
    }
}