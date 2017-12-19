/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
    3����ϼ̳�

    ���ģʽ���ǽ� ����ʽ�̳У��ͣ����캯���̳У���һ�����


    �ŵ㣺�ֲ��ˣ���ʽ�̳У��ͣ����캯���̳У�����ȱ��

    ȱ�㣺���๹�캯������������ �����ڴ�
    ��Ϊ������ʹ��(���캯���̳�)ʱִ����һ�鸸��Ĺ��캯����
    ����ʵ������ԭ�͵�(��ʽ�̳�)ʱ�ֵ�����һ�鸸��Ĺ��캯��
 */

//��������
var index = 0;
function SuperClass(name){
    index++;
    console.log(index);
    this.name = name;
    this.books = ['heml','css','java'];
}
//����ԭ�͹��з���
SuperClass.prototype.getName = function(){
    console.log(this.name);
};
//��������
function SubClass(name,time){
    SuperClass.call(this,name);

    //������������������
    this.time = time;
}
//��ʽ�̳� ����ԭ�ͼ̳и���
SubClass.prototype = new SuperClass();

//����ԭ�ͷ���
SubClass.prototype.getTime = function(){
    console.log(this.time);
};

//Test

var sub1 = new SubClass('jsbook',1024);
sub1.books.push('c++');
console.log(sub1.books);//(4) ["heml", "css", "java", "c++"]
sub1.getName();//jsbook
sub1.getTime();//1024
console.log(sub1 instanceof SuperClass);
var sub2 = new SubClass('cssbook',2048);
console.log(sub2.books);//(3) ["heml", "css", "java"]
sub2.getName();//cssbook
sub2.getTime();//2048