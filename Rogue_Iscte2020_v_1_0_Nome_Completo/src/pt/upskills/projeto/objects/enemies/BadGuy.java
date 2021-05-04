package pt.upskills.projeto.objects.enemies;

import pt.upskills.projeto.objects.generic.Bot;
import pt.upskills.projeto.rogue.utils.Position;

public class BadGuy extends Bot {

    public BadGuy (Position position) {
        super(position, "BadGuy", 3);
    }
}


