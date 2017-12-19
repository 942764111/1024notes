/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
 4���������ʽ�̳�
 ����

 �ŵ㣺�ֲ��ˣ���ϼ̳У���ȱ��
 ȱ�㣺�Ƚ��鷳
 */
//ԭ��ʽ�̳�
function inheritObject(o){
    //����һ�� ���Ⱥ�������
    function F(){}
    //���ȶ����ԭ�ͼ̳и�����
    F.prototype = o;
    //���ع��ȶ����һ��ʵ��
    return new F();
}
/**
 * ����ʽ�̳� �̳�ԭ��
 * @param subClass
 * @param SuperClass
 */
function inheritPrototype(subClass,SuperClass){
    //����һ�ݸ����ԭ�͸��������ڱ�����
    var p = inheritObject(SuperClass.prototype);
    console.log(p);
    //������Ϊ��д����ԭ�͵�������Ĺ��캯�����Ա��޸�
    p.constructor = subClass;
    console.log(p);
    //��������ԭ��
    subClass.prototype = p;
}
//Test
//���常��
var index = 0;
function SuperClass(name){
    index++;
    console.log(index);
    this.name = name;
    this.colors = ['red','blue','green'];
}
//���常��ԭ�ͷ���
SuperClass.prototype.getName = function(){
    console.log(this.name);
};

//��������
function SubClass(name,time){
    //���캯��ʽ�̳�
    SuperClass.call(this,name);
    //������������
    this.time = time;
}

//����ʽ�̳и���ԭ��
 inheritPrototype(SubClass,SuperClass);

SubClass.prototype.getTime = function(){
    console.log(this.time);
};

//Test
var sub1 = new SubClass('js book',1024);
var sub2 = new SubClass('css book',2048);

sub1.colors.push('black');
console.log(sub1.colors);
console.log(sub2.colors);
sub1.getTime();
sub2.getTime();
