/**
 * Created by QiaoBin on 2017/8/24.
 */
/*
    简单的工厂模式：又叫静态工厂方法,由一个工厂对象决定创建某一种产品对象的实例！主要用来创建同一类对象

    例：
 */
//test1   通过类实例化对象
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

//test2   创建新对象然后包装增强属性
function createPop(type,text){
    //创建一个对象,并对对象拓展属性和方法
    var obj = new Object();
    o.content = text;
    o.show = function(){
        //显示方法
    }
    if(type == '1'){
//差异一
    }
    if(type == '2'){
//差异二
    }
    if(type == '3'){
//差异三
    }
    return obj;
}
var poptest = createPop('1','asdasdasdasds');