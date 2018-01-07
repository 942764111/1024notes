var net = require("net");

// net.Socket,
var sock = net.connect({
	port: 6080,
	host: "127.0.0.1",
}, function(a) {
	a.setEncoding('utf8');
	console.log('connected to server!');
});

// 连接成功调用的事件
sock.on("connect",function() {
	console.log("connect success");


	// 在这里我们就可以发送数据了
	/*
		这里的步揍是：
			（1：将你传的 "HelloWorld!"	数据设置编码为 "utf8"
			（2：sock.write 默认以Buffer二进制编码传输
	*/
	sock.write("HelloWorld!", "utf8");
	// end 
});
// end

// 有错误发生调用的事件
sock.on("error", function(e) {
	console.log("error", e);
});

// socket关闭的事件
sock.on("close", function() {
	console.log("close");
});

// 对方发送了关闭数据包过来的事件
sock.on("end", function() {
	console.log("end event");
});

// 当有数据发生的时候，调用;
sock.on("data", function(data) {
	console.log(data);
});