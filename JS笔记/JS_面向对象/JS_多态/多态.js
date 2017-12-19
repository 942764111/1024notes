/**
 * Created by QiaoBin on 2017/8/24.
 */
/*
多态：同一种方法多种不同的调用
    通过对传递的参数判断来决定执行逻辑,即实现一种多态处理机制。
 例：
 */

function Add(){
    //无参算法
    function zero(){
        return 10;
    }
    //一个参数算法
    function one(num){
        return 10+num;
    }
    //俩个参数算法
    function two(num1,num2){
        return num1+num2;
    }

    //相加共有方法
    this.add = function(){
        var arg = arguments,
            len = arguments.length;
        switch (len){
            case 0://如果没有参数
                return zero();
            case 1:
                return one(arg[0]);
            case 2:
                return two(arg[0],arg[1])
        }
    };
}
var A = new Add(2);
console.log(A.add());
console.log(A.add(5));
console.log(A.add(6,7));