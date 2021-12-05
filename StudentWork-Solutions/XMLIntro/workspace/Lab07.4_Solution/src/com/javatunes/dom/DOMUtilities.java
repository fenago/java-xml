package com.javatunes.dom;
/*

 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */


import org.w3c.dom.*;

import com.javatunes.sax.OrderHandler;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.sax.SAXResult;
import java.io.File;

public class DOMUtilities
{
   // navigates the entire tree - called recursively
   public static void walkTree(Node node)
   {
      // print current node
      printNode(node);
      
      // get this node's children
      NodeList children = node.getChildNodes();
      
      // Lab 10 OPTIONAL - remove whitespace nodes from the node list (which is "live")
      stripWhitespaceNodes(children);
      
      // go through remaining children, calling this method recursively until at end of node list
      for (int i = 0; i < children.getLength(); i++)
      {
         Node child = children.item(i);
         walkTree(child);
      }
   }

   // prints node data, including attributes (if element node)
   public static void printNode(Node node)
   {
      // print the node name and node type
      System.out.print(node.getNodeName() + " type=" + node.getNodeType());

      // print the node's attributes
      NamedNodeMap atts = node.getAttributes();
      if (atts != null)  // only element nodes have attributes
      {
         for (int i = 0; i < atts.getLength(); i++)
         {
            Node attrib = atts.item(i);
            System.out.print(" " + attrib.getNodeName() + "=" + 
                                   attrib.getNodeValue());
         }
      }

      // print the node value
      String nodeValue = node.getNodeValue();
      if (nodeValue != null)
      {
         System.out.println(" value=" + nodeValue);
      }
      else
      {
         System.out.println();
      }
   }

   public static void deleteElements(Document doc, String tagname)
   {
      // query (entire) tree for the named element nodes
      NodeList list = doc.getElementsByTagName(tagname);
      
      // iterate through collection, from length-1 to 0 ("backwards")
      // collection automatically shrinks as each node is deleted from it
      // decrementing i from length-1 to 0 prevents node shifting
      for (int i = list.getLength() - 1; i >= 0; i--)
      {
         // get node to be deleted (tbd) and its parent, remove tbd
         Node tbd = list.item(i);  // last/right node - process right-to-left
         Node parent = tbd.getParentNode();
         parent.removeChild(tbd);
      }
   }

   // Lab 10 OPTIONAL - remove whitespace nodes from the node list (which is "live")
   public static void stripWhitespaceNodes(NodeList list)
   {
      // decrementing i from length-1 to 0 prevents node shifting
      for (int i = list.getLength() - 1; i >= 0; i--)
      {
         Node node = list.item(i);

         // if text node and trimmed length is 0 -> whitespace
         if (node.getNodeType() == Node.TEXT_NODE &&
             node.getNodeValue().trim().length() == 0)
         {
            // must "step up" to parent node to remove the current node
            node.getParentNode().removeChild(node);
         }
      }
   }

   public static void writeXML(Document doc, String filename)
   {
      try
      {
         // first create factory and (the identity) transformer
         TransformerFactory factory = TransformerFactory.newInstance();
         Transformer xformer = factory.newTransformer();
         
         // pass in DOM tree as source, empty file as result
         xformer.transform(new DOMSource(doc),
                           new StreamResult(new File(filename)));
      }
      catch (TransformerException e)
      {
         System.out.println(e);
      }
   }

   // Lab 11 OPTIONAL - write modified tree to a series of SAX events
   public static void writeSAX(Document doc, String targetElement)
   {
      try
      {
         // first create factory and (the identity) transformer
         TransformerFactory factory = TransformerFactory.newInstance();
         Transformer xformer = factory.newTransformer();
         
         // pass in DOM tree as source, SAX ContentHandler as result
         xformer.transform(new DOMSource(doc),
                           new SAXResult(new OrderHandler(targetElement)));
      }
      catch (TransformerException e)
      {
         System.out.println(e);
      }
   }
}
