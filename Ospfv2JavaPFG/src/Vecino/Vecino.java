package Vecino;


public class Vecino {

	private EstadoVecino estadoVecino;
	
	public Vecino(){
		estadoVecino = new EstadoVecinoDown();
		
	}
	
	public void setEstado(EstadoVecino estadoVecino){
		this.estadoVecino=estadoVecino;
	}
	
	public void mostrar(){
		estadoVecino.mostrar();
	}
}
