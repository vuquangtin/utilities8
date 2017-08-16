<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: output86 -->
  <!-- Document: http://www.w3.org/TR/xslt -->
  <!-- DocVersion: 19991116 -->
  <!-- Section: 16.3 Text Output Method -->
  <!-- Creator: David Marston -->
  <!-- Purpose: Text output of characters encoded between 128 and 255 -->

<xsl:output method="text" encoding="ISO-8859-1"/>

<xsl:template match="doc">
  <xsl:apply-templates select="dat"/>
</xsl:template>

<xsl:template match="dat">
  <xsl:text>&#255;</xsl:text><xsl:value-of select="."/>
</xsl:template>

</xsl:stylesheet>