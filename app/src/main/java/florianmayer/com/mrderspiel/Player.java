package florianmayer.com.mrderspiel;

public class Player {
    private String name;
    private boolean alive;
    private Player target;

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.alive = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Player getTarget() {
        return target;
    }

    public void setTarget(Player target) {
        this.target = target;
    }

    public void killTarget() {
        target.setAlive(false);
        Player nexttarget = target.getTarget();
        target.setTarget(null);
        this.target = nexttarget;
    }

    @Override
    public String toString() {
        return name;
    }
}
