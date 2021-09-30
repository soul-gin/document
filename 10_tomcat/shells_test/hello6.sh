

#!/bin/bash
# 需要定义函数名
funWithReturn(){
echo "这个函数会对输入的两个数字进行相加运算..."
echo "输入第一个数字: "
read aNum
echo "输入第二个数字: "
read anotherNum
echo "两个数字分别为 $aNum 和 $anotherNum !"
return $(($aNum+$anotherNum))
} 
# 这里表示调用函数(直接写上函数名即可)
funWithReturn
# $? 表示返回上一次变量的返回值
echo "输入的两个数字之和为 $? !"


