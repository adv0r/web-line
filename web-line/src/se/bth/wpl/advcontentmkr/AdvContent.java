package se.bth.wpl.advcontentmkr;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class AdvContent implements IAdvContent{
	final Logger log = Logger.getLogger(AdvContent.class.getName());
	Map<String, String[]> jm;
	public AdvContent(){
		jm= new HashMap<String, String[]>();
	}
	public String createAdvContent() {
		
		BBController bbc= new BBController();
		bbc.load(jm);
		String result=bbc.finish();
		log.warning(result);
		return result;
	}
	@Override
	public void addPlugin(String jarName, String[] params) {
		jm.put(jarName, params);
	}

}
