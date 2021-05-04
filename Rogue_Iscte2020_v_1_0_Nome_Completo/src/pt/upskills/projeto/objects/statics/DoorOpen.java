package pt.upskills.projeto.objects.statics;

import pt.upskills.projeto.objects.generic.Door;
import pt.upskills.projeto.rogue.utils.Position;

public class DoorOpen extends Door {
    public DoorOpen(Position position, String destinationRoom, int destinationDoor, int keyRequired) {
        super(position, "DoorOpen", destinationRoom, destinationDoor, keyRequired);
    }
}
