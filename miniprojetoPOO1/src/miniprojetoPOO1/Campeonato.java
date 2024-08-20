package miniprojetoPOO1;

import java.util.ArrayList;
public class Campeonato {
    ArrayList<Clube> clubes = new ArrayList<Clube>();

    public static void bubbleSort(ArrayList<Clube> array) {
        int n = array.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array.get(j).pontos < array.get(j + 1).pontos) {
                    // Troca array[j] e array[j+1]
                    Clube temp = array.get(j);
                    array.set(j, array.get(j + 1));
                    array.set(j + 1, temp);
                } else if(array.get(j).pontos == array.get(j + 1).pontos) {
                	if (array.get(j).saldoGols < array.get(j + 1).saldoGols) {
                        // Troca array[j] e array[j+1]
                        Clube temp = array.get(j);
                        array.set(j, array.get(j + 1));
                        array.set(j + 1, temp);
                    }
                }
            }
        }
    }

    public void jogarCampeonato() {
    	//jogos de ida
        for(int i=0;i<clubes.size();i++) {
        	for(int j=i+1;j<clubes.size();j++) {
        		jogarPartida(clubes.get(i),clubes.get(j));
            }        	
        }
        //jogos de volta
        for(int i=0;i<clubes.size();i++) {
        	for(int j=i;j<clubes.size();j++) {
        		jogarPartida(clubes.get(i),clubes.get(j));
            }        	
        }
    }

    private void jogarPartida(Clube m, Clube v) {
        int golsA = (int) (Math.random() * 6);
        int golsB = (int) (Math.random() * 6);

        if (golsA < golsB) {
            // time B ganhou
            m.perder(golsA);
            v.ganhar(golsB);
            System.out.println(v.nome + " ganhou de " + m.nome + " de " + golsB + " a " + golsA);
        } else if (golsA > golsB) {
            // time A ganhou
            m.ganhar(golsA);
            v.perder(golsB);
            System.out.println(m.nome + " ganhou de " + v.nome + " de " + golsA + " a " + golsB);
        } else {
            // empate
            m.empatar();
            v.empatar();
            System.out.println("Empate entre " + m.nome + " e " + v.nome);
        }
    }

    public String getClassificacao() {
        bubbleSort(clubes);
        String classificacao = "|";
        for (int i = 0; i < clubes.size(); i++) {
            Clube clube = clubes.get(i);
            String classLine = clube.nome + " - Pontos: " + clube.pontos+" - Saldo de Gols: "+clube.saldoGols;
            classificacao += classLine+"|";
            System.out.println(classLine);
        }
        return classificacao.toString();
    }

    public String getCampeao() {
        return clubes.get(0).nome;
    }
}
