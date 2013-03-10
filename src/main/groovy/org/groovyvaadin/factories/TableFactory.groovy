package org.groovyvaadin.factories

import com.vaadin.ui.*
import com.vaadin.data.Container


class TableFactory extends AbstractSelectFactory {
	@Override protected Component createComponent() {
		return new Table()
	}

    def void handleAttributeFieldFactory(FactoryBuilderSupport builder, Table table, Closure closure) {
        TableFieldFactory tff = new DefaultFieldFactory() {
            @Override
            public Field createField(Container container, Object itemId,
                                     Object propertyId, Component uiContext) {
                return closure.call(itemId, propertyId)
            }

        }
        table.tableFieldFactory=tff

    }


}