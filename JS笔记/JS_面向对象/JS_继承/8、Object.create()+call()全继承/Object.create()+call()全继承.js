function Shape() {
    this.x = 0;
    this.y = 0;
}

Shape.prototype.move = function (x, y) {
    this.x += x;
    this.y += y;
    console.log('Shape moved.');
};

// 第一步，子类继承父类的实例
function Rectangle() {
    Shape.call(this); // 调用父类构造函数
}
// 另一种写法
// function Rectangle() {
//     this.base = Shape;
//     this.base();
// }

// 第二步，子类继承父类的原型
Rectangle.prototype = Object.create(Shape.prototype);
Rectangle.prototype.constructor = Rectangle;

var rect = new Rectangle();
rect.move(1, 1) // 'Shape moved.'

console.log(rect instanceof Rectangle)  // true
console.log(rect instanceof Shape)  // true


// 上面代码中，子类是整体继承父类。有时只需要单个方法的继承，这时可以采用下面的写法。
//
// ClassB.prototype.print = function() {
//     ClassA.prototype.print.call(this);
//     // some code
// }
// 上面代码中，子类B的print方法先调用父类A的print方法，再部署自己的代码。这就等于继承了父类A的print方法。