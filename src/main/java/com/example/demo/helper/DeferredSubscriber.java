package com.example.demo.helper;

import org.springframework.web.context.request.async.DeferredResult;
import rx.Subscriber;

public class DeferredSubscriber<T> extends Subscriber<T> {
    private DeferredResult<T> result;

    public DeferredSubscriber(DeferredResult<T> result) {
        this.result = result;
    }

    @Override
    public void onCompleted() {
        // do nothing
    }

    @Override
    public void onError(Throwable e) {
        this.result.setErrorResult(e);
    }

    @Override
    public void onNext(T o) {
        this.result.setResult(o);
    }
}
