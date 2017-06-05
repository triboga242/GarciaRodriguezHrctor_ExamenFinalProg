package container;

import models.Coche;
import models.MiLista;

public class Contenedor {

	public static MiLista<Coche> ml = new MiLista<>(
			(Coche a, Coche b) -> b.getFechaEntrada().compareTo(a.getFechaEntrada()));
	public static Double TOTAL;
	public static  Double GRAN_TOTAL;
	

}
