package pt.upskills.projeto.objects.statics;

import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.generic.RoomObject;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.Scanner;

public class Wall extends RoomObject {
    public Wall(Position position) {
        super(position, "Wall");
    }
}


