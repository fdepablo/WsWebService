package webservice;

import java.util.List;

import javax.ejb.EJB;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import entidad.Persona;
import persistencia.PersonaDao;

//http://localhost:8080/_01_WebServicePersonas-0.0.1-SNAPSHOT/PersonaWSImplements?wsdl
@WebService
public class PersonaWSImplements implements PersonaWS{
	
	@EJB
	private PersonaDao pd;
	
	@WebMethod
	@Oneway
	public void alta(@WebParam Persona persona) {
		System.out.println("Servicio: Alta persona: " + persona);
		pd.insertar(persona);
	}
	
	@WebMethod
	public Persona obtener(@WebParam int id) {
		System.out.println("Servicio: Obteniendo persona con id: " + id);
		Persona p = pd.buscar(id);
		return p;
	}
	
	@WebMethod
	public int baja(@WebParam int id) {
		System.out.println("Servicio: Baja de persona con id: " + id);
		int valor = pd.borrar(id);
		return valor;
	}

	@WebMethod
	public List<Persona> listar() {
		return pd.listar();
	}
	
	
}
