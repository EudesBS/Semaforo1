package view;
import java.util.concurrent.Semaphore;
import controller.ThreadPessoas;

public class Principal {
	public static void main(String[] args) {
		
		int permissao = 1;
		Semaphore semaforo = new Semaphore(permissao);
		
		for (int idPessoa = 0; idPessoa < 4; idPessoa++) {
			
			Thread pessoas = new ThreadPessoas(idPessoa, semaforo);
			pessoas.start();
		}
	}
}
