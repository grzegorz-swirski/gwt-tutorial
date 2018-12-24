package com.grzegorz.training.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.grzegorz.training.client.application.ApplicationPresenter;
import com.grzegorz.training.client.place.NameTokens;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy>
        implements HomeUiHandlers {

    private static final Logger LOG = Logger.getLogger(HomePresenter.class.getName());

    interface MyView extends View, HasUiHandlers<HomePresenter> {
    }

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Override
    public void onSend(String name) {
        LOG.log(Level.SEVERE, "SEVERE Message received: " + name);
        LOG.log(Level.INFO, "INFO Message received: " + name);
    }

    @Inject
    HomePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

        getView().setUiHandlers(this);
    }
}
