<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:variable name="x">1</xsl:variable>
    <xsl:template match="text()"></xsl:template>
    <xsl:template match="book">
        <xsl:variable name="x">Book</xsl:variable>
        <xsl:for-each select="title">
            
******
            <xsl:value-of select="$x"></xsl:value-of>
            ******
            <xsl:value-of select="text()"></xsl:value-of>
        </xsl:for-each>
    </xsl:template>
    <xsl:template match="magazine">
        <xsl:variable name="x">Magazine</xsl:variable>
        <xsl:for-each select="title">
            
***
            <xsl:value-of select="$x"></xsl:value-of>
            ***
            <xsl:value-of select="text()"></xsl:value-of>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
