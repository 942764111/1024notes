/**
 * Created by QiaoBin on 2017/8/22.
 */
/*
* 1����ʽ�̳�
*
* ����
* */
function SuperClass(){
   this.superValue = true;
}
//Ϊ������ӹ��з���
SuperClass.prototype.getSuperValue = function(){
   return this.superValue;
}

//��������
function SubClass(){
   this.subValue = false;
}
//�̳и���
SubClass.prototype = new SuperClass();
//Ϊ������ӹ��з���
SubClass.prototype.getSubValue = function(){
   return this.subValue;
};
//Test
var sub = new SubClass();
console.log(sub);

/*��ʽ�̳е�ȱ�㣺
   1����������ͨ����ԭ��prototype�Ը���ʵ�������̳��˸��࣬
   ����˵�����й�������Ҫ����������,�ͻ��������б�����ʵ�����ã�
   ���һ�����ʵ����������ԭ�ʹӸ��๹�캯���м̳����Ĺ�������
   �ͻ�ֱ��Ӱ�쵽�������ࡣ
      ����
         function SuperClass(){
         this.books = ['Java','html','css'];
         }
         function SubClass(){}
         SubClass.prototype = new SuperClass();
         var  sub1 = new SubClass();
         var  sub2 = new SubClass();
         console.log(sub2.books);
         sub1.books.push('���ģʽ');
         console.log(sub2.books);

   2����������ʵ�ֵļ̳��ǿ���ԭ�� prototype �Ը����ʵ����ʵ�ֵ�,���
   �ڴ��������ʱ�����޷����ഫ�ݲ�����,�����ʵ���������ʱ��Ҳ�޷���
   ����Ĺ��캯���ڵ����Խ��г�ʼ����

   �ŵ㣺ʵ�ּ̳�

 */




