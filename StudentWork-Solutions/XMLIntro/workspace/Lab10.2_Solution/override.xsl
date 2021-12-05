<?xml version='1.0'?>

<!--
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitablity for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
-->

<!-- this stylesheet overrides some of the default template rules -->

<xsl:stylesheet xmlns:xsl='http://www.w3.org/1999/XSL/Transform' version='1.0'>

  <!-- overrides default template rule for root and element nodes -->
  <xsl:template match='/ | *'>  
    <!-- process child nodes AND attribute nodes -->
    <xsl:apply-templates select='node() | @*'/>
  </xsl:template>

  <!-- overrides default template rule for PI and comment nodes -->
  <xsl:template match='processing-instruction() | comment()'>
    <!-- output string value of PIs and comments -->
    <xsl:value-of select='.'/>
  </xsl:template>
  
</xsl:stylesheet>
