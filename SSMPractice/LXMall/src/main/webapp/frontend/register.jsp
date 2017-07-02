<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath",basePath);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>乐鲜Mall商城 | 注册</title>
    <link rel="shortcut icon" href="${basePath }frontend/images/web_title.png">
    <link href="${basePath }frontend/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <link href="${basePath }frontend/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <script src="${basePath }frontend/js/jquery.min.js"></script>
   <script type="text/javascript">
    $(function() {
    	$("#id").blur("input propertychange",function(){
    		if($("#id").val()==""){
    			$('#message').html("账号不能为空");
    			$('#submit').attr('disabled',"true");
    		}else
    			$('#message').html("");
    	});
		$("#id").blur(function () {
			$.post("${basePath}user/validate.do",{id:$(this).val()},function(data){
				if(data=="该账号已存在"){
					$('#submit').attr('disabled',"true");
				}
				$('#message').html(data);
			},"json")
		});
		$("#password2").bind("input propertychange",function(){
			if($("#password1").val()==$("#password2").val()){
				$('#emessage').html("");
				$('#submit').removeAttr("disabled"); 
			}
			else
				$('#emessage').html("密码必须相同 ");
			})
	})
   </script>
</head>
<body>

<div class="container">
    <div class="register">
        <form id="registerform" name="registerform" action="${basepath }user/register.do" method="post">
            <div class="  register-top-grid">
                <h3>个人信息</h3>
                <div class="mation">
                    <span>账号<label>*</label></span> <h3 color="red" id="message">账号不能为空</h3>
                    <input type="text" name="id" id="id" placeholder="此项必填" required autofocus class="input">

                    <span>电话<label>*</label></span>
                    <input type="text" name="utelphone">
                    
                    <span>邮箱<label>*</label></span>
                    <input type="text" name="mail">

                    <span>昵称<label>*</label></span>
                    <input type="text" name="nickname">
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="  register-bottom-grid">
                <h3>登录信息</h3>
                <div class="mation">
                    <span>密码<label>*</label></span>
                    <input id="password1" type="password" placeholder="此项必填" required class="input">
                    <span>确认密码<label>*</label></span><h3 color="red" id="emessage"></h3>
                    <input id="password2" type="password" name="password" placeholder="此项必填" required class="input">
                </div>
            </div>
            <input id="submit" type="submit" value="注册" disabled="true">
                <div class="clearfix"></div>
        </form>
    </div>
    <div class="sub-cate">
        <div class=" top-nav rsidebar span_1_of_left">
            <h3 class="cate">类别</h3>
            <ul class="menu">
                <li class="item1"><a href="#">生鲜水果<img class="arrow-img" src="images/arrow1.png" alt=""/>
                </a>
                    <ul class="cute">
                        <li class="subitem1"><a href="product.html">新鲜蔬菜 </a></li>
                        <li class="subitem2"><a href="product.html">新鲜水果</a></li>
                        <li class="subitem3"><a href="product.html">新鲜水产 </a></li>
                        <li class="subitem4"><a href="product.html">肉类 </a></li>
                    </ul>
                </li>
                <li class="item2"><a href="#">零&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;食<img class="arrow-img"
                                                                                         src="images/arrow1.png"
                                                                                         alt=""/></a>
                    <ul class="cute">
                        <li class="subitem1"><a href="product.html">进口食品 </a></li>
                        <li class="subitem2"><a href="product.html">休闲零食</a></li>

                    </ul>
                </li>
                <li class="item3"><a href="#">茶&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;酒<img class="arrow-img"
                                                                                         src="images/arrow1.png"
                                                                                         alt=""/> </a>
                    <ul class="cute">
                        <li class="subitem1"><a href="product.html">酒类 </a></li>
                        <li class="subitem2"><a href="product.html">茶叶 </a></li>
                        <li class="subitem3"><a href="product.html">乳品冲饮</a></li>
                    </ul>
                </li>

                <ul class="kid-menu ">
                    <li class="menu-kid-left"><a href="contact.html">联系我们</a></li>
                </ul>

            </ul>
        </div>
        <!--initiate accordion-->
        <script type="text/javascript">
            $(function () {
                var menu_ul = $('.menu > li > ul'),
                    menu_a = $('.menu > li > a');
                menu_ul.hide();
                menu_a.click(function (e) {
                    e.preventDefault();
                    if (!$(this).hasClass('active')) {
                        menu_a.removeClass('active');
                        menu_ul.filter(':visible').slideUp('normal');
                        $(this).addClass('active').next().stop(true, true).slideDown('normal');
                    } else {
                        $(this).removeClass('active');
                        $(this).next().stop(true, true).slideUp('normal');
                    }
                });
            });
        </script>
        <div class=" chain-grid menu-chain">
            <a href="single.html"><img class="img-responsive chain" src="images/chengzi.jpg" alt=" "/></a>
            <div class="grid-chain-bottom chain-watch">
                <span class="actual dolor-left-grid">30元</span>
                <span class="reducedfrom">50元</span>
                <h6><a href="single.html">刘二橙子</a></h6>
            </div>
        </div>
        <a class="view-all all-product" href="product.html">查看所有商品<span> </span></a>
    </div>
    <div class="clearfix"></div>
</div>
</body>
</html>