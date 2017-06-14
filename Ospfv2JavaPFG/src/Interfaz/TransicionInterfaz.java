package Interfaz;

public class TransicionInterfaz {
 
	private final EstadoInterfaz sourceState; 
	private final EstadoInterfaz targetState;
 
 
	public TransicionInterfaz (EstadoInterfaz sourceState, EstadoInterfaz targetState) {
		this.sourceState = sourceState;
		this.targetState = targetState;
	}
 
	public EstadoInterfaz nextState(EventoInterfaz event) {
		return targetState;
	}
	
}
