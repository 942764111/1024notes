/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
 2、创建即继承----构造函数继承

    优点 ：
      1、由于call这个方法可以更改函数的作用环境,
      因此在子类中,对subClass调用这个方法就是将子类中
      的变量在父类的构造函数中执行一遍,由于父类中是给this绑定属性的,
      因此子类自然也就继承了父类的共有属性。
        可以父类方法传参

      2、子类修改父类的共有方法不会影响到其他子类
      (因为由于call这个方法可以更改函数的作用环境,
        因此在子类中,对subClass调用这个方法就是将子类中
        的变量在父类的构造函数中执行一遍,)

    缺点 ：
      1、由于这种类型的继承没有涉及到原型prototype，
      所以父类的原型方法自然不会被子类继承,
      而如果要想被子类继承就没必要放在构造函数中，
      这样创建出来的每个实例都会单独拥有一份，
      而不能共用，这样就违背了代码复用的原则。
 例：
 */
//声明父类
function SuperClass(id){
    //引用类型共有属性
    this.books = ['java','html','css'];
    this.id = id;
}
//父类声明原型方法
SuperClass.prototype.showBooks = function(){
        console.log(this.books);
};
//声明子类
function SubClass(id){
    //继承父类
    SuperClass.call(this,id);
}
//创建第一个子类的实例
var sub1 = new SubClass(10);
var sub2 = new SubClass(11);
sub1.books.push('设计模式');
console.log(sub1.books);//(4) ["java", "html", "css", "设计模式"]
console.log(sub1.id);//10
console.log(sub2.books);//(3) ["java", "html", "css"]
console.log(sub2.id);//11

sub1.showBooks();//  Uncaught TypeError: sub1.showBooks is not a function