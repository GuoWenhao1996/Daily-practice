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
    <title>乐鲜Mall商城 | 商城首页</title>
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
<div class="container">
    <div class="shoes-grid">
        <a href="${basePath }frontend/single.jsp">
            <div class="wrap-in">
                <div class="wmuSlider example1 slide-grid">
                    <div class="wmuSliderWrapper">
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-matter">
                                <div class="col-md-5 banner-bag">
                                    <img class="img-responsive " src="images/chengzi.jpg" alt=" "/>
                                </div>
                                <div class="col-md-7 banner-off">
                                    <h2>打5折！</h2>
                                    <label>对所有购买者 <b>价格</b></label>
                                    <p>这是橙子，打5折真是赚大了！ </p>
                                    <span class="on-get">立即购买</span>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-matter">
                                <div class="col-md-5 banner-bag">
                                    <img class="img-responsive " src="images/pingguo.jpg" alt=" "/>
                                </div>
                                <div class="col-md-7 banner-off">
                                    <h2>打5折！</h2>
                                    <label>对所有购买者 <b>价格</b></label>
                                    <p>这是苹果，打5折真是赚大了！ </p>
                                    <span class="on-get">立即购买</span>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-matter">
                                <div class="col-md-5 banner-bag">
                                    <img class="img-responsive " src="images/ningmeng.jpg" alt=" "/>
                                </div>
                                <div class="col-md-7 banner-off">
                                    <h2>打5折！</h2>
                                    <label>FOR ALL PURCHASE <b>VALUE</b></label>
                                    <p>这是柠檬，打5折真是赚大了！ </p>
                                    <span class="on-get">立即购买</span>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </article>

                    </div>
        </a>
        <ul class="wmuSliderPagination">
            <li><a href="#" class="">0</a></li>
            <li><a href="#" class="">1</a></li>
            <li><a href="#" class="">2</a></li>
        </ul>
        <script src="${basePath }frontend/js/jquery.wmuSlider.js"></script>
        <script>
            $('.example1').wmuSlider();
        </script>
    </div>
</div>
</a>
<!---->
<div class="shoes-grid-left">
    <a href="${basePath }frontend/single.jsp">
        <div class="col-md-6 con-sed-grid">

            <div class="clearfix">
                <img class="img-responsive shoe-left" src="images/xia.jpg" alt=" "/>
            </div>
            <div class="elit-grid">
                <h4>虾</h4>
                <label>大大大大大大大大大虾！</label>
                <p>一盘大虾 </p>
                <span class="on-get">立即购买</span>
            </div>

        </div>
    </a>
    <a href="single.html">
        <div class="col-md-6 con-sed-grid sed-left-top">

            <div class="clearfix">
                <img class="img-responsive shoe-left" src="images/yangxiezi.jpg" alt=" "/>
            </div>
            <div class="elit-grid">
                <h4>羊蝎子</h4>
                <label>打折真是赚大了！</label>
                <p>一盘羊蝎子！</p>
                <span class="on-get">立即购买</span>
            </div>

        </div>
    </a>
</div>
<div class="products">
    <h5 class="latest-product">最新商品</h5>
    <a class="view-all" href="${basePath }frontend/product.jsp">查看全部<span> </span></a>
</div>
<div class="product-left">
    <div class="col-md-4 chain-grid">
        <a href="${basePath }frontend/single.jsp"><img class="img-responsive chain" src="images/quechaokafei.jpg" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="${basePath }frontend/single.jsp">咖啡</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">300元</span>
                    <span class="reducedfrom">400元</span>
                    <span class="rating">
									        <input type="radio" class="rating-input" id="rating-input-1-5"
                                                   name="rating-input-1">
									        <label for="rating-input-1-5" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-4"
                                                   name="rating-input-1">
									        <label for="rating-input-1-4" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-3"
                                                   name="rating-input-1">
									        <label for="rating-input-1-3" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-2"
                                                   name="rating-input-1">
									        <label for="rating-input-1-2" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-1"
                                                   name="rating-input-1">
									        <label for="rating-input-1-1" class="rating-star"> </label>
							    	   </span>
                </div>
                <a class="now-get get-cart" href="#">加入购物车</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-4 chain-grid">
        <a href="${basePath }single.jsp"><img class="img-responsive chain" src="images/82nianlafei.jpg" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="${basePath }single.jsp">82年拉菲</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">300元</span>
                    <span class="reducedfrom">400元</span>
                    <span class="rating">
									        <input type="radio" class="rating-input" id="rating-input-1-5"
                                                   name="rating-input-1">
									        <label for="rating-input-1-5" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-4"
                                                   name="rating-input-1">
									        <label for="rating-input-1-4" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-3"
                                                   name="rating-input-1">
									        <label for="rating-input-1-3" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-2"
                                                   name="rating-input-1">
									        <label for="rating-input-1-2" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-1"
                                                   name="rating-input-1">
									        <label for="rating-input-1-1" class="rating-star"> </label>
							    	   </span>
                </div>
                <a class="now-get get-cart" href="#">加入购物车</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-4 chain-grid grid-top-chain">
        <a href="${basePath }single.jsp"><img class="img-responsive chain" src="images/defuqiaokeli.jpg" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="single.html">德芙巧克力</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">300元</span>
                    <span class="reducedfrom">400元</span>
                    <span class="rating">
									        <input type="radio" class="rating-input" id="rating-input-1-5"
                                                   name="rating-input-1">
									        <label for="rating-input-1-5" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-4"
                                                   name="rating-input-1">
									        <label for="rating-input-1-4" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-3"
                                                   name="rating-input-1">
									        <label for="rating-input-1-3" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-2"
                                                   name="rating-input-1">
									        <label for="rating-input-1-2" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-1"
                                                   name="rating-input-1">
									        <label for="rating-input-1-1" class="rating-star"> </label>
							    	   </span>
                </div>
                <a class="now-get get-cart" href="#">加入购物车</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<div class="products">
    <h5 class="latest-product">最新产品</h5>
    <a class="view-all" href="product.html">查看全部<span> </span></a>
