package pt.upskills.projeto.objects.objects;

import pt.upskills.projeto.objects.generic.Collectable;
import pt.upskills.projeto.objects.generic.RoomObject;
import pt.upskills.projeto.rogue.utils.Position;

public class Key extends Collectable {
    private int number;

    public Key(Position position, int number) {
        super(position, "Key");
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public int getDamage() {
        return 0;
    }

    @Override
    public int getScore() {
        return 3;
    }
}
