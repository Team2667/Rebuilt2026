package frc.robot.commands;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Rumble extends Command {
    private CommandXboxController controller;

    public Rumble(CommandXboxController controller) {
        this.controller = controller;
    }

    @Override
    public void initialize() {
        controller.setRumble(RumbleType.kBothRumble, 10.0);
    }

    @Override
    public void end(boolean isInterupted) {
        controller.setRumble(RumbleType.kBothRumble, 0);
    }
}
