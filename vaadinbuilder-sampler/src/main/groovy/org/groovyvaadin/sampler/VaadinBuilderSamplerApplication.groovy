/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 3/11/13
 * Time: 7:29 AM
 * To change this template use File | Settings | File Templates.
 */
package org.groovyvaadin.sampler

import com.vaadin.server.VaadinRequest
import com.vaadin.ui.AbsoluteLayout
import com.vaadin.ui.Label
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import com.vaadin.ui.Window
import org.groovyvaadin.VaadinBuilder

class VaadinBuilderSamplerApplication extends UI {
    private VaadinBuilder builder

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout root = new VerticalLayout()
        setContent(root)

        builder = new VaadinBuilder(root)
        builder.vlayout() {
            textarea('source', height: '500', width: '800', caption: 'Source Input', value: '''
            vlayout() {
                tabsheet() {
                    vlayout(caption:'Login') {
                        gridlayout('loginGrid', caption:'Login', columns:2, width: 600) {
                            label( caption:'URL')
                            textfield('url', model:'url')
                            label(caption:'Name'); textfield('username', model:'username')
                            label(caption:'Password'); textfield('password', secret:true, model:'password')
                            label(); button('login', caption:'Login', onclick: {this.login()})
                            label(); button('logout', caption:'Logout', onclick: {this.logout()}, enabled:false)
                        }
                        hlayout() {
                            label('welcomeLabel')
                        }
                    }
                    hlayout('browser', caption:'Browser', readOnly:true, width:1100) {
                        tree('browserTree', immediate:true, caption:'Browser Tree', width:200, onchange: { e-> /*println e.source;*/ this.displayNode()})
                        hlayout('nodeDetails', visible:false) {
                        }
                    }
                }
            }
            ''')
            button(caption: 'Create UI', onclick: {
                Window sampleWindow= new Window("VaadinBuilder sample window")
                sampleWindow.modal=true
                AbsoluteLayout sampleRoot = new AbsoluteLayout()
                sampleWindow.content=sampleRoot
                VaadinBuilder myBuilder = new VaadinBuilder(sampleRoot)
                sampleWindow.height='80%'
                sampleWindow.width='80%'
                Binding b = new Binding()
                b.setVariable("x", myBuilder)
                GroovyShell sh = new GroovyShell(b);
                sh.evaluate("x.${builder.components.source.value}");
                addWindow(sampleWindow)

//                this.builder.components.target.removeAllComponents()
//                Eval.me('builder', builder, "builder.components.target.addComponent( builder.${builder.components.source.value})")
                //Eval.xy(myBuilder, 'label(caption:\'lala\')', 'x.y')

            })
            vlayout('target')
        }

        //To change body of implemented methods use File | Settings | File Templates.
    }

}
