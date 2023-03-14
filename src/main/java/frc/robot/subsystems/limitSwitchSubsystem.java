package frc.robot.subsystems;


import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class limitSwitchSubsystem implements Subsystem {
	private final DigitalInput limitSwitch;

	public limitSwitchSubsystem() {
		limitSwitch = new DigitalInput(0);
		Shuffleboard.getTab("Life").addBoolean("Hello world", () -> limitSwitch.get());
	}

	@Override
	public void periodic() {

	}
}

