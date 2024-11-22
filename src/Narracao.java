public abstract class Narracao {

    private static boolean ativo = false;

    public static void narrar(String s){
        if(ativo){
            System.out.println(s);
        }
    }
}
