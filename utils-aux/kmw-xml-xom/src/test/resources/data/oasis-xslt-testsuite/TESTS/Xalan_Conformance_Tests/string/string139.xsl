<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

  <!-- FileName: string139 -->
  <!-- Document: http://www.w3.org/TR/xpath -->
  <!-- DocVersion: 19991116 -->
  <!-- Section: 4.2 String Functions -->
  <!-- Creator: David Marston -->
  <!-- Purpose: Use 'translate()' to change certain characters to quotes and apostrophes. -->

<xsl:template match="/doc">
  <out>
    <!-- The output string to translate() contains both a quote and an apostrophe.
      Since only one of those two can be treated as data in one string constant,
      we build up the string from two variables, using opposite double-quoting on each. -->
    <xsl:variable name="pt1" select='"aqu&apos;"'/>
    <xsl:variable name="pt2" select="'&quot;eos'"/>
    <xsl:value-of select="translate(a,'AQU-+EOS',concat($pt1,$pt2))"/>
  </out>
</xsl:template>

</xsl:stylesheet>