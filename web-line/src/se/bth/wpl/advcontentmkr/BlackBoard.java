package se.bth.wpl.advcontentmkr;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

public class BlackBoard {
	String solution;
    private static final Logger log = Logger.getLogger(BlackBoard.class.getName());

	public String[] invokeJar(Class<?> cl){
		Object obj= null;
		String[] st= null;
		try {

			
			st= (String[])(cl.getMethods()[0].invoke(obj));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return st;
	}

	public String getSolution() {
		return solution;
	}
	
	public BlackBoard()
	{
		solution=null;
	}

	public void updateSolution(Map<Class<?>, String[]> map) {
		// TODO Auto-generated method stub
		Iterator<Class<?>> itC= map.keySet().iterator();
		
		while(itC.hasNext()){
			String[] staticCode=null;
			String[] params = null;

			Class<?>tmpC= itC.next();
			staticCode=invokeJar(tmpC);
			
			String name = tmpC.getName();

			if(map.get(tmpC)==null)
			{
				String[] sTemp = {};
				params=sTemp;
			}
			else
			{
				params = map.get(tmpC);
			}
			
			//Check coherence
			
			if( (params.length + 1) == (staticCode.length) )
			{
				log.warning("Plugin-in code generation started for * "+name+" *");	
				solution = "\n\n<!-- ## Begin Plugin Code : "+name+" ##  -->\n";
				solution += staticCode[0];
				if(params.length >= 1)
				{
					for(int i=0; i<params.length;i++)
					{
						solution=solution + params[i] + staticCode[i+1];	
					}
				}
				solution +="\n\n<!-- ## End Plugin : "+name+" ##  -->\n";
				
				log.warning("Plugin-in generated : * "+name+" *");	
	
			}
			else
			{
			log.warning("Plugin-in Configuration error for *"+name+"* : the number of parameter is not compliant\n" +
						"Number of Params = "+params.length+ " , Plugin Code slices = " + staticCode.length);	

			}
		}

		}
}

