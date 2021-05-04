package pt.upskills.projeto.objects.statics;

import pt.upskills.projeto.objects.generic.Door;
import pt.upskills.projeto.rogue.utils.Position;

public class DoorWay extends Door {
    public DoorWay(Position position, String destinationRoom, int destinationDoor, int keyRequired) {
        super(position, "DoorWay", destinationRoom, destinationDoor, keyRequired);
    }

}
