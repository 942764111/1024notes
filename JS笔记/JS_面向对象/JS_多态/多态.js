/**
 * Created by QiaoBin on 2017/8/24.
 */
/*
��̬��ͬһ�ַ������ֲ�ͬ�ĵ���
    ͨ���Դ��ݵĲ����ж�������ִ���߼�,��ʵ��һ�ֶ�̬������ơ�
 ����
 */

function Add(){
    //�޲��㷨
    function zero(){
        return 10;
    }
    //һ�������㷨
    function one(num){
        return 10+num;
    }
    //���������㷨
    function two(num1,num2){
        return num1+num2;
    }

    //��ӹ��з���
    this.add = function(){
        var arg = arguments,
            len = arguments.length;
        switch (len){
            case 0://���û�в���
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