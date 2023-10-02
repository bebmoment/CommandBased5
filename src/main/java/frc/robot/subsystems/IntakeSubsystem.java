package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.IntakeConstants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeSubsystem extends SubsystemBase {
    
    private final CANSparkMax intake = new CANSparkMax(IntakeConstants.INTAKE_MOTOR_ID, MotorType.kBrushless);

    private boolean stall;
    
    public IntakeSubsystem() {

    }

    public void setMotor(double speed) {
        intake.set(speed);
    }

    public boolean getStall() {
      return stall;
    }

    public void setStall(boolean idle) {
      this.stall = idle;
    }


    @Override
    public void periodic() {
      // This method will be called once per scheduler run
      SmartDashboard.putNumber("Intake Speed", intake.get());
    }
}
