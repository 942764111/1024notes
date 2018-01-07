// 将net模块 引入进来
var net = require("net");

// 创建一个net.Server用来监听,当连接进来的时候，就会调用我们的函数
// client_sock,就是我们的与客户端通讯建立连接配对的socket
// client_sock 就是与客户端通讯的net.Socket
var server = net.createServer(function(client_sock) { 
	console.log("client comming", client_sock.remoteAddress, client_sock.remotePort);
	// 设置你接受的格式, 
	// client_sock.setEncoding("utf8");
	// client_sock.setEncoding("hex"); // 转成二进制的文本编码
	// 
	// 客户端断开连接的时候处理,用户断线离开了
	client_sock.on("close", function() {
		console.log("close socket");
	});

	// 接收到客户端的数据，调用这个函数
	// data 默认是Buffer对象，如果你强制设置为utf8,那么底层会先转换成utf8的字符串，传给你
	// hex 底层会把这个Buffer对象转成二进制字符串传给你
	// 如果你没有设置任何编码 <Buffer 48 65 6c 6c 6f 57 6f 72 6c 64 21>
	// utf8 --> HelloWorld!!!   hex--> "48656c6c6f576f726c6421"
	client_sock.on("data", function(data) {
		console.log(data);

		client_sock.write("goodbye!!!");

		client_sock.end(); // 正常关闭
	});




/*
	如果node.js没有要处理的事件了，那整个就结束了;
	事件里面可以继续插入事件，
	如果有事件是一直要继续下去的，
	那么node 也就不会退出了,
	每一次事件处理结束后等待下一个事件的发生。

 所以：
*/
	//  当我们发生了一个未知的异常的时候，我们调用这个回掉函数;
	// node 停止处理当前这个事件，继续等待下一个事件的处理，不会整个退出，
	// 服务器就不会随意的奔溃
	// 可以把这个错误，保存起来，方便我们去查找
	//如果异常本次循环socket会正常退出 进入 close  事件回调

//方法一：
	client_sock.on("error", function(err) {
		console.log("error", err);
	});

//方法二：
	
	process.on("uncaughtException", function(err) {
		console.log("uncaughtException called ", err);
	});

});


// 当我开始监听的时候就会调用这个回掉函数
server.on("listening", function() {
	console.log("start listening...");
});


// 监听发生错误的时候调用
server.on("error", function() {
	console.log("listen error");
});

server.on("close", function() {
	console.log("server stop listener");
});
/*
server.on("connection", function(client_sock) {
	console.log("client comming 22222");
});
*/
// 编写代码，指示这个server监听到哪个端口上面。
// 127.0.0.1: 6080
// node就会来监听我们的server,等待连接接入
server.listen({
	port: 6080,
	host: "127.0.0.1",
	exclusive: true,
});

// 停止node对server的监听事件处理，那么node就没有其他的事件要处理，所以就退出了。
// server.unref(); // 取消node,对server的事件的监听；
// server.close(); // 主动的掉这个server.close才会触发这个net.Server的close事件



