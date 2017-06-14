package Interfaz;

public class EstadoInterfazWaiting extends EstadoInterfaz{
	
	private EstadoInterfaz dr;
	private EstadoInterfaz drother;
	private EstadoInterfaz backup;
	private EstadoInterfaz down;
	private EstadoInterfaz loopback;
	
	public EstadoInterfazWaiting(){
		
	}
	
	public void setStates(EstadoInterfazDr dr,EstadoInterfazDrOther drother, EstadoInterfazBackup backup, EstadoInterfazDown down, EstadoInterfazLoopback loopback){
		this.dr=dr;
		this.drother=drother;
		this.backup=backup;
		this.down=down;
		this.loopback=loopback;
	}
	
	public void postConstruct() {
		transitionByEvent.put(EventoInterfazBackupSeenBackup.class.getName(), new TransicionInterfaz(this, backup));
		transitionByEvent.put(EventoInterfazBackupSeenDr.class.getName(), new TransicionInterfaz(this, dr));
		transitionByEvent.put(EventoInterfazBackupSeenDrother.class.getName(), new TransicionInterfaz(this, drother));
		transitionByEvent.put(EventoInterfazWaitTimerBackup.class.getName(), new TransicionInterfaz(this, backup));
		transitionByEvent.put(EventoInterfazWaitTimerDr.class.getName(), new TransicionInterfaz(this, dr));
		transitionByEvent.put(EventoInterfazWaitTimerDrother.class.getName(), new TransicionInterfaz(this, drother));
		transitionByEvent.put(EventoInterfazLoopInd.class.getName(), new TransicionInterfaz(this, loopback));
		transitionByEvent.put(EventoInterfazInterfaceDown.class.getName(), new TransicionInterfaz(this, down));

	}
	
	public void mostrar(){
		System.out.println("Estado Waiting");
	}
	
	public void doEntry(){
		//Iniciar WaitTimer
		//Si red es no-broadcast, enviar Start a vecinos capaces de ser DR
	}
	
	public void doExit(){
	}
}
