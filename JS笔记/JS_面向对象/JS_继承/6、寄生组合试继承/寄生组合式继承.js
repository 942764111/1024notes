/**
 * Created by QiaoBin on 2017/8/23.
 */
/*
 4、寄生组合式继承
 例：

 优点：弥补了（组合继承）的缺点
 缺点：比较麻烦
 */
//原型式继承
function inheritObject(o){
    //声明一个 过度函数对象
    function F(){}
    //过度对象的原型继承父对象
    F.prototype = o;
    //返回过度对象的一个实例
    return new F();
}
/**
 * 寄生式继承 继承原型
 * @param subClass
 * @param SuperClass
 */
function inheritPrototype(subClass,SuperClass){
    //复制一份父类的原型副本保存在变量中
    var p = inheritObject(SuperClass.prototype);
    console.log(p);
    //修正因为重写子类原型导致子类的构造函数属性被修改
    p.constructor = subClass;
    console.log(p);
    //设置子类原型
    subClass.prototype = p;
}
//Test
//定义父类
var index = 0;
function SuperClass(name){
    index++;
    console.log(index);
    this.name = name;
    this.colors = ['red','blue','green'];
}
//定义父类原型方法
SuperClass.prototype.getName = function(){
    console.log(this.name);
};

//定义子类
function SubClass(name,time){
    //构造函数式继承
    SuperClass.call(this,name);
    //子类新增属性
    this.time = time;
}

//寄生式继承父类原型
 inheritPrototype(SubClass,SuperClass);

SubClass.prototype.getTime = function(){
    console.log(this.time);
};

//Test
var sub1 = new SubClass('js book',1024);
var sub2 = new SubClass('css book',2048);

sub1.colors.push('black');
console.log(sub1.colors);
console.log(sub2.colors);
sub1.getTime();
sub2.getTime();
