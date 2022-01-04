package Edit.EducacionITViernes;

import org.testng.annotations.Test;

public class Laboratorio0 {
	
	@Test
	public void imprimir() {
		Impresora p = new Impresora();
		p.imprimirPalabra("Imprimiendo desde el objeto");
	}
}
