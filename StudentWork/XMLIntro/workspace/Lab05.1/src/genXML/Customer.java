/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package genXML;

class Customer
{
   // INSTANCE VARIABLES
   private String  m_name = null;
   private String  m_street = null;
   private String  m_city = null;
   private String  m_state = null;
   private String  m_zip = null;
   private Shipper m_shipper = null;

   // CONSTRUCTORS
   public Customer()
   {
   }
   
   public Customer (String name, String street, String city,
                    String state, String zip, Shipper shipper)
   {
      this.setName(name);
      this.setStreet(street);
      this.setCity(city);
      this.setState(state);
      this.setZipcode(zip);
      this.setShipper(shipper);
   }

   // XML GENERATION METHOD
   public String toXML()
   {
      StringBuffer buffer = new StringBuffer();
      
      // create a customer element with child elements
      buffer.append("<customer>");
      buffer.append("<name>"    + this.getName()    + "</name>");
      buffer.append("<street>"  + this.getStreet()  + "</street>");
      buffer.append("<city>"    + this.getCity()    + "</city>");
      buffer.append("<state>"   + this.getState()   + "</state>");
      buffer.append("<zipcode>" + this.getZipcode() + "</zipcode>");

      // add the shipper's XML, by calling its toXML() method
      buffer.append(this.getShipper().toXML());

      // close the customer element
      buffer.append("</customer>");

      // return the XML
      return buffer.toString();
   }

   // good idea to have a toString() method, too
   public String toString()
   {
      StringBuffer buffer = new StringBuffer();
      buffer.append("Customer: name=" + this.getName() + ", street=" + this.getStreet() +
         ", city=" + this.getCity() + ", state=" + this.getState() + 
         ", zipcode=" + this.getZipcode() + "\n");
      buffer.append(this.getShipper().toString());
      return buffer.toString();
   }

   // ACCESSOR METHODS
   public String getName()
   { return m_name; }
   public void setName(String name)
   { m_name = name; }

   public String getStreet()
   { return m_street; }
   public void setStreet(String street)
   { m_street = street; }

   public String getCity()
   { return m_city; }
   public void setCity(String city)
   { m_city = city; }

   public String getState()
   { return m_state; }
   public void setState(String state)
   { m_state = state; }

   public String getZipcode()
   { return m_zip; }
   public void setZipcode(String zip)
   { m_zip = zip; }

   public Shipper getShipper()
   { return m_shipper; }
   public void setShipper(Shipper shipper)
   { m_shipper = shipper; }
}
