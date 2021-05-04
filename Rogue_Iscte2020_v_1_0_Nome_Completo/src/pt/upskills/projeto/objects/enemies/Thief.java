package pt.upskills.projeto.objects.enemies;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.objects.generic.Bot;
import pt.upskills.projeto.objects.generic.Movable;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Thief extends Bot { //Tem de andar na Diagonal

    public Thief(Position position) {
        super(position, "Thief",2);

    }

    @Override
    protected void moveToTarget(Movable target) {
        int targetX = target.getPosition().getX();
        int targetY = target.getPosition().getY();

        int selfX = this.getPosition().getX();
        int selfY = this.getPosition().getY();

        if (targetX < selfX && targetY < selfY) {
            this.setPosition(position.plus(Direction.LEFT_UP.asVector()));
        } else if (targetX < selfX && targetY > selfY) {
            this.setPosition(position.plus(Direction.LEFT_DOWN.asVector()));
        } else if (targetX > selfX && targetY < selfY) {
            this.setPosition(position.plus(Direction.RIGHT_UP.asVector()));
        } else if (targetX > selfX && targetY > selfY) {
            this.setPosition(position.plus(Direction.RIGHT_DOWN.asVector()));
        }
    }

    protected void moveRandom() {
        int value = (int) (Math.random() * 4);
        switch (value) {
            case 0:
                this.setPosition(position.plus(Direction.RIGHT_DOWN.asVector()));
                break;
            case 1:
                this.setPosition(position.plus(Direction.RIGHT_UP.asVector()));
                break;
            case 2:
                this.setPosition(position.plus(Direction.LEFT_DOWN.asVector()));
                break;
            case 3:
                this.setPosition(position.plus(Direction.LEFT_UP.asVector()));
                break;
            default:
                break;
        }
    }

}

