# Gauss-Elimination
A java project for qlz's Linear Algebra
一份极其丢人的需求文档

# 分数类 Fraction

## 属性

+ `int numerator`分子
+ `int denominator` 分母

## 方法

+ `void reduct()` 将该分数约分
+ `Fraction add()` 分数相加
+ `void mul(Fraction b)` 分数乘
+ `void div(Fraction b)` 分数除
+ `bool isZero()` 判断该分数是否为0

# 矩阵类 Matrix

##属性

+ `int m` 行数
+ `int n` 列数
+ `Vector <Vector <Integer>> elements = new Vector<>()` 元素
+ `int extend_n` 增广阵列数

## 方法

+ `void exchangeTwoRows()` 交换某两行
+ `void addOneRowToAnother(int src, int dst, Fraction cof)` 将第src行乘上cof加给第dst行
+ `void oneRowMul()` 将某行乘以一个非零系数
+ `String toString()`  输出矩阵
+ `bool isEchelon()` 判断是否为行梯阵
+ `bool isReducedEchelon()` 判断是否为约化行梯阵
+ `void changePivotToOne(int i)` 将行主元化为1  
+ `Fraction getElement(int i, int j)` 返回某个位置的元素
+ `int findPivot(int row)` 返回第row行的主元的列指标，不存在主元则返回-1
# 高斯消元类 GaussElimination

## 方法

+ 
