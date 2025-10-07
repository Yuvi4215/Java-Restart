/**
 * Enums in Java:
 * - Used to represent a fixed set of constants.
 * - Can have constructors, fields, and methods.
 * - Each constant is an instance of the enum type.
 * - Provides type-safety compared to using plain constants or strings.
 */
public class EnumsDemo {

    enum Direction {
        NORTH, SOUTH, EAST, WEST
    }


     //  2. Enum with Fields, Constructor, and Methods

    enum Season {
        WINTER("Cold Season", 0),
        SPRING("Pleasant Season", 1),
        SUMMER("Hot Season", 2),
        AUTUMN("Windy Season", 3);

        private final String description;
        private final int order;

        // Constructor (must be private or package-private)
        Season(String description, int order) {
            this.description = description;
            this.order = order;
        }

        public String getDescription() {
            return description;
        }

        public int getOrder() {
            return order;
        }

        public void displayInfo() {
            System.out.println(this.name() + " → " + description + " (Order: " + order + ")");
        }
    }


     //  3. Enum with Custom Methods and Behavior

    enum TrafficLight {
        RED(30) {
            @Override
            public TrafficLight next() {
                return GREEN;
            }
        },
        GREEN(45) {
            @Override
            public TrafficLight next() {
                return YELLOW;
            }
        },
        YELLOW(5) {
            @Override
            public TrafficLight next() {
                return RED;
            }
        };

        private final int duration; // seconds

        TrafficLight(int duration) {
            this.duration = duration;
        }

        public int getDuration() {
            return duration;
        }

        // Abstract method that must be overridden by each constant
        public abstract TrafficLight next();
    }


     //  4. Enum Inside a Class (Example)

    static class Game {
        enum Level { EASY, MEDIUM, HARD }

        void start(Level level) {
            switch (level) {
                case EASY:
                    System.out.println("Starting game in EASY mode...");
                    break;
                case MEDIUM:
                    System.out.println("Starting game in MEDIUM mode...");
                    break;
                case HARD:
                    System.out.println("Starting game in HARD mode... Good luck!");
                    break;
            }
        }
    }


     //  5. Main Method (Demo)

    public static void main(String[] args) {
        System.out.println("=== Enums in Java Demo ===\n");

        /** 1. Basic Enum Example **/
        System.out.println("------------------------------------");
        System.out.println("* 1. Basic Enum Example *");
        Direction dir = Direction.NORTH;
        System.out.println("Current direction: " + dir);

        System.out.println("All directions:");
        for (Direction d : Direction.values()) {
            System.out.println("- " + d);
        }
        System.out.println();

        /** 2. Enum with Fields, Constructor, and Methods **/
        System.out.println("------------------------------------");
        System.out.println("* 2. Enum with Fields & Methods *");
        for (Season s : Season.values()) {
            s.displayInfo();
        }
        System.out.println("Season.SUMMER description: " + Season.SUMMER.getDescription());
        System.out.println();

        /** 3. Enum with Custom Behavior **/
        System.out.println("------------------------------------");
        System.out.println("* 3. Enum with Custom Behavior *");
        TrafficLight light = TrafficLight.RED;
        for (int i = 0; i < 4; i++) {
            System.out.println("Light: " + light + " (Duration: " + light.getDuration() + "s)");
            light = light.next();
        }
        System.out.println();

        /** 4. Enum Inside a Class **/
        System.out.println("------------------------------------");
        System.out.println("* 4. Enum Inside a Class *");
        Game game = new Game();
        game.start(Game.Level.EASY);
        game.start(Game.Level.HARD);
        System.out.println();

        /** 5. Enum Methods Demonstration **/
        System.out.println("------------------------------------");
        System.out.println("* 5. Enum Built-in Methods *");
        System.out.println("Ordinal of Direction.EAST = " + Direction.EAST.ordinal());
        System.out.println("Value of 'WEST' = " + Direction.valueOf("WEST"));
        System.out.println("Comparing NORTH and SOUTH = " + Direction.NORTH.compareTo(Direction.SOUTH));
        System.out.println();
    }
}
