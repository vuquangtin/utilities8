<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: OUTPUT96 -->
  <!-- Document: http://www.w3.org/TR/xslt -->
  <!-- DocVersion: 19991116 -->
  <!-- Section: 16.1 XML Output Method-->
  <!-- Creator: David Marston -->
  <!-- Purpose: Test that cdata-section-elements applies to text-node children, not descendants. -->

<xsl:output method="xml" cdata-section-elements="example" encoding="UTF-8"/>

<xsl:template match="doc">
  <out>
    <example>
      <xsl:text>a section</xsl:text>
      <sub>descendant text node</sub>
      <xsl:text>one more section</xsl:text>
    </example>
  </out>
</xsl:template>

</xsl:stylesheet>
