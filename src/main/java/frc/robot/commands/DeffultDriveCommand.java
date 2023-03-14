package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DrivetrainSubsystem;

import java.util.function.DoubleSupplier;


public class DeffultDriveCommand extends CommandBase {
	private final DrivetrainSubsystem drivetrainSubsystem;
	private final DoubleSupplier m_xSupplier;
	private final DoubleSupplier m_ySupplier;

	public DeffultDriveCommand(DrivetrainSubsystem drivetrainSubsystem,
	                           DoubleSupplier xSupplier,
	                           DoubleSupplier ySupplier) {
		this.drivetrainSubsystem = drivetrainSubsystem;
		m_xSupplier = xSupplier;
		m_ySupplier = ySupplier;

		addRequirements(this.drivetrainSubsystem);
	}

	@Override
	public void initialize() {

	}

	@Override
	public void execute() {
		drivetrainSubsystem.drive(
				m_xSupplier.getAsDouble(),
				m_ySupplier.getAsDouble()
		);
	}

	@Override
	public boolean isFinished() {
		// TODO: Make this return true when this Command no longer needs to run execute()
		return false;
	}

	@Override
	public void end(boolean interrupted) {

	}
}
