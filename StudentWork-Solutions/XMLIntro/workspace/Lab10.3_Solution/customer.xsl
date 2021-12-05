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

  <!-- copy the customer subtree into the result -->
  <xsl:template match='order'>
    <xsl:copy-of select='customer'/>
  </xsl:template>

  <!-- copy the first comment in the prolog into the result -->
  <!-- xsl:copy or xsl:copy-of could be used.
       if using xsl:copy, MUST match on /comment()[1] -->
  <xsl:template match='/comment()[1]'>
    <xsl:copy/>
  </xsl:template>

</xsl:stylesheet>
