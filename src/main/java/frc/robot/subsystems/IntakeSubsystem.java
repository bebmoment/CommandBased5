package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants.IntakeConstants;
import frc.robot.Constants.PneumaticsConstants;
import edu.wpi.first.wpilibj2.command.CommandBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class IntakeSubsystem extends SubsystemBase {
    
    private final CANSparkMax intake = new CANSparkMax(IntakeConstants.INTAKE_MOTOR_ID, MotorType.kBrushless);
    
    private final DoubleSolenoid intakePneumatic = new DoubleSolenoid(PneumaticsConstants.PCM,
      PneumaticsModuleType.CTREPCM, IntakeConstants.INTAKE_FORWARD_PORT, IntakeConstants.INTAKE_REVERSE_PORT);
    
    public IntakeSubsystem() {

    }

    public void open() {
        
    }
}
