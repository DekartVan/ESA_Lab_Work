<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <body>
                <h1>Directors</h1>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Country</th>
                        <th>Movies</th>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="director">
        <tr>
            <td><xsl:value-of select="@id"/></td>
            <td><xsl:value-of select="@name"/></td>
            <td><xsl:value-of select="@country"/></td>
            <td><xsl:value-of select="@movies"/></td>
        </tr>
    </xsl:template>
</xsl:stylesheet>