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
import org.xml.sax.*;

import com.javatunes.sax.OrderHandler;

import org.w3c.dom.*;
import java.io.FileReader;

public class DOMTest
{
   public static void main(String[] args)
   {
      if (args.length != 3)
      {
         System.out.println("Usage: java DOMTest file delete-element result-file");
         System.exit(-1);
      }

      // declare the factory and parser, error handler, XML source, and Document
      DocumentBuilderFactory factory = null;
      DocumentBuilder parser = null;
      ErrorHandler errhandler = null;
      InputSource source = null;
      Document doc = null;

      try
      {
         // instantiate the factory
         factory = DocumentBuilderFactory.newInstance();

         // set some properties of the factory - want validating, namespace-aware
         // want to ignore insignificant whitespace, but not ignore comments
         // want to expand entity references and coalesce CDATA sections
         factory.setValidating(true);
         factory.setNamespaceAware(true);
         factory.setIgnoringElementContentWhitespace(true);
         factory.setIgnoringComments(true);  // remove comments
         factory.setExpandEntityReferences(true);
         factory.setCoalescing(true);

         // set *factory* property to use XML Schema validation
         factory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage",
                              "http://www.w3.org/2001/XMLSchema");

         // get the parser from the factory
         parser = factory.newDocumentBuilder();

         // instantiate error handler and XML source
         errhandler = new OrderHandler();
         source = new InputSource(new FileReader(args[0]));
         
         // register error handler with parser
         parser.setErrorHandler(errhandler);
         
         // get DOM tree (Document object) from XML source
         doc = parser.parse(source);
         
         System.out.println("\nParse completed successfully.");

         // walk the DOM tree, starting at the root of the tree.
         // NOTE - the root of the tree is NOT the root element.
         // the root of the tree is ABOVE the root element and includes prolog constructs.
         System.out.println("INITIAL TREE:");
         DOMUtilities.walkTree(doc);

         // delete the element node(s) specified on the command line
         System.out.println("\nDELETING " + args[1] + " ELEMENT NODES FROM THE TREE...");
         DOMUtilities.deleteElements(doc, args[1]);
         
         // rewalk the tree to see if they're indeed gone
         System.out.println("MODIFIED TREE:");
         DOMUtilities.walkTree(doc);

         // write modified tree back to XML, stored in file specified on command line
         DOMUtilities.writeXML(doc, args[2]);

         // Lab 11 OPTIONAL - write modified tree to a series of SAX events
         // for simplicity, we hardcode a target element name of "order", to see the whole document
         DOMUtilities.writeSAX(doc, "order");
      }
      catch (Exception e)
      {
         System.out.println(e);
         System.out.println("\nParse aborted.");
      }
   }
}
