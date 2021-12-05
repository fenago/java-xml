package com.javatunes.sax;
/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */


import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.*;

public class OrderHandler
extends DefaultHandler
{
   // the Locator object
   private Locator m_locator;
   
   // CONTENT HANDLING - from interface ContentHandler
   public void startDocument()
   throws SAXException
   {
      System.out.println("\nDocument processing starts at line " + 
         m_locator.getLineNumber() + ".\n");
   }

   public void endDocument()
   throws SAXException
   {
      System.out.println("\nDocument processing terminates at line " + 
         m_locator.getLineNumber() + ".\n");
   }

   public void startElement(String namespaceURI, String localName, String qName,
                            Attributes attribs)
   throws SAXException
   {
      System.out.print("<" + qName);
      for (int i = 0; i < attribs.getLength(); i++)
      {
         System.out.print(" " + attribs.getQName(i) + "=" + attribs.getValue(i));
      }
      System.out.println(">");
   }

   public void endElement(String namespaceURI, String localName, String qName)
   throws SAXException
   {
      System.out.println("</" + qName + ">");
   }

   public void characters(char[] data, int start, int length)
   throws SAXException
   {
      // use trim() and length() to disregard insignificant whitespace
      // if there is no schema, the parser treats all whitespace as significant
      // Xerces, when used with XML Schema, treats all whitespace as significant
      // (but we know better)
      String content = new String(data, start, length).trim();
      if (content.length() != 0)
      {
         System.out.println(content);
      }
   }

   // OPTIONAL
   public void processingInstruction(String target, String data)
   throws SAXException
   {
      try
      {
         Runtime.getRuntime().exec(target + " " + data);
      }
      catch (java.io.IOException e)
      {
         System.out.println("Unable to execute " + target);
      }
   }

   public void setDocumentLocator(Locator locator)
   {
      m_locator = locator;
   }


   // ERROR HANDLING - from interface ErrorHandler
   public void warning(SAXParseException e)
   throws SAXException
   {
      System.out.println("\n---- Warning at line " + e.getLineNumber());
      System.out.println(e.getMessage());
   }

   public void error(SAXParseException e)
   throws SAXException
   {
      System.out.println("\n++++ Error at line " + e.getLineNumber());
      System.out.println(e.getMessage());

      // Part B - abort parse on validation error - uncomment below to activate
      // throw an exception at the parser to abort it
      // you can throw the parameter e or throw your own exception
      // throw e;
      // OR
      // throw new SAXException("Validity error.");
   }

   public void fatalError(SAXParseException e)
   throws SAXException
   {
      // note that this method does not throw an exception at the parser
      // yet the parser still aborts the parse - by definition, it must do so
      System.out.println("\n**** Fatal error at line " + e.getLineNumber());
      System.out.println(e.getMessage());
   }
}
