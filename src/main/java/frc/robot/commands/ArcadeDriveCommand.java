package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    
    private final DriveSubsystem driveSubsystem;
    private final DoubleSupplier speedFunction, turnFunction;

    public ArcadeDriveCommand(DriveSubsystem driveSubsystem, DoubleSupplier speedFunction, DoubleSupplier turnFunction) {
        this.driveSubsystem = driveSubsystem;
        this.speedFunction = speedFunction;
        this.turnFunction = turnFunction;
        addRequirements(driveSubsystem);
    }

    @Override 
    public void initialize() {
        System.out.println("Arcade driving");
    }

    @Override
    public void execute() {
        double forwardSpeed = speedFunction.getAsDouble();
        double turnSpeed = turnFunction.getAsDouble();
        if (forwardSpeed > 0.7) {
            forwardSpeed = 0.7;
        }
        if (turnSpeed > 0.8) {
            turnSpeed = 0.7;
        }
        driveSubsystem.setMotors(forwardSpeed, turnSpeed);
    }

    @Override 
    public void end(boolean interrupted) {

        System.out.println("Arcade no longer driving");
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
