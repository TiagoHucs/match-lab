public abstract class Utils {

    public static void aguarda(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            System.err.println("Ocorreu um erro durante a pausa.");
            e.printStackTrace();
        }
    }
}
