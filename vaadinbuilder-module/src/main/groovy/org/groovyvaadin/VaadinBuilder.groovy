//see http://vgrails.googlecode.com/svn/trunk/src/groovy/org/zhakimel/vgrails/builder/VaadinBuilder.groovy
package org.groovyvaadin

import com.vaadin.ui.UI
import groovy.swing.SwingBuilder
import groovy.swing.factory.BindFactory
import groovy.swing.factory.BindGroupFactory
import groovy.swing.factory.BindProxyFactory
import org.groovyvaadin.factories.*

import com.vaadin.ui.Component

/**
 * Builder for Vaadin GUIs
 *
 * @author Christian Sprecher
 */
class VaadinBuilder extends FactoryBuilderSupport {
	private Component rootComponent
    private UI ui
	def model=[:]

    //holds all components which have been id'ed by the first argument, e.g. textfield('mytextfield')
	def components=[:]
	def missingProperties=[:]
	private boolean attached=false

    public VaadinBuilder(Component rootComponent, UI ui) {
        this.ui=ui
        this.rootComponent=rootComponent
        register()
    }

	private void register() {
        registerFactory "window", new WindowFactory(ui)
		registerFactory "vlayout", new VerticalLayoutFactory()
		registerFactory "hlayout", new HorizontalLayoutFactory()
		registerFactory "gridlayout" , new GridLayoutFactory()
		registerFactory "absolutelayout", new AbsoluteLayoutFactory()
		registerFactory "formlayout", new FormLayoutFactory()
		registerFactory "customlayout", new CustomLayoutFactory()
		registerFactory "csslayout", new CssLayoutFactory()
		registerFactory "horizontalsplitpanel", new HorizontalLayoutFactory()
		registerFactory "verticalsplitpanel" , new VerticalSplitPanelFactory()
        registerFactory "accordion",new AccordionFactory()
		registerFactory "tabsheet" , new TabSheetFactory()
		registerFactory "label" , new LabelFactory()
        registerFactory "link" , new LinkFactory()
		registerFactory "button",new ButtonFactory()
        registerFactory "linkbutton",new LinkButtonFactory()
		registerFactory "textfield",new TextFieldFactory()
        registerFactory "textarea",new TextAreaFactory()
        registerFactory "richtext",new RichTextAreaFactory()
        registerFactory "datefield",new DateFieldFactory()
        registerFactory "popupdatefield",new PopupDateFieldFactory()
        registerFactory "password",new PasswordFieldFactory()
        registerFactory "combobox",new ComboBoxFactory()
        registerFactory "tree",new TreeFactory()
		registerFactory "table",new TableFactory()
        registerFactory "tr", new TableRowFactory()
        registerFactory "treetable",new TreeTableFactory()
        this.methodMissingDelegate = { name, args ->
            println("tried to call $name with $args")
        }
    }

    /**
	 * delegate to currentFactory.handleAttributes(node,attributes)
	 * @param layout
	 * @param attributes
	 */
	@Override
    protected void setNodeAttributes(Object node, Map attributes) {
		currentFactory.onHandleNodeAttributes(this, node, attributes)
	}

    @Override
    protected Factory resolveFactory(Object name, Map attributes, Object value) {
        Factory found = super.resolveFactory(name.toLowerCase(),attributes,value)
        if(!found) { found = new DynamicComponentFactory()}
        return found
    }
	
}



