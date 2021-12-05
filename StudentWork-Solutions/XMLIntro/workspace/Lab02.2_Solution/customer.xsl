<?xml version='1.0'?>

<!--
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
-->

<xsl:stylesheet version='1.0' xmlns:xsl='http://www.w3.org/1999/XSL/Transform'>

  <xsl:output method='html'/>

  <xsl:template match='order'>
    <html>
    <head>
    <title>JavaTunes Order - Customer Information</title>
    </head>
    <body>
    <xsl:apply-templates select='customer'/>
    </body>
    </html>
  </xsl:template>

  <xsl:template match='customer'>
    <h3 align='left'>Customer Info:</h3>
    <table border='1'>
    <thead>
      <tr>
        <th>Name</th>
        <th>Street</th>
        <th>City</th>
        <th>State</th>
        <th>Zip</th>
      </tr>
    </thead>
    <tbody>
      <tr><xsl:apply-templates select='*'/></tr>
    </tbody>
    </table>
  </xsl:template>

  <xsl:template match='text()'>
    <td><xsl:value-of select='.'/></td>
  </xsl:template>

</xsl:stylesheet>
