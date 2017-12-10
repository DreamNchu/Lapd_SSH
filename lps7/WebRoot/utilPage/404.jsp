<%@ page language="java"  pageEncoding="UTF-8"%>
<%
StringBuffer basePath = request.getRequestURL();

%>
<!DOCTYPE html>
<html>
<head lang="en">
  	<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>404</title>
<link href="css/404.css" rel="stylesheet" type="text/css" />
<script src="bower_components/jquery/dist/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		var h = $(window).height();
		$('body').height(h);
		$('.mianBox').height(h);
		centerWindow(".tipInfo");
	});

	//2.将盒子方法放入这个方，方便法统一调用
	function centerWindow(a) {
		center(a);
		//自适应窗口
		$(window).bind('scroll resize',
				function() {
					center(a);
				});
	}

	//1.居中方法，传入需要剧中的标签
	function center(a) {
		var wWidth = $(window).width();
		var wHeight = $(window).height();
		var boxWidth = $(a).width();
		var boxHeight = $(a).height();
		var scrollTop = $(window).scrollTop();
		var scrollLeft = $(window).scrollLeft();
		var top = scrollTop + (wHeight - boxHeight) / 2;
		var left = scrollLeft + (wWidth - boxWidth) / 2;
		$(a).css({
			"top": top,
			"left": left
		});
	}
</script>
</head>
<body>
<div class="mianBox">
	<img src="image/yun0.png" alt="" class="yun yun0" />
	<img src="image/yun1.png" alt="" class="yun yun1" />
	<img src="image/yun2.png" alt="" class="yun yun2" />
	<img src="image/bird.png" alt="" class="bird" />
	<img src="image/san.png" alt="" class="san" />
	<div class="tipInfo">
		<div class="in">
			<div class="textThis">
				<h2>出错啦404！</h2>
			</div>
		</div>
	</div>
</div>

</body>
</html>
