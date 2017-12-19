/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
 4、寄生式继承
    寄生式继承就是对原型继承的二次封装,
    并且在这第二次封装过程中对继承的对象进行了拓展，
    这样新创建的对象不仅仅有父类中的属性和方法而且还添加新的属性和方法

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

function createBook(obj){
    //通过原型方式创建新对象
    var o = new SubClass(obj);
    //拓展新对象
    o.getName = function(){
        console.log(this.name);
    };
    //返回拓展后的新对象
    return o;
}
//Test
var book = {
    name:'js book',
    alikeBook:['css book','html book']
};

var sub1 = createBook(book);
sub1.name = 'ajax book';
sub1.alikeBook.push('xml book');

var sub2 = createBook(book);
sub2.name = 'flash book';
sub2.alikeBook.push('as book');

console.log(sub1.getName());//ajax book
console.log(sub1.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]

console.log(sub2.getName());//flash book
console.log(sub2.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]

console.log(book.name);//js book
console.log(book.alikeBook);//(4) ["css book", "html book", "xml book", "as book"]