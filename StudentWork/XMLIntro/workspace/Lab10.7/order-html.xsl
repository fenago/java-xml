<?xml version='1.0'?>

<!--
Copyright, LearningPatterns Inc.

This code is sample code, provided as-is, and we make no
warranties as to its correctness or suitablity for
any purpose.

Feel free to use it in any way that you want.  We
hope that it's useful to you.  Enjoy.
-->

<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0'>
  
  <xsl:output method='html' indent='yes'/>
  
  <xsl:template match='/'>
    <xsl:copy-of select='comment()[1]'/>
    <html>
      <head><title>JavaTunes Order</title></head>
      <body>
        <xsl:apply-templates select='order'/>
      </body>
    </html>
  </xsl:template>
  
  <xsl:template match='order'>
    <h1 align='center'>JavaTunes Order</h1>
    <b>Order ID: <xsl:value-of select='@ID'/></b>
    <br/>
    Order Date: <xsl:value-of select='@dateTime'/>
    <hr/>
    <xsl:apply-templates select='customer'/>
    <font size='+2'><b>Purchase Info</b></font>
    <br/>
    <table border='1'>
    <thead>
      <tr>
        <th>Item ID</th>
        <th>Name</th>
        <th>Artist</th>
        <th>Release Date</th>
        <th>List Price</th>
        <th>Your Price</th>
      </tr>
    </thead>
    <tbody>
      <xsl:apply-templates select='item'/>
    </tbody>
    </table>
    <hr/>
    <xsl:apply-templates select='customer/shipper'/>
  </xsl:template>
  
  <xsl:template match='customer'>
    <font size='+2'><b>Customer Info</b></font>
    <br/>
    <xsl:value-of select='name'/>
    <br/>
    <xsl:value-of select='street'/>
    <br/>
    <xsl:value-of select='city'/>
    <br/>
    <xsl:value-of select='state'/>
    <br/>
    <xsl:value-of select='zipcode'/>
    <hr/>
  </xsl:template>
  
  <xsl:template match='item'>
    <tr>
      <xsl:apply-templates select='@ID | *'/>
    </tr>
  </xsl:template>
  
  <xsl:template match='item/@ID | item/*'>
    <td>
      <xsl:value-of select='.'/>
    </td>
  </xsl:template>
  
  <xsl:template match='shipper'>
    <font size='+2'><b>Shipping Info</b></font>
    <br/>
    <xsl:value-of select='@name'/>
    <br/>
    <xsl:value-of select='@accountNum'/>
  </xsl:template>
  
</xsl:stylesheet>
