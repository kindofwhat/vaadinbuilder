package org.groovyvadin.factories


import com.vaadin.event.ItemClickEvent
import com.vaadin.ui.*

import groovy.lang.Closure;
import groovy.util.AbstractFactory;
import groovy.util.FactoryBuilderSupport;
import com.vaadin.ui.Component

import java.util.Map;

interface SimpleFactories {}

class VerticalLayoutFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new VerticalLayout()
	}
}

class HorizontalLayoutFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new HorizontalLayout()
	}
}

class GridLayoutFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new GridLayout()
	}
}
class CustomLayoutFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new CustomLayout()
	}
}
class FormLayoutFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new FormLayout()
	}
}

class AbsoluteLayoutFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new AbsoluteLayout()
	}
}
class HorizontalSplitPanelFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new HorizontalSplitPanel()
	}
}
class VerticalSplitPanelFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new VerticalSplitPanel()
	}
}
class CssLayoutFactory extends AbstractLayoutFactory {
	@Override protected Component createComponent() {
		return new CssLayout()
	}
}
class TabSheetFactory extends AbstractComponentFactory {
	@Override protected Component createComponent() {
		return new TabSheet()
	}
}

class LabelFactory extends AbstractFieldFactory {
	@Override protected Component createComponent() {
		return new Label()
	}
}

class ButtonFactory extends AbstractFieldFactory {
	@Override protected Component createComponent() {
		return new Button()
	}
	def void handleAttributeOnclick(FactoryBuilderSupport builder, Button button, Closure closure) {
		button.addListener(closure as Button.ClickListener)
	}

}

class TextFieldFactory extends AbstractFieldFactory {
	@Override protected Component createComponent() {
		return new TextField()
	}
}

class TreeFactory extends AbstractSelectFactory {
	@Override protected Component createComponent() {
		return new Tree()
	}
}


