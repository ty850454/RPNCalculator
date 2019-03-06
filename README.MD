
[中文](blob/master/README-CN.MD)

# programming exercise RPN calculator

some of the best calculators in the world have an 'RPN' (reverse polish notation) mode.
we would like you to write a command-line based RPN calculator.


### requirements
- the calculator has a stack that can contain real numbers.
- the calculator waits for user input and expects to receive strings containing whiitespace separated lists of numbers and operators
- numbers are pushed on to the stack. operators operate on numbers that are on the stack
- availavble operators are +,-,*,/,sqrt,undo,clear
- the 'clear' operator removes all items from the stack.
- the 'undo' operator undoes the previous operation. 'undo undo' will unfo the previous two operations.
- sqrt performs a square root on the top item from the stack.
- The '+', '-', '*', '/' operators perform addotion, subtraction, multipliplication and division respectively on the top two items from the stack.
- after processing an input string, the calculator displays the contents of the stack as a space-asparate list.
- numbers should be stored on the stack to at least 15 decimal places of precision, but displayed to 10 decimal places (or less if cause no loss of precision).
- all numbers should be formatted as plain decimal strings (ie, no engineering formatting).
- if an operator cannot find a sufficient number of parameters on the stack, a warning is displayed: operator <operator> (position: <pos>): insufficient parameters.
- after displaying the warning. all further processing of the string terminates and the current state of the stack is displayed

### deliverables
- the solution submitted should indude structure,source code, configuration and any tests or test code you deem necessary - no need to package class files.
- the solution submitted should use idea as possable as you can.
- solve the problem in java, C# or in a specific language that you may have been directed to use.
- solve the problem as though it were "production level" code.
- it is not required to provide any graphical inter face.
- push code to github and send adress to email when you finished coding.
- in order to get around firewall issues we recommend the solution be packaged as a password protected zip file.

### examples

#### examples 1
    5 2
    stack: 5 2

#### examples 2
    2 sqrt
    stack: 1.4142135623
    clear 9 sqrt
    stack: 3

#### example 3
    5 2 -
    stack: 3
    3 -
    stack: 0
    clear
    stack:

#### example 4
    5 4 3 2
    stack: 5 4 3 2
    undo undo *
    stack: 20
    5 *
    stack: 100
    undo
    stack: 20 5

#### example 5
    7 12 2 /
    stack: 7 6
    *
    stack: 42
    4 /
    stack: 10.5

#### example 6
    1 2 3 4 5
    stack: 1 2 3 4 5
    *
    stack: 1 2 3 20
    clear 3 4 -
    stack: -1

#### example 7
    1 2 3 4 5
    stack: 1 2 3 4 5
    * * * *
    stack: 120

#### example 8
    1 2 3 * 5 + * * 6 5
    operator * (opsition: 15): insufficlent parameters stack: 11
    (the 6 and 5 were not pushed on to the stack due to the previous error)
