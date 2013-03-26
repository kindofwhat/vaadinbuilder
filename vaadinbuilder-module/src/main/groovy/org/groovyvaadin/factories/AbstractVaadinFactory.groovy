package org.groovyvaadin.factories

import com.vaadin.ui.Component

abstract class AbstractVaadinFactory extends AbstractFactory {
	
	@Override
	protected void handleValue(Component component, value) {
		id = value
	}

	@Override
	Object newInstance(FactoryBuilderSupport builder,Object name,Object value,Map attributes) {
		def component=createComponent()
		handleValueOnInit(builder, value,component)
		
		if(!builder.attached) {
			 builder.rootComponent.addComponent component
			 builder.attached=true
		}
		
		return component
	}
	
	protected abstract Object createComponent()
	
	protected void handleValueOnInit(FactoryBuilderSupport builder ,value, Object component) {
		if(value!=null) {
			if(builder.components[value]) println "Component with id $value already defined, will be overwritten"
			builder.components[value]=component
		}
	}

    @Override
	public boolean onHandleNodeAttributes(FactoryBuilderSupport builder, component, Map attributes){
		attributes.each {name, value ->
			def capName = name.capitalize()
			if(this.metaClass.getMetaMethod ("handleAttribute${capName}", [builder, component,value] as Object[]) ) {
				this."handleAttribute${capName}"(builder, component,value)
			} else defaultHandleAttribute(component,name,value) 
		}
        return true
	}
	
	def void defaultHandleAttribute(component, name, value) {
		if(component.metaClass.hasProperty(component,"$name")) component."$name"=value
		else println "Property $name of class ${component.class.name} not found"
	}


}