/**
 * Created by QiaoBin on 2017/8/24.
 */
/*
    ��̳�
 */

var  book1 = {
    name:'book1',
    books:['html','css']
};
var  book2 = {
    book2name:'book2',
    book2books:['html','css','flash']
};

var subObj = {
    color:'blue'
};

Object.prototype.mixaa = function(){
  var i= 0,
      len = arguments.length,
      arg;
    //�������̳еĶ���
    for(;i<len;i++){
        //���浱ǰ����
        arg = arguments[i];
        //�����������
        for(var obj in arg){
            //����������Ը��Ƶ���������
            this[obj] = arg[obj];
        }
    }
};


subObj.mixaa(book1,book2);
console.log(subObj);

