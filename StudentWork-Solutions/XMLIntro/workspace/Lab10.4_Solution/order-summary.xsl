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

  <xsl:output method='xml' indent='yes'/>

  <xsl:template match='order'>
    <!-- OPTIONAL - copy the copyright comment -->
    <xsl:copy-of select='/comment()[1]'/>
    
    <!-- OPTIONAL - add a new comment -->
    <xsl:comment> JavaTunes order-summary XML document </xsl:comment>
  
    <order-summary total-cost='{sum(item/price)}'
                   sales-region='{customer/state}'
                   shipper='{customer/shipper/@name}'
                   ID='{@ID}'
                   xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'
                   xsi:noNamespaceSchemaLocation='file:///StudentWork/XML_XSLT/order-summary.xsd'>
      
      <!-- could also use <xsl:copy-of select='item/artist'/> here -->
      <xsl:apply-templates select='item/artist'/>
    </order-summary>
  </xsl:template>

  <!-- don't need this template if performing the copy in the order template -->
  <xsl:template match='artist'>
    <xsl:copy-of select='.'/>
  </xsl:template>

</xsl:stylesheet>
