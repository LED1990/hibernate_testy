package smz.adm;

import smz.zgl.daneref.ud.Uslugodawca;
import smz.zgl.wspolne.Organizacja;

import java.io.Serializable;
import java.util.Set;

/**
 * Wniosek o uprawnienia i role w systemie SMZ
 * @author Kamil
 *
 */
public class Wniosek implements Serializable{

	public static final String STAUS_ZAAKCEPTOWANY="A";
	public static final String STAUS_ODRZUCONY="O";
	
	long id;
	String idWniosku;
	String uid;
	String imie;
	String nazwisko;
	Uslugodawca uslugowawca;
	Organizacja organizacja;
	String nrPWZ;
	String status;
	String przyczynaOdrzucenia;
	String email;
	String telefon;
	boolean administratorRegionalny;
	boolean administratorLokalny;
	
	
	String dn;
	
	
	String role;					//Role o jakie wnioskuje wnioskodawca
	Set<ZalacznikWniosku> zalaczniki;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getImie() {
		return imie;
	}
	public void setImie(String imie) {
		this.imie = imie;
	}
	public String getNazwisko() {
		return nazwisko;
	}
	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	public Uslugodawca getUslugowawca() {
		return uslugowawca;
	}
	public void setUslugowawca(Uslugodawca uslugowawca) {
		this.uslugowawca = uslugowawca;
	}
	public String getIdWniosku() {
		return idWniosku;
	}
	public void setIdWniosku(String idWniosku) {
		this.idWniosku = idWniosku;
	}
	public Organizacja getOrganizacja() {
		return organizacja;
	}
	public void setOrganizacja(Organizacja organizacja) {
		this.organizacja = organizacja;
	}
	
	/*
	 * Role o jakie wnioskuje wnioskodawca
	 */
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNrPWZ() {
		return nrPWZ;
	}
	public void setNrPWZ(String nrPWZ) {
		this.nrPWZ = nrPWZ;
	}
	public Set<ZalacznikWniosku> getZalaczniki() {
		return zalaczniki;
	}
	public void setZalaczniki(Set<ZalacznikWniosku> zalaczniki) {
		this.zalaczniki = zalaczniki;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPrzyczynaOdrzucenia() {
		return przyczynaOdrzucenia;
	}
	public void setPrzyczynaOdrzucenia(String przyczynaOdrzucenia) {
		this.przyczynaOdrzucenia = przyczynaOdrzucenia;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public boolean isAdministratorRegionalny() {
		return administratorRegionalny;
	}
	public void setAdministratorRegionalny(boolean administratorRegionalny) {
		this.administratorRegionalny = administratorRegionalny;
	}
	public boolean isAdministratorLokalny() {
		return administratorLokalny;
	}
	public void setAdministratorLokalny(boolean administratorLokalny) {
		this.administratorLokalny = administratorLokalny;
	}
		
}
