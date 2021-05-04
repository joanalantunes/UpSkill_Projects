package pt.upskills.projeto.objects.objects;

import pt.upskills.projeto.game.FireBallThread;
import pt.upskills.projeto.gui.FireTile;
import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.generic.Bot;
import pt.upskills.projeto.objects.generic.Damageable;
import pt.upskills.projeto.objects.generic.RoomObject;
import pt.upskills.projeto.objects.statics.Wall;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.List;

public class FireBall extends RoomObject implements FireTile, Damageable {

    private List<Bot> bots;
    private List<Wall> walls;
    private Hero hero;

    public FireBall(Position position, List<Bot> bots, List<Wall> walls, Hero hero) {
        super(position, "Fire");
        this.bots = bots;
        this.walls = walls;
        this.hero = hero;
    }

    @Override
    public boolean validateImpact() {
        for (Bot bot: bots) {
            if (bot.getPosition().equals(this.getPosition())) {
                if (bot.damage(this.getDamage()) <= 0) {
                    this.bots.remove(bot);
                    this.hero.updateScore(bot.getScore());
                }
                return false;
            }
        }

        for (Wall wall: walls) {
            if (wall.getPosition().equals(this.getPosition())) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int getDamage() {
        return 10;
    }

    public void shoot(Direction direction, Position position) {
        ImageMatrixGUI.getInstance().removeStatusImage(this);

        this.setPosition(position);
        ImageMatrixGUI.getInstance().addImage(this);

        FireBallThread fireBallThread = new FireBallThread(direction, this);
        fireBallThread.start();
    }
}
