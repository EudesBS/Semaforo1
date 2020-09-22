package controller;
import java.util.concurrent.Semaphore;

public class ThreadPessoas extends Thread{

	private int idPessoa;
	private Semaphore semaforo;
	private static int posChegada;
	private static int posSaida;
	
	public ThreadPessoas(int idPessoa, Semaphore semaforo) {
		
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		caminhada();
		try {
			semaforo.acquire();
			abrirPorta();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
			chegou();
		}
		
		
		
	}
	
	public void caminhada() {
		
		int distanciaCorredor = 200;
		int distanciaPercorrida = (int) ((Math.random() * 3) + 4);
		int deslocamento = 0;
		int tempo = 1000;
		
		while (deslocamento < distanciaCorredor) {
			
			deslocamento = deslocamento + distanciaPercorrida;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idPessoa + " caminhou " + deslocamento + " m.");
			
		}
		posChegada++;
		System.out.println("#" + idPessoa + " foi a " + posChegada + " a chegar na porta!");
	}
	
	public void abrirPorta() {
		
		System.out.println("#" + idPessoa + " está atravessando porta!");
		int tempo = (int) ((Math.random() * 2) + 1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void chegou() {
		
		posSaida++;
		System.out.println("#" + idPessoa + " foi a " + posSaida + " a sair!");
	}
}
