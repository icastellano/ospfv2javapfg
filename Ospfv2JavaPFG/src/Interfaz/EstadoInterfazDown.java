package Interfaz;

public class EstadoInterfazDown extends EstadoInterfaz{

	private EstadoInterfaz ptp;
	private EstadoInterfaz waiting;
	private EstadoInterfaz drother;
	private EstadoInterfaz loopback;
	
	public EstadoInterfazDown(){
		
	}
	
	public void setStates(EstadoInterfazPTP ptp, EstadoInterfazWaiting waiting, EstadoInterfazDrOther drother, EstadoInterfazLoopback loopback){
		this.ptp=ptp;
		this.waiting=waiting;
		this.drother=drother;
		this.loopback=loopback;
	}
	
	public void postConstruct() {
		transitionByEvent.put(EventoInterfazInterfaceUpPtp.class.getName(), new TransicionInterfaz(this, ptp));
		transitionByEvent.put(EventoInterfazInterfaceUpWaiting.class.getName(), new TransicionInterfaz(this, waiting));
		transitionByEvent.put(EventoInterfazInterfaceUpDrother.class.getName(), new TransicionInterfaz(this, drother));
		transitionByEvent.put(EventoInterfazLoopInd.class.getName(), new TransicionInterfaz(this, loopback));

	}
	
	public void mostrar(){
		System.out.println("Estado Down");
	}
	
	public void doEntry(){
		//Resetear variables de interfaz
		//Destruir conexiones con vecinos
	}
	
	public void doExit(){
		//Iniciar HelloTimer
	}
}
