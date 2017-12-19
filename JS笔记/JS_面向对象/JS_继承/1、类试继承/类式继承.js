/**
 * Created by QiaoBin on 2017/8/22.
 */
/*
* 1、类式继承
*
* 例：
* */
function SuperClass(){
   this.superValue = true;
}
//为父亲添加共有方法
SuperClass.prototype.getSuperValue = function(){
   return this.superValue;
}

//声明子类
function SubClass(){
   this.subValue = false;
}
//继承父类
SubClass.prototype = new SuperClass();
//为子类添加共有方法
SubClass.prototype.getSubValue = function(){
   return this.subValue;
};
//Test
var sub = new SubClass();
console.log(sub);

/*类式继承的缺点：
   1、由于子类通过其原型prototype对父类实例化，继承了父类，
   所以说父类中共有属性要是引用类型,就会在子类中被所有实例共用，
   因此一个类的实例更改子类原型从父类构造函数中继承来的共有属性
   就会直接影响到其他子类。
      例：
         function SuperClass(){
         this.books = ['Java','html','css'];
         }
         function SubClass(){}
         SubClass.prototype = new SuperClass();
         var  sub1 = new SubClass();
         var  sub2 = new SubClass();
         console.log(sub2.books);
         sub1.books.push('设计模式');
         console.log(sub2.books);

   2、由于子类实现的继承是靠其原型 prototype 对父类的实例化实现的,因此
   在创建父类的时候，是无法向父类传递参数的,因而在实例化父类的时候也无法对
   父类的构造函数内的属性进行初始化。

   优点：实现继承

 */




