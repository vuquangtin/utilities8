<?xml version='1.0'?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
<xsl:output method="xml" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <xsl:for-each select="//text">
            <foo bar="{@size}{./* | ./text()}"></foo>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>
