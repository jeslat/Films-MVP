package com.jla.modelviewpresenter.view.util;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;

public class MainThreadBus extends Bus {

    private final Handler mainThread = new Handler(Looper.getMainLooper());
    private static MainThreadBus bus;

    @Override
    public void post(final Object event) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            super.post(event);
        } else {
            mainThread.post(new Runnable() {
                @Override
                public void run() {
                    post(event);
                }
            });
        }
    }

    public static MainThreadBus getInstance() {
        if (bus == null)
            bus = new MainThreadBus();
        return bus;
    }
}
