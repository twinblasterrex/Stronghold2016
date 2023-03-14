package frc.robot.subsystems;


import edu.wpi.first.wpilibj.PneumaticHub;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class IntakeSubsystem implements Subsystem {
	Spark motor = new Spark(5);
	Solenoid sol;
	PneumaticHub m_pneumaticHub;

	public IntakeSubsystem() {
		m_pneumaticHub = new PneumaticHub(18);


		m_pneumaticHub.enableCompressorDigital();

		sol = m_pneumaticHub.makeSolenoid(10);
//		sol = new Solenoid(PneumaticsModuleType.CTREPCM, 4);
	}

	public void out() {
//		sol.set(false);

	}

	public void in() {
//		sol.set(true);
	}

	public void run(double speed) {
		motor.set(speed);
	}

}

