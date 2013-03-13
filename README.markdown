#vaadinbuilder: a Groovy Builder for Vaadin
Goal is to make the creation of vaadin GUIs as clutterless as possible, using the excellent
[builder](http://docs.codehaus.org/display/GROOVY/BuilderSupport) support of Groovy.

##Current State
* Currently using Groovy 2.0.x and Vaadin 7.0.1 as base.
* Not all widgets implemented
* the sampler is ugly

##Building/Using it
    mvn build; java -jar vaadinbuilder-sampler/target/vaadinbuilder-sampler-0.2-war-exec.jar
==> open localhost:8080/sampler in your browser, start working :)





