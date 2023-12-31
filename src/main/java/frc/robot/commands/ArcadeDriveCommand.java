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
        driveSubsystem.setMotors(forwardSpeed, turnSpeed);
    }

    @Override 
    public void end(boolean interrupted) {
        this.driveSubsystem.setMotors(0,0);
        System.out.println("Arcade no longer driving");
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
