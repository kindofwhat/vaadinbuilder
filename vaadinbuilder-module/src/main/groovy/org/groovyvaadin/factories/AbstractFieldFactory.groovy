package org.groovyvaadin.factories

import com.vaadin.data.Property

import com.vaadin.event.FieldEvents
import com.vaadin.ui.Field

import com.vaadin.ui.Component

abstract class AbstractFieldFactory extends AbstractComponentFactory {
	protected void handleValueOnInit(FactoryBuilderSupport builder ,value, Component component) {
		if(value!=null) {
			super.handleValueOnInit(builder,value,component) 
			if(builder.missingProperties[value]) {
				builder.missingProperties[value].each { refComponent ->
					println "delayed adding of propertyRef with id $value"
					handleAttributePropertyRef(builder, refComponent, value)
				}
				builder.missingProperties.remove(value)
			}
		}
	}
	
	
	def void handleAttributeOntextchange(FactoryBuilderSupport builder, Field field, Closure closure) {
		field.addListener (closure as FieldEvents.TextChangeListener)
	}
	def void handleAttributeOnchange(FactoryBuilderSupport builder, Field field, Closure closure) {
		field.addValueChangeListener (closure as Property.ValueChangeListener)
	}

	def void handleAttributeModel(FactoryBuilderSupport builder, Property property, String key) {
		property.addListener(  {event -> builder.model[key] = event.property.value} as Property.ValueChangeListener)
	}

	def void handleAttributePropertyRef(FactoryBuilderSupport builder, Property property, String id) {
		if(!builder.components[id]) {
			 println "No component found for id $id"
			if(!builder.missingProperties[id]) builder.missingProperties[id]=[]
			builder.missingProperties[id]<<property
		} else {
            property.setPropertyDataSource(builder.components[id])
		}
	}
}
