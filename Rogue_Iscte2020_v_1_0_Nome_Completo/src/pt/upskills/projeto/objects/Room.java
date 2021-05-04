package pt.upskills.projeto.objects;

import pt.upskills.projeto.gui.ImageMatrixGUI;
import pt.upskills.projeto.gui.ImageTile;
import pt.upskills.projeto.objects.enemies.BadGuy;
import pt.upskills.projeto.objects.enemies.Bat;
import pt.upskills.projeto.objects.enemies.Skeleton;
import pt.upskills.projeto.objects.enemies.Thief;
import pt.upskills.projeto.objects.generic.Bot;
import pt.upskills.projeto.objects.generic.Collectable;
import pt.upskills.projeto.objects.generic.Door;
import pt.upskills.projeto.objects.generic.Movable;
import pt.upskills.projeto.objects.objects.FireBall;
import pt.upskills.projeto.objects.objects.Hammer;
import pt.upskills.projeto.objects.objects.Key;
import pt.upskills.projeto.objects.objects.Sword;
import pt.upskills.projeto.objects.statics.*;
import pt.upskills.projeto.objects.status.Black;
import pt.upskills.projeto.rogue.utils.Position;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Room {

    public static List<ImageTile> parseStatus() {
        List<ImageTile> statusImages = new ArrayList<>();

        statusImages.add(new Black(new Position(0, 0)));
        statusImages.add(new Black(new Position(1, 0)));
        statusImages.add(new Black(new Position(2, 0)));
        statusImages.add(new Black(new Position(7, 0)));
        statusImages.add(new Black(new Position(8, 0)));
        statusImages.add(new Black(new Position(9, 0)));

       return statusImages;
    }

    private static void clearAll() {
        ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
        gui.clearImages();
        gui.clearStatus();
    }

    public static boolean parseRoom(String roomName, int doorStart) {
        if (roomName == null) {
            return true;
        }

        List<ImageTile> room = new ArrayList<>();

        Hero hero;
        List<Wall> walls = new ArrayList<>();
        List<Bot> bots = new ArrayList<>();
        List<Collectable> collectables = new ArrayList<>();
        List<Door> doors = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File("rooms/"+roomName));
            clearAll();

            int i = 0;
            hero = new Hero(new Position(0,0));

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.startsWith("#")) {
                    String[] tokens = line.split(" ");
                    if (tokens.length == 6) {
                        Door door = new DoorClosed(new Position(-1, -1), tokens[3], Integer.parseInt(tokens[4]), 1);
                        doors.add(door);
                    } else if (tokens.length == 5) {
                        Door door;
                        switch (tokens[2]) {
                            case "E":
                                door = new DoorWay(new Position(-1, -1), tokens[3], Integer.parseInt(tokens[4]), -1);
                                doors.add(door);
                                break;
                            case "D":
                                door = new DoorOpen(new Position(-1, -1), tokens[3], Integer.parseInt(tokens[4]), -1);
                                doors.add(door);
                                break;
                            default:
                                break;
                        }
                    } else if (tokens.length == 3) {
                        DoorTrap door = new DoorTrap(new Position(-1, -1), -1);
                        doors.add(door);
                    }
                } else {
                    String[] tokens = line.split("");
                    for (int j = 0; j < tokens.length; j++) {
                        switch (tokens[j]){
                            case "W":
                                Wall wall = new Wall(new Position(j, i));
                                room.add(wall);
                                walls.add(wall);
                                break;
                            case " ":
                               room.add(new Floor(new Position(j, i)));
                               break;
                            case "r":
                               room.add(new Grass(new Position(j,i)));
                               break;
                            case "S":
                                Skeleton skeleton = new Skeleton(new Position(j,i));
                                room.add(new Floor(new Position(j,i)));
                                bots.add(skeleton);
                                break;
                            case "B":
                                Bat bat = new Bat(new Position(j,i));
                                room.add(new Floor(new Position(j,i)));
                                bots.add(bat);
                                break;
                            case "G":
                                BadGuy badGuy = new BadGuy(new Position(j,i));
                                room.add(new Floor(new Position(j,i)));
                                bots.add(badGuy);
                                break;
                            case "s":
                                Sword sword = new Sword(new Position(j,i));
                                room.add(new Floor(new Position(j,i)));
                                room.add(sword);
                                collectables.add(sword);
                                break;
                            case "a":
                                Hammer hammer = new Hammer(new Position(j,i));
                                room.add(new Floor(new Position(j,i)));
                                room.add(hammer);
                                collectables.add(hammer);
                                break;
                            case "T":
                                Thief thief = new Thief(new Position(j,i));
                                room.add(new Floor(new Position(j,i)));
                                bots.add(thief);
                                break;
                            case "h":
                                hero.setPosition(new Position(j, i));
                                room.add(new Floor(new Position(j,i)));
                                break;
                            case "k":
                                Key key = new Key(new Position(j, i), 1);
                                room.add(new Floor(new Position(j,i)));
                                room.add(key);
                                collectables.add(key);
                                break;
                            default:
                                try {
                                    int doorNumber = Integer.parseInt(tokens[j]);
                                    if (doorStart == doorNumber) {
                                        hero.setPosition(new Position(j, i));
                                    }

                                    if (doorNumber <doors.size()) {
                                        Door door = doors.get(doorNumber);
                                        door.setPosition(new Position(j, i));
                                        room.add(door);
                                    }
                                } catch (NumberFormatException e) {

                                }
                                break;
                        }
                    }
                    i++;
                }

            }
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
            return false;
        }

        for(int i=0;i<bots.size();i++) {
            Bot bot = bots.get(i);
            bot.setWalls(walls);
            bot.setDoors(doors);

            List<Movable> movables = new ArrayList<>();
            movables.addAll(bots);
            movables.remove(bot);
            movables.add(hero);
            bot.setMovables(movables);

            room.add(bot);
        }

        List<FireBall> fireBalls = new ArrayList<>();
        fireBalls.add(new FireBall(new Position(0, 0), bots, walls, hero));
        fireBalls.add(new FireBall(new Position(1, 0), bots, walls, hero));
        fireBalls.add(new FireBall(new Position(2, 0), bots, walls, hero));


        hero.setWalls(walls);
        hero.setDoors(doors);
        hero.setBots(bots);
        hero.setCollectables(collectables);
        hero.setFireBalls(fireBalls);


        hero.updateLife(Hero.life);

        room.add(hero);

        List<ImageTile> statusImages = parseStatus();
        statusImages.addAll(fireBalls);

        ImageMatrixGUI gui = ImageMatrixGUI.getInstance();
        gui.newStatusImages(statusImages);

        gui.addObserver(hero);
        gui.newImages(room);

        return true;
    }
}






