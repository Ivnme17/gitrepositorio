package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public abstract class Vehiculo {

	private static String ER_MARCA = ("(^[A-Z][a-z]+)|(^[A-Z][a-z]+\s[A-Z][a-z]+)|(^[A-Z]+)|(^[A-Z][a-z]+-[A-Z][a-z]+)|(^[A-Z][a-z]+[A-Z][a-z]+)");
	private static String ER_MATRICULA = "[0-9]{4}[BCDFGHJKLMNÑPQRSTVWXYZ]{3}";
	private String marca;
	private String modelo;
	protected String matricula;
	

	public static  Vehiculo getVehiculoConMatricula(String matricula) {
		return new Turismo("Seat", "León", 90, matricula);

	}

	
	public String getMarca() {
		return marca;
	}
	public static Vehiculo copiar(Vehiculo vehiculo) {
		return vehiculo;
	}

	protected Vehiculo(Vehiculo vehiculo) {
		super();
	}


	protected Vehiculo(String marca, String modelo, String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setMatricula(matricula);
	}


	public String getModelo() {
		return modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMarca(String marca) {
		if (marca == null) {
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		if (!marca.matches(ER_MARCA)) {
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
	}

	private void setModelo(String modelo) {
		if (modelo == null) {
	        throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
	    }
		if (modelo.isBlank()) {
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		this.modelo = modelo;
	}

	private void setMatricula(String matricula) {
		if (matricula == null) {
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA)) {
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;

	}
	public abstract double getFactorPrecio();

	 public Vehiculo copiar() {
	        Vehiculo vehiculo = null;
	        try {
	            vehiculo = (Vehiculo) super.clone();
	        } catch (CloneNotSupportedException e) {
	            e.printStackTrace();
	        }
	        return vehiculo;
	    }
	@Override
	public int hashCode() {
		return Objects.hash(marca, matricula, modelo);
	}

	@Override
	  public boolean equals(Object o) {
        if (!(o instanceof Vehiculo)) {
            return false;
        }
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula) &&
                Objects.equals(marca, vehiculo.marca) &&
                Objects.equals(modelo, vehiculo.modelo);
    }
	 @Override
	    public String toString() {
	        return "Vehiculo{" +
	                "matricula='" + matricula + '\'' + 
	                ", marca='" + marca + '\'' +
	                ", modelo=" + modelo + '\'' +
	                '}';

}


	protected abstract int getCilindrada();

}