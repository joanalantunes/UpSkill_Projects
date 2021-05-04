package pt.upskills.projeto.objects.statics;

import pt.upskills.projeto.objects.generic.Door;
import pt.upskills.projeto.rogue.utils.Position;

public class DoorTrap extends Door {
    public DoorTrap(Position position, int keyRequired) {
        super(position, "Trap", null, -1, keyRequired);
    }
}
