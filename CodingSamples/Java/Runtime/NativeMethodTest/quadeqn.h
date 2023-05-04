#pragma once

namespace Algebra
{
	class QuadraticEquation
	{
	public:
		QuadraticEquation(double, double);

		bool Solve(double&, double&) const;
	private:
		double p, q;
	};
}


