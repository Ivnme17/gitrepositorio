package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Cliente {
	private String nombre;
	private String telefono;
	private String dni;
	private static final String ER_NOMBRE = "[A-Z][a-zñ]*( [A-Z][a-zñ]*)*";
	private static final String ER_DNI = "[0-9]\\d{8}[A-HJ-NP-TV-Z]";
	private static final String ER_TELEFONO = "[6-9][0-9]{8}";

	public Cliente(String nombre, String dni, String telefono) {
		setNombre(nombre);
		setTelefono(telefono);
		setDni(dni);
		if (!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("ERROR: El nombre no coincide con su condición.");
		}
		if (!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El dni no coincide con su condición.");
		}
		if (!telefono.matches(ER_TELEFONO)) {
			throw new IllegalArgumentException("ERROR: El telefono no coincide con su condición.");
		}
	}

	// Constructor copia
	public Cliente(Cliente cliente) {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No es posible copiar un cliente nulo.");
		}

		this.nombre = nombre;
		this.dni = dni;
		this.telefono = telefono;
	}

	private boolean comprobarletradni(String dni) {
		char[] letrasDni = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
				'H', 'L', 'C', 'K', 'E' };

		int numeroDni = Integer.parseInt(dni.substring(0, 8));

		int CalcularLetra = letrasDni[numeroDni % 23];

		return dni.charAt(8) == CalcularLetra;

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new NullPointerException("ERROR: El nombre no puede ser nulo.");
		}

		if (!nombre.matches(ER_NOMBRE)) {
			throw new IllegalArgumentException("El nombre no es válido.");
		}
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		if (telefono == null) {
			throw new NullPointerException("ERROR: El teléfono no puede ser nulo.");
		}

		if (!telefono.matches(ER_TELEFONO)) {
			throw new IllegalArgumentException("El teléfono no es válido.");
		}
		this.telefono = telefono;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		if (dni == null) {
			throw new NullPointerException("ERROR: El DNI no puede ser nulo.");
		}
		if (!dni.matches(ER_DNI)) {
			throw new IllegalArgumentException("ERROR: El DNI no tiene un formato válido.");
		}
		if (!comprobarletradni(dni)) {
			throw new IllegalArgumentException("ERROR: La letra del DNI no es correcta.");
		}
		this.dni = dni;
	}

	public static Cliente getClienteConDni(String dni) {
		return new Cliente(null, dni, null);

	}
}