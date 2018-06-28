package com.example.user.services.callbacks;

public class ServiceConnectionManager {

    ServiceConnectionOne serviceConnectionOne;
    ServiceConnectionSecond serviceConnectionSecond;

    public ServiceConnectionManager(ServiceConnectionOne serviceConnectionOne, ServiceConnectionSecond serviceConnectionSecond) {
        this.serviceConnectionOne = serviceConnectionOne;
        this.serviceConnectionSecond = serviceConnectionSecond;
    }
}
