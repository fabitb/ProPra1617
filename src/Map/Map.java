package Map;

/**
 * Created by FabianTB on 25.01.17.
 */
public class Map implements Runnable{


    public static <T, R> void map(Fun<T, R> f, T[] a, R[] b, int n) throws InterruptedException {

        if ((a.length != b.length) || n > a.length){
            throw new IllegalArgumentException();
        }


        int longerParts = a.length%n;
        int normalParts = n - longerParts;

        for (int i = 0; i < normalParts; i++){

        }



    }

    @Override
    public void run() {

    }
}
