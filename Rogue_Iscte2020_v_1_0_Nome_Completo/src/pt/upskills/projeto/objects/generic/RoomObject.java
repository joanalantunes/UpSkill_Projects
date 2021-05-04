package pt.upskills.projeto.objects.generic;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.rogue.utils.Position;

public abstract class RoomObject implements ImageTile {
    protected Position position;
    protected String name;

    protected RoomObject(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
