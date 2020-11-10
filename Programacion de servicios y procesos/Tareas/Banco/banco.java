class cuenta {
	private String nombre = "CC0041783";
	private int saldo = 50;
	
	public int getSaldo(){
		return saldo;
	}
	
	public boolean getSaldo(int Retiro){
		if (Retiro<=saldo){
			return true;
		}else{
			return false;
		}
	}
		
	public void retirarsaldo(int numSaldo){
		saldo = saldo - numSaldo;
	}
} // fin clase cuenta

public class banco implements Runnable {
	private cuenta C1 = new cuenta();
	
	public void run(){
		for(int i = 0; i<3; i++){
			gestioSaldo(10);
		}
		
	}
	
	public synchronized void gestioSaldo(int SaldoRetirar){
		//Comprobar si hay saldo disponible
		if(C1.getSaldo()>=SaldoRetirar){
			System.out.println(Thread.currentThread().getName()+" retirara "+ SaldoRetirar +" €");
			try {
				Thread.sleep(1000); //adormim el fil 1 segon
				}
				catch (InterruptedException ex) {	
					ex.printStackTrace();
					}
			//Retiramos el saldo
			C1.retirarsaldo(SaldoRetirar);
			System.out.println(Thread.currentThread().getName() + " Retiro realizado con exito."+" El saldo disponible es "+C1.getSaldo());


		} else {
			System.out.println("No hay saldo suficiente." + Thread.currentThread().getName()+" El saldo disponible es: "+C1.getSaldo());
			try {
				Thread.sleep(1000);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		
	
	} //fin clase banco
	public static void main(String[] args) {
 
		banco objb = new banco();
 
		//creem els dos fils sobre la mateixa instància
		Thread Fil_1 = new Thread(objb);
		Thread Fil_2 = new Thread(objb);
		Fil_1.setName("Client 1");
		Fil_2.setName("Client 2");

		Fil_1.start();
		Fil_2.start();

	} //fin clase main
}
