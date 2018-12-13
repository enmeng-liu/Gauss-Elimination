# Gauss-Elimination

+ A java project for qlz's Linear Algebra
+ Collaborators: @NJUBrocoli @RosalieMiao
+ 一个极其虐待用户的项目
+ 一份极其丢人的文档
+ <s>妈妈再也不用担心我的线代作业算不对了呢</s>用个P还不如手算
+ 仍有很多bug等待被发现
+ 有生之年可能会拥有GUI

## 使用说明

+ 由于时间有限，目前只有<s>全是bug的</s>命令行形态
+ 因为是CSer的产物，所以行和列都是**从0开始**计数的！！！<s>其实只是我们懒得调整</s>
+ 分为手动模式和自动模式，开始时命令会有提示，按0进入手动模式，1进入自动模式
+ 自动模式按照确定的步骤输出中间过程，每步有操作信息输出
+ 为了个人消元习惯与自动模式的算法不同，增加了手动模式，按照命令行提示选择操作和输入参数，可以进行按照个人习惯对矩阵进行可逆变换
+ 目前只支持有理数运算

## 目前支持的功能

+ 普通矩阵的高斯消元
+ 解线性方程组时带右端项的增广矩阵的高斯消元
+ 与单位阵合并求逆矩阵的高斯消元(右侧单位阵需自行输入)

## To do list

+ 判断行梯阵和约化行梯阵的方法有bug，暂时用不到所以没有debug
+ 求行列式功能【这个为什么不调MATLAB呢
+ 想要一个Web端的GUI
+ 即使只有命令行形态也想稍微用户友好一丢丢

## 丢人的代码解读

### 分数类 Fraction

@author RosalieMiao

属性

+ `public int numerator`分子
+ `public int denominator` 分母

方法

+ `public Fraction(String inp)`  字符串构造函数
+ `public Fraction(int a, int b)` 整数构造函数
+ `private void reduct()` 将该分数约分
+ `public Fraction add(Fraction b)` 分数相加
+ `public Fraction mul(Fraction b)` 分数乘
+ `public Fraction div(Fraction b)` 分数除
+ `public boolean isZero()` 判断该分数是否为0
+ `public boolean isOne()` 判断该分数是否为1
+ `public String toString()` 

### 矩阵类 Matrix

@author NJUBrocoli

代码里写得很清楚了可以直接RTFSC

### 高斯消元类 GaussElimination

@author mengzelev

方法
+ `public static void autoGauss(Matrix A)` 自动高斯消元

### Main

@author RosalieMiao

+ `public static void main(String[] args)` 