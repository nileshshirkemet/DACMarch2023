//A namespace provides a named-scope for related types to
//avoid collision between the names of these types and 
//other types not belonging to their scope. A type T that 
//belongs to a namespace N is referenced from outside of N 
//using its qualified name of N.T
namespace Payroll
{
    //user-defined reference type
    class Employee
    {
        private int hours;
        private float rate;

        //parameterized constructor
        public Employee(int h, float r)
        {
            hours = h;
            rate = r;
        }

        //parameterless constructor
        public Employee() : this(0, 40)
        {
        }

        //Property is a member which exposes a value of
        //a specified type and provides field-like syntax
        //for reading/writing this value through implicit
        //invocation of its get/set block
        public int Hours
        {
            get
            {
                return hours;
            }

            set
            {
                hours = value;
            }
        }

        public float Rate
        {
            get { return rate; }
            set { rate = value; }
        }

        //a method declare with 'virtual' keyword can
        //be overridden in the derived class
        public virtual double Income()
        {
            double amount = hours * rate;
            int ot = hours - 180;
            if(ot > 0)
                amount += 50 * ot;
            return amount;
        }
    }
}