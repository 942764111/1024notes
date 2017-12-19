/**
 * Created by jorbeen on 2017/8/30.
 */
/*/
    抽象工厂模式
    例:
 */

var VehicleFactory = function (SubType,SuperType) {
    //判断抽象工厂中是否有该抽象类
    if(typeof VehicleFactory[SuperType] === 'function'){
        //缓存类
        function F() {

        }
        //继承父类属性和方法
        F.prototype = new VehicleFactory[SuperType]();

        //将子类 constructor(构造器) 指向子类
        SubType.constructor = SubType;
        //子类原型继承 父类
        SubType.prototype = new F();

    }else{
        //不存在抽象类抛出错误
        throw new Error('未创建该抽奖类');
    }
}

//小汽车抽象类
VehicleFactory.Car = function () {
    this.type = 'Car'
}
VehicleFactory.Car.prototype = {
    getPrice : function () {
        return new Error('抽象方法不能调用')
    },
    getSpeed : function () {
        return new Error('抽象方法不能调用')
    }

}

var BMW = function (price,speed) {
    this.price = price;
    this.speed = speed;
}
//抽象工厂实现对Car抽象类的继承
VehicleFactory(BMW,'Car');

BMW.prototype.getPrice = function () {
    return this.price;
}

BMW.prototype.getSpeed = function () {
    return this.speed;
}


//TEST
var ss = new BMW("Hello","World");
console.log(ss.getPrice());
console.log(ss.getSpeed());
