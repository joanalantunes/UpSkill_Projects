package pt.upskills.projeto.objects.generic;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.statics.Wall;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public abstract class Bot extends Movable implements Life {

    private int life;
    private int score;

    public Bot(Position position, String name, int life) {
        super(position, name);
        this.life = life;
        this.score = life;
    }

    public int damage(int damage) {
        this.updateLife(this.life - damage);
        return this.life;
    }

    public void updateLife(int life) {
        this.life = life;
        if (this.life <= 0) {
            this.setPosition(new Position(-1, -1));
            ImageMatrixGUI.getInstance().removeImage(this);
        }
    }

    public void update(Movable target) {
        Position position = this.getPosition();
        if (position.getX() == -1 && position.getY() == -1) {
            return;
        }

        double distance = this.position.getDistance(target.getPosition());
        if (distance < 3){
            this.moveToTarget(target);
        } else {
            this.moveRandom();
        }
    }

    protected void moveToTarget(Movable target) {
        int targetX = target.getPosition().getX();
        int targetY = target.getPosition().getY();

        int selfX = this.getPosition().getX();
        int selfY = this.getPosition().getY();

        if (targetX < selfX) {
            this.setPosition(position.plus(Direction.LEFT.asVector()));
        } else if (targetX > selfX) {
            this.setPosition(position.plus(Direction.RIGHT.asVector()));
        } else if (targetY > selfY) {
            this.setPosition(position.plus(Direction.DOWN.asVector()));
        } else {
            this.setPosition(position.plus(Direction.UP.asVector()));
        }
    }

    protected void moveRandom() {
        int value = (int) (Math.random() * 4);
        switch (value) {
            case 0:
                this.setPosition(position.plus(Direction.DOWN.asVector()));
                break;
            case 1:
                this.setPosition(position.plus(Direction.UP.asVector()));
                break;
            case 2:
                this.setPosition(position.plus(Direction.LEFT.asVector()));
                break;
            case 3:
                this.setPosition(position.plus(Direction.RIGHT.asVector()));
                break;
            default:
                break;
        }
    }

    public int getLife() {
        return life;
    }

    public int getScore() {
        return score;
    }
}




