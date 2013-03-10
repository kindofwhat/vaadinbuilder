package org.groovyvaadin;

import groovy.util.GroovyScriptEngine;
import groovy.util.ResourceException;
import groovy.util.ScriptException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;

import org.codehaus.groovy.control.CompilerConfiguration;

import com.vaadin.Application;
import com.vaadin.terminal.gwt.server.ApplicationServlet;

/**
 * @author Christian Sprecher
 */
public class GroovyScriptEngineApplicationServlet  extends ApplicationServlet {

	private static final long serialVersionUID = 7368864881058974722L;

	private GroovyScriptEngine engine=null;  
	 @Override
	    protected ClassLoader getClassLoader() throws ServletException {
	        if (engine == null) {
	        	String path = getServletConfig().getInitParameter("scriptsPath");
	        	if(path!=null) {
	        		List<String> paths = new ArrayList<String>();
	        		StringTokenizer tokenizer = new StringTokenizer(path,";\n");
	        		while(tokenizer.hasMoreElements()) {
	        			String next = (String) tokenizer.nextElement();
	        			paths.add( next.trim().replaceAll("^\\s+", ""));
	        		}
	        		try {
	        			String[] allPaths = new String[paths.size()];
	        			engine=new GroovyScriptEngine(paths.toArray(allPaths), super.getClassLoader());
	        			CompilerConfiguration config = new CompilerConfiguration();
	        			config.setDebug(!this.isProductionMode());
	        			config.setRecompileGroovySource(true);
	        			
	        		} catch (IOException e) {
	        			throw new RuntimeException("Error creating Groovy Script Engine: " + e);
	        		}
	        		
	        	}

	        }
	        return engine.getGroovyClassLoader();
	    }

@Override
@SuppressWarnings("unchecked")
protected Class<? extends Application> getApplicationClass()   {

//	if(engine==null) return super.getApplicationClass();
    final String applicationClassName = getServletConfig().getInitParameter("application");
    if (applicationClassName == null) {
        throw new RuntimeException("Application not specified in servlet parameters");
    }
        try {
			return (Class<? extends Application> ) engine.loadScriptByName(applicationClassName.replace('.', '/') +".groovy");
		} catch (ResourceException e) {
            throw new RuntimeException("Resource not found: " +applicationClassName);
		} catch (ScriptException e) {
            throw new RuntimeException("Script exception: " + e);
		}
}

}