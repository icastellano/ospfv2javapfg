package Interfaz;

import java.util.*;

public abstract class EstadoInterfaz {

	protected final Map<String, TransicionInterfaz> transitionByEvent = new HashMap<String, TransicionInterfaz>();
	 
	public EstadoInterfaz fire(EventoInterfaz event) {
		
		final TransicionInterfaz transition = transitionByEvent.get(event.getClass().getName());
		
		if (transition == null) {
			return this;
		}
	 
		return transition.nextState(event);
	}
	
	
	public abstract void mostrar();
	
	public abstract void doEntry();
	
	public abstract void doExit();
}
