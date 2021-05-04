package pt.upskills.projeto.objects.generic;

import pt.upskills.projeto.objects.Hero;
import pt.upskills.projeto.objects.Room;
import pt.upskills.projeto.objects.objects.Key;
import pt.upskills.projeto.rogue.utils.Position;

public abstract class Door extends RoomObject {
    private int keyRequired;
    private int destinationDoor;
    private String destinationRoom;

    protected Door(Position position, String name, String destinationRoom, int destinationDoor, int keyRequired) {
        super(position, name);
        this.keyRequired = keyRequired;
        this.destinationDoor = destinationDoor;
        this.destinationRoom = destinationRoom;
    }

    public boolean requiresKey() {
        return this.keyRequired >= 0;
    }

    public int getKeyRequired() {
        return keyRequired;
    }

    public int getDestinationDoor() {
        return destinationDoor;
    }

    public String getDestinationRoom() {
        return destinationRoom;
    }

    public boolean enter(Collectable[] collectables) {
        if (this.requiresKey()) {
            for (int i = 0; i < collectables.length; i++) {
                if (collectables[i] != null && collectables[i].getName().equals("Key")) {
                    Key key = (Key) collectables[i];
                    if (key.getNumber() == this.getKeyRequired()) {
                        return Room.parseRoom(this.getDestinationRoom(), this.getDestinationDoor());
                    }
                }
            }

            return false;
        }

        return Room.parseRoom(this.getDestinationRoom(), this.getDestinationDoor());
    }
}
