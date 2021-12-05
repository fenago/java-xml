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

  <!-- copy the first comment in the prolog and the customer subtree into the result -->
  <xsl:template match='order'>
    <xsl:copy-of select='/comment()[1]'/>
    <xsl:copy-of select='customer'/>
  </xsl:template>

  <!-- this will also work -->
  <!--
  <xsl:template match='/'>
    <xsl:copy-of select='comment()[1]'/>
    <xsl:copy-of select='order/customer'/>
  </xsl:template>
  -->

</xsl:stylesheet>
