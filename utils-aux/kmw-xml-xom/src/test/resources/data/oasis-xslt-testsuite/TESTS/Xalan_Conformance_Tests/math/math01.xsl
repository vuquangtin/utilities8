<?xml version="1.0"?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: MATH01 -->
  <!-- Document: http://www.w3.org/TR/xpath -->
  <!-- DocVersion: 19990922 -->
  <!-- Section: 4.4 -->
  <!-- Purpose: Test of number() conversion function on an element. -->

<xsl:template match="doc">
  <out>
    <xsl:value-of select="number(n1)"/>
  </out>
</xsl:template>
 
</xsl:stylesheet>
