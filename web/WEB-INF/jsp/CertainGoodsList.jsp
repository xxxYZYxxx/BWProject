<%--
  Created by IntelliJ IDEA.
  User: xxxYZYxxx
  Date: 2021/12/5
  Time: 12:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl标签库--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
    //获取当前工程的绝对路径
    String path = request.getContextPath();
%>

<html>

<head>
    <title>商品页面</title>
</head>


<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

<%--引入jquery控件--%>
<script src="<%=path%>/jquery/jquery-1.7.2.js"></script>

<script type="text/javascript">

</script>

<body>

<h1 align="center" style="font-size: 30px">商品列表</h1>
<hr>


<table class="table table-hover">

    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>上架时间</th>
        <th>商品品牌</th>
        <th>商品类别</th>
        <th>商品描述</th>
        <th>库存</th>
    </tr>

    <c:forEach items="${goodsList}" var="goods">

        <tr>
            <td>${goods.goodsName}</td>
            <td>${goods.price}</td>
            <td>${goods.upTime}</td>
            <td>
                <c:forEach items="${brandList}" var="brand">

                    <c:if test="${brand.bid == goods.brandId}">

                        ${brand.brandName}

                    </c:if>

                </c:forEach>
            </td>

            <td>

                <c:forEach items="${cateList}" var="cate">

                    <c:if test="${cate.cid == goods.cateId}">

                        ${cate.cateName}

                    </c:if>

                </c:forEach>

            </td>
            <td>${goods.goodsDesc}</td>
            <td>${goods.num}</td>
        </tr>

    </c:forEach>

</table>

</body>
</html>


