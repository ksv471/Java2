package Home_work_1;

public class Home_work_1 {
    public static void main(String[] args) {

        Gang[] gang = new Gang[7];
        gang[0] = new Cat("Barsik",1000, 7);
        gang[1] = new Cat("Murzik",2000, 8);
        gang[2] = new Human("Ivan",3000, 9);
        gang[3] = new Human("Igor",4000, 10);
        gang[4] = new Human("Vova",5000, 11);
        gang[5] = new Robot("Bender",10000, 24);
        gang[6] = new Robot("WALL-E",20000, 37);

        Treadmill treadmill = new Treadmill(100);
        Wall wall = new Wall(1);

        squidgame(gang, treadmill, wall);
    }

    //Игра в кальмара
    public static void squidgame(Gang[] gang, Treadmill treadmill, Wall wall) {
        int Stage;
        for ( Stage = 1; Stage <= 7; Stage++) {
            treadmill.setRunnig(treadmill.getRunnig()*Stage);
            wall.setHeight(wall.getHeight()*Stage);
            for (int i = 0; i < 7; i++) {
                if (gang[i].getMaxRunning() < treadmill.getRunnig()){
                    continue;
                }
                gang[i].runningTreadmill(treadmill);
            }
            for (int j = 0; j < 7; j++) {
                if (gang[j].getMaxJump() < wall.getHeight()) {
                    continue;
                }
                gang[j].jumpingWall(wall);
            }
            System.out.println("\n" + Stage + " этап окончен" + "\n");
        }
    }
}
