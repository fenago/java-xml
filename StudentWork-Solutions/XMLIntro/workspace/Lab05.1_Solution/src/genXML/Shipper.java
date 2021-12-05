/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package genXML;

class Shipper
{
   // INSTANCE VARIABLES
   private String m_name = null;
   private String m_accountNum = null;

   // CONSTRUCTORS
   public Shipper()
   {
   }
   
   public Shipper(String name, String accountNum)
   {
      this.setName(name);
      this.setAccountNum(accountNum);
   }

   // XML GENERATION METHOD
   public String toXML()
   {
      // return an empty shipper element with two attributes
      return "<shipper name='" + this.getName()       + "'" +
               " accountNum='" + this.getAccountNum() + "'/>";
   }

   // good idea to have a toString() method, too
   public String toString()
   {
      return "Shipper: name=" + this.getName() + ", accountNum=" + this.getAccountNum();
   }

   // ACCESSOR METHODS
   public String getName()
   { return m_name; }
   public void setName(String name)
   { m_name = name; }
   
   public String getAccountNum()
   { return m_accountNum; }
   public void setAccountNum(String accountNum)
   { m_accountNum = accountNum; }
}
