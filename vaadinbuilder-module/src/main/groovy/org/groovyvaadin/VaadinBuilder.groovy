//see http://vgrails.googlecode.com/svn/trunk/src/groovy/org/zhakimel/vgrails/builder/VaadinBuilder.groovy
package org.groovyvaadin

import org.groovyvaadin.factories.*

import com.vaadin.ui.Component

/**
 * Builder for Vaadin GUIs
 *
 * @author Christian Sprecher
 */
class VaadinBuilder extends FactoryBuilderSupport {
	private Component rootComponent
	def model=[:]
	/**
	 * holds all components which have been id'ed by the first argument, e.g. textfield('mytextfield')
	 */
	def components=[:]
	def missingProperties=[:]
	private boolean attached=false
	
	public VaadinBuilder(Component rootComponent) {
		this.rootComponent=rootComponent
		register()
	} 
	
	public VaadinBuilder() {
		register()
	}
	
	private void register() {
		registerFactory "vlayout", new VerticalLayoutFactory()
		registerFactory "hlayout", new HorizontalLayoutFactory()
		registerFactory "gridlayout" , new GridLayoutFactory()
		registerFactory "absolutelayout", new AbsoluteLayoutFactory()
		registerFactory "formlayout", new FormLayoutFactory()
		registerFactory "customlayout", new CustomLayoutFactory()
		registerFactory "csslayout", new CssLayoutFactory()
		registerFactory "horizontalsplitpanel", new HorizontalLayoutFactory()
		registerFactory "verticalsplitpanel" , new VerticalSplitPanelFactory()
		registerFactory "tabsheet" , new TabSheetFactory()
		registerFactory "label" , new LabelFactory()
		registerFactory "button",new ButtonFactory()
        registerFactory "linkbutton",new LinkButtonFactory()
		registerFactory "textfield",new TextFieldFactory()
        registerFactory "textarea",new TextAreaFactory()
        registerFactory "tree",new TreeFactory()
		registerFactory "table",new TableFactory()
        registerFactory "tr", new TableRowFactory()
        registerFactory "treetable",new TreeTableFactory()
        autoRegisterNodes()
    }
	
	/**
	 * delegate to currentFactory.handleAttributes(node,attributes)
	 * @param layout
	 * @param attributes
	 */
	@Override
    protected void setNodeAttributes(Object node, Map attributes) {
		currentFactory.handleAttributes(this, node, attributes)
	}
	
}



