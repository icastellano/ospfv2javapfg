import Interfaz.*;



public class mainEjemploInterfaz {

	public static void main(String[] args) {
		
		//Inicializar estados
		System.out.println("Inicializamos interfaz y estados");
		EstadoInterfazLoopback loopback = new EstadoInterfazLoopback();
		EstadoInterfazDown down = new EstadoInterfazDown();
		EstadoInterfazPTP ptp = new EstadoInterfazPTP();
		EstadoInterfazWaiting waiting = new EstadoInterfazWaiting();
		EstadoInterfazDr dr = new EstadoInterfazDr();
		EstadoInterfazDrOther drother = new EstadoInterfazDrOther();
		EstadoInterfazBackup backup = new EstadoInterfazBackup();
		
		//Set state
		System.out.println("SetState");
		loopback.setStates(down);
		down.setStates(ptp, waiting, drother,loopback);
		ptp.setStates(loopback,down);
		waiting.setStates(dr, drother, backup, down, loopback);
		dr.setStates(dr, drother, backup, down, loopback);
		drother.setStates(dr, drother, backup, down, loopback);
		backup.setStates(dr, drother, backup, down, loopback);
		
		//PostConstruct
		System.out.println("PostConstruct");
		loopback.postConstruct();
		down.postConstruct();
		ptp.postConstruct();
		waiting.postConstruct();
		dr.postConstruct();
		drother.postConstruct();
		backup.postConstruct();
		
		//creamos interfaz y lanzamos eventos
		System.out.println("Creamos interfaz, estado inicial: loopback");
		Interfaz interfaz = new Interfaz(loopback);
		interfaz.mostrar();
		
		EstadoInterfaz nextState;
		
		System.out.println("");
		System.out.println("Lanzamos evento UnloopInd");
		nextState=interfaz.getEstado().fire(new EventoInterfazUnloopInd());
		System.out.println("Nextstate devuelto por fire:");
		interfaz.setEstado(nextState);
		interfaz.mostrar();
		
		System.out.println("");
		System.out.println("Lanzamos evento InterfaceUpWaiting");
		nextState=interfaz.getEstado().fire(new EventoInterfazInterfaceUpWaiting());
		System.out.println("Nextstate devuelto por fire:");
		interfaz.setEstado(nextState);
		interfaz.mostrar();		
		
		System.out.println("");
		System.out.println("Lanzamos evento BackupSeenDr");
		nextState=interfaz.getEstado().fire(new EventoInterfazBackupSeenDr());
		System.out.println("Nextstate devuelto por fire:");
		interfaz.setEstado(nextState);
		interfaz.mostrar();
		
		System.out.println("");
		System.out.println("Lanzamos evento NeighborChangeBackup");
		nextState=interfaz.getEstado().fire(new EventoInterfazNeighborChangeBackup());
		System.out.println("Nextstate devuelto por fire:");
		interfaz.setEstado(nextState);
		interfaz.mostrar();
		
		
		System.out.println("");
		System.out.println("Lanzamos evento InterfaceDown");
		nextState=interfaz.getEstado().fire(new EventoInterfazInterfaceDown());
		System.out.println("Nextstate devuelto por fire:");
		interfaz.setEstado(nextState);
		interfaz.mostrar();
		
		System.out.println("");
		System.out.println("Fin de la aplicación");
		//interfaz.getEstado().fire
	}

}
