/**
 * Created with IntelliJ IDEA.
 * User: christian
 * Date: 3/11/13
 * Time: 7:29 AM
 * To change this template use File | Settings | File Templates.
 */
package org.groovyvaadin.sampler

import com.vaadin.annotations.Theme
import com.vaadin.server.FileResource
import com.vaadin.server.VaadinRequest
import com.vaadin.server.VaadinService
import com.vaadin.ui.UI
import com.vaadin.ui.VerticalLayout
import org.groovyvaadin.VaadinBuilder

@Theme('builder')
class VaadinBuilderSamplerApplication extends UI {
    private VaadinBuilder builder

    @Override
    protected void init(VaadinRequest request) {
        VerticalLayout root = new VerticalLayout()
        setContent(root)
        String basepath = VaadinService.current.baseDirectory.absolutePath
        FileResource samplesDir = new FileResource(new File(basepath + '/samples'))

        builder = new VaadinBuilder(root, this)
        builder.vlayout(spacing: 10) {
            hlayout(spacing: 10) {
                samplesDir.sourceFile.eachFile { sample ->
                    linkbutton(caption: sample.name, onclick: { c.source.value = sample.text })
                }

            }
            textarea('source', height: '500', width: '800', caption: 'Builder Input:', value: '''
//Choose a sample or start typing away
//vaadinbuilder sampler v0.4

vlayout() {
    label(caption:'hello world')
}

//Click 'Create UI' to display your UI
''')
            button(caption: 'Create UI', onclick: {
                window('showWindow', caption:'VaadinBuilder sample window', modal:true, height:'80%', width: '80%') {
                    vlayout('showLayout')   {
                        label(caption:'Sample Result:')
                    }
                }
                VaadinBuilder myBuilder = new VaadinBuilder(builder.components.showLayout, this)
                Binding b = new Binding()
                b.setVariable("builder", myBuilder)
                GroovyShell sh = new GroovyShell(b);
                sh.evaluate("builder.${builder.components.source.value}");
            })
            vlayout('target')
        }

        //To change body of implemented methods use File | Settings | File Templates.
    }

}
