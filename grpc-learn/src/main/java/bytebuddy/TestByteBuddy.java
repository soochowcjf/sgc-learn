package bytebuddy;

/**
 * created by cjf 2020/12/1 15:57
 */
public class TestByteBuddy {

    private static int selectedIdx = -1;

    public static void main(String[] args) {


        try {

            selectedIdx = 2;
            throw new RuntimeException("");
        } catch (Exception e) {


        }
        System.out.println(selectedIdx);

    }

}
