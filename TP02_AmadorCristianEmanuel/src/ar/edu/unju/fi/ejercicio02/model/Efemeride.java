package ar.edu.unju.fi.ejercicio02.model;

import ar.edu.unju.fi.ejercicio02.constantes.Mes;

public class Efemeride {
	private String code;
	private Mes month;
	private int day;
	private String datail;

	public Efemeride() {
	}

	public Efemeride(String code, Mes month, int day, String datail) {
		this.code = code;
		this.month = month;
		this.day = day;
		this.datail = datail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Mes getMonth() {
		return month;
	}

	public void setMonth(Mes month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public String getDatail() {
		return datail;
	}

	public void setDatail(String datail) {
		this.datail = datail;
	}

	@Override
	public String toString() {
		return "Efemeride [code=" + code + ", month=" + month + ", day=" + day + ", datail=" + datail + "]";
	}

}
