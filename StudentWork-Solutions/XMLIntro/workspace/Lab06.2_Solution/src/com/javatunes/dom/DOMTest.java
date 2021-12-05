package com.javatunes.dom;
/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */


import javax.xml.parsers.*;

public class DOMTest
{
   public static void main(String[] args)
   {
      // declare the factory and parser
      DocumentBuilderFactory factory = null;
      DocumentBuilder parser = null;

      /* 
       * OPTIONAL - specify factory via system property
       * 
       * if property is not specified, default parser factory is used.
       * the name-value pair is:
       * javax.xml.parsers.DocumentBuilderFactory=org.apache.xerces.jaxp.DocumentBuilderFactoryImpl
       *
       * 1. hard-coding: probably the least-desirable way
       * System.setProperty("javax.xml.parsers.DocumentBuilderFactory", 
       *    "org.apache.xerces.jaxp.DocumentBuilderFactoryImpl");
       * OR
       * 2. specify on command line: much better
       * java -Djavax.xml.parsers.DocumentBuilderFactory=org.apache.xerces.jaxp.DocumentBuilderFactoryImpl DOMTest
       * OR
       * 3. put this name-value pair in the jaxp.properties file
       */

      try
      {
         // instantiate the factory
         factory = DocumentBuilderFactory.newInstance();
         
         // set some properties of the factory - want validating, namespace-aware
         factory.setValidating(true);
         factory.setNamespaceAware(true);
         
         // set *factory* property to use XML Schema validation
         factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                              "http://www.w3.org/2001/XMLSchema");

         // get the parser from the factory
         parser = factory.newDocumentBuilder();

         // see what factory and parser we got
         System.out.println("DocumentBuilderFactory is: " + factory.getClass().getName());
         System.out.println("DocumentBuilder is:        " + parser.getClass().getName());
         System.out.println("DocumentBuilder is validating: " + factory.isValidating());
         System.out.println("DocumentBuilder is namespace-aware: " + factory.isNamespaceAware());
      }
      catch (Exception e)
      {
         System.out.println(e);
      }
   }
}
