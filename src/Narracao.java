public abstract class Narracao {

    private static boolean ativo = true;

    public static void narrar(int tempo, String s){
        if(ativo){
            System.out.println(tempo + "' " + s);
        }
    }
}
