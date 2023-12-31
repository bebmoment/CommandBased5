// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.IntakeConstants;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Autonomous extends ParallelCommandGroup {
  /** Creates a new Autonomous. */
  public Autonomous(DriveSubsystem driveSubsystem, IntakeSubsystem intakeSubsytem) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(new ArcadeDriveCommand(driveSubsystem, () -> AutoConstants.AUTO_DRIVE_SPEED, () -> AutoConstants.AUTO_TURN_SPEED).withTimeout(AutoConstants.DELAY_SECONDS), 
    new IntakeCommand(intakeSubsytem, () -> IntakeConstants.INTAKE_SPEED).withTimeout(AutoConstants.DELAY_SECONDS));
  }
}
