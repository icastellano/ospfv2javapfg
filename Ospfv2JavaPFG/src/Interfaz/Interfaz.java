package Interfaz;

public class Interfaz {

	private EstadoInterfaz estadoInterfaz;
	
	public Interfaz(EstadoInterfazLoopback inicial){
		estadoInterfaz = inicial;
		
	}
	
	public void setEstado(EstadoInterfaz estadoInterfaz){
		this.estadoInterfaz=estadoInterfaz;
	}
	
	public EstadoInterfaz getEstado(){
		return estadoInterfaz;
	}
	
	public void mostrar(){
		estadoInterfaz.mostrar();
	}
}
