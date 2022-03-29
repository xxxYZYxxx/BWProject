<%--
  Created by IntelliJ IDEA.
  User: xxxYZYxxx
  Date: 2021/12/5
  Time: 9:34
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

    function toCertainGoodsList(){
        var goodsName=document.getElementsByName("goodsName")[0].value;
        location.href="<%=path%>/goods/certainlist?goodsName="+goodsName
    }
    //删除商品
    function deleteGoods(gid){
        $.ajax({

            url : "<%=path%>/goods/deleteGoods?gid="+gid,

            type : "post",

            data : $("form").serialize(),

            success:function (obj){

                if (obj == "1"){

                    alert("删除成功！")

                    location.href = "<%=path%>/goods/list";

                }else if (obj == "0"){

                    alert("删除失败！")

                    location.href = "<%=path%>/goods/list";

                }

            },

            dataType: "json"

        })
    }

    //跳转添加页面
    function toAdd(){

        location.href = "<%=path%>/goods/toAdd"

    }

    //分页函数
    function page(currentPage){

        location.href = "<%=path%>/goods/list?currentPage="+currentPage;
    }

    //加库存
    function addNum(gid){
        $.ajax({
            url:"<%=path%>/goods/addNum",
            type:"post",
            data:{
                gid:gid
            },
            success:function (obj){
                if(obj==1){
                    location.href="<%=path%>/goods/list"
                }else{
                    alert("添加库存失败")
                    location.href="<%=path%>/goods/list"
                }
            },
            dataType: "text"
        })
    }

    //减库存
    function subtractNum(gid){
        $.ajax({
            url:"<%=path%>/goods/subtractNum",
            type:"post",
            data:{
                gid:gid
            },
            success:function (obj){
                if(obj==1){
                    location.href="<%=path%>/goods/list"
                }else{
                    alert("减少库存失败，注意库存不能小于0")
                    location.href="<%=path%>/goods/list"
                }
            },
            dataType:"text"
        })
    }

</script>

<body>

<h1 align="center" style="font-size: 30px">商品列表</h1>
<hr>


<table class="table table-hover">

    <tr>
        <td colspan="12" align="center">
            <div class="form-group">
            <input type="button" value="商品上架" class="btn btn-info" onclick="toAdd()">
            </div>

            <form action="<%=path%>/goods/certainlist" method="post" class="form-horizontal" role="form" style="margin-top: 20px">
            <div class="form-group">
                <div class="col-sm-6">
                    <input type="text" class="form-control" placeholder="根据商品名查询" name="goodsName">
                </div>
                <input type="button" value="查询" class="btn btn-info" onclick="toCertainGoodsList()">
            </div>
            </form>

        </td>
    </tr>

    <tr>
        <th>商品名称</th>
        <th>商品价格</th>
        <th>上架时间</th>
        <th>商品品牌</th>
        <th>商品类别</th>
        <th>商品描述</th>
        <th>库存</th>
        <th>操作</th>
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
            <td>
                <input type="button" value="-" onclick="subtractNum(${goods.gid})">
                    ${goods.num}
                <input type="button" value="+" onclick="addNum(${goods.gid})">
            </td>
            <td>
                <form action="/BW/goods/list" method="post">
                <input type="submit" class="btn btn-danger" value="删除"  onclick="deleteGoods(${goods.gid})">
                    </form>
          </td>
</tr>

</c:forEach>

<tr>
<td colspan="11" align="center">

    ${pageUtils.currentPage} / ${pageUtils.lastPage}

    <a onclick="page(1)">首页</a>
    <a onclick="page(${pageUtils.prevPage})">上一页</a>
    <a onclick="page(${pageUtils.nextPage})">下一页</a>
    <a onclick="page(${pageUtils.lastPage})">尾页</a>

</td>
</tr>


</table>




</body>
</html>
