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
    <title>乐鲜Mall商城 | 首页</title>
    <link rel="stylesheet" type="text/css" href="${basePath }frontend/css/style-cart.css">
    <link rel="stylesheet" type="text/css" href="${basePath }frontend/css/css-cart.css"/>
    <script type="text/javascript" src="${basePath }frontend/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript">
        function setIframeHeight(iframe) {
            if (iframe) {
                var iframeWin = iframe.contentWindow || iframe.contentDocument.parentWindow;
                if (iframeWin.document.body) {
                    iframe.height = iframeWin.document.documentElement.scrollHeight || iframeWin.document.body.scrollHeight;
                }
            }
        };
        window.onload = function () {
            setIframeHeight(document.getElementById('mainframe'));
        };
    </script>
</head>
<body>

<!--顶端头部-->
<div id="top">
    <div id="top_main">
        <ul class="topu">
            <li>
                <div class="xing">
                </div>
                <a href="#">待定。。。</a>
            </li>
        </ul>
        <div id="hello">
					<span>您好，欢迎来到&nbsp;&nbsp;乐鲜Mall商城！
			<a href="${basePath }frontend/login.jsp" target="mainframe">[登陆]</a>&nbsp;<a href="${basePath }frontend/register.jsp" target="mainframe">[免费注册]</a>
			</span>
        </div>
        <div class="topright">
            <ul>
                <li>
                    <div class="cun">
                        <a href="${basePath}order/oneuserlist.do" target="mainframe">我的订单</a>
                    </div>
                </li>
                <li class="kefu">
                    <div class="cun">
                        <div class="a1">
                            <div class="kefuhide">
                                <span>客户服务</span>
                                <div class="downjian1">
                                </div>
                                <ul>
                                    <li><a href="#">帮助中心</a></li>
                                    <li><a href="#">售后服务</a></li>
                                    <li><a href="#">在线客服</a></li>
                                    <li><a href="#">投诉中心</a></li>
                                    <li><a href="#">客服邮箱</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </li>
                <li class="wangzhan">
                    <div class="cun">
                        <span>网站导航</span>
                        <div class="downjian1">
                        </div>
                    </div>
                    <div class="wangzhanhide">
                        <div class="tese">
                            <span>特色栏目</span>
                        </div>
                        <div class="tesemain">
                            <a href="#">商城通信</a>
                            <a href="#">校园之星</a>
                            <a href="#">视频购物</a>
                            <a href="#">商城社区</a>
                            <a href="#">在线读书</a>
                            <a href="#">装机大师</a>
                            <a href="#">商城E卡　</a>
                            <a href="#">家装城</a>
                            <a href="#">搭配购　</a>
                            <a href="#">我喜欢　</a>
                            <a href="#">游戏社区</a>
                        </div>
                        <div class="tese">
                            <span>企业服务</span>
                        </div>
                        <div class="tesemain1">
                            <a href="#">企业采购</a>
                            <a href="#">办公直通车</a>
                        </div>
                        <div class="tese">
                            <span>旗下网站</span>
                        </div>
                        <div class="tesemain2">
                            <a href="#">English Site</a>
                        </div>
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>

<!-- 搜索区域开始 -->
<div id="serach">
    <div class="logo">
        <a href="${basePath }frontend/index.jsp" target="mainframe">
            <img src="${basePath }frontend/images/logo.png" alt=""/></a>
        <div class="dongtu">
        </div>
    </div>
    <div class="sou">
        <div class="sousuo">
            <input type="text" class="kuang" placeholder="请输入搜索条件" style="color:#999;font-size:14px"/>
            <div class="souzi">
                <a href="#">搜索</a>
            </div>
        </div>
        <div class="reci">
            <span>热门搜索:</span>
            <a href="#" style="color:red">校园之星</a>
            <a href="#">影院到家</a>
            <a href="#">JD制暖节</a>
            <a href="#">腕表领券</a>
            <a href="#">自营满减</a>
            <a href="#">N3抢购</a>
            <a href="#">图书换购</a>
            <a href="#">12.12</a>
        </div>
    </div>
    <div class="myjd">
        <div class="mytu">
        </div>
        <a href="${basePath }frontend/user_center.jsp" target="mainframe">我的商城</a>
        <div class="jiantou">
        </div>
        <div class="myjdhide">
            <div class="hello">
                <span>您好，请</span>
                <a href="${basePath }frontend/login.jsp" target="mainframe">登录</a>
            </div>
            <div class="hey">
                <div class="heyleft">
                    <ul>
                        <li><a href="#">待处理订单</a></li>
                        <li><a href="#">咨询回复</a></li>
                        <li><a href="#">降价商品</a></li>
                        <li><a href="#">返修退换货</a></li>
                        <li><a href="#">优惠券</a></li>
                    </ul>
                </div>
                <div class="heyright">
                    <ul>
                        <li><a href="#">我的关注></a></li>
                        <li><a href="#">我的京豆></a></li>
                        <li><a href="#">我的理财></a></li>
                        <li><a href="#">我的白条></a></li>
                    </ul>
                </div>
            </div>
            <div class="hidebot">
                <div class="bottop">
                    <span>最近浏览的商品:</span>
                    <a href="#">查看浏览历史></a>
                </div>
                <div class="botdown">
                    <span>「暂无数据」</span>
                </div>
            </div>
        </div>
    </div>
    <div class="gouwuche">
        <div class="chetu">
        </div>
        <a href="${basePath }shoppingcart/usercartlist.do" target="mainframe">去购物车结算</a>
        <div class="jianleft">
        </div>
        <div class="num">
            <div class="numright">
            </div>
            <div class="numzi">
                <span>0</span>
            </div>
        </div>
        <div class="hideche">
            <div class="kongche">
            </div>
            <span>购物车中还没有商品，赶紧选购吧！</span>
        </div>
    </div>
    <div class="jubao">
    </div>
</div>

<iframe src="${basePath }frontend/index.jsp" width="100%" height="1200px" id="mainframe" name="mainframe"></iframe>

<!-- 底部开始 -->
<div id="down">
    <div class="down_top">
        <a href="#">关于我们</a>
        <a href="#">联系我们</a>
        <a href="#">商家入驻</a>
        <a href="#">营销中心</a>
        <a href="#">手机商城</a>
        <a href="#">友情链接</a>
        <a href="#">销售联盟</a>
        <a href="#">商城社区</a>
        <a href="#">商城公益</a>
        <a href="#" style="border-right:none">English Site</a>
    </div>
    <div class="down_center">
        <span>北京市公安局朝阳分局备案编号110105014669  |  京ICP证070359号  |  <a href="#">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>  |  新出发京零 字第大120007号</span>
        <span><a href="#">音像制品经营许可证苏宿批005号</a>  |  出版物经营许可证编号新出发(苏)批字第N-012号  |  互联网出版许可证编号新出网证(京)字150号</span>
        <span><a href="#">网络文化经营许可证京网文[2011]0168-061号</a>  违法和不良信息举报电话：4006561155  Copyright (c) 2004-2014  商城JD.com 版权所有</span>
        <span>商城旗下网站：<a href="#">360TOP</a><a href="#">拍拍网</a><a href="#">网银在线</a></span>
    </div>
    <div class="down_bot">
        <img src="${basePath }frontend/images/bot1.gif" alt=""/>
        <img src="${basePath }frontend/images/bot2.gif" alt=""/>
        <img src="${basePath }frontend/images/bot3.png" alt=""/>
        <img src="${basePath }frontend/images/bot4.png" alt=""/>
    </div>
</div>
<!-- 底部结束 -->

</body>
</html>