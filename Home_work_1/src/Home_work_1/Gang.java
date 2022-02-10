package Home_work_1;

//Класс банда
public abstract class Gang {
    private final String name;
    private final int maxRunning;
    private final int maxJump;

    public Gang(String name, int maxRunning, int maxJump) {
        this.maxRunning = maxRunning;
        this.maxJump = maxJump;
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public int getMaxRunning() {
        return maxRunning;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public abstract void runningTreadmill(Treadmill treadmill);
    public abstract void jumpingWall(Wall wall);
}
