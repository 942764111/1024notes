/**
 * Created by QiaoBin on 2017/8/24.
 */
/*
    多继承
 */

var  book1 = {
    name:'book1',
    books:['html','css']
};
var  book2 = {
    book2name:'book2',
    book2books:['html','css','flash']
};

var subObj = {
    color:'blue'
};

Object.prototype.mixaa = function(){
  var i= 0,
      len = arguments.length,
      arg;
    //遍历被继承的对象
    for(;i<len;i++){
        //缓存当前对象
        arg = arguments[i];
        //遍历父类对象
        for(var obj in arg){
            //将父类的属性复制到子类身上
            this[obj] = arg[obj];
        }
    }
};


subObj.mixaa(book1,book2);
console.log(subObj);

