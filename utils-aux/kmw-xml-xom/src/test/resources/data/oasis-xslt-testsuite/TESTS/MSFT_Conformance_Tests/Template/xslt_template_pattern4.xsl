<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">

<xsl:template match="foo[position()&lt;2] | foo[position()=4]">
	<out><xsl:value-of select="." /></out>
</xsl:template>

</xsl:stylesheet>
