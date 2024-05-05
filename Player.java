public class Player {
    private String name;
    private Die playerDie;

    public Player(String name, Die playerDie) {
        this.name = name;
        this.playerDie = playerDie;
    }

    public String getName() {
        return name;
    }

    public Die getPlayerDie() {
        return playerDie;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPlayerDie(Die playerDie) {
        this.playerDie = playerDie;
    }
}
