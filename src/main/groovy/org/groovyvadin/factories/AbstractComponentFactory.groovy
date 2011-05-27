package org.groovyvadin.factories

import com.vaadin.ui.Component
import com.vaadin.ui.Layout
import com.vaadin.ui.VerticalLayout
import groovy.util.AbstractFactory;
import groovy.util.FactoryBuilderSupport;

import java.util.Map;

abstract class AbstractComponentFactory extends AbstractFactory {
	
	@Override
	protected void handleValue(Component component, value) {
		id = value
	}

	@Override
	public void setParent(FactoryBuilderSupport builder, Object parent,Object child) {
		parent.addComponent child
	}

	@Override
	Object newInstance(FactoryBuilderSupport builder,Object name,Object value,Map attributes) {
		Component component=createComponent()
		handleValueOnInit(builder, value,component)
		
		if(!builder.attached) {
			 builder.rootComponent.addComponent component
			 builder.attached=true
		}
		
		return component
	}
	
	protected abstract Component createComponent()
	
	protected void handleValueOnInit(FactoryBuilderSupport builder ,value, Component component) {
		if(value!=null) {
			if(builder.components[value]) println "Component with id $value already defined, will be overwritten"
			builder.components[value]=component
		}
	}
	
	protected void handleAttributes(FactoryBuilderSupport builder, component, Map attributes){
		attributes.each {name, value ->
			def capName = name.capitalize()
			if(this.metaClass.getMetaMethod ("handleAttribute${capName}", [builder, component,value] as Object[]) ) {
				this."handleAttribute${capName}"(builder, component,value)
			} else defaultHandleAttribute(component,name,value) 
		}
	}
	
	def void defaultHandleAttribute(component, name, value) {
		if(component.metaClass.hasProperty(component,"$name")) component."$name"=value
		else println "Property $name of class ${component.class.name} not found"
	}
}