package Interfaz;

public class EstadoInterfazBackup extends EstadoInterfaz{

	private EstadoInterfaz dr;
	private EstadoInterfaz drother;
	private EstadoInterfaz backup;
	private EstadoInterfaz down;
	private EstadoInterfaz loopback;
	
	public EstadoInterfazBackup(){
		
	}
	
	public void setStates(EstadoInterfazDr dr,EstadoInterfazDrOther drother, EstadoInterfazBackup backup, EstadoInterfazDown down, EstadoInterfazLoopback loopback){
		this.dr=dr;
		this.drother=drother;
		this.backup=backup;
		this.down=down;
		this.loopback=loopback;
	}
	
	public void postConstruct() {
		//transitionByEvent.put(EventoInterfazNeighborChangeBackup.class.getName(), new TransicionInterfaz(this, backup));
		transitionByEvent.put(EventoInterfazNeighborChangeDr.class.getName(), new TransicionInterfaz(this, dr));
		transitionByEvent.put(EventoInterfazNeighborChangeDrother.class.getName(), new TransicionInterfaz(this, drother));
		transitionByEvent.put(EventoInterfazLoopInd.class.getName(), new TransicionInterfaz(this, loopback));
		transitionByEvent.put(EventoInterfazInterfaceDown.class.getName(), new TransicionInterfaz(this, down));

	}
	
	public void mostrar(){
		System.out.println("Estado Backup");
	}
	public void doEntry(){
	}
	
	public void doExit(){
	}
}
