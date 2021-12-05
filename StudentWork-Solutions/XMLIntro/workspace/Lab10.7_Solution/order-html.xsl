<?xml version='1.0'?>

<!--
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
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
    <b>Order ID: <xsl:value-of select='substring-after(@ID, "_")'/></b>
    <br/>
    Order Date: <xsl:value-of select='substring-before(@dateTime, "T")'/>
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
        <th><font color='red'>Your Price</font></th>
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
    <xsl:value-of select='city'/>,
    <xsl:value-of select='state'/><xsl:value-of select='string(" ")'/>
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
      <xsl:choose>
        <xsl:when test='name(.)="price"'>
          <font color='red'><b>$<xsl:value-of select='.'/></b></font>
        </xsl:when>
        <xsl:when test='name(.)="listPrice"'>
          $<xsl:value-of select='.'/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select='.'/>
        </xsl:otherwise>
      </xsl:choose>
    </td>
  </xsl:template>
  
  <xsl:template match='shipper'>
    <font size='+2'><b>Shipping Info</b></font>
    <br/>
    <xsl:choose>
      <xsl:when test='@name="FedEx"'>
        <font color='blue'><xsl:value-of select='@name'/></font>
        <br/>
        <font color='orange'><xsl:value-of select='@accountNum'/></font>
      </xsl:when>
      <xsl:when test='@name="UPS"'>
        <font color='brown'><xsl:value-of select='@name'/></font>
        <br/>
        <font color='brown'><xsl:value-of select='@accountNum'/></font>      
      </xsl:when>
      <xsl:otherwise>
        <xsl:value-of select='@name'/>
        <br/>
        <xsl:value-of select='@accountNum'/>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  
</xsl:stylesheet>
