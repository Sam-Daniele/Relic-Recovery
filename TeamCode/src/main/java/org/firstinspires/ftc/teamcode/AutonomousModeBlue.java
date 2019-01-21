package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


@Autonomous(name="Autonomous Mode (Blue)")

public class AutonomousModeBlue extends LinearOpMode {

    public char RunColorSensorCode = 'N';

    HardwareMapping robot = new HardwareMapping();

    public void runOpMode() throws InterruptedException

    {
        robot.init(hardwareMap);

        waitForStart();

        robot.JewelColorDetector.enableLed(true);

        telemetry.addData("Color Number: ", robot.JewelColorDetector.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER));

        telemetry.update();

        JewelPostDown();

        while (RunColorSensorCode == 'Y' && opModeIsActive())

        {

            switch (robot.JewelColorDetector.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER))

            {

                case 3:

                {

                    SpinRightTime(-1, 300);

                    RunColorSensorCode = 'N';

                    break;

                }

                case 10:

                {

                    SpinLeftTime(-1, 300);

                    RunColorSensorCode = 'N';

                    break;

                }

            }

        }

    }

    public void DriveForward (double power)

    {

        robot.RightDriveMotor.setPower(power);
        robot.LeftDriveMotor.setPower(power);

    }

    public void DriveForwardTime(double power, long time) throws InterruptedException

    {

        DriveForward(power);
        Thread.sleep(time);

    }

    public void SpinLeft (double power)

    {

        robot.RightDriveMotor.setPower(power);

    }

    public void SpinLeftTime(double power, long time) throws InterruptedException

    {

        SpinLeft(power);
        Thread.sleep(time);

    }

    public void SpinRight (double power)

    {

        robot.LeftDriveMotor.setPower(power);

    }

    public void SpinRightTime(double power, long time) throws InterruptedException

    {

        SpinRight(power);
        Thread.sleep(time);

    }


    public void JewelPostDown ()

    {

        robot.JewelPostServo.setPosition(1);

        RunColorSensorCode = 'Y';

    }

    public void JewelPostUp ()

    {

        robot.JewelPostServo.setPosition(0);

    }

}
