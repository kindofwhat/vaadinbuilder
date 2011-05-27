package org.groovyvadin.factories

import com.vaadin.ui.Layout
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Component
import groovy.util.AbstractFactory;
import groovy.util.FactoryBuilderSupport;

import java.util.Map;

abstract class AbstractLayoutFactory extends AbstractComponentFactory {
	
	
	def void handleAttributeMargin(FactoryBuilderSupport builder, Layout layout, Boolean value) {
			layout.setMargin(new Layout.MarginInfo(value))
	}
	
}
