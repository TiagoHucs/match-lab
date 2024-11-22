public abstract class Graficos {

    private static boolean ativo = false;

    public static void printField(int setor) {
        if (ativo){
            String field = "       ";
            StringBuilder modifiedField = new StringBuilder(field);

            if (setor >= 0 && setor < field.length()) {
                modifiedField.setCharAt(setor, '*'); // Substitui o caractere na posição do setor por '*'
            }

            System.out.println(inserirTraves(modifiedField.toString()));
        }

    }


    public static String inserirTraves(String original) {
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
