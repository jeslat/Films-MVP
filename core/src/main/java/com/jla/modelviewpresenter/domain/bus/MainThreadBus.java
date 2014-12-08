package com.jla.modelviewpresenter.domain.bus;

public interface MainThreadBus {

    public void post(Object event);

    public void register(Object object);

    public void unregister(Object object);
}
