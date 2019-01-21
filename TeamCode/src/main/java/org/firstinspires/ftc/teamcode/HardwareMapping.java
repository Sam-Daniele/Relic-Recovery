package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HardwareMapping

{

    public DcMotor LeftDriveMotor;
    public DcMotor RightDriveMotor;

    public DcMotor LiftMotor;

    public CRServo LeftDrawbridgeCRServo;
    public CRServo RightDrawbridgeCRServo;

    public Servo JewelPostServo;

    public ModernRoboticsI2cColorSensor JewelColorDetector;


    HardwareMap hwMap  = null;
    private ElapsedTime period  = new ElapsedTime();

    public HardwareMapping(){
    }

    public void init(HardwareMap ahwMap) {

        hwMap = ahwMap;

        LeftDriveMotor  = hwMap.get(DcMotor.class, "left_drive");
        RightDriveMotor = hwMap.get(DcMotor.class, "right_drive");

        LeftDriveMotor.setDirection(DcMotor.Direction.REVERSE);

        LiftMotor = hwMap.get(DcMotor.class, "lift_motor");

        LeftDrawbridgeCRServo = hwMap.get(CRServo.class, "left_drawbridge");
        RightDrawbridgeCRServo = hwMap.get(CRServo.class, "right_drawbridge");

        JewelPostServo = hwMap.get(Servo.class, "jewel_post");

        JewelColorDetector = hwMap.get(ModernRoboticsI2cColorSensor.class, "jewel_color_detector");

    }
}
