package org.iesalandalus.programacion.alquilervehiculos.modelo;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.AlquilerTest;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.AutobusTest;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.ClienteTest;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.FurgonetaTest;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.TurismoTest;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.AlquileresTest;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.ClientesTest;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.VehiculosTest;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({ ClienteTest.class, ClientesTest.class, TurismoTest.class, AutobusTest.class, FurgonetaTest.class, 
	VehiculosTest.class, AlquilerTest.class, AlquileresTest.class, ModeloTest.class })
public class AllTests { }
