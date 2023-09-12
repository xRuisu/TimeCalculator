package application.timecalculator;

public class TimeCalculator extends ProgramController {

	public static void main(String[] args) {

		var tc = new TimeCalculator();
		tc.onEnable();
	}

	@Override
	void onEnable() {
		System.out.println("[ v ]>: Simple Time Addition Calculator :<[ v ]");
		System.out.flush();
		var calculator = new Calc();
		calculator.calculate();
	}

	//If needed in any updates or application expansions.
	@Override
	void onDisable() {}
}
