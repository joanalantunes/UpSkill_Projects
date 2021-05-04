package pt.upskills.projeto.objects.generic;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.statics.Wall;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;
import java.util.List;

public abstract class Movable extends RoomObject {

    protected List<Wall> walls;
    protected List<Door> doors;
    protected List<Movable> movables;

    protected Movable(Position position, String name) {
        super(position, name);
        this.walls = new ArrayList<>();
        this.movables = new ArrayList<>();
        this.doors = new ArrayList<>();
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public void setDoors(List<Door> doors) {
        this.doors = doors;
    }

    public void setMovables(List<Movable> movables) {
        this.movables = movables;
    }

    @Override
    public void setPosition(Position position) {
        if (position.getX() == -1 && position.getY() == -1) {
            this.position = position;
        }


        for (int i = 0 ; i < walls.size(); i++) {
            Wall wall = walls.get(i);
            Position wallPosition = wall.getPosition();
            if (wallPosition.equals(position)) {
                return;
            }
        }

        for (int i = 0 ; i < doors.size(); i++) {
            Door door = doors.get(i);
            Position doorPosition = door.getPosition();
            if (doorPosition.equals(position)) {
                return;
            }
        }

        for (int i = 0 ; i < movables.size(); i++) {
            Movable movable = movables.get(i);
            Position movablePosition = movable.getPosition();
            if (movablePosition.equals(position)) {
                return;
            }
        }

        this.position = position;
    }
}
