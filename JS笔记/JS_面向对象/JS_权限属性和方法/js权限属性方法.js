/**
 * Created by QiaoBin on 2017/8/25.
 */
/*

 */
var Book = function(id){
    //˽������
    var num = 1;
    //˽�з����� �հ�����
    function checkId(){

    }

    //��Ȩ����
    this.getName = function(){};
    this.setName = function(){};

    //����������
    this.id = id;
    //�����з���
    this.copy = function(){}
    //������
    this.setName();

    //�ྲ̬��������(�����ܷ���)
    Book.isChinese = true;
    //�ྲ̬���з���(�����ܷ���)
    Book.resetTime = function(){

    }

};
Book.prototype = {
    //��������
    isJSB : false,
    //���з���
    dissplay : function(){console.log(this.id)}
}
new Book('2').dissplay();