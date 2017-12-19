function Shape() {
    this.x = 0;
    this.y = 0;
}

Shape.prototype.move = function (x, y) {
    this.x += x;
    this.y += y;
    console.log('Shape moved.');
};

// ��һ��������̳и����ʵ��
function Rectangle() {
    Shape.call(this); // ���ø��๹�캯��
}
// ��һ��д��
// function Rectangle() {
//     this.base = Shape;
//     this.base();
// }

// �ڶ���������̳и����ԭ��
Rectangle.prototype = Object.create(Shape.prototype);
Rectangle.prototype.constructor = Rectangle;

var rect = new Rectangle();
rect.move(1, 1) // 'Shape moved.'

console.log(rect instanceof Rectangle)  // true
console.log(rect instanceof Shape)  // true


// ��������У�����������̳и��ࡣ��ʱֻ��Ҫ���������ļ̳У���ʱ���Բ��������д����
//
// ClassB.prototype.print = function() {
//     ClassA.prototype.print.call(this);
//     // some code
// }
// ��������У�����B��print�����ȵ��ø���A��print�������ٲ����Լ��Ĵ��롣��͵��ڼ̳��˸���A��print������