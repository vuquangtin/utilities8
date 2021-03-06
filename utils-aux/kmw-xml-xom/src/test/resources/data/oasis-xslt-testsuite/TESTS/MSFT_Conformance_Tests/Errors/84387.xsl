<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="book">
        <xsl:value-of select="title"></xsl:value-of>
        <xsl:apply-templates>
            <!-- This is a comment --><!--Apply Templates can have all these below but not any other nodes or PCDATA Types--><?mypi ?> 	
<!--xsl:text node is redundant and should error out-->
            <xsl:text>This is a text node </xsl:text>
        </xsl:apply-templates>
    </xsl:template>
    <xsl:template match="text()"></xsl:template>
</xsl:stylesheet>
