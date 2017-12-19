/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
 4������ʽ�̳�
    ����ʽ�̳о��Ƕ�ԭ�ͼ̳еĶ��η�װ,
    ��������ڶ��η�װ�����жԼ̳еĶ����������չ��
    �����´����Ķ��󲻽����и����е����Ժͷ������һ�����µ����Ժͷ���

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

function createBook(obj){
    //ͨ��ԭ�ͷ�ʽ�����¶���
    var o = new SubClass(obj);
    //��չ�¶���
    o.getName = function(){
        console.log(this.name);
    };
    //������չ����¶���
    return o;
}
//Test
var book = {
    name:'js book',
    alikeBook:['css book','html book']
};

var sub1 = createBook(book);
sub1.name = 'ajax book';
sub1.alikeBook.push('xml book');

var sub2 = createBook(book);
sub2.name = 'flash book';
sub2.alikeBook.push('as book');

console.log(sub1.getName());//ajax book
console.log(sub1.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]

console.log(sub2.getName());//flash book
console.log(sub2.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]

console.log(book.name);//js book
console.log(book.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]