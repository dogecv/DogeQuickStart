package org.firstinspires.ftc.teamcode.dogecommander;

import com.disnodeteam.dogecommander.DogeCommander;
import com.disnodeteam.dogecommander.DogeOpMode;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.dogecommander.bot.commands.teleop.TeleOpDriveControl;
import org.firstinspires.ftc.teamcode.dogecommander.bot.commands.teleop.TeleOpIntakeControl;
import org.firstinspires.ftc.teamcode.dogecommander.bot.subsystems.Drive;
import org.firstinspires.ftc.teamcode.dogecommander.bot.subsystems.Intake;

@TeleOp(group = "DogeCommander")
public class CommanderTeleOpExample extends LinearOpMode implements DogeOpMode {
    @Override
    public void runOpMode() {
        DogeCommander commander = new DogeCommander(this);

        Drive drive = new Drive(hardwareMap);
        Intake intake = new Intake(hardwareMap);

        commander.registerSubsystem(drive);
        commander.registerSubsystem(intake);
        commander.init();

        waitForStart();

        commander.runCommandsParallel(
                new TeleOpDriveControl(drive, gamepad1),
                new TeleOpIntakeControl(intake, gamepad1)
        );

        commander.stop();
    }
}
