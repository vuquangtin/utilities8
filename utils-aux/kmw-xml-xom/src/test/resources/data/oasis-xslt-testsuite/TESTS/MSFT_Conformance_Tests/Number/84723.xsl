<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:output encoding="UTF-16"/>

<!-- XSLT - Numbering - format= "&#x58f9;" (Taiwan traditional) & = "&#x4e01;" (Taiwan decimal) - letter-value="alphabetic" | "traditional" - lang="zh-tw" -->
<!-- Created : Khalil Jabrane -->
<!-- Date: 04/12/2000 -->

<xsl:template match="/">  
	<TABLE>  
		<xsl:for-each select="//하홏흄료">
			<TR><TD>  
				<TD>
					<!-- Taiwan traditional -->
					<xsl:number format="&#x58f9;" lang="zh-tw" letter-value="traditional"/> *					
					<xsl:value-of select = "text()"/>
				</TD>
				
				<TD>|---|</TD>
				
				<TD>
					<!-- Taiwan decimal -->
					<xsl:number format="&#x4e01;" letter-value="traditional" lang="zh-tw" /> *					
					<xsl:value-of select = "text()"/>
				</TD>
			</TD></TR>
		</xsl:for-each>  
	</TABLE>
</xsl:template>  

</xsl:stylesheet>  

