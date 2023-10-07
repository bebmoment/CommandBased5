// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
/*
 * Essentially a timer only ever used to autonomous for 2 seconds
 * 
 * CNE Bot 1 needed a way to keep track of time somewhere and so do I
 * this is sufficient
 */
public class Stopwatch extends SubsystemBase {
  private final Timer timer = new Timer();
  /** Creates a new Stopwatch. */
  public Stopwatch() {}

  public void resetTimer() {
    timer.reset();
  }

  public void startTimer() {
    timer.start();
  }

  public double getTimer() {
    return timer.get();
  }



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
