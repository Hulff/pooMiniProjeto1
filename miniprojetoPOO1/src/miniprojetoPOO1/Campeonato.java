package miniprojetoPOO1;

import java.util.ArrayList;
public class Campeonato {
    ArrayList<Clube> clubes = new ArrayList<Clube>();

    public void bubbleSort() {
        int n = clubes.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (clubes.get(j).pontos < clubes.get(j + 1).pontos) {
                    // Troca clubes[j] e clubes[j+1]
                    Clube temp = clubes.get(j);
                    clubes.set(j, clubes.get(j + 1));
                    clubes.set(j + 1, temp);
                } else if(clubes.get(j).pontos == clubes.get(j + 1).pontos) {
                        if (clubes.get(j).saldoGols < clubes.get(j + 1).saldoGols) {
                        // Troca clubes[j] e clubes[j+1]
                        Clube temp = clubes.get(j);
                        clubes.set(j, clubes.get(j + 1));
                        clubes.set(j + 1, temp);
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
        bubbleSort();
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
        
        String classificacao = "|";
        for (int i = 0; i < clubes.size(); i++) {
            Clube clube = clubes.get(i);
            String classLine =(i+1)+"° "+clube.nome + " - Pontos: " + clube.pontos +" Saldo de gols "+clube.saldoGols;
            classificacao += classLine+"|";
            System.out.println(classLine);
        }
        return classificacao;
    }

    public String getCampeao() {
        return clubes.get(0).nome;
    }
}