<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:my="http://my.com">
<xsl:output encoding="UTF-8" indent="yes" omit-xml-declaration="yes"/>

<!-- XSLT - Numbering - Additional formatting tests - level = "multiple" - count="x|x|x" <x=node name> -->
<!-- format="" & "A" & ";1" & "A=" & "*" & "A 1 A 1 A 1 A 1 A" & "A.1" & "=" & "1.1" -->
<!-- Created : Khalil Jabrane -->
<!-- Date: 04/19/2000 -->

	<xsl:template match="/">
	    <xsl:text>&#10;&#10;Formatting Tests&#10;</xsl:text>
	    <xsl:apply-templates select="//last-name" mode="formatting-tests"/><BR/><BR/><BR/>
	</xsl:template>

	<!-- Test various formatting combinations -->
	<xsl:template match="last-name" mode="formatting-tests">

		<xsl:text>&#10;</xsl:text>
		<xsl:number level="multiple" count="last-name | publication | author | book"/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="last-name | publication | author | book" format=""/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="last-name | publication | author | book" format="A"/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="last-name | publication | author | book" format=";1"/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="last-name | publication | author | book" format="A="/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="last-name | publication | author | book" format="*"/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="last-name | publication | author | book" format="A 1 A 1 A 1 A 1 A"/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="last-name | publication | author | book" format="A.1"/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="unknown" format="="/><xsl:text>, </xsl:text>
		<xsl:number level="multiple" count="unknown" format=".1."/><xsl:text>, </xsl:text>
		<xsl:value-of select="concat(../first-name, ' ', .)"/>

	</xsl:template>

</xsl:stylesheet>
	
 
 