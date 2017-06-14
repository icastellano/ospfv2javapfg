package Interfaz;

public class EstadoInterfazPTP extends EstadoInterfaz{

	private EstadoInterfaz down;
	private EstadoInterfaz loopback;
	
	public EstadoInterfazPTP(){
		
	}
	
	public void setStates(EstadoInterfazLoopback loopback, EstadoInterfazDown down){
		this.down=down;
		this.loopback=loopback;
	}
	
	public void postConstruct() {
		transitionByEvent.put(EventoInterfazInterfaceDown.class.getName(), new TransicionInterfaz(this, down));
		transitionByEvent.put(EventoInterfazLoopInd.class.getName(), new TransicionInterfaz(this, loopback));
	}
	
	public void mostrar(){
		System.out.println("Estado PTP");
	}
	public void doEntry(){
	}
	
	public void doExit(){
	}
}
