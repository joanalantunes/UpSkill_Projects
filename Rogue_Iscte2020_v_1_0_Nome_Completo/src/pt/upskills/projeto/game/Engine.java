package pt.upskills.projeto.game;

import pt.upskills.projeto.gui.FireTile;
import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.*;
import pt.upskills.projeto.objects.enemies.Thief;
import pt.upskills.projeto.objects.generic.Bot;
import pt.upskills.projeto.objects.generic.Movable;
import pt.upskills.projeto.objects.objects.Hammer;
import pt.upskills.projeto.objects.objects.Key;
import pt.upskills.projeto.objects.objects.Sword;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.objects.status.Green;
import pt.upskills.projeto.objects.status.RedGreen;
import pt.upskills.projeto.rogue.utils.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class Engine {

    public void init() {
        ImageMatrixGUI gui = ImageMatrixGUI.getInstance();

        Hero.life = 8;
        Hero.score = 100;
        Room.parseRoom("room0.txt", -1);

        gui.setName("Rogue");
        gui.go();

        while (true) { //enquanto for true faz update
            gui.update();
        }
    }

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.init();
    }
}

