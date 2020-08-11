

$(document).click(function () {
	console.info("开始请求...")
	$.ajax( {
		type : "POST",
		url : "",
		dataType : "json",
		data : {"pin": "{“1\",\"2\",\"3\",\"4\",\"5\",\"6”}"},
		success : function(data) {
			console.info("请求成功")
			// var json = JSON.parse(data);
			console.info(data);
			console.info(data.code);
			if(data.code == 200){
				console.info("返回200")
			}else {
				console.info(data.code)
			}
		},
		error : function() {
			console.error("请求错误");
		}
	});
});
