<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:variable name="x" select="1"></xsl:variable>
    <xsl:template match="/">
        
******
        <xsl:value-of select="(bookstore/book)[$x]/title"></xsl:value-of>
        ******
	
    </xsl:template>
</xsl:stylesheet>
