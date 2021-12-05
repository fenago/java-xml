package com.javatunes.sax;
/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */


import javax.xml.parsers.*;
import org.xml.sax.*;
import java.io.FileReader;

public class SAXTest
{
   public static void main(String[] args)
   {
      if (args.length != 2)
      {
         System.out.println("Usage: java SAXTest file target-element");
         System.exit(-1);
      }
      
      // declare the factory and parser, handler and XML source
      SAXParserFactory factory = null;
      SAXParser parser = null;
      OrderHandler handler = null;
      InputSource source = null;

      try
      {
         // instantiate the factory
         factory = SAXParserFactory.newInstance();
         
         // set some properties of the factory - want validating, namespace-aware
         factory.setValidating(true);
         factory.setNamespaceAware(true);
                  
         // get the parser from the factory
         parser = factory.newSAXParser();
         
         // set *parser* property to use XML Schema validation
         parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                            "http://www.w3.org/2001/XMLSchema");

         // instantiate the handler and input source
         handler = new OrderHandler(args[1]);
         source = new InputSource(new FileReader(args[0]));
         
         // parse the input source - pass in source and handler to parser
         parser.parse(source, handler);
         
         System.out.println("\nParse completed successfully.");
      }
      catch (SAXException e)
      {
         System.out.println(e);
         System.out.println("\nParse aborted.");
      }
      catch (Exception e)
      {
         System.out.println(e);
      }
   }
}
