/**
 * Created by jorbeen on 2017/8/30.
 */
/*/
    ���󹤳�ģʽ
    ��:
 */

var VehicleFactory = function (SubType,SuperType) {
    //�жϳ��󹤳����Ƿ��иó�����
    if(typeof VehicleFactory[SuperType] === 'function'){
        //������
        function F() {

        }
        //�̳и������Ժͷ���
        F.prototype = new VehicleFactory[SuperType]();

        //������ constructor(������) ָ������
        SubType.constructor = SubType;
        //����ԭ�ͼ̳� ����
        SubType.prototype = new F();

    }else{
        //�����ڳ������׳�����
        throw new Error('δ�����ó齱��');
    }
}

//С����������
VehicleFactory.Car = function () {
    this.type = 'Car'
}
VehicleFactory.Car.prototype = {
    getPrice : function () {
        return new Error('���󷽷����ܵ���')
    },
    getSpeed : function () {
        return new Error('���󷽷����ܵ���')
    }

}

var BMW = function (price,speed) {
    this.price = price;
    this.speed = speed;
}
//���󹤳�ʵ�ֶ�Car������ļ̳�
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
