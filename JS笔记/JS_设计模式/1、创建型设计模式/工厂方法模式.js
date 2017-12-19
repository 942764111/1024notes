/**
 * Created by QiaoBin on 2017/8/25.
 */
/*
工厂方法模式：
    通过对产品类的抽象使其创建业务主要负责用于创建多类产品的实例

    例：
 */

//安全模式创建工具类
var Factory = function(type,content){
    if(this instanceof  Factory){
        var s = new this[type](content);
        return s;
    }else{
        return new Factory(type,content);
    }
};
//工厂原型中设置创建所有类型数据对象的基类

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