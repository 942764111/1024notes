/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
  4、原型式继承
  2006年 道格拉斯·克罗克福德 发表一篇《JavaScript中 原型式继承》的文章,
  他的观点是 "借助原型prototype可以根据已有的对象创建一个新对象,同时不必创建新的自定义对象类型。"

  它是对 类式继承的一个封装,其中的过滤对象就相当于类式继承中的子类,
  只不过在原型式中作为一个过滤对象出现的,目的是为了创建要返回的新的实例化对象。

  优点：这种方式由于 F 过滤类的构造函数中无内容,所以开销比较小，使用起来比较方便
  缺点：同类式继承 影响父类对象 和 其他子类
  例：
 */
//原型式继承

function SubClass(o){
    //声明一个 过度函数对象
    function F(){}
    //过度对象的原型继承父对象
    F.prototype = o;
    //返回过度对象的一个实例
    return new F();
}

//Test
var book = {
  name:'js book',
  alikeBook:['css book','html book']
};

var sub1 = SubClass(book);
sub1.name = 'ajax book';
sub1.alikeBook.push('xml book');

var sub2 = SubClass(book);
sub2.name = 'flash book';
sub2.alikeBook.push('as book');

console.log(sub1.name);//ajax book
console.log(sub1.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]

console.log(sub2.name);//flash book
console.log(sub2.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]

console.log(book.name);//js book
console.log(book.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]