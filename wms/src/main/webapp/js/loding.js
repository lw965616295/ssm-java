function load() {
	var a= setTimeout("loading.style.transition='opacity 0.3s'",0)   
	//设置透明度改变的过渡时间为0.3秒
	var b= setTimeout("loading.style.opacity=0",400)
	//0.5秒后加载动画开始变为透明
	var c= setTimeout("loading.style.display='none'",600)
	//当透明度为0的时候，隐藏掉它
}

var i = 0;
$(function(){
	
	change1();
	
});

function change1(){
	var timer2 = setInterval(function(){
		$("#text").children().remove();
	
	if(i<=90){
		i += 2;
		$(".container").css("transform","rotateY("+i+"deg)")
	}else{
		clearInterval(timer2);
		change2();
	}
	},5);
	
}
function change2(){
	var timer1 = setInterval(function(){
		$("#text").children().remove();
		if(i>=0){
			i -= 2;
			$(".container").css("transform","rotateY("+i+"deg)")
		}else{
			clearInterval(timer1);
			change1();
		}
	},5);
}

$(function(){
	var html = "<div id='loading'>" +
			"<div id='loading-center'>" +
			"<div id='loading-center-absolute'>" +
			"<div class='stage'>" +
			"<div class='container'><img src='/wms/images/zscLogo.png'/></div>" +
			"</div></div></div></div>";
	$("body").append(html)
	$("body").attr('onload','load()');
})