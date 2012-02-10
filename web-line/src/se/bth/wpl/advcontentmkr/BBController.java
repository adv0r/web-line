package se.bth.wpl.advcontentmkr;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class BBController {
	BlackBoard bb=null;
	Map<Class<?>, String[]> jmC;
	public BBController(){
		bb= new BlackBoard();
		jmC= new HashMap<Class<?>, String[]>();
	}
	public void load (Map<String, String[]> jm){
		try {
			bb.updateSolution(loadJars(jm));
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String finish(){
		return bb.getSolution();
	}
	public Map<Class<?>,String[]> loadJars (Map<String, String[]> jm) throws MalformedURLException, ClassNotFoundException{
		Iterator<String>it=jm.keySet().iterator();
		while(it.hasNext()){
			String tmp2=it.next();
			Class<?> tmp=loadJar(tmp2);
			jmC.put(tmp, jm.get(tmp2));
		}
		return jmC;
		
	}
	private Class<?> loadJar(String name) throws MalformedURLException, ClassNotFoundException{
		File file  = new File("res/plugins/"+name+".jar");

		URI url = file.toURI();  
		URL[] urls = new URL[]{url.toURL()};
		ClassLoader cl = new URLClassLoader(urls);

		return cl.loadClass("com.se.bth.wpl.plugins."+name);
	}
}
