//see http://vgrails.googlecode.com/svn/trunk/src/groovy/org/zhakimel/vgrails/builder/VaadinBuilder.groovy
package org.groovyvadin

import java.util.Map;

import groovy.util.FactoryBuilderSupport
import org.groovyvadin.factories.*

import com.vaadin.ui.Component
import com.vaadin.ui.Panel
import com.vaadin.ui.HorizontalLayout
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.CssLayout



import com.vaadin.ui.Label
import com.vaadin.ui.TextField
import com.vaadin.ui.Select
import com.vaadin.ui.GridLayout
import com.vaadin.ui.DateField
import com.vaadin.ui.Button
import com.vaadin.ui.NativeButton
import com.vaadin.ui.Form
import com.vaadin.ui.Table
import com.vaadin.event.FieldEvents;
import com.vaadin.terminal.ThemeResource
import com.vaadin.ui.Window
import com.vaadin.ui.ComboBox
import com.vaadin.ui.SplitPanel
import com.vaadin.ui.TabSheet
import com.vaadin.ui.Accordion
import com.vaadin.ui.PasswordField

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
		registerFactory "textfield",new TextFieldFactory()
		registerFactory "tree",new TreeFactory()
		registerFactory "table",new TableFactory()
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



