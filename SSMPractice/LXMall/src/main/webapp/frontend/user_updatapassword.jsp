<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	session.setAttribute("basePath",basePath);
%>
<!doctype html>
<html>
<head>
    <base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>乐鲜Mall商城 | 个人账户</title>
    <!--[if IE]>
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie7.css">
<![endif]-->
    <link rel="stylesheet" type="text/css" href="${basePath }frontend/css/jiazaitoubu.css">
    <link rel="stylesheet" type="text/css" href="${basePath }frontend/css/css.css">
    <script src="${basePath }frontend/js/jquery-1.8.3.min.js"></script>
    <script src="${basePath }frontend/js/index2.js"></script>
    <link rel="stylesheet" type="text/css" href="${basePath }frontend/css/center.css">
    <!--城市联动-->
    <link rel="stylesheet" type="text/css" href="${basePath }frontend/city/city.css">
    <script src="${basePath }frontend/city/Popt.js"></script>
    <script src="${basePath }frontend/city/cityJson.js"></script>
    <script src="${basePath }frontend/city/citySet.js"></script>

    <link rel="shortcut icon" href="${basePath }frontend/images/web_title.png">
    <link href="${basePath }frontend/css/bootstrap.css" rel="stylesheet" type="text/css" media="all"/>
    <!--theme-style-->
    <link href="${basePath }frontend/css/style.css" rel="stylesheet" type="text/css" media="all"/>
    <!--//theme-style-->
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script type="application/x-javascript"> addEventListener("load", function () {
        setTimeout(hideURLbar, 0);
    }, false);
    function hideURLbar() {
        window.scrollTo(0, 1);
    } </script>
    <!--fonts-->
    <!--<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>-->
    <!--//fonts-->
    <script src="${basePath }frontend/js/jquery.min.js"></script>
    <!--script-->
</head>
<body>
<script>
    window.onload = function () {
        $(".aside").css({display: "none"})
        $(".important").mouseenter(function () {
            $(".aside").css({display: "block"})
        }).mouseleave(function () {
            $(".aside").css({display: "none"})
        })
    }
</script>
<!--当前位置-->
<div class="now_positionm">
    <span>当前位置：</span><a href="${basePath }frontend/index.jsp">首页></a><a href="#">个人账户</a>
</div>
<!--centers-->
<div class="centers_m">
    <!--清除浮动-->
    <div class="clear_sm"></div>
    <!--left-->
    <div class="centers_ml">
        <!--头像-->
        <div class="center_header">
            <a href="#"><img src="${basePath }frontend/images/66f625e1ecfd7ad8244efabaa744aa73.png"/></a>
            <em>您好，<font>user</font></em>
        </div>
        <!--列表go-->
        <div class="centers_listm">
            <div class="centers_listm_one">
                <img src="${basePath }frontend/images/zshy.png"/>
                <em>会员中心</em>
            </div>
            <!--一条开始-->
            <div class="centers_listm_one_in">
                <img src="${basePath }frontend/images/shezhi.png"/>
                <em>资料管理</em>
                <b></b>
            </div>
            <span class="gjszmdm">
                <a href="${basePath }frontend/user_center.jsp" class="center_in_self"><font>信息资料</font></a>
            </span>
            <!--一条开始-->
            <div class="centers_listm_one_in">
                <img src="${basePath }frontend/images/ddgl.png"/>
                <em>订单管理</em>
                <b></b>
            </div>
            <span class="gjszmdm">
                <a href="${basePath }frontend/user_orderlist.jsp" class="center_in_self"><font>我的订单</font></a>
                <a href="#" class="center_in_self"><font>评价订单</font></a>
                <a href="#" class="center_in_self"><font>订单投诉</font></a>
            </span>
            <!--一条开始-->
            <div class="centers_listm_one_in">
                <img src="${basePath }frontend/images/suo.png"/>
                <em>账户安全</em>
                <b></b>
            </div>
            <span class="gjszmdm">
                <a href="${basePath }frontend/user_updatapassword.jsp" class="center_in_self"><font>修改密码</font></a>
            </span>
        </div>
        <script type="text/javascript">
            $(function () {//第一步都得写这个
                $(".centers_listm_one_in").click(function () {
                    $(this).next(".gjszmdm").slideToggle().siblings("gjszmdm").slideUp()
                });
            })
        </script>
    </div>
    <!--right-->
    <div class="centers_mr">
        <h1 class="welcom_tm">欢迎您，普通会员 <font>user</font>！您上次登录时间为 2016-10-28 14:23</h1>
        <!--一条开始-->
        <div class="public_m1">
            <div class="public_m2">登录密码修改</div>
            <!--提示信息-->
            <div class="tip_notem">
                <ul>
                    <li>1.请牢记登录密码</li>
                    <li>2.如果丢失密码，可以通过绑定的手机或邮箱找到</li>
                </ul>
            </div>
            <div class="public_m4">
                <p>
                    <em>原密码：</em>
                    <input type="text" style=" height:23px; border:1px solid #eaeaea; width:140px">
                </p>
                <p>
                    <em>新的密码：</em>
                    <input type="text" style=" height:23px; border:1px solid #eaeaea; width:140px">
                </p>
                <p>
                    <em>确认密码：</em>
                    <input type="text" style=" height:23px; border:1px solid #eaeaea; width:140px">
                </p>
                <a href="#" class="public_m3">确认修改</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>    
            
                    
          
	   	
                
            
            
            			  
    
           
       	
				     
             		
            
           
        
    			 
        	
       
            
            
            
            
    	
                         
       
                                                     
                            
					      
                
        
       	
					     
           
            
             
        	
					
            
            
                
                           
                

        
                
                        
                
                
                    	
               
             
                 
                
                
                
                
                
            
                  
        
    	
    
			

                
    
