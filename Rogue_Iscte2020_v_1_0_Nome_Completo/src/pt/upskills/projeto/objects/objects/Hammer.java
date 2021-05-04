package pt.upskills.projeto.objects.objects;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.objects.generic.Collectable;
import pt.upskills.projeto.objects.generic.RoomObject;
import pt.upskills.projeto.rogue.utils.Position;

public class Hammer extends Collectable {
    public Hammer(Position position) {
        super(position, "Hammer");
    }

    @Override
    public int getDamage() {
        return 2;
    }


    @Override
    public int getScore() {
        return 2;
    }
}
