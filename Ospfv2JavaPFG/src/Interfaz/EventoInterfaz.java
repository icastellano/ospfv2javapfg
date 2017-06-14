package Interfaz;

public class EventoInterfaz {
	 
	private Object value;
 
	public EventoInterfaz() {
		value = null;
	}
 
	public EventoInterfaz(Object value) {
		this.value = value;
	}
 
	public Object getValue() {
		return value;
	}
}