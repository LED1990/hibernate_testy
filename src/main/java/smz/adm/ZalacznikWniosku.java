package smz.adm;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ZalacznikWniosku implements Serializable {
	
	private Long id;
	private String nazwa;
	private byte[] zalacznik;
	private Wniosek wniosek;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	public Wniosek getWniosek() {
		return wniosek;
	}
	public void setWniosek(Wniosek wniosek) {
		this.wniosek = wniosek;
	}
	
	public byte[] getZalacznik() {
		return zalacznik;
	}
	public void setZalacznik(byte[] zalacznik) {
		this.zalacznik = zalacznik;
	}

}
