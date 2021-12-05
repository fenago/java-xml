/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.File;

class XSLT
{
	public static void main(String[] args)
	{
	   try
	   {
         // instantiate factory
         TransformerFactory factory = TransformerFactory.newInstance();
         
         // instantiate transformer - pass in stylesheet
         Transformer xformer = 
            factory.newTransformer(new StreamSource(new File("order-html.xsl")));

         // transform() takes a Source and transforms it to a Result
         xformer.transform(new StreamSource(new File("order.xml")), 
                           new StreamResult(new File("order-result.html")));
	   }
	   catch (Exception e)
	   {
	      System.out.println(e);
	   }
	}
}
