// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.Autonomous;
import frc.robot.commands.IntakeCommand;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.Stopwatch;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();  
  private final DriveSubsystem driveSubsystem = new DriveSubsystem();
  private final Stopwatch timer = new Stopwatch();

  private final Joystick driverController = new Joystick(ControllerConstants.DRIVER_PORT);
  private final Joystick operatorController = new Joystick(ControllerConstants.OPERATOR_PORT);

  SendableChooser<Command> chooser = new SendableChooser<>();
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    driveSubsystem.setDefaultCommand(
      new ArcadeDriveCommand(driveSubsystem, () -> -driverController.getRawAxis(DriveConstants.DRIVE_AXIS) * DriveConstants.DRIVE_PROPORTION, (() -> -driverController.getRawAxis(DriveConstants.TURN_AXIS) * DriveConstants.TURN_PROPORTION)));
    chooser.setDefaultOption("Autonomous", new Autonomous(driveSubsystem, intakeSubsystem, timer));
    intakeSubsystem.setDefaultCommand(new IntakeCommand(intakeSubsystem, () -> 0.0));


  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new JoystickButton(operatorController, ControllerConstants.INTAKE_BUTTON).whileTrue(new IntakeCommand(intakeSubsystem, () -> IntakeConstants.INTAKE_SPEED));
    new JoystickButton(operatorController, ControllerConstants.OUTTAKE_BUTTON).whileTrue(new IntakeCommand(intakeSubsystem, () -> -IntakeConstants.INTAKE_SPEED));
    
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return chooser.getSelected();

    
  }
}
