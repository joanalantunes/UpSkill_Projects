package pt.upskills.projeto.objects.statics;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.generic.RoomObject;
import pt.upskills.projeto.rogue.utils.Position;

public class Floor extends RoomObject {

    public Floor(Position position) {
        super(position, "Floor");
    }

}
