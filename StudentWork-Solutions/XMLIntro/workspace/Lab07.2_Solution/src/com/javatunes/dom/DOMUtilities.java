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

public class DOMUtilities
{
   // navigates the entire tree - called recursively
   public static void walkTree(Node node)
   {
      // print current node
      printNode(node);
      
      // get this node's children
      NodeList children = node.getChildNodes();
      
      // go through children, calling this method recursively until at end of node list
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
}
