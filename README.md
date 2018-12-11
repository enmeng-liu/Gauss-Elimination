# Gauss-Elimination
A java project for qlz's Linear Algebra
一份极其丢人的需求文档

# 分数类 Fraction

## 属性

+ `int numberator`分子
+ `int denominator` 分母

## 方法

+ `void reduct()` 将该分数约分
+ `Fraction add()` 分数相加
+ `void mul()` 分数乘
+ `void div()` 分数除

# 矩阵类 Matrix

##属性

+ `int m` 行数
+ `int n` 列数
+ `Vector <Vector <Integer>> elements = new Vector<>()` 元素
+ `int extend_n` 增广阵列数

## 方法

+ `void exchange()` 交换某两行
+ `void addOneRowToAnother()` 将某行乘以一个系数以后加给另一行
+ `void oneRowMul()` 将某行乘以一个非零系数
+ `String toString()`  输出矩阵
+ `bool isEchelon()` 判断是否为行梯阵
+ `bool isReducedEchelon()` 判断是否为约化行梯阵

# 高斯消元类 GaussElimination

## 方法

+ `void Main` 实现高斯消元
