package Home_work_1;

//Класс человек
public class Human extends Gang {

    public Human(String name, int maxRunning, int maxJump) {
        super(name, maxRunning, maxJump);
    }


    @Override
    public void runningTreadmill(Treadmill treadmill) {
        if (treadmill.getRunnig() <= getMaxRunning() )
            System.out.println("Человек " + getName() + " пробежал " + treadmill.getRunnig() + " метров" );
        else System.out.println("Человек " + getName() + " не смог пробежать " + treadmill.getRunnig() + " метров");
    }

    @Override
    public void jumpingWall(Wall wall) {
        if (wall.getHeight() <= getMaxJump())
            System.out.println("Человек " + getName() + " перепрыгнул препятствие высотой " + wall.getHeight() + " метра");
        else System.out.println("Человек " + getName() + " не смог перепрыгнуть препятствие");
    }
}
