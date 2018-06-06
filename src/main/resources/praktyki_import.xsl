<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/uslugodawcy">
		<xsl:apply-templates select="uslugodawca" />
	</xsl:template>

	<xsl:template match="uslugodawca">
		<praktyki>
			<xsl:apply-templates select="praktyka/osoby/osoba" />
		</praktyki>
	</xsl:template>
	<xsl:template match="osoba">
		<xsl:variable name="praktyka" select="../.." />
		<xsl:variable name="uslugodawca" select="$praktyka/.." />
		<xsl:variable name="osoba" select="current()" />
		<xsl:choose>
			<xsl:when test="rodzajeDzialalnosci and rodzajeDzialalnosci/rodzajDzialalnosci/adresyUdzielaniaSwiadczen/adresUdzielaniaSwiadczen">
				<xsl:for-each select="rodzajeDzialalnosci/rodzajDzialalnosci/adresyUdzielaniaSwiadczen/adresUdzielaniaSwiadczen">
					<xsl:call-template name="praktyka">
						<xsl:with-param name="uslugodawca" select="$uslugodawca" />
						<xsl:with-param name="praktyka" select="$praktyka" />
						<xsl:with-param name="osoba" select="$osoba" />
					</xsl:call-template>
				</xsl:for-each>
			</xsl:when>
			<xsl:otherwise>
				<xsl:for-each select="rodzajeDzialalnosci/rodzajDzialalnosci/adresyUdzielaniaSwiadczen/adresUdzielaniaSwiadczen">
					<xsl:call-template name="praktyka">
						<xsl:with-param name="uslugodawca" select="$uslugodawca" />
						<xsl:with-param name="praktyka" select="$praktyka" />
						<xsl:with-param name="osoba" select="$osoba" />
					</xsl:call-template>
				</xsl:for-each>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="praktyka">
		<xsl:param name="uslugodawca" />
		<xsl:param name="praktyka" />
		<xsl:param name="osoba" />
		<praktykaZawodowa>

            <!--<xsl:if test="$praktyka/kodOrganuRejestrowego"><xsl:attribute name="kodOrganuRejestrowego"><xsl:value-of select="$praktyka/kodOrganuRejestrowego/kod"/></xsl:attribute></xsl:if>-->

			<xsl:if test="$praktyka/identyfikatorPraktykiZawodowej"><xsl:attribute name="idPraktyki"><xsl:value-of select="$praktyka/identyfikatorPraktykiZawodowej" /></xsl:attribute></xsl:if>
			<xsl:if test="$praktyka/regon"><xsl:attribute name="regon"><xsl:value-of select="$praktyka/regon" /></xsl:attribute></xsl:if>
			<xsl:if test="$praktyka/nrKsiegiRejestrowej"><xsl:attribute name="nrKsiegiRejestrowej"><xsl:value-of select="$praktyka/nrKsiegiRejestrowej" /></xsl:attribute></xsl:if>
			<xsl:if test="$praktyka/nazwaOrganuRejestrowego"><xsl:attribute name="nazwaOrganuRejestrowego"><xsl:value-of select="$praktyka/nazwaOrganuRejestrowego" /></xsl:attribute></xsl:if>
			<xsl:if test="$uslugodawca/nazwa"><xsl:attribute name="nazwa"><xsl:value-of select="$uslugodawca/nazwa" /></xsl:attribute></xsl:if>
			<xsl:if test="daneKontaktowe/telefon"><xsl:attribute name="nrTelefonu"><xsl:value-of select="substring(daneKontaktowe/telefon,1,30)" /></xsl:attribute></xsl:if>
			<xsl:if test="$praktyka/dataWykreslenia"><dataWykreslenia><xsl:value-of select="$praktyka/dataWykreslenia" /></dataWykreslenia></xsl:if>

			<kodOrganuRejestrowego>
				<xsl:if test="$praktyka/kodOrganuRejestrowego/kod"><xsl:attribute name="kod"><xsl:value-of select="$praktyka/kodOrganuRejestrowego/kod" /></xsl:attribute></xsl:if>
				<xsl:if test="$praktyka/kodOrganuRejestrowego/opis"><xsl:attribute name="opis"><xsl:value-of select="$praktyka/kodOrganuRejestrowego/opis" /></xsl:attribute></xsl:if>
			</kodOrganuRejestrowego>

			<praktykaZawodowaOsoba>
				<xsl:if test="$osoba/tytul"><xsl:attribute name="tytul"><xsl:value-of select="$osoba/tytul" /></xsl:attribute></xsl:if>
				<xsl:if test="$osoba/nip"><xsl:attribute name="nip"><xsl:value-of select="$osoba/nip" /></xsl:attribute></xsl:if>
				<xsl:if test="$osoba/nrPWZ"><xsl:attribute name="nrPWZ"><xsl:value-of select="$osoba/nrPWZ" /></xsl:attribute></xsl:if>
				<xsl:if test="$osoba/specjalizacje"><xsl:attribute name="specjalizacje"><xsl:value-of select="$osoba/specjalizacje" /></xsl:attribute></xsl:if>
				<daneOsobowe>
					<nazwisko><xsl:value-of select="$osoba/nazwisko" /></nazwisko>
					<imie><xsl:value-of select="$osoba/imie" /></imie>
				</daneOsobowe>
			</praktykaZawodowaOsoba>
            <xsl:if test="kodIdentyfikujacyMiejsceSwiadczenPraktyki"><kodIdentyfikujacyMiejsceSwiadczenPraktyki><xsl:value-of select="kodIdentyfikujacyMiejsceSwiadczenPraktyki"/></kodIdentyfikujacyMiejsceSwiadczenPraktyki>
        </xsl:if>

            <xsl:if test="adres">
			<adres>
				<xsl:if test="adres/kodPocztowy"><kodPocztowy><xsl:value-of select="adres/kodPocztowy" /></kodPocztowy></xsl:if>
				<xsl:if test="adres/nazwaPoczty"><nazwaPoczty><xsl:value-of select="adres/nazwaPoczty" /></nazwaPoczty></xsl:if>
				<xsl:if test="adres/wojewodztwo"><wojewodztwo><xsl:value-of select="adres/wojewodztwo" /></wojewodztwo></xsl:if>
				<xsl:if test="adres/powiat"><powiat><xsl:value-of select="adres/powiat" /></powiat></xsl:if>
				<xsl:if test="adres/gmina"><gmina><xsl:value-of select="adres/gmina" /></gmina></xsl:if>
				<xsl:if test="adres/miejscowosc"><miejscowosc><xsl:value-of select="adres/miejscowosc" /></miejscowosc></xsl:if>
				<xsl:if test="adres/ulica"><ulica><xsl:value-of select="adres/ulica" /></ulica></xsl:if>
				<xsl:if test="adres/nrDomu"><nrDomu><xsl:value-of select="adres/nrDomu" /></nrDomu></xsl:if>
				<xsl:if test="adres/nrLokalu"><nrLokalu><xsl:value-of select="adres/nrLokalu" /></nrLokalu></xsl:if>
				<xsl:if test="adres/kraj"><kraj><xsl:value-of select="adres/kraj" /></kraj></xsl:if>
				<xsl:if test="adres/kodeTerytorialnyMsw"><kodeTerytorialnyMsw><xsl:value-of select="adres/kodeTerytorialnyMsw" /></kodeTerytorialnyMsw></xsl:if>
				<xsl:if test="adres/kodTerytTerc"><kodTerytTerc><xsl:value-of select="adres/kodTerytTerc" /></kodTerytTerc></xsl:if>
				<xsl:if test="adres/kodTerytSimc"><kodTerytSimc><xsl:value-of select="adres/kodTerytSimc" /></kodTerytSimc></xsl:if>
			</adres>
			</xsl:if>
		</praktykaZawodowa>
	</xsl:template>
</xsl:stylesheet>