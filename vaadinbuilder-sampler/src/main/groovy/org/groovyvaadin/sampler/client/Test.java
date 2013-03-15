package org.groovyvaadin.sampler.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;


/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 3/13/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class Test implements EntryPoint {
    @Override
    public void onModuleLoad() {
        RootPanel.get().add(new Label("Hello, world!"));
    }
}