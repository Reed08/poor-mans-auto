package org.firstinspires.ftc.teamcode.Lincoln;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous
public class PoorMansAuto extends LinearOpMode {
    // TODO: Change power as necessary
    private final double power = 0.6;

    // TODO: Change time delay for robot
    private final int timeDelay = 2;

    private DcMotorEx FL, BL, FR, BR;
    private ElapsedTime timer;

    @Override
    public void runOpMode() throws InterruptedException {
        // Hardware maps
        // TODO: Change hardware maps for robot
        FL = hardwareMap.get(DcMotorEx.class, "Motor FL");
        BL = hardwareMap.get(DcMotorEx.class, "Motor BL");
        FR = hardwareMap.get(DcMotorEx.class, "Motor FR");
        BR = hardwareMap.get(DcMotorEx.class, "Motor BR");

        // Reversals
        // TODO: Change reversals for robot
        FL.setDirection(DcMotorSimple.Direction.REVERSE);
        BL.setDirection(DcMotorSimple.Direction.REVERSE);
//        FR.setDirection(DcMotorSimple.Direction.REVERSE);
//        BR.setDirection(DcMotorSimple.Direction.REVERSE);

        waitForStart();

        timer = new ElapsedTime();

        // Initial motor powers
        FL.setPower(power);
        BL.setPower(power);
        FR.setPower(power);
        BR.setPower(power);

        // Turn off motors after delay
        while (timer.seconds() < timeDelay) {
            telemetry.addLine("Waiting");
            telemetry.update();
        }

        FL.setPower(0);
        BL.setPower(0);
        FR.setPower(0);
        BR.setPower(0);
    }
}
