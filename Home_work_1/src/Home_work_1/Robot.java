package Home_work_1;

//Класс робот
public class Robot extends Gang {

    public Robot(String name, int maxRunning, int maxJump) {
        super(name, maxRunning, maxJump);
    }


    @Override
    public void runningTreadmill(Treadmill treadmill) {
        if (treadmill.getRunnig() <= getMaxRunning() )
            System.out.println("Робот " + getName() + " пробежал " + treadmill.getRunnig() + " метров" );
        else System.out.println("Робот " + getName() + " не смог пробежать " + treadmill.getRunnig() + " метров");
    }

    @Override
    public void jumpingWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump())
            System.out.println("Робот " + getName() + " перепрыгнул препятствие высотой " + wall.getHeight() + " метра");
        else System.out.println("Робот " + getName() + " не смог перепрыгнуть препятствие высотой  " + wall.getHeight() + " метра");
    }
}
