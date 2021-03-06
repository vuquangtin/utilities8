<?xml version="1.0" encoding="ISO-8859-1"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: PREDICATE13 -->
  <!-- Document: http://www.w3.org/TR/xpath -->
  <!-- DocVersion: 19991116 -->
  <!-- Section: 3.4 -->
  <!-- Creator: David Marston -->
  <!-- Purpose: Test of boolean not compounded with or. -->

<xsl:template match="doc">
  <out>
    <xsl:value-of select="a[not(('target'=descendant::*) or @squish)]"/>
    <!-- True only when the node has neither a squish attribute nor a descendant containing "target". -->
  </out>
</xsl:template>

</xsl:stylesheet>
