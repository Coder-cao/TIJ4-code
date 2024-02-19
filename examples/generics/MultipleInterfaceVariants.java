package generics;//: generics/MultipleInterfaceVariants.java
// {CompileTimeError} (Won't compile)

interface Payable<T> {}

class MinEmployee implements Payable<Employee> {}
//class Hourly extends Employee
//  implements Payable<Hourly> {} ///:~
