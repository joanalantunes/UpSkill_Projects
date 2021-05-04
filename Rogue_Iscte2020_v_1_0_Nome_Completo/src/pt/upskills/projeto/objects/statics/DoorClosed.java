package pt.upskills.projeto.objects.statics;

import pt.upskills.projeto.objects.generic.Door;
import pt.upskills.projeto.objects.generic.RoomObject;
import pt.upskills.projeto.rogue.utils.Position;

public class DoorClosed extends Door {
    public DoorClosed(Position position, String destinationRoom, int destinationDoor, int keyRequired) {
        super(position, "DoorClosed", destinationRoom, destinationDoor, keyRequired);
    }

}
