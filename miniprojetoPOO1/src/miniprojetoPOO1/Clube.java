package miniprojetoPOO1;

public class Clube {
		String nome;
		int pontos = 0;
		int saldoGols = 0;
		
		public Clube(String nome) {
			this.nome = nome;
		}
		
		public void ganhar(int saldoGols) {
			this.saldoGols += saldoGols;
			pontos += 3;
		}
		public void empatar() {
			pontos += 1;
		}
		public void perder(int saldoGols) {
			this.saldoGols += saldoGols;
		}
}
