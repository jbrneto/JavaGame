package Interface;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;


public class RobotMouse {

	public static void main(String[] args) {

		try {
			
			 
			
			Robot robot = new Robot();
			

			for (int x = 0; x < 500; x=x+10) {

				robot.mouseMove(x, 200);

				try {
					Thread.sleep(60);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			// SCROLL THE MOUSE WHEEL
			robot.mouseWheel(-100);

			// MIDDLE WHEEL CLICK
			robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
			robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

			// RIGHT CLICK
			robot.mousePress(InputEvent.BUTTON3_MASK);
			robot.mouseRelease(InputEvent.BUTTON3_MASK);

			// LEFT CLICK
			robot.mousePress(InputEvent.BUTTON1_MASK);
			robot.mouseRelease(InputEvent.BUTTON1_MASK);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
