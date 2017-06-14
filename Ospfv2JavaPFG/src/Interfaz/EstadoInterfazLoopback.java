package Interfaz;

public class EstadoInterfazLoopback extends EstadoInterfaz{

	private EstadoInterfaz down;
	
	public EstadoInterfazLoopback(){		
	}
	
	public void setStates(EstadoInterfazDown down){
		this.down=down;
	}
	
	public void postConstruct() {
		transitionByEvent.put(EventoInterfazUnloopInd.class.getName(), new TransicionInterfaz(this, down));
		transitionByEvent.put(EventoInterfazInterfaceDown.class.getName(), new TransicionInterfaz(this, down));
	}
	
	public void mostrar(){
		System.out.println("Estado Loopback");
	}
	
	public void doEntry(){
		//Resetear variables de interfaz
		//Destruir conexiones con vecinos
	}
	
	public void doExit(){
	}
}
