package org.groovyvaadin.factories

import com.vaadin.ui.UI
import com.vaadin.ui.Window

class WindowFactory extends AbstractVaadinFactory {

    UI ui

    public WindowFactory(UI ui) {
        this.ui=ui
    }



    @Override
    public void setChild( FactoryBuilderSupport builder, Object parent, Object child )  {
        parent.content =child
    }


    @Override
	public void setParent(FactoryBuilderSupport builder, Object parent,Object child) {
	}

    @Override
    protected Object createComponent() {
        return new Window()  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    Object newInstance(FactoryBuilderSupport builder,Object name,Object value,Map attributes) {
        Window window = new Window()
        handleValueOnInit(builder, value,window)
        ui.addWindow window

        if(!builder.attached) {
            builder.attached=true
        }

        return window
    }

}