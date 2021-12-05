/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */


package genXML;

class Item
{
   // INSTANCE VARIABLES
   private String m_id = null;
   private String m_name = null;
   private String m_artist = null;
   private String m_releaseDate = null;
   private String m_listPrice = null;
   private String m_price = null;

   // CONSTRUCTORS
   public Item()
   {
   }
   
   public Item(String id, String name, String artist,
               String releaseDate, String listPrice, String price)
   {
      this.setID(id);
      this.setName(name);
      this.setArtist(artist);
      this.setReleaseDate(releaseDate);
      this.setListPrice(listPrice);
      this.setPrice(price);
   }

   // XML GENERATION METHOD
   public String toXML()
   {
      StringBuffer buffer = new StringBuffer();

      // create an item element with an attribute and child elements
      buffer.append("<item ID='"    + this.getID()          + "'>");
      buffer.append("<name>"        + this.getName()        + "</name>");
      buffer.append("<artist>"      + this.getArtist()      + "</artist>");
      buffer.append("<releaseDate>" + this.getReleaseDate() + "</releaseDate>");
      buffer.append("<listPrice>"   + this.getListPrice()   + "</listPrice>");
      buffer.append("<price>"       + this.getPrice()       + "</price>");
      buffer.append("</item>");

      // return the XML
      return buffer.toString();
   }

   // good idea to have a toString() method, too
   public String toString()
   {
      return "Item: ID=" + this.getID() + ", name=" + this.getName() + 
         ", artist=" + this.getArtist() + ", releaseDate=" + this.getReleaseDate() + 
         ", listPrice=" + this.getListPrice() + ", price=" + this.getPrice();
   }

   // ACCESSOR METHODS
   public String getID()
   { return m_id; }
   public void setID(String id)
   { m_id = id; }

   public String getName()
   { return m_name; }
   public void setName(String name)
   { m_name = name; }

   public String getArtist()
   { return m_artist; }
   public void setArtist(String artist)
   { m_artist = artist; }

   public String getReleaseDate()
   { return m_releaseDate; }
   public void setReleaseDate(String releaseDate)
   { m_releaseDate = releaseDate; }

   public String getListPrice()
   { return m_listPrice; }
   public void setListPrice(String listPrice)
   { m_listPrice = listPrice; }

   public String getPrice()
   { return m_price; }
   public void setPrice(String price)
   { m_price = price; }
}
