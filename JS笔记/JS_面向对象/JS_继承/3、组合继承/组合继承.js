/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
    3、组合继承

    组合模式就是将 （类式继承）和（构造函数继承）的一个组合


    优点：弥补了（类式继承）和（构造函数继承）的优缺点

    缺点：父类构造函数调用了俩变 消耗内存
    因为我们在使用(构造函数继承)时执行了一遍父类的构造函数，
    而在实现子类原型的(类式继承)时又调用了一遍父类的构造函数
 */

//声明父类
var index = 0;
function SuperClass(name){
    index++;
    console.log(index);
    this.name = name;
    this.books = ['heml','css','java'];
}
//父类原型共有方法
SuperClass.prototype.getName = function(){
    console.log(this.name);
};
//声明子类
function SubClass(name,time){
    SuperClass.call(this,name);

    //子类中新增共有属性
    this.time = time;
}
//类式继承 子类原型继承父类
SubClass.prototype = new SuperClass();

//子类原型方法
SubClass.prototype.getTime = function(){
    console.log(this.time);
};

//Test

var sub1 = new SubClass('jsbook',1024);
sub1.books.push('c++');
console.log(sub1.books);//(4) ["heml", "css", "java", "c++"]
sub1.getName();//jsbook
sub1.getTime();//1024
console.log(sub1 instanceof SuperClass);
var sub2 = new SubClass('cssbook',2048);
console.log(sub2.books);//(3) ["heml", "css", "java"]
sub2.getName();//cssbook
sub2.getTime();//2048