<!-- Error Case -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="foo" select="5"/>

	<xsl:template match="/">
		<xsl:comment> Parameter used in select must return a node-set </xsl:comment>
		<xsl:for-each select="$foo"/>
	</xsl:template>
</xsl:stylesheet>
