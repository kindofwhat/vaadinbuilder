package org.groovyvaadin.factories

import com.vaadin.event.ItemClickEvent
import com.vaadin.ui.AbstractSelect

abstract class AbstractSelectFactory extends AbstractFieldFactory {
	def void handleAttributeOnclick(FactoryBuilderSupport builder, AbstractSelect select, Closure closure) {
		select.addListener (closure as ItemClickEvent.ItemClickListener )
	}


}
