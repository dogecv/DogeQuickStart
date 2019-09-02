package org.firstinspires.ftc.teamcode.dogecommander;

import com.disnodeteam.dogecommander.DogeCommander;
import com.disnodeteam.dogecommander.DogeOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.dogecommander.bot.commands.DriveForTime;
import org.firstinspires.ftc.teamcode.dogecommander.bot.commands.RunIntakeForTime;
import org.firstinspires.ftc.teamcode.dogecommander.bot.subsystems.Drive;
import org.firstinspires.ftc.teamcode.dogecommander.bot.subsystems.Intake;

@Autonomous(group = "DogeCommander")
public class CommanderAutonomousExample extends LinearOpMode implements DogeOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        DogeCommander commander = new DogeCommander(this);

        Drive drive = new Drive(hardwareMap);
        Intake intake = new Intake(hardwareMap);

        commander.registerSubsystem(drive);
        commander.registerSubsystem(intake);
        commander.init();

        waitForStart();

        commander.runCommandsParallel(
                new DriveForTime(drive, 3, 0.5),
                new RunIntakeForTime(intake, 1, Intake.State.INTAKE)
        );

        commander.runCommand(new RunIntakeForTime(intake, 2, Intake.State.SPIT_OUT));
        commander.runCommand(new DriveForTime(drive, 1, 0.5));

        commander.stop();
    }
}
