import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Nomes {
    private static final String[] firstNames = {"João", "Carlos", "Gustavo", "Diego", "Lucas", "Rafael", "Fernando", "Roberto", "Paulo", "Bruno"};
    private static final String[] lastNames = {"Silva", "Oliveira", "Santos", "Ferreira", "Lima", "Pereira", "Costa", "Gomes", "Martins", "Souza"};

    private static String[] teamNames = {
            "Flamengo", "Corinthians", "São Paulo", "Palmeiras", "Vasco da Gama",
            "Grêmio", "Internacional", "Cruzeiro", "Atlético Mineiro", "Botafogo",
            "Fluminense", "Santos", "Atlético Paranaense", "Bahia", "Sport Recife",
            "Fortaleza", "Ceará", "Chapecoense", "América Mineiro", "Red Bull Bragantino",
            "Juventude", "Goiás", "Coritiba", "Avaí", "Figueirense",
            "Ponte Preta", "Náutico", "Vitória", "Paysandu", "Remo",
            "Santa Cruz", "Criciúma"
    };

    public static String getRandomName(){
        Random random = new Random();
        String randomFirstName = firstNames[random.nextInt(firstNames.length)];
        String randomLastName = lastNames[random.nextInt(lastNames.length)];
        String randomFullName = randomFirstName + " " + randomLastName;
        return randomFullName;
    }

    public static String getDisponibleTeamName(){
        List<String> teamList = new ArrayList<>(Arrays.asList(teamNames));

        Random random = new Random();
        int randomIndex = random.nextInt(teamList.size());

        String removedTeam = teamList.remove(randomIndex);
        teamNames = teamList.toArray(new String[0]);

        return removedTeam;
    }

    public static String[] getTeamNames(){
        return teamNames;
    }
}
