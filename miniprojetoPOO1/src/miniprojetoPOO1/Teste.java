package miniprojetoPOO1;

import java.util.ArrayList;

public class Teste {
    ArrayList<String> nomesDosClubes = new ArrayList<String>();

    public void gerarClubes(Campeonato campeonato) {
        nomesDosClubes.add("Flamengo");
        nomesDosClubes.add("Corinthians");
        nomesDosClubes.add("Palmeiras");
        nomesDosClubes.add("São Paulo FC");
        nomesDosClubes.add("Santos");
        nomesDosClubes.add("Vasco da Gama");
        nomesDosClubes.add("Grêmio");
        nomesDosClubes.add("Internacional");
        nomesDosClubes.add("Cruzeiro");
        nomesDosClubes.add("Atlético Mineiro");
        nomesDosClubes.add("Botafogo");
        nomesDosClubes.add("Fluminense");
        nomesDosClubes.add("Bahia");
        nomesDosClubes.add("Athletico Paranaense");
        nomesDosClubes.add("Coritiba");
        nomesDosClubes.add("Sport Recife");
        nomesDosClubes.add("Ceará");
        nomesDosClubes.add("Fortaleza");
        nomesDosClubes.add("Goiás");
        nomesDosClubes.add("Atlético Goianiense");

        for (String nome : nomesDosClubes) {
            campeonato.clubes.add(new Clube(nome));
        }
    }

    public static void main(String[] args) {
        Campeonato campeonato = new Campeonato();
        Teste teste = new Teste();
        teste.gerarClubes(campeonato); 
        
        campeonato.jogarCampeonato();  
        System.out.print("Campeão:");
        System.out.println(campeonato.getCampeao());  
        System.out.println("Classificação:");
        System.out.println(campeonato.getClassificacao());  
    }
}
