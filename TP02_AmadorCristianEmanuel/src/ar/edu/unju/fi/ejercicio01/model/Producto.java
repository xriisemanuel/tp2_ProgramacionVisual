package ar.edu.unju.fi.ejercicio01.model;

public class Producto {

	private String code;
	private String desc;
	private float price;
	private MadeIn madeIn;
	private Category cat;
	
	public Producto() {}
	
	public Producto(String code, String desc, float price, MadeIn madeIn, Category cat) {
		this.code = code;
		this.desc = desc;
		this.price = price;
		this.madeIn = madeIn;
		this.cat = cat;
	}
	
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public MadeIn getMadeIn() {
		return madeIn;
	}

	public void setMadeIn(MadeIn madeIn) {
		this.madeIn = madeIn;
	}

	public Category getCat() {
		return cat;
	}

	public void setCat(Category cat) {
		this.cat = cat;
	}


	public enum MadeIn {
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Category {
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}

	@Override
	public String toString() {
		return "Producto [code=" + code + ", desc=" + desc + ", price=" + price + ", madeIn=" + madeIn + ", cat=" + cat
				+ "]";
	}
	
	
}
