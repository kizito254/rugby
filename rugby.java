import java.util.Random;

public class RugbyGame {
  private static final int NUM_PLAYERS = 15;
  private static final int FIELD_LENGTH = 100;

  public static void main(String[] args) {
    // Create the players
    Player[] players = new Player[NUM_PLAYERS];
    for (int i = 0; i < NUM_PLAYERS; i++) {
      players[i] = new Player("Player " + (i + 1));
    }

    // Play the game
    while (true) {
      for (Player player : players) {
        player.run(10);
        if (player.getPosition() == FIELD_LENGTH) {
          System.out.println(player.getName() + " has scored a try!");
          return;
        }
      }
    }
  }
}

class Player {
  private String name;
  private int position;

  public Player(String name) {
    this.name = name;
    this.position = 0;
  }

  public void run(int distance) {
    // Generate a random number between 1 and 6
    Random random = new Random();
    int roll = random.nextInt(6) + 1;

    // Advance the player's position by the roll
    position += roll;

    // Clamp the position to the length of the field
    if (position > RugbyGame.FIELD_LENGTH) {
      position = RugbyGame.FIELD_LENGTH;
    }

    System.out.println(name + " runs for " + distance + " meters! "
                       + "They are now at position " + position + " on the field.");
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }
}
