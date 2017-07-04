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
    <link rel="shortcut icon" href="${basePath}frontend/images/30-30.ico"/>
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
    <script src="${basePath }frontend/js/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="shoes-grid">
        <a href="${basePath }goods/idlist.do?gnumber=${goodstype1[0].gnumber}">
            <div class="wrap-in">
                <div class="wmuSlider example1 slide-grid">
                    <div class="wmuSliderWrapper">
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-matter">
                                <div class="col-md-5 banner-bag">
                                    <img class="img-responsive " src="${goodstype1[0].url}"  alt=" "/>
                                </div>
                                <div class="col-md-7 banner-off">
                                    <h2>打5折！</h2>
                                    <label>限时特价<b>${goodstype1[0].gprice}</b></label>
                                    <p>${goodstype1[0].gsort} </p>
                                    <a class="on-get" href="${basePath }goods/idlist.do?gnumber=${goodstype1[0].gnumber}">立即抢购</a>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-matter">
                                <div class="col-md-5 banner-bag">
                                    <img class="img-responsive" src="${goodstype2[0].url}" alt=" "/>
                                </div>
                                <div class="col-md-7 banner-off">
                                    <h2>打5折！</h2>
                                    <label>限时特价 <b>${goodstype2[0].gprice}</b></label>
                                    <p>${goodstype2[0].gsort}</p>
                                    <a class="on-get" href="${basePath }goods/idlist.do?gnumber=${goodstype2[0].gnumber}">立即抢购</a>
                                </div>

                                <div class="clearfix"></div>
                            </div>

                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-matter">
                                <div class="col-md-5 banner-bag">
                                    <img class="img-responsive" src="${goodstype3[0].url}" alt=" "/>
                                </div>
                                <div class="col-md-7 banner-off">
                                    <h2>打5折！</h2>
                                    <label>限时特价<b>${goodstype3[0].gprice}</b></label>
                                    <p>${goodstype3[0].gsort}</p>
                                    <a class="on-get" href="${basePath }goods/idlist.do?gnumber=${goodstype3[0].gnumber}">立即抢购</a>
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
<div class="products">
    <h5 class="latest-product">新鲜水果最新商品</h5>
    <a class="view-all" href="${basePath }goods/list.do?gsort=新鲜水果">查看全部<span> </span></a>
</div>
<div class="shoes-grid-left">
    <a href="${basePath }goods/idlist.do?gnumber=${goodstype1[0].gnumber}">
        <div class="col-md-6 con-sed-grid">

            <div class="clearfix">
                <img class="img-responsive shoe-left" src="${goodstype1[0].url}" alt=" "/>
            </div>
            <div class="elit-grid">
                <h4>${goodstype1[0].gname}</h4>
                <label>${goodstype1[0].gstatus}</label>
                <p>${goodstype1[0].gsort} </p>
                <span class="on-get">立即购买</span>
            </div>

        </div>
    </a>
    <a href="${basePath }goods/idlist.do?gnumber=${goodstype1[1].gnumber}">
        <div class="col-md-6 con-sed-grid sed-left-top">

            <div class="clearfix">
                <img class="img-responsive shoe-left" src="${goodstype1[1].url}" alt=" "/>
            </div>
            <div class="elit-grid">
                <h4>${goodstype1[1].gname}</h4>
                <label>${goodstype1[1].gstatus}</label>
                <p>${goodstype1[1].gsort} </p>
                <span class="on-get">立即购买</span>
            </div>

        </div>
    </a>
</div>
<div class="products">
    <h5 class="latest-product">休闲零食最新商品</h5>
    <a class="view-all" href="${basePath }goods/list.do?gsort=休闲零食">查看全部<span> </span></a>
</div>
<div class="product-left">
    <div class="col-md-4 chain-grid">
        <a href="${basePath }goods/idlist.do?gnumber=${goodstype2[0].gnumber}">
        <img class="img-responsive chain" src="${goodstype2[0].url}" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="${basePath }goods/idlist.do?gnumber=${goodstype2[0].gnumber}">${goodstype2[0].gname}</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">${goodstype2[0].gprice}元</span>
                    <span class="reducedfrom">1${goodstype2[0].gprice}元</span>
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
                <a class="now-get get-cart" href="${basePath }goods/idlist.do?gnumber=${goodstype2[0].gnumber}">立即抢购</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-4 chain-grid">
        <a href="${basePath }goods/idlist.do?gnumber=${goodstype2[1].gnumber}">
        <img class="img-responsive chain" src="${goodstype2[1].url}" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="${basePath }goods/idlist.do?gnumber=${goodstype2[1].gnumber}">${goodstype2[1].gname}</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">${goodstype2[1].gprice}元</span>
                    <span class="reducedfrom">1${goodstype2[1].gprice}元</span>
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
                <a class="now-get get-cart" href="${basePath }goods/idlist.do?gnumber=${goodstype2[1].gnumber}">立即抢购</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-4 chain-grid grid-top-chain">
        <a href="${basePath }goods/idlist.do?gnumber=${goodstype2[2].gnumber}">
        <img class="img-responsive chain" src="${goodstype2[2].url}" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="${basePath }goods/idlist.do?gnumber=${goodstype2[2].gnumber}">${goodstype2[2].gname}</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">${goodstype2[1].gprice}元</span>
                    <span class="reducedfrom">1${goodstype2[1].gprice}元</span>
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
                <a class="now-get get-cart" href="${basePath }goods/idlist.do?gnumber=${goodstype2[2].gnumber}">立即抢购</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="clearfix"></div>
