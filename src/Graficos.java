public abstract class Graficos {

    private static boolean ativo = true;

    public static void printField(int setor) {
        int s = setor + 1;
        if (ativo){
            String field = "         ";
            StringBuilder modifiedField = new StringBuilder(field);

            if (s >= 0 && s < field.length()) {
                modifiedField.setCharAt(s, '*'); // Substitui o caractere na posição do setor por '*'
            }

            System.out.print(" " + inserirTraves(modifiedField.toString()) + " ");
        }

    }


    private static String inserirTraves(String original) {
        char charBetweenFirstAndSecond = '[';
        char charBetweenLastAndPenultimate = ']';

        // Inserir entre o 1º e o 2º
        StringBuilder sb = new StringBuilder(original);
        sb.insert(1, charBetweenFirstAndSecond); // Posição após o primeiro caractere

        // Atualizar a string
        original = sb.toString();

        // Inserir entre o penúltimo e o último
        sb.insert(original.length() - 1, charBetweenLastAndPenultimate); // Posição antes do último caractere

        // Resultado final
        return sb.toString();
    }
}
