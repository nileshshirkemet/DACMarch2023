class Investment {

	//method declared with static modifier can be called directly
	//on the class using . operator
	public static double futureValue(double installment, int years, boolean risk) {
		float i = risk ? 0.11f : 0.06f;
		return (installment / i) * (Math.pow(1 + i, years) - 1);
	}

}

