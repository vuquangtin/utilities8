<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: variable59 -->
  <!-- Document: http://www.w3.org/TR/xslt -->
  <!-- DocVersion: 19991116 -->
  <!-- Section: 11.6 -->
  <!-- Creator: David Marston -->
  <!-- Purpose: Test for passing param containing 0-element node-set via apply-templates -->

<xsl:output method="xml" encoding="UTF-8"/>

<xsl:template match="doc">
  <out>
    <size><xsl:value-of select="count(a/comment())"/></size>
    <xsl:text>&#10;</xsl:text>
    <xsl:apply-templates select="a">
      <xsl:with-param name="comments" select="a/comment()"/>
    </xsl:apply-templates>
  </out>
</xsl:template>

<xsl:template match="a">
  <xsl:param name="comments">Default text in param 1</xsl:param>
  <list>
    <xsl:for-each select="$comments">
      <xsl:value-of select="."/>
      <xsl:text>,</xsl:text>
    </xsl:for-each>
  </list>
</xsl:template>

</xsl:stylesheet>