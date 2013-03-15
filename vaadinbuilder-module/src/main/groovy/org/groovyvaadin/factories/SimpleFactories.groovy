package org.groovyvaadin.factories

import com.vaadin.ui.*

import com.vaadin.ui.Component
import com.vaadin.ui.themes.BaseTheme

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
		button.addClickListener(closure as Button.ClickListener)
	}

}

class LinkButtonFactory extends ButtonFactory{
    @Override protected Component createComponent() {
        Button button = new Button()
        button.styleName= BaseTheme.BUTTON_LINK
        return button
    }

}

class TextFieldFactory extends AbstractFieldFactory {
	@Override protected Component createComponent() {
		return new TextField()
	}
}

class TextAreaFactory extends AbstractFieldFactory {
    @Override protected Component createComponent() {
        return new TextArea()
    }
}


class TreeFactory extends AbstractSelectFactory {
	@Override protected Component createComponent() {
		return new Tree()
	}
}

class TreeTableFactory extends TableFactory {
    @Override protected Component createComponent() {
        return new TreeTable()
    }

}


