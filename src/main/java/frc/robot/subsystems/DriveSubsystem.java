// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.DriveConstants;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;


public class DriveSubsystem extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */

  private final WPI_VictorSPX driveFrontLeft = new WPI_VictorSPX(DriveConstants.DRIVE_FRONT_LEFT);
  private final WPI_VictorSPX driveFrontRight = new WPI_VictorSPX(DriveConstants.DRIVE_FRONT_RIGHT);
  private final WPI_VictorSPX driveBackLeft = new WPI_VictorSPX(DriveConstants.DRIVE_BACK_LEFT);
  private final WPI_VictorSPX driveBackRight = new WPI_VictorSPX(DriveConstants.DRIVE_BACK_RIGHT);

  private final MotorControllerGroup driveLeft = new MotorControllerGroup(driveFrontLeft, driveBackLeft);
  private final MotorControllerGroup driveRight = new MotorControllerGroup(driveFrontRight, driveBackRight);
  private final DifferentialDrive differentialDrive = new DifferentialDrive(driveLeft, driveRight);


  public DriveSubsystem() {
    driveFrontLeft.setNeutralMode(NeutralMode.Brake);
    driveFrontRight.setNeutralMode(NeutralMode.Brake);
    driveBackRight.setNeutralMode(NeutralMode.Brake);
    driveBackLeft.setNeutralMode(NeutralMode.Brake);
    driveRight.setInverted(true);
  }

  public void setMotors(double forwardSpeed, double turnSpeed)  {
    differentialDrive.arcadeDrive(forwardSpeed, turnSpeed);
  }

}
