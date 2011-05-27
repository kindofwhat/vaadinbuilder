package org.groovyvadin.factories

import com.vaadin.ui.*;

class TableFactory extends AbstractSelectFactory {
	@Override protected Component createComponent() {
		return new Table()
	}

}