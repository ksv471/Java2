package Home_work_2;

public class Home_work_2 {
    static int S = 4;

    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"}
        };
        try {
            int sum = ArraySize.sum(array);
            System.out.println(sum);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println(e.getRow() + " " + e.getCol());
            System.out.println(array[e.getRow()][e.getCol()]);
        }
        System.out.println("конец");
    }
}
