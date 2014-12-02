package com.jla.modelviewpresenter.view.bus;

public interface MainThreadBus {

    public void post(Object event);

    public void register(Object object);

    public void unregister(Object object);
}
