/**
 * Created by QiaoBin on 2017/8/24.
 */
/*
    �򵥵Ĺ���ģʽ���ֽо�̬��������,��һ�����������������ĳһ�ֲ�Ʒ�����ʵ������Ҫ��������ͬһ�����

    ����
 */
//test1   ͨ����ʵ��������
var Test = function(name){
    switch (name){
        case '1':
            return new test1();
            break;
        case '2':
            return new test2();
            break;
        case '3':
            return new test3();
            break;
    }
};

//test2   �����¶���Ȼ���װ��ǿ����
function createPop(type,text){
    //����һ������,���Զ�����չ���Ժͷ���
    var obj = new Object();
    o.content = text;
    o.show = function(){
        //��ʾ����
    }
    if(type == '1'){
//����һ
    }
    if(type == '2'){
//�����
    }
    if(type == '3'){
//������
    }
    return obj;
}
var poptest = createPop('1','asdasdasdasds');