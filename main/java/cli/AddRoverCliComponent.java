package cli;


import com.sun.org.apache.xpath.internal.operations.Or;
import control.MissionController;
import io.IOHandler;
import location.Orientation;
import location.Position;
import units.Rover;

public class AddRoverCliComponent implements CliComponent {

    private final IOHandler handler;
    private final MissionController controller;

    AddRoverCliComponent(IOHandler handler, MissionController controller) {
        this.handler = handler;
        this.controller = controller;
    }

    private Rover createRover(String roverId, String xString, String yString, String orientationString) {

        if (roverId.isEmpty()) {
            throw new IllegalArgumentException("roverId can not be empty");
        }

        int x = Integer.parseInt(xString);
        int y = Integer.parseInt(yString);
        Orientation orientation = Orientation.fromString(orientationString);

        return new Rover(roverId, orientation, new Position(x,y));
    }


    public void execute() {

        String roverId = handler.readWithMessage("rover_ID>");
        String positionX = handler.readWithMessage("rover_X>");
        String positionY = handler.readWithMessage("rover_Y>");
        String orientationString = handler.readWithMessage("rover_Orientation>");

        try {
            controller.add(createRover(roverId, positionX, positionY, orientationString));
        } catch (NumberFormatException ex) {
            handler.write("An invalid number was received, the error is: " + ex.getMessage());
        } catch (IllegalArgumentException ex) {
            handler.write(ex.getMessage());
        }

    }

}
