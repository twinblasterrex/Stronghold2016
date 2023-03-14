package frc.robot.subsystems;


import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.Subsystem;

public class DrivetrainSubsystem implements Subsystem {
	public final Spark frontL;
	public final Spark frontR;
	public final Spark backL;
	public final Spark backR;

	public final MotorControllerGroup left;
	public final MotorControllerGroup right;

	public final DifferentialDrive drive;

	public DrivetrainSubsystem() {

		frontL = new Spark(0);
		frontR = new Spark(2);
		backL = new Spark(1);
		backR = new Spark(4);

		left = new MotorControllerGroup(frontL, backL);
		right = new MotorControllerGroup(frontR, backR);

		drive = new DifferentialDrive(left, right);
	}

	public void drive(double left, double right) {
		drive.tankDrive(left, right);
	}
}

