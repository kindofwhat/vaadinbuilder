package org.groovyvaadin.typed

import com.vaadin.ui.TextArea
import com.vaadin.ui.UI
import groovy.transform.CompileStatic

@CompileStatic
class VerticalLayoutBuilder {
    public void create(Closure c) {


    }
}

@CompileStatic
class VaadinBuilder {
    UI ui

    void vlayout(@DelegatesTo(VerticalLayoutBuilder) Closure createClosure ) {
        createClosure()

    }
}
