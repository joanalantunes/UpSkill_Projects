package pt.upskills.projeto.objects;

import pt.upskills.projeto.gui.FireTile;
import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.generic.*;
import pt.upskills.projeto.objects.objects.FireBall;
import pt.upskills.projeto.objects.status.Green;
import pt.upskills.projeto.objects.status.Red;
import pt.upskills.projeto.objects.status.RedGreen;
import pt.upskills.projeto.rogue.utils.Direction;
import pt.upskills.projeto.rogue.utils.Position;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Hero extends Movable implements Observer {

    public static int life;
    public static int score;
    private Direction direction;

    private Collectable[] equipment;

    private List<Bot> bots;
    private List<FireBall> fireBalls;
    private List<Collectable> collectables;

    private ImageTile[] lifeTiles;


    public Hero(Position position) {
        super(position, "Hero");

        this.lifeTiles = null;
        this.equipment = new Collectable[3];

        this.bots = new ArrayList<>();
        this.fireBalls = new ArrayList<>();
        this.collectables = new ArrayList<>();
        this.direction = Direction.UP;
    }

    public void setCollectables(List<Collectable> collectables) {
        this.collectables = collectables;
    }

    public void setBots(List<Bot> bots) {
        this.bots = bots;

        this.movables.clear();
        this.movables.addAll(bots);
    }

    public void setFireBalls(List<FireBall> fireBalls) {
        this.fireBalls = fireBalls;
    }

    public void updateLife(int life) {
        this.life = life;
        if (this.lifeTiles != null) {
            for (int i = 0; i < this.lifeTiles.length; i++) {
                ImageMatrixGUI.getInstance().removeStatusImage(this.lifeTiles[i]);
            }
        }

        this.lifeTiles = new ImageTile[4];

        int numberOfGreens = life / 2;
        boolean hasHalfGreen = false;
        if (life % 2 == 1) {
            hasHalfGreen = true;
        }

        int totalTiles = 0;
        for (int i = 0; i < numberOfGreens; i++) {
            this.lifeTiles[totalTiles] = new Green(new Position(3+totalTiles, 0));
            totalTiles++;
        }

        if (hasHalfGreen) {
            this.lifeTiles[totalTiles] = new RedGreen(new Position(3+totalTiles, 0));
            totalTiles++;
        }

        while (totalTiles < this.lifeTiles.length) {
            this.lifeTiles[totalTiles] = new Red(new Position(3+totalTiles, 0));
            totalTiles++;
        }

        for (int i = 0; i < this.lifeTiles.length; i++) {
            ImageMatrixGUI.getInstance().addStatusImage(this.lifeTiles[i]);
        }

    }


    /**
     * This method is called whenever the observed object is changed. This function is called when an
     * interaction with the graphic component occurs {{@link ImageMatrixGUI}}
     *
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {

        Integer keyCode = (Integer) arg;
        Position oldPosition = this.getPosition();

        Position newPosition = processKeyEvent(keyCode);

        if (oldPosition == this.getPosition()) {
            for (int i = 0; i < doors.size(); i++) {
                Door door = doors.get(i);
                Position doorPosition = door.getPosition();
                if (doorPosition.equals(newPosition)) {
                    if (door.enter(equipment)) {
                        ImageMatrixGUI.getInstance().deleteObserver(this);
                        if (door.getDestinationRoom() == null) {
                            this.endGame();
                        }
                        return;
                    }
                }
            }

            for (int i = 0 ; i < bots.size(); i++) {
                Bot bot = bots.get(i);
                Position botPosition = bot.getPosition();
                if (botPosition.equals(newPosition)) {
                    bot.damage(calculateDamage());
                    if (bot.getLife() <= 0) {
                        this.updateScore(bot.getScore());
                    }
                    return;
                }
            }
            return;
        }

        this.updateScore(-1);

        processCollectables();

        processBots();

        processLife();
    }

    private void processCollectables() {
        for (int i = 0; i < this.collectables.size(); i++) {
            if (this.collectables.get(i).isCollected(this.getPosition())) {
                int j = 0;
                while (this.equipment[j] != null && j < this.equipment.length) {
                    j++;
                }

                if (j < this.equipment.length) {
                    this.equipment[j] = this.collectables.get(i);
                    this.equipment[j].equip(new Position(j + 7, 0));
                    this.updateScore(this.equipment[j].getScore());
                }

                break;
            }
        }
    }

    private void processBots() {
        for (int i = 0; i < this.bots.size(); i++) {
            this.bots.get(i).update(this);
        }
    }

    private void processLife() {
        for (int i = 0; i < this.bots.size(); i++) {
            double distance = this.getPosition().getDistance(this.bots.get(i).getPosition());
            if (distance == 1) {
                this.damage(1);
                return;
            }
        }
    }

    public void endGame() {
        ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
        gui.removeImage(this);
        gui.deleteObserver(this);
        System.out.println("Score of "+this.score);
        System.out.println("I'll be back!");
    }

    public int damage(int damage) {
        this.updateLife(this.life - damage);
        if (this.life <= 0) {
            this.endGame();
        }

        return this.life;
    }

    private Position processKeyEvent(Integer keyCode) {
        Position newPosition = this.getPosition();
        switch (keyCode) {
            case KeyEvent.VK_DOWN:
                newPosition = this.getPosition().plus(Direction.DOWN.asVector());
                this.setPosition(newPosition);
                direction = Direction.DOWN;
                break;
            case KeyEvent.VK_UP:
                newPosition = this.getPosition().plus(Direction.UP.asVector());
                this.setPosition(newPosition);
                direction = Direction.UP;
                break;
            case KeyEvent.VK_LEFT:
                newPosition = this.getPosition().plus(Direction.LEFT.asVector());
                this.setPosition(newPosition);
                direction = Direction.LEFT;
                break;
            case KeyEvent.VK_RIGHT:
                newPosition = this.getPosition().plus(Direction.RIGHT.asVector());
                this.setPosition(newPosition);
                direction = Direction.RIGHT;
                break;
            case KeyEvent.VK_SPACE:
                if (this.fireBalls.size() > 0) {
                    FireBall fireBall = fireBalls.remove(fireBalls.size() - 1);
                    fireBall.shoot(direction, this.getPosition());
                }
                break;
            case KeyEvent.VK_1:
                if (this.equipment[0] != null) {
                    this.equipment[0].drop(this.getPosition());
                    this.equipment[0] = null;
                }
                break;
            case KeyEvent.VK_2:
                if (this.equipment[1] != null) {
                    this.equipment[1].drop(this.getPosition());
                    this.equipment[1] = null;
                }
                break;
            case KeyEvent.VK_3:
                if (this.equipment[2] != null) {
                    this.equipment[2].drop(this.getPosition());
                    this.equipment[2] = null;
                }
                break;
            default:
                break;
        }

        return newPosition;
    }

    private int calculateDamage() {
        int damage = 1;
        for (int i = 0; i < equipment.length; i++) {
            if (equipment[i] != null) {
                damage = damage + equipment[i].getDamage();
            }
        }

        return damage;
    }

    public void updateScore(int score) {
        this.score = this.score + score;
        if (this.score < 0) {
            this.score = 0;
        }
    }

}

