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

  <xsl:template match='order'>
    <!-- wrap the resulting item elements in a document element - items -->
    <items>
      <!-- process the items - they will be copied and inserted here -->
      <xsl:apply-templates select='item'/>
    <!-- close the document element -->
    </items>
  </xsl:template>

  <xsl:template match='item'>
    <!-- can't use xsl:copy-of because that would include the whole subtree -->
    <xsl:copy>
      <xsl:copy-of select='@ID | name | artist | releaseDate'/>
    </xsl:copy>
  </xsl:template>

</xsl:stylesheet>
