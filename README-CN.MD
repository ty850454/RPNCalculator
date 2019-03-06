# 编程练习RPN计算器

世界上一些最好的计算器都有“RPN”(反向波兰符号)模式。

我们希望您编写一个基于命令行的RPN计算器。

### 需求
- 计算器有一个可以包含实数的堆栈。
- 计算器等待用户输入，并期望接收包含空格分隔的数字和操作符列表的字符串
- 数字被推入堆栈。操作符对堆栈上的数字进行操作
- 可用的操作符有+、-、*、/、sqrt、undo、clear
- 'clear'操作符从堆栈中删除所有项。
- the 'undo'操作符撤消前面的操作。'undo undo'将取消前两个操作。
- sqrt在堆栈的顶部项上执行平方根。
- 运算符“+”、“-”、“*”、“/”分别对堆栈中最上面的两项执行加、减、乘和除运算。
- 在处理输入字符串后，计算器将堆栈的内容显示为一个空格分隔列表。
- 数字应存储在堆栈中，精度至少为15位小数，但显示为10位小数(如果不造成精度损失，则小于10位)。
- 所有数字都应该格式化为普通的十进制字符串(即，没有工程格式)。
- 如果操作符无法在堆栈中找到足够数量的参数，则显示警告:操作符<操作符>(位置:<pos>):参数不足。
- 显示警告后。字符串的所有后续处理结束，并显示堆栈的当前状态

### 可交付成果
- 提交的解决方案应该包含结构、源代码、配置以及您认为必要的任何测试或测试代码——不需要打包类文件。
- 提交的解决方案应该尽可能使用idea。
- 用java、c#或指定的语言解决问题。
- 像解决“生产级”代码那样解决问题。
- 不需要提供任何图形界面。
- 将代码推送到github，完成编码后发送地址到电子邮件。
- 为了避免防火墙问题，我们建议将解决方案打包为密码保护的zip文件。



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