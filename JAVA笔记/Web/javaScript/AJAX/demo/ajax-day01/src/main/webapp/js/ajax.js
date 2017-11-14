function $(id){
	return document.getElementById(id);
}

function $F(id){
	return $(id).value;
}

function getXhr(){
	var xhr = null;
	if(window.XMLHttpRequest){
		//非ie浏览器
		xhr = new XMLHttpRequest();
	}else{
		xhr = new ActiveXObject(
				'MicroSoft.XMLHttp');
	}
	return xhr;
} 