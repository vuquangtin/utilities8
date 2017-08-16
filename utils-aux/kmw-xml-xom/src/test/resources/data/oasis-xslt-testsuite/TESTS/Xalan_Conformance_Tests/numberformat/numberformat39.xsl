<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: NumberFormat39 -->
  <!-- Document: http://www.w3.org/TR/xslt -->
  <!-- DocVersion: 19991116 -->
  <!-- Section: 12.3 -->
  <!-- Creator: David Marston -->
  <!-- Purpose: Test result pattern for negative infinity, unchanged. -->

<xsl:template match="doc">
  <out>
    <xsl:value-of select="format-number(-1 div 0,'###############################')"/>
  </out>
</xsl:template>

</xsl:stylesheet>
