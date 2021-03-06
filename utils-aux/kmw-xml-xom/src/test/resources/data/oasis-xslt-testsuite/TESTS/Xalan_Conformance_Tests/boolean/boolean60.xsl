<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: boolean60 -->
  <!-- Document: http://www.w3.org/TR/xpath -->
  <!-- DocVersion: 19991116 -->
  <!-- Section: 3.4 -->
  <!-- Creator: David Marston -->
  <!-- Purpose: Test of the '!=' operator returning false on two numbers. -->

<xsl:template match="/">
  <out>
    <xsl:value-of select="1!=1"/>
  </out>
</xsl:template>

</xsl:stylesheet>