<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: boolean01 -->
  <!-- Document: http://www.w3.org/TR/xpath -->
  <!-- DocVersion: 19991116 -->
  <!-- Section: 3.4 -->
  <!-- Purpose: Test of true() -->

<xsl:template match="/">
  <out>
    <xsl:value-of select="true()"/>
  </out>
</xsl:template>

</xsl:stylesheet>
