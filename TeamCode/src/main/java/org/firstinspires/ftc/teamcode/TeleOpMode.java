package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="TeleOp Mode")
public class TeleOpMode extends OpMode {

    HardwareMapping robot = new HardwareMapping();

    public void init()

    {

        robot.init(hardwareMap);

    }

    public void loop()

    {
        double left = gamepad1.left_stick_y;
        double right = gamepad1.right_stick_y;

        robot.LeftDriveMotor.setPower(left);
        robot.RightDriveMotor.setPower(right);

        robot.JewelPostServo.setPosition(0);

        robot.JewelColorDetector.enableLed(true);

        telemetry.addData("Color Number: ", robot.JewelColorDetector.readUnsignedByte(ModernRoboticsI2cColorSensor.Register.COLOR_NUMBER));

        telemetry.update();

        if (gamepad2.a)

        {

            robot.LiftMotor.setPower(1);

        }

        else if (gamepad2.b)

        {

            robot.LiftMotor.setPower(-1);

        }

        else

        {

            robot.LiftMotor.setPower(0);

        }

        if (gamepad2.x)

        {

            robot.LeftDrawbridgeCRServo.setPower(1);
            robot.RightDrawbridgeCRServo.setPower(1);

        }

        else if (gamepad2.y)

        {

            robot.LeftDrawbridgeCRServo.setPower(-1);
            robot.RightDrawbridgeCRServo.setPower(-1);


        }

        else

        {

            robot.LeftDrawbridgeCRServo.setPower(0);
            robot.RightDrawbridgeCRServo.setPower(0);

        }

         */

    }

    public void stop()

    {

        robot.LeftDriveMotor.setPower(0);
        robot.RightDriveMotor.setPower(0);

        robot.LiftMotor.setPower(0);

        robot.LeftDrawbridgeCRServo.setPower(0);
        robot.RightDrawbridgeCRServo.setPower(0);

    }

}
