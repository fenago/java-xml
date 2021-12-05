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

public class SAXTest
{
   public static void main(String[] args)
   {
      // declare the factory and parser
      SAXParserFactory factory = null;
      SAXParser parser = null;
      
      /* 
       * OPTIONAL - specify factory via system property
       * 
       * if property is not specified, default parser factory is used.
       * the name-value pair is:
       * javax.xml.parsers.SAXParserFactory=org.apache.xerces.jaxp.SAXParserFactoryImpl
       *
       * 1. hard-coding: probably the least-desirable way
       * System.setProperty("javax.xml.parsers.SAXParserFactory", 
       *    "org.apache.xerces.jaxp.SAXParserFactoryImpl");
       * OR
       * 2. specify on command line: much better
       * java -Djavax.xml.parsers.SAXParserFactory=org.apache.xerces.jaxp.SAXParserFactoryImpl SAXTest
       * OR
       * 3. put this name-value pair in the jaxp.properties file
       */

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

         // see what factory and parser we got
         System.out.println("SAXParserFactory is: " + factory.getClass().getName());
         System.out.println("SAXParser is:        " + parser.getClass().getName());
         System.out.println("SAXParser is validating: " + parser.isValidating());
         System.out.println("SAXParser is namespace-aware: " + parser.isNamespaceAware());
      }
      catch (Exception e)
      {
         System.out.println(e);
      }
   }
}
