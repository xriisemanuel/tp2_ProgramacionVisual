package ar.edu.unju.fi.ejercicio01.main;

import java.util.ArrayList;

import ar.edu.unju.fi.ejercicio01.model.Producto;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Producto> products = new ArrayList<Producto>();
		
		Producto p1 = new Producto();
		
		p1.setCode("AAA123");
		p1.setDesc("Computer");
		p1.setPrice(1234567f);
		p1.setMadeIn(p1.getMadeIn().ARGENTINA);
		p1.setCat(p1.getCat().INFORMATICA);
		
		products.add(p1);
		
		for(Producto p: products) {
			System.out.println(p.toString());
		}
	}

}
