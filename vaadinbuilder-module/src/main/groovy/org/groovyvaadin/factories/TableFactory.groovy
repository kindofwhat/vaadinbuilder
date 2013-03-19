package org.groovyvaadin.factories

import com.vaadin.data.util.ObjectProperty
import com.vaadin.data.util.PropertysetItem
import com.vaadin.ui.*
import com.vaadin.data.Container

class TableRowFactory extends AbstractItemFactory{


    @Override
    void setChild(FactoryBuilderSupport builder, Object parent, Object child) {
//        parent.addItemProperty(parent.itemPropertyIds.size(), child)
        parent << child
    }

    @Override
    void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
        Table table = (Table)parent
        if(table.getContainerPropertyIds().size()==0) {
            //have to add those properties
            node.eachWithIndex { property,idx ->
                table.addContainerProperty(idx,property.class,null)
            }
        }
        table.addItem(node as Object[], table.size())
    }

    @Override
    void setParent(FactoryBuilderSupport builder, Object parent, Object child) {
            int i=0
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    protected Object createComponent() {
        return []
//        return new PropertysetItem()
    }
}

class TableFactory extends AbstractSelectFactory {

    private headers = []
	@Override protected Object createComponent() {
        Table result = new Table()
		return result
	}

    @Override
    boolean onNodeChildren(FactoryBuilderSupport builder, Object node, Closure childContent) {
        return true
    }

    @Override
    void onNodeCompleted(FactoryBuilderSupport builder, Object parent, Object node) {
        headers.eachWithIndex { header, idx ->
            node.setColumnHeader(idx, header)
        }
    }

    @Override
    public void setChild( FactoryBuilderSupport builder, Object parent, Object child )  {
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

    def void handleAttributeHeader(FactoryBuilderSupport builder, Table table, List headers)  {
        this.headers = headers


    }



}