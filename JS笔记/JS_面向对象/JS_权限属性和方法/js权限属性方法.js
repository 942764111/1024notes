/**
 * Created by QiaoBin on 2017/8/25.
 */
/*

 */
var Book = function(id){
    //私有属性
    var num = 1;
    //私有方法： 闭包函数
    function checkId(){

    }

    //特权方法
    this.getName = function(){};
    this.setName = function(){};

    //对象共有属性
    this.id = id;
    //对象共有方法
    this.copy = function(){}
    //构造器
    this.setName();

    //类静态共有属性(对象不能访问)
    Book.isChinese = true;
    //类静态共有方法(对象不能访问)
    Book.resetTime = function(){

    }

};
Book.prototype = {
    //共有属性
    isJSB : false,
    //共有方法
    dissplay : function(){console.log(this.id)}
}
new Book('2').dissplay();