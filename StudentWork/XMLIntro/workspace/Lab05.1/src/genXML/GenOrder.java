/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */

package genXML;

import java.io.FileWriter;
import java.io.IOException;

class GenOrder
{
	public static void main(String[] args)
	{
		String outputFile = "genOrder.xml";
	   if (args.length == 1) {
		   outputFile = args[0];
	   }
	   
      // create a shipper
      Shipper s = new Shipper("UPS", "343-9080-1");

      // create a customer
      Customer c = new Customer("Susan Phillips", "763 Rodeo Circle",
         "San Francisco", "CA", "94109", s);

      // create an order and add some items to it
      Order o = new Order("_01170302", "2002-03-20T05:02:00", c);
      o.addItem(new Item("CD514", "So", "Peter Gabriel", "1986-10-03", "17.97", "13.99"));
      o.addItem(new Item("CD517", "1984", "Van Halen", "1984-08-19", "11.97", "11.97" ));
      o.addItem(new Item("CD503", "Trouble is...", "Kenny Wayne Shepherd Band", "1997-08-08", "17.97", "14.99"));

      // get the XML for this order and write it to a file
      String xml = o.toXML();
      try
      {
         // output file specified on command line
         FileWriter fw = new FileWriter(outputFile);
         fw.write(xml);
         fw.close();
      }
      catch (IOException e)
      {
         System.out.println(e);
      }
	}
}
