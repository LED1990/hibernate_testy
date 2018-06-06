package smz.zgl.daneref.ud;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ParametryKonfiguracyjne implements Serializable {
	
	private Long id;
	private String parametr;
	private String wartosc;
	private String sekcja;
	private String opis;
	
	public static String SEKCJA_BAZA = "BAZA";
	public static String SEKCJA_RAPORTY = "RAPORTY";
	public static String SEKCJA_KONTEKST_APLIKACJI = "KONTEKST_APLIKACJI";
	public static String SEKCJA_PODPIS_ELEKTRONICZNY = "PODPIS_ELEKTRONICZNY";
	public static String SEKCJA_IMPORTY = "IMPORTY";
	
	public static String RAPORT_MZ_55 = "MZ_55";
	public static String RAPORT_ZLK = "ZLK";
	public static String RAPORT_ZLB = "ZLB";
	public static String RAPORT_NOP = "NOP";
	public static String RAPORT_NDPL_1 = "NDPL_1";
	public static String RAPORT_NDPL_4 = "NDPL_4";
	public static String RAPORT_NDPLW = "NDPLW";
	public static String RAPORT_NDBPL = "NDBPL";
	
	public static String RAPORT_MZ55_1ABC = "MZ_55_RAPORT1";
	public static String RAPORT_MZ55_2ABC  = "MZ_55_RAPORT2";
	 
	
	public static String LOKALIZACJA_DANYCH_REFERENCYJNYCH = "LOKALIZACJA_DANYCH_REFERENCYJNYCH"; 
	public static final String URL_LEKI = "URL_LEKI"; 
	public static final String GODZINA_POBIERANIA_XML_LEK = "GODZINA_POBIERANIA_XML_LEK";  
	
	public static final String DZIEN_IMPORTU_LEK = "DZIEN_IMPORTU_LEK";  
	public static final String DZIEN_IMPORTU_CWUD = "DZIEN_IMPORTU_CWUD"; 
	public static final String DZIEN_IMPORTU_RSK = "DZIEN_IMPORTU_RSK";
	
	public static final String GODZINA_IMPORTU_LEK = "GODZINA_IMPORTU_LEK";  
	public static final String GODZINA_IMPORTU_CWUD = "GODZINA_IMPORTU_CWUD"; 
	public static final String GODZINA_IMPORTU_RSK = "GODZINA_IMPORTU_RSK";
	
		
	public static final String WALIDUJ_PLIKI_IMPORTU_CWUD_Z_XSD = "WALIDUJ_PLIKI_IMPORTU_CWUD_Z_XSD";
	public static final String DZIEN_POBIERANIA_XML_LEK = "DZIEN_POBIERANIA_XML_LEK";

	public static final String FLAGA_NAPRAWA_PRAKTYK = "FLAGA_NAPRAWA_PRAKTYK";
	 
	
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getParametr() {
		return parametr;
	}
	public void setParametr(String parametr) {
		this.parametr = parametr;
	}
	public String getWartosc() {
		return wartosc;
	}
	public void setWartosc(String wartosc) {
		this.wartosc = wartosc;
	}
	public String getSekcja() {
		return sekcja;
	}
	public void setSekcja(String sekcja) {
		this.sekcja = sekcja;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	
	
	
}
