package ar.edu.unju.fi.ejercicio04.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio04.constantes.Posicion;

public class Jugador {
	private String name;
	private String lastname;
	private LocalDate date;
	private String nationality;
	private float high;
	private float weight;
	private Posicion position;

	public Jugador() {

	}

	public Jugador(String name, String lastname, LocalDate date, String nationality, float high, float weight,
			Posicion position) {
		this.name = name;
		this.lastname = lastname;
		this.date = date;
		this.nationality = nationality;
		this.high = high;
		this.weight = weight;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public float getHigh() {
		return high;
	}

	public void setHigh(float high) {
		this.high = high;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public Posicion getPosition() {
		return position;
	}

	public void setPosition(Posicion position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Jugador [name=" + name + ", lastname=" + lastname + ", date=" + date + ", nationality=" + nationality
				+ ", high=" + high + ", weight=" + weight + ", position=" + position + ", age=" + age() + "]";
	}
	
	public int age() {
		LocalDate x = LocalDate.now();
		return (x.getYear() - date.getYear());
	}

}
