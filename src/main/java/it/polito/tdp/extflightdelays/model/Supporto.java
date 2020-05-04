package it.polito.tdp.extflightdelays.model;

public class Supporto {


	private int partenza;
	private int arrivo;
	private double media;
	private int id;
	
	
	public Supporto(double media,int partenza, int arrivo,  int id) {
		super();
		this.partenza = partenza;
		this.arrivo = arrivo;
		this.media = media;
		this.id = id ;
	}


	public int getPartenza() {
		return partenza;
	}


	public void setPartenza(int partenza) {
		this.partenza = partenza;
	}


	public int getArrivo() {
		return arrivo;
	}


	public void setArrivo(int arrivo) {
		this.arrivo = arrivo;
	}


	public double getMedia() {
		return media;
	}


	public void setMedia(double media) {
		this.media = media;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supporto other = (Supporto) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Supporto [partenza=" + partenza + ", arrivo=" + arrivo + ", media=" + media + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}





}
