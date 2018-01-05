console.log("HelloWorld");

// 计时器事件, 每隔一段事件触发一次, time的单位是毫秒
/*setInterval(function  () {
	console.log("get time doing");
}, 5 * 1000); // 每间隔5秒调用一次*/

// 插入一个事件，让它多长时间以后执行一次
setTimeout(function() {
	console.log("set time out");
}, 3 * 1000);

// process是node的一个全局模块
console.log(process.pid);
console.log(process.version);
console.log(process.platform);
console.log(process.title);
console.log(process.argv); // 在启动的时候，我们可以往程序里面传入参数,参数都是字符串

var argc = process.argv.length;
if (argc >= 3) {
	console.log(process.argv[2]);
}


console.log(process.execPath); // node所在的路径
console.log(process.env); // 获得系统的环境变量

// 当我们的node在每次退出的时候，都会抛出一个exit这样一个事件，如果我们用户监听这个事件，那么
// 当有exit事件发生的时候，我们之前设置的回掉函数，将会倍调用；
// process.on来监听事件
process.on("exit", function() {
	console.log("now node exit!!!!");
});

//  当我们发生了一个未知的异常的时候，我们调用这个回掉函数;
// node 停止处理当前这个事件，继续等待下一个事件的处理，不会整个退出，
// 服务器就不会随意的奔溃
// 可以把这个错误，保存起来，方便我们去查找
process.on("uncaughtException", function(err) {
	console.log("uncaughtException called ", err);
});
// 当我们的程序，如果运行的时候有异常，那么这个时候，我们可以通过捕获异常，
// 如果说我们没有捕获的异常，这个uncaughtException
// 如果发生uncaughtException，node是会退出的;
// 没有主动捕获，所以javascript解释器，他是不会继续执行的;
// current work director 当前的工作目录
// ./ ---> C:\Home\workspace\node_js
// process.chdir("C:\\Home\\workspace"); // 修改我们的工作目录，工作目录默认你的node是在哪个目录下启动的，就是那个目录为你的工作目录
console.log(process.cwd());

// while处理时间，进入等待时间之前调用，完成后，去事件里面来等待新的事件发生；
process.nextTick(function() {
	console.log("nextTick");
});

// 

notfunction_test();

console.log("after notfunction_test");




