

//======================================第一种创建Buffer方式====================================================
/*
			需要给定内存字节的大小
			Buffer.alloc
			Buffer.allocUnsafe
			allocUnsafeSlow
*/

// (1)给定一个大小
// (2)会给这些内存一个初值，如果你没有指定，那么这个初值就是0；
				// var buf = Buffer.alloc(10, 0xff);
				// console.log(buf);


// (1) 给定分配一个给定大小的Buffer的内存
// (2) 不会对这些内存区赋初值的,随机的数据，它原来是什么就是什么；
// Unsafe 指的是没有初始化的内存
				// buf = Buffer.allocUnsafe(10);
				// console.log(buf);


// 不重Buffer缓冲区里面分配，直接从操作系统分配
// Slow指的是没有重缓冲池里面高效的分配
// Unsafe, 指的是内存，没有被初始化  
//不会对这些内存区赋初值的,随机的数据
				// var  buf = Buffer.allocUnsafeSlow(10);
				// // console.log(buf);


// // 获得我们的bufer对象的长度
// // Buffer一旦分配，大小再也不能改变。
			   // console.log(buf.length);




//======================================第二种创建Buffer方式====================================================
/*
					Buffer.from(array); 
					Buffer.from(buf); 
					Buffer.from(string);
					
					
*/
// 方便的创建方式，复制
// 创建一个Buffer对象，用来存放这个字符串的二进制  
//	存放着对应的ascii码 : 16进制
			// buf = Buffer.from("Helloworld!");
			// console.log(buf);



			// buf = Buffer.from([123, 22, 24, 36, 47, -1]);
			// console.log(buf);




// 重新创建一个Buffer,然后把原来Buffer的数据拷贝给新的Buffer
			// var buf2 = Buffer.from(buf);
			// console.log(buf2);



// buf[index] index [0, len - 1];
			// console.log(buf[0], buf[1]);	



//======================================常用的Buffer方法====================================================
	/*
		writeInt32BE 以大尾的形式存放 4个字节的整数

		writeInt32LE 以小尾的形式存放 4个字节的整数

		writeFloatLE 以小尾的形式存放 4个字节的小数

		readInt32LE  以小尾的形式读取 4个字节的整数

		 Buffer.byteLength  //获取字节长度

		 swap32  大尾 小尾 切换   如果 writeInt32BE 默认是 大尾    swap32  则取反


		 fill	用来填充 buf 的值。
	*/


// 以大尾的形式存放 4个字节的整数
// 0x00 00 ff ff --->655535
// 00 00 ff ff
// start从哪里开始

//默认是以小尾存放

//如果对应数据的高字节存放在低地址就是大尾
		// var buf = Buffer.alloc(10);
		// buf.writeInt32BE(65535, 0);
		// console.log(buf);


// 以小尾的形式存放 4个字节的整数
		// buf.writeInt32LE(65535, 0);
		// console.log(buf);

//以小尾的形式读取 4个字节的整数
		// var value = buf.readInt32LE(0);
		// console.log(value);

////获取字节长度
		// var len = Buffer.byteLength("HelloWorld");
		// console.log(len);

		// len = Buffer.byteLength(buf2);
		// console.log(len);



// swap32  取反

// 4个字节的Int为例 4 * 4 = 16;
// 0, 1, 2, 3,| 4, 5, 6, 7, |8, 9, 10, 11, |12, 13, 14, 15
			buf = Buffer.alloc(4 * 4);
			buf.writeInt32BE(65535, 0);
			buf.writeInt32LE(65535, 4);
			buf.writeInt32LE(65535, 8);
			buf.writeInt32LE(65535, 12);
			// console.log(buf);
//大尾小尾数据变化   小尾 变 大尾   取反
			//buf.swap32();
// 3, 2, 1, 0,| 7, 6, 5, 4, |11, 10, 9, 8, |15, 14, 13, 12
			// console.log(buf);

			// console.log(buf.readInt32BE(0));
			// console.log(buf.readInt32BE(4));
			// console.log(buf.readInt32BE(8));
			// console.log(buf.readInt32BE(12));





//遍历buf里面的每个字节;
			// for(var v of buf.values()) {
			// 	console.log(v);
			// }

  
//buf转字符串   指定一个输出的编码   如果buf的值是int类型  那么 buf只能以  hex(二进制)输出   否则 utf8输出会出现乱码
			console.log(buf.toString('utf8'));
// "0000ffff0000ffff0000ffff0000ffff"
 			console.log(buf.toString('hex'));

//转为json格式
			 console.log(buf.toJSON());


//	fill用来填充 buf 的值。
//如果是 字符类型 就可以指定以 utf8 输出
			 buf.fill('a');
			 console.log(buf);
			 console.log(buf.toString('utf8'));

			 buf.fill("hello",0,5);
			console.log(buf);
			console.log(buf.toString('utf8'));