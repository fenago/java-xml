/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package genXML;

import java.util.ArrayList;
import java.util.List;

class Order
{
   // INSTANCE VARIABLES
   private String   m_id = null;
   private String   m_dateTime = null;
   private Customer m_customer = null;
   private List<Item>     m_items = null;

   // CONSTRUCTORS
   public Order()
   {
   }
   
   public Order (String id, String dateTime, Customer customer)
   {
      this.setID(id);
      this.setDateTime(dateTime);
      this.setCustomer(customer);
      m_items = new ArrayList<Item>();
   }

   // XML GENERATION METHOD
   public String toXML()
   {
      StringBuffer buffer = new StringBuffer();

      // create the prolog
      buffer.append("<?xml version='1.0'?>");
         
      // create the document element (order) and its attributes
      // include the schema location attribute
      buffer.append("<order ID='" + this.getID() + "' dateTime='" + this.getDateTime() + 
      "' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' " + 
      "xsi:noNamespaceSchemaLocation='file:///StudentWork/XML/order.xsd'>");

      // add the customer's XML, by calling its toXML() method
      buffer.append(this.getCustomer().toXML());

      // add each item's XML, by iterating through them and calling toXML() on each
      for (Item item : m_items)
      {
         buffer.append(item.toXML());
      }

      // close the document element (order)
      buffer.append("</order>");

      // return the XML
      return buffer.toString();
   }

   // support for multiple items - List makes this easy
   public void addItem(Item item)
   {
      m_items.add(item);
   }
   public void removeItem(Item item)
   {
      m_items.remove(item);
   }

   // good idea to have a toString() method, too
   public String toString()
   {
      StringBuffer buffer = new StringBuffer();
      buffer.append("Order: ID=" + this.getID() + ", dateTime=" + this.getDateTime() + "\n");
      buffer.append(this.getCustomer().toString() + "\n");
      for (Item item : m_items)
      {
         buffer.append(item.toString() + "\n");
      }
      return buffer.toString();
   }

   // ACCESSOR METHODS
   public String getID()
   { return m_id; }
   public void setID(String id)
   { m_id = id; }

   public String getDateTime()
   { return m_dateTime; }
   public void setDateTime(String dateTime)
   { m_dateTime = dateTime; }

   public Customer getCustomer()
   { return m_customer; }
   public void setCustomer(Customer customer)
   { m_customer = customer; }
}
