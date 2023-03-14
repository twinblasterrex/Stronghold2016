// Copyright (c) FIRST and other WPILib contributors.

// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.limitSwitchSubsystem;

public class RobotContainer {

	public final XboxController xboxController;
	public final DrivetrainSubsystem m_drivetrain;
	public final IntakeSubsystem m_intake;
	public final limitSwitchSubsystem limitswitch;

	public RobotContainer() {
		limitswitch = new limitSwitchSubsystem();
		xboxController = new XboxController(0);
		m_drivetrain = new DrivetrainSubsystem();
		m_intake = new IntakeSubsystem();
//
//        m_drivetrain.setDefaultCommand(
//                new DeffultDriveCommand(
//                        m_drivetrain,
//                        () -> -xboxController.getRawAxis(1),
//                        () -> xboxController.getRawAxis(4)
//                )
//        );
		// Configure the trigger bindings
		configureBindings();
	}


	/**
	 * Use this method to define your trigger->command mappings.
	 */
	private void configureBindings() {
		new Trigger(() -> xboxController.getRawButton(2)).whileTrue(
				new StartEndCommand(
						() -> m_intake.run(.8),
						() -> m_intake.run(0),
						m_intake
				)
		);

		new Trigger(() -> xboxController.getAButton()).whileTrue(
				new StartEndCommand(
						() -> m_intake.run(-.60),
						() -> m_intake.run(0),
						m_intake
				)
		);

		new Trigger(() -> xboxController.getYButton()).onTrue(new InstantCommand(() -> m_intake.out()));
		new Trigger(() -> xboxController.getXButton()).onTrue(new InstantCommand(() -> m_intake.in()));


	}


	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		// TODO: Implement properly
		return null;
	}
}
