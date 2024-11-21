import java.util.Arrays;

public abstract class Graficos {

    @Deprecated
    public static String printField(int etapaA, int etapaB) {

        char[] field = new char[9];
        Arrays.fill(field, ' ');

        if (etapaA == -1 && etapaB == 7) {
            field[0] = '*';
        } else if (etapaA == 7 && etapaB == -1) {
            field[8] = '*';
        } else if (etapaA + etapaB == 6) {
            field[etapaA + 1] = '*';
        } else {
            return ""; // Caso inválido
        }

        return "[" + new String(field) + "]";
    }

    public static void printField2(int setor) {
        String field = " [     ] ";
        StringBuilder modifiedField = new StringBuilder(field);

        if (setor >= 0 && setor < field.length()) {
            modifiedField.setCharAt(setor, '*'); // Substitui o caractere na posição do setor por '*'
        }

        System.out.println(modifiedField.toString());
    }
}
