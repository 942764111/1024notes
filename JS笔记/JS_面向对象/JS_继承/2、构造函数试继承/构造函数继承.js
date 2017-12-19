/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
 2���������̳�----���캯���̳�

    �ŵ� ��
      1������call����������Ը��ĺ��������û���,
      �����������,��subClass��������������ǽ�������
      �ı����ڸ���Ĺ��캯����ִ��һ��,���ڸ������Ǹ�this�����Ե�,
      ���������ȻҲ�ͼ̳��˸���Ĺ������ԡ�
        ���Ը��෽������

      2�������޸ĸ���Ĺ��з�������Ӱ�쵽��������
      (��Ϊ����call����������Ը��ĺ��������û���,
        �����������,��subClass��������������ǽ�������
        �ı����ڸ���Ĺ��캯����ִ��һ��,)

    ȱ�� ��
      1�������������͵ļ̳�û���漰��ԭ��prototype��
      ���Ը����ԭ�ͷ�����Ȼ���ᱻ����̳�,
      �����Ҫ�뱻����̳о�û��Ҫ���ڹ��캯���У�
      ��������������ÿ��ʵ�����ᵥ��ӵ��һ�ݣ�
      �����ܹ��ã�������Υ���˴��븴�õ�ԭ��
 ����
 */
//��������
function SuperClass(id){
    //�������͹�������
    this.books = ['java','html','css'];
    this.id = id;
}
//��������ԭ�ͷ���
SuperClass.prototype.showBooks = function(){
        console.log(this.books);
};
//��������
function SubClass(id){
    //�̳и���
    SuperClass.call(this,id);
}
//������һ�������ʵ��
var sub1 = new SubClass(10);
var sub2 = new SubClass(11);
sub1.books.push('���ģʽ');
console.log(sub1.books);//(4) ["java", "html", "css", "���ģʽ"]
console.log(sub1.id);//10
console.log(sub2.books);//(3) ["java", "html", "css"]
console.log(sub2.id);//11

sub1.showBooks();//  Uncaught TypeError: sub1.showBooks is not a function