</div>
<div class="products">
    <h5 class="latest-product">乳品冲饮最新产品</h5>
    <a class="view-all" href="${basePath }goods/list.do?gsort=乳品冲饮">查看全部<span> </span></a>
</div>
<div class="product-left">
    <div class="col-md-4 chain-grid">
        <a href="${basePath }goods/idlist.do?gnumber=${goodstype3[0].gnumber}">
        <img class="img-responsive chain" src="${goodstype3[0].url}" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="${basePath }goods/idlist.do?gnumber=${goodstype3[0].gnumber}">${goodstype3[0].gname}</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">${goodstype3[0].gprice}元</span>
                    <span class="reducedfrom">${goodstype3[0].gprice}元</span>
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
                <a class="now-get get-cart" href="${basePath }goods/idlist.do?gnumber=${goodstype3[0].gnumber}">立即抢购</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-4 chain-grid">
        <a href="${basePath }goods/idlist.do?gnumber=${goodstype3[1].gnumber}">
        <img class="img-responsive chain" src="${goodstype3[1].url}" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="${basePath }goods/idlist.do?gnumber=${goodstype3[1].gnumber}">${goodstype3[1].gname}</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">${goodstype3[1].gprice}元</span>
                    <span class="reducedfrom">1${goodstype3[1].gprice}元</span>
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
                <a class="now-get get-cart" href="${basePath }goods/idlist.do?gnumber=${goodstype3[1].gnumber}">立即抢购</a>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
    <div class="col-md-4 chain-grid grid-top-chain">
        <a href="${basePath }goods/idlist.do?gnumber=${goodstype3[2].gnumber}">
        <img class="img-responsive chain" src="${goodstype3[2].url}" alt=" "/></a>
        <span class="star"> </span>
        <div class="grid-chain-bottom">
            <h6><a href="${basePath }goods/idlist.do?gnumber=${goodstype3[2].gnumber}">${goodstype3[2].gname}</a></h6>
            <div class="star-price">
                <div class="dolor-grid">
                    <span class="actual">${goodstype3[2].gprice}元</span>
                    <span class="reducedfrom">1${goodstype3[2].gprice}元</span>
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
                <a class="now-get get-cart" href="${basePath }goods/idlist.do?gnumber=${goodstype3[2].gnumber}">立即抢购</a>
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
        <ul class="menu">
            <li class="item1"><a >生&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;鲜<img class="arrow-img" src="${basePath }frontend/images/sun.png"/>
            </a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=新鲜蔬菜">新鲜蔬菜 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=新鲜水果">新鲜水果</a></li>
                    <li class="subitem3"><a href="${basePath }goods/list.do?gsort=新鲜水产">新鲜水产 </a></li>
                    <li class="subitem4"><a href="${basePath }goods/list.do?gsort=肉类">肉类 </a></li>
                </ul>
            </li>
            <li class="item2" ><a href="${basePath }goods/list.do?gsort=零食">零&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;食<img class="arrow-img"
                                                                                     src="${basePath }frontend/images/snack.png"
                                                                                     alt=""/></a>
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=休闲零食">休闲零食 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=饼干糕点">饼干糕点</a></li>

                </ul>
            </li>
            <li class="item3"><a >茶&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;酒<img class="arrow-img"
                                                                                     src="${basePath }frontend/images/drinks.png"
                                                                                     alt=""/></a> 
                <ul class="cute">
                    <li class="subitem1"><a href="${basePath }goods/list.do?gsort=酒类">酒类 </a></li>
                    <li class="subitem2"><a href="${basePath }goods/list.do?gsort=茶叶">茶叶 </a></li>
                    <li class="subitem3"><a href="${basePath }goods/list.do?gsort=乳品冲饮">乳品冲饮</a></li>
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
        <a href="${basePath }goods/idlist.do?gnumber=${goods[0].gnumber}">
        	<img class="img-responsive chain" src="${goods[0].url }"/></a>
        <div class="grid-chain-bottom chain-watch">
            <span class="actual dolor-left-grid">${goods[0].gprice}元</span>
            <span class="reducedfrom">1${goods[0].gprice}元</span>
            <h6><a href="${basePath }goods/idlist.do?gnumber=${goods[0].gnumber}">${goods[0].gname }</a></h6>
        </div>
    </div>
    <a class="view-all all-product" href="${basePath }goods/list.do">查看所有商品<span> </span></a>
</div>

</body>
</html>