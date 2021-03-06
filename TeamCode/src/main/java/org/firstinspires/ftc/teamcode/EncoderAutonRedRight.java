package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.usb.RobotArmingStateNotifier;

/**
 * Created by William Goelz and Bridger Mattson for G3 Robotics (Blue).
 * Written over the course of November and December of 2017
 * Used in the Houghton FTC Qualifying round.
 * Developed in Android Studio using the FTC SDK on GitHub.
 */

@Autonomous ( name = "EncoderAutonRedRight")

//Right motor is reversed, negative direction goes left and positive goes right

public class EncoderAutonRedRight extends LinearOpMode {
    @Override

    public synchronized void waitForStart() {
        super.waitForStart();
    }

    public DcMotor right;
    public DcMotor left;
    public DcMotor rightEscalator;
    public DcMotor leftEscalator;

    public void DropGlyph() {

        leftEscalator.setPower(0.5);
        rightEscalator.setPower(-0.5);

        sleep(1000);
    }

    public void DriveBackward(float power, int rotations){

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        right.setTargetPosition(-rotations*800);
        left.setTargetPosition(rotations*800);

        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setPower(power);
        right.setPower(-power);
        while (left.isBusy() && right.isBusy()){

        }
        left.setPower(0);
        right.setPower(0);

    }
    public void Turn(float direction, int rotations){

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        right.setTargetPosition(-rotations*1440);
        left.setTargetPosition(-rotations*1440);


        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setPower(-direction);
        right.setPower(-direction);

        while (left.isBusy() && right.isBusy()) {

        }

        left.setPower(0);
        right.setPower(0);
    }
    public void DriveForward(float power, int rotations){

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);


        left.setTargetPosition(-rotations*375);
        right.setTargetPosition(rotations*375);

        left.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        right.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        left.setPower(-power);
        right.setPower(power);

        while (left.isBusy() && right.isBusy()){

        }
        left.setPower(0);
        right.setPower(0);
    }
    @Override

    public void runOpMode() throws InterruptedException {
        waitForStart();
        right = hardwareMap.dcMotor.get("rightDrive");
        left = hardwareMap.dcMotor.get("leftDrive");
        leftEscalator = hardwareMap.dcMotor.get("leftEscalator");
        rightEscalator = hardwareMap.dcMotor.get("rightEscalator");

        DriveForward(0.5f, 7);
        Turn(0.5f, -1);
        DriveForward(0.5f, 4);
        Turn(0.5f, 1);
        DriveForward(0.1f, 1);
        DropGlyph();
        DropGlyph();
        DriveBackward(0.7f, 1);

    }
}
