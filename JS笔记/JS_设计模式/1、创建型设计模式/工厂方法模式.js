/**
 * Created by QiaoBin on 2017/8/25.
 */
/*
��������ģʽ��
    ͨ���Բ�Ʒ��ĳ���ʹ�䴴��ҵ����Ҫ�������ڴ��������Ʒ��ʵ��

    ����
 */

//��ȫģʽ����������
var Factory = function(type,content){
    if(this instanceof  Factory){
        var s = new this[type](content);
        return s;
    }else{
        return new Factory(type,content);
    }
};
//����ԭ�������ô��������������ݶ���Ļ���

Factory.prototype = {
      Java : function(content){
        console.log(content)
      },
    PHP : function(content){
        console.log(content)
    },
    test : function(){
        console.log('123');
    }
};

var data = [
    {type:'Java',content:'javaasdsa'},
    {type:'PHP',content:'phpasdsa'}
];

for(var i=0;i<data.length;i++){
   var a =  new Factory(data[i].type,data[i].content);
}