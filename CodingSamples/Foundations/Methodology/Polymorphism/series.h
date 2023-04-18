/*
 A namespace is a named scope containing symbols (classes, functions, ...)
 grouped together to avoid collision between their names and names of
 other symbols not belonging to their group. A member M declared in 
 namespace N must be referenced using its qualified name N::M outside of N.
*/
namespace Series
{
	class Sequence
	{
	public:
		//A pure virtual function is an overridable member function
		//which is defined without any specific implementation by
		//its class. A class which defines at least one pure virtual
		//function is called an abstract data type (ADT) because it
		//does not support instantiation but it can be used as a
		//pointer/reference type to address an instance of its derived
		//class which has overridden its pure virtual functions.
		virtual double Next() = 0;
	};

	class Resetable
	{
	public:
		virtual void Reset() = 0;
	};

	class LinearSequence : public Sequence
	{
	public:
		LinearSequence(double, double);
		double Next();
	private:
		double current;
		double step;
	};

	//Multiple Inheritance (MI) allows one class to be derived
	//directly from more than one base classes
	class ExponentialSequence : public Sequence, public Resetable
	{
	public:
		ExponentialSequence(double);
		double Next();
		void Reset();
	private:
		double current;
		double base;
	};

	class FibonacciSequence : public Sequence, public Resetable
	{
	public:
		FibonacciSequence();
		double Next();
		void Reset();
	private:
		long first;
		long second;
	};
}

