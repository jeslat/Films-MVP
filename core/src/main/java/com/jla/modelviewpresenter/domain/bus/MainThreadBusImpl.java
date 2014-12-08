package com.jla.modelviewpresenter.domain.bus;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

public class MainThreadBusImpl extends Bus implements MainThreadBus {

    private final Handler mainThread = new Handler(Looper.getMainLooper());

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            mainThread.post(() -> post(event));
        }
    }
}
