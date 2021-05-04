package pt.upskills.projeto.objects.objects;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.generic.Collectable;
import pt.upskills.projeto.objects.generic.RoomObject;
import pt.upskills.projeto.rogue.utils.Position;

public class Sword extends Collectable {

    private ImageTile imageTile;

    public Sword(Position position) {
        super(position, "Sword");
    }

    @Override
    public int getDamage() {
        return 1;
    }

    @Override
    public int getScore() {
        return 1;
    }
}
