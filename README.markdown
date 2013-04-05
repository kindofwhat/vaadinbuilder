#vaadinbuilder: a Groovy Builder for Vaadin
The goal of this little projekt is to make the creation of [Vaadin 7](https://vaadin.com) GUIs as clutterless as possible,
 using the excellent [builder](http://docs.codehaus.org/display/GROOVY/BuilderSupport) support of Groovy.

##Current State
* Currently using Groovy 2.0.x and Vaadin 7.0.1 as base.
* Most widgets implemented
* Basic Binding implementend

##Prerequisites
* [Java] (http://www.java.com/download)
* [Maven] (http://maven.apache.org/download.cgi)

##Building/Using it
    mvn build; java -jar vaadinbuilder-sampler/target/vaadinbuilder-sampler-0.2-war-exec.jar
==> open http://localhost:8080/sampler in your browser, start working :)


##Sample
The [Sampler](https://github.com/kindofwhat/vaadinbuilder/blob/master/vaadinbuilder-sampler/src/main/groovy/org/groovyvaadin/sampler/VaadinBuilderSamplerApplication.groovy)
App strives to showcase the usage

##Online Demo
The [Sampler](https://github.com/kindofwhat/vaadinbuilder/blob/master/vaadinbuilder-sampler/src/main/groovy/org/groovyvaadin/sampler/VaadinBuilderSamplerApplication.groovy)
running on [CloudBees] (http://vaadinbuilder.kindofwhat.cloudbees.net/)  (might be a little outdated)




