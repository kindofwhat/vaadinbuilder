package org.groovyvaadin.factories

import com.vaadin.ui.Component

abstract class AbstractComponentFactory extends AbstractVaadinFactory {

    @Override
    public void setChild( FactoryBuilderSupport builder, Object parent, Object child )  {
        parent.addComponent child
    }


    @Override
	public void setParent(FactoryBuilderSupport builder, Object parent,Object child) {
		//do nothing ?
	}


}