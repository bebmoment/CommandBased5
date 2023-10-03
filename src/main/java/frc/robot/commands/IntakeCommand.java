// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import java.util.function.DoubleSupplier;
import frc.robot.Constants.IntakeConstants;;

public class IntakeCommand extends CommandBase {
 
  private final IntakeSubsystem m_intakeSubsystem;
  private final DoubleSupplier speed;
  
  /** Creates a new IntakeCommand. */
  public IntakeCommand(IntakeSubsystem intakeSubsystem, DoubleSupplier speedFunction) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_intakeSubsystem = intakeSubsystem;
    speed = speedFunction;
    addRequirements(this.m_intakeSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    if(speed.getAsDouble() < 0.0){

      m_intakeSubsystem.setMotor(speed.getAsDouble());
      m_intakeSubsystem.setStall(true);
    }

    else if(speed.getAsDouble() > 0.0){
      m_intakeSubsystem.setMotor(speed.getAsDouble());
      m_intakeSubsystem.setStall(false);
    }

    else if(speed.getAsDouble() == 0.0){

      if(m_intakeSubsystem.getStall() /* && IntakeConstants.stallAfterIntake */){
        m_intakeSubsystem.setMotor(IntakeConstants.INTAKE_STALL_SPEED);
      }
      else{
        m_intakeSubsystem.setMotor(speed.getAsDouble());
      }
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_intakeSubsystem.setMotor(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
