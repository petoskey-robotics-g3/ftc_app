package org.firstinspires.ftc.teamcode;
        import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
        import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
        import com.qualcomm.robotcore.hardware.ColorSensor;
        import com.qualcomm.robotcore.hardware.DcMotor;
        import com.qualcomm.robotcore.hardware.Servo;
        import com.qualcomm.robotcore.hardware.usb.RobotArmingStateNotifier;

/**
 * Created by Bridger for G3 Robotics (Blue).
 * Written over the course of September, October, and November of 2017
 * Used in the Houghton FTC Qualifying round.
 * Developed in Android Studio using the FTC SDK on GitHub.
 */

@Autonomous ( name = "ColorSensorPractice")

//Right motor is reversed, negative direction goes left and positive goes right

public class ColorSensorPractice extends LinearOpMode {
    @Override

    public synchronized void waitForStart() {
        super.waitForStart();
    }

    public DcMotor right;
    public DcMotor left;
    public DcMotor rightEscalator;
    public DcMotor leftEscalator;
    ColorSensor colorSensor;
    Servo leftServo, rightServo;
    Servo leftServo2, rightServo2;

    public void DropGlyph() {

        leftEscalator.setPower(0.5);
        rightEscalator.setPower(-0.5);

        sleep(1000);
    }

    public void DriveBackward(float power, int rotations){

        left.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        right.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        right.setTargetPosition(-rotations*900);
        left.setTargetPosition(rotations*900);

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


        left.setTargetPosition(-rotations*750);
        right.setTargetPosition(rotations*750);

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

        right = hardwareMap.dcMotor.get("rightDrive");
        left = hardwareMap.dcMotor.get("leftDrive");
    //Servo up and down
        rightServo = hardwareMap.servo.get("rightServo");
        leftServo = hardwareMap.servo.get("leftServo");
    //Servo clasp
        rightServo2 = hardwareMap.servo.get("rightServo2");
        leftServo2 = hardwareMap.servo.get("rightServo2");

        leftEscalator = hardwareMap.dcMotor.get("leftEscalator");
        rightEscalator = hardwareMap.dcMotor.get("rightEscalator");
        colorSensor = hardwareMap.colorSensor.get("colorSensor");
        colorSensor.enableLed(true);
    //Servos
        rightServo.setDirection(Servo.Direction.FORWARD);
        rightServo.setPosition(0.5);
        rightServo.setDirection(Servo.Direction.REVERSE);
        rightServo.setPosition(0.5);

        leftServo.setDirection(Servo.Direction.FORWARD);
        leftServo.setPosition(0.5);
        leftServo.setDirection(Servo.Direction.REVERSE);
        leftServo.setPosition(0.5);
    // Servo Clasp
        rightServo2.setDirection(Servo.Direction.FORWARD);
        rightServo2.setPosition(0.5);
        rightServo2.setDirection(Servo.Direction.REVERSE);
        rightServo2.setPosition(0.5);

        leftServo2.setDirection(Servo.Direction.FORWARD);
        leftServo2.setPosition(0.5);
        leftServo2.setDirection(Servo.Direction.REVERSE);
        leftServo2.setPosition(0.5);



        // send the info back to driver station using telemetry function.
        telemetry.addData("LED", true ? "On" : "Off");
        telemetry.addData("Red  ", colorSensor.red());
        telemetry.addData("Blue ", colorSensor.blue());




        DriveForward(0.5f, 4);
        Turn(0.5f, 1);
        DriveForward(0.5f, 1);
        DropGlyph();
        DropGlyph();
        DriveBackward(0.7f, 1);

    }
}
