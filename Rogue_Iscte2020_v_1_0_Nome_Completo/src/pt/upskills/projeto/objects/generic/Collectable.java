package pt.upskills.projeto.objects.generic;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.rogue.utils.Position;

public abstract class Collectable extends RoomObject implements Damageable {

    protected Collectable(Position position, String name) {
        super(position, name);
    }

    public boolean isCollected(Position position) {
        return this.getPosition().equals(position);
    }

    public void equip(Position position) {
        this.setPosition(position);
        ImageMatrixGUI.getInstance().removeImage(this);
        ImageMatrixGUI.getInstance().addStatusImage(this);
    }

    public void drop(Position position) {
        this.setPosition(position);
        ImageMatrixGUI.getInstance().removeStatusImage(this);
        ImageMatrixGUI.getInstance().addImage(this);
    }

    public abstract int getScore();
}
