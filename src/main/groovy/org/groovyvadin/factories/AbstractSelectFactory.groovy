package org.groovyvadin.factories

import com.vaadin.data.Property
import com.vaadin.data.util.ObjectProperty
import com.vaadin.event.FieldEvents
import com.vaadin.event.ItemClickEvent
import com.vaadin.ui.AbstractSelect
import com.vaadin.ui.Field
import com.vaadin.ui.Layout
import com.vaadin.ui.Select;
import com.vaadin.ui.Tree
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Component

import groovy.lang.Closure;
import groovy.util.AbstractFactory;
import groovy.util.FactoryBuilderSupport;

import java.util.Map;

import org.codehaus.groovy.binding.PropertyBinding;

abstract class AbstractSelectFactory extends AbstractFieldFactory {
	def void handleAttributeOnclick(FactoryBuilderSupport builder, AbstractSelect select, Closure closure) {
		select.addListener (closure as ItemClickEvent.ItemClickListener )
	}

	
}
