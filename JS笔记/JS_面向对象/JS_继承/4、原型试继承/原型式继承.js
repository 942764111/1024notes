/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
  4��ԭ��ʽ�̳�
  2006�� ������˹�����޿˸��� ����һƪ��JavaScript�� ԭ��ʽ�̳С�������,
  ���Ĺ۵��� "����ԭ��prototype���Ը������еĶ��󴴽�һ���¶���,ͬʱ���ش����µ��Զ���������͡�"

  ���Ƕ� ��ʽ�̳е�һ����װ,���еĹ��˶�����൱����ʽ�̳��е�����,
  ֻ������ԭ��ʽ����Ϊһ�����˶�����ֵ�,Ŀ����Ϊ�˴���Ҫ���ص��µ�ʵ��������

  �ŵ㣺���ַ�ʽ���� F ������Ĺ��캯����������,���Կ����Ƚ�С��ʹ�������ȽϷ���
  ȱ�㣺ͬ��ʽ�̳� Ӱ�츸����� �� ��������
  ����
 */
//ԭ��ʽ�̳�

function SubClass(o){
    //����һ�� ���Ⱥ�������
    function F(){}
    //���ȶ����ԭ�ͼ̳и�����
    F.prototype = o;
    //���ع��ȶ����һ��ʵ��
    return new F();
}

//Test
var book = {
  name:'js book',
  alikeBook:['css book','html book']
};

var sub1 = SubClass(book);
sub1.name = 'ajax book';
sub1.alikeBook.push('xml book');

var sub2 = SubClass(book);
sub2.name = 'flash book';
sub2.alikeBook.push('as book');

console.log(sub1.name);//ajax book
console.log(sub1.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]

console.log(sub2.name);//flash book
console.log(sub2.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]

console.log(book.name);//js book
console.log(book.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]