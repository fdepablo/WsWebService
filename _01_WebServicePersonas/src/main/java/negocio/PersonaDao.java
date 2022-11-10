package negocio;

import java.util.ArrayList;
import java.util.List;

import entidad.Persona;

public class PersonaDao {

	private static List<Persona> listaPersonas = new ArrayList<>();
	private static int contador = 1;
	
	static {
		Persona p = new Persona();
		p.setId(contador++);
		p.setNombre("Homer");
		p.setEdad(38);
		p.setPeso(120);
		
		listaPersonas.add(p);
	}
	
	
	public void alta(Persona p) {
		p.setId(contador++);
		listaPersonas.add(p);
	}
	
	public boolean baja(int id) {
		Persona p = new Persona();
		p.setId(id);
		return listaPersonas.remove(p);
	}
	
	public Persona obtener(int id) {
		Persona pAux = new Persona();
		pAux.setId(id);
		
		for(Persona p : listaPersonas) {
			if(p.equals(pAux)) {
				return p;
			}
		}

		return null;
	}
	
	public List<Persona> listar(){
		return listaPersonas;
	}
}