</div>
<div class="product-left">
    <div class="col-md-4 chain-grid">
        <a href="single.html"><img class="img-responsive chain" src="images/xilanhua.jpg" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="single.html">西兰花</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">3000元</span>
                    <span class="reducedfrom">4000元</span>
                    <span class="rating">
									        <input type="radio" class="rating-input" id="rating-input-1-5"
                                                   name="rating-input-1">
									        <label for="rating-input-1-5" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-4"
                                                   name="rating-input-1">
									        <label for="rating-input-1-4" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-3"
                                                   name="rating-input-1">
									        <label for="rating-input-1-3" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-2"
                                                   name="rating-input-1">
									        <label for="rating-input-1-2" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-1"
                                                   name="rating-input-1">
									        <label for="rating-input-1-1" class="rating-star"> </label>
							    	   </span>
                </div>
                <a class="now-get get-cart" href="#">加入购物车</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-4 chain-grid">
        <a href="single.html"><img class="img-responsive chain" src="images/daiyu.jpg" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="single.html">带鱼</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">300元</span>
                    <span class="reducedfrom">400元</span>
                    <span class="rating">
									        <input type="radio" class="rating-input" id="rating-input-1-5"
                                                   name="rating-input-1">
									        <label for="rating-input-1-5" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-4"
                                                   name="rating-input-1">
									        <label for="rating-input-1-4" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-3"
                                                   name="rating-input-1">
									        <label for="rating-input-1-3" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-2"
                                                   name="rating-input-1">
									        <label for="rating-input-1-2" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-1"
                                                   name="rating-input-1">
									        <label for="rating-input-1-1" class="rating-star"> </label>
							    	   </span>
                </div>
                <a class="now-get get-cart" href="#">加入购物车</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-4 chain-grid grid-top-chain">
        <a href="single.html"><img class="img-responsive chain" src="images/rousongbing.jpg" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="single.html">肉松饼</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">3500元</span>
                    <span class="reducedfrom">5000元</span>
                    <span class="rating">
									        <input type="radio" class="rating-input" id="rating-input-1-5"
                                                   name="rating-input-1">
									        <label for="rating-input-1-5" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-4"
                                                   name="rating-input-1">
									        <label for="rating-input-1-4" class="rating-star1"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-3"
                                                   name="rating-input-1">
									        <label for="rating-input-1-3" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-2"
                                                   name="rating-input-1">
									        <label for="rating-input-1-2" class="rating-star"> </label>
									        <input type="radio" class="rating-input" id="rating-input-1-1"
                                                   name="rating-input-1">
									        <label for="rating-input-1-1" class="rating-star"> </label>
							    	   </span>
                </div>
                <a class="now-get get-cart" href="#">加入购物车</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<div class="clearfix"></div>
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

                <li class="menu-kid-left"><a href="${basePath }frontend/contact.jsp">联系我们</a></li>
            </ul>

        </ul>
    </div>

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
        <a href="${basePath }frontend/single.jsp"><img class="img-responsive chain" src="images/chengzi.jpg" alt=" "/></a>
        <div class="grid-chain-bottom chain-watch">
            <span class="actual dolor-left-grid">30元</span>
            <span class="reducedfrom">50元</span>
            <h6><a href="${basePath }frontend/single.jsp">刘二橙子</a></h6>
        </div>
    </div>
    <a class="view-all all-product" href="${basePath }frontend/product.jsp">查看所有商品<span> </span></a>
</div>

</body>
</html>