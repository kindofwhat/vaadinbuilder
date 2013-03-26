package org.groovyvaadin.factories

/**
 * tries to create a component out of a name
 */
class DynamicComponentFactory extends AbstractVaadinFactory {

    @Override
    public void setChild( FactoryBuilderSupport builder, Object parent, Object child )  {
        if (child) parent.addComponent child
    }


    @Override
	public void setParent(FactoryBuilderSupport builder, Object parent,Object child) {
		//do nothing ?
	}

    @Override
    Object newInstance(FactoryBuilderSupport builder,Object name,Object value,Map attributes) {
        try {
            Class clazz= Class.forName("com.vaadin.ui.${name.capitalize()}")
            def component=clazz.newInstance()
            handleValueOnInit(builder, value,component)

            if(!builder.attached) {
                builder.rootComponent.addComponent component
                builder.attached=true
            }

            return component

        } catch (ClassNotFoundException e) {
            println ("did not find vaadin component for $name")
            return null

        }
    }

    @Override
    protected Object createComponent() {
        return null  //To change body of implemented methods use File | Settings | File Templates.
    }
}