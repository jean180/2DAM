public class Escritor{
	public static void main(String[] args) {
 
		final Object boligrafo ="boligrafo";
		final Object libreta = "libreta";
		
		//creem els dos fils sobre la mateixa instància
		Thread Fil_1 = new Thread(){
			public void run() {
				
				for (int i=0; i<5; i++) {
					synchronized(boligrafo){
						System.out.println("Escritor 1: bloquea el bolifrago");
						synchronized(libreta){
							System.out.println("Escritor 1: bloque la libreta");
						}
					}
					System.out.println("Escritor 1: escribe y libera el boligrafo y la libreta");
					try {
				Thread.sleep(1000); //adormim el fil 1 segon
				}
				catch (InterruptedException ex) {	
					ex.printStackTrace();
					}
				}
			}
		};
		Thread Fil_2 = new Thread(){
			public void run() {
				
				for (int i=0; i<5; i++) {
					synchronized(libreta){
						System.out.println("Escritor 2: bloquea la libreta");
						synchronized(boligrafo){
							System.out.println("Escritor 2: bloque el boli");
						}
					}
					System.out.println("Escritor 2: escribe y libera el boligrafo y la libreta");
try {
				Thread.sleep(1000); //adormim el fil 1 segon
				}
				catch (InterruptedException ex) {	
					ex.printStackTrace();
					}
				}
			}
		};

		Fil_1.start();
		Fil_2.start();

	} //fin clase main
}
