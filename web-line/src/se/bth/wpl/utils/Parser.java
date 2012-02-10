package se.bth.wpl.utils;

import java.util.logging.Logger;

public class Parser {
	private static final String TAG="#WPL_ID";
	private static final String CLOSE_COMMENT ="-->";
	private static final String OPEN_COMMENT ="<!--";
	private static final String STOP_TAG="STOP";
	
	
	public static final String REPLACE="replace";
	public static final String NEXTLINE="netline";
	public static final String REPLACE_TILL_STOP="replacetillstop";

    private static final Logger log = Logger.getLogger(Parser.class.getName());

	public Parser()
	{
		
	}
	
	public String parse(String originalString,String what,String where,String mode)
	{
		String toReturn = originalString;
		String toSearch = TAG+"='"+where+"'";
		int charToEndComment = toSearch.length()+CLOSE_COMMENT.length();
		int indexOfTag = originalString.indexOf(toSearch);
		if(indexOfTag!=-1)
		{
			
			
			if(mode.equals(REPLACE)) //REPLACE THE COMMENTS
			{
				String toReplace = OPEN_COMMENT+toSearch+CLOSE_COMMENT;
				log.warning("Looking forward to replace : "+toReplace);
				toReturn = toReturn.replace(toReplace, what);
				log.warning("String: "+toReplace+" found and replaced");
			}
			
			
			else if(mode.equals(NEXTLINE)) //WRITE ON NEXT LINE
			{
				int indexToInsert = indexOfTag+charToEndComment;
				String firstPart = originalString.substring(0,indexToInsert)+"\n";
				String lastPart = "\n"+originalString.substring(indexToInsert,originalString.length());
				toReturn = firstPart+what+lastPart;	
				
				log.warning("String: "+toSearch+" found, next line appended"); 
			}
			
			
			else //REPLACE NEXT LINE
			{
				String toReplace = OPEN_COMMENT+toSearch+CLOSE_COMMENT;
				String stop = OPEN_COMMENT+STOP_TAG+CLOSE_COMMENT;
				int indexToInsert = indexOfTag+charToEndComment;		
				String firstPart = originalString.substring(0,indexToInsert-toReplace.length());
				String branch=originalString.substring(indexToInsert,originalString.length());
				int indexInBranch = branch.indexOf(stop)+stop.length();
				if(indexInBranch!=-1)
				{
					int indexFinal=indexToInsert+indexInBranch;				
					String lastPart = originalString.substring(indexFinal,originalString.length());
					toReturn = firstPart+what+lastPart;	

					log.warning("String: "+toSearch+" found, next line replaced");
				}
				else 
					log.warning("Stop String not found after: "+toSearch);

			}
		
		}
		else 
			log.warning("String: "+toSearch+" not found");

		return toReturn;
	}

}
