package org.groovyvaadin.factories

import com.vaadin.ui.Layout

abstract class AbstractLayoutFactory extends AbstractComponentFactory {
	
	
	def void handleAttributeMargin(FactoryBuilderSupport builder, Layout layout, Boolean value) {
			layout.setMargin(new Layout.MarginInfo(value))
	}
	
}
