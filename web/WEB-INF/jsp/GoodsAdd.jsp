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
    <title>商品上架</title>
</head>


<%--引入jquery控件--%>
<script src="<%=path%>/jquery/jquery-1.7.2.js"></script>

<!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">


<style>
    .back {
        position: absolute;
        top: 0;
        bottom: 0;
        left: 0;
        right: 0;
        background-color: #E4E4E4;
        background-size: 100% 100%;
        background-repeat: no-repeat;
    }
    .container-round {
        background-color: rgba(255,255,255,0.5);
        width: 736px;
        border-radius: 10px;
        margin-top: 40px
    }
</style>


<script type="text/javascript">


    //文本就绪函数
    $(function (){

        $.ajax({

            url : "<%=path%>/goods/findAllBrand",

            type : "post",

            success:function (obj){

                for (let i in obj){

                    $("#brandId").append("<option value='"+obj[i].bid+"'>"+obj[i].brandName+"</option>")

                }

            },

            dataType: "json"

        })
    })

    //添加商品
    function addGoods(){


        $.ajax({

            url : "<%=path%>/goods/addGoods",

            type : "post",

            data : $("form").serialize(),

            success:function (obj){

                if (obj == "1"){

                    alert("该商品已经存在，已为您添加了库存！")

                    location.href = "<%=path%>/goods/list";

                }else if (obj == "3"){

                    alert("商品已经上架成功！")

                    location.href = "<%=path%>/goods/list";

                }else {

                    alert("后端异常，请联系管员！")
                }

            },

            dataType: "json"

        })


    }

</script>

<body class="back">


<div class="container container-round">
    <h1 align="center" style="font-size: 30px">商品添加页</h1>
    <form class="form-horizontal" role="form" style="margin-top: 20px">
        <div class="form-group">
            <label for="goodsName" class="col-sm-3 control-label">商品名称:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="goodsName" name="goodsName" placeholder="goodsName">
            </div>
        </div>

        <div class="form-group">
            <label for="price" class="col-sm-3 control-label">商品价格:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="price" name="price" placeholder="price">
            </div>
        </div>

        <div class="form-group">
            <label for="brandId" class="col-sm-3 control-label">商品品牌:</label>
            <div class="col-sm-6">

                <select id="brandId" class="form-control" name="brandId">
                    <option>---请选择---</option>
                </select>
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-6">
                <div class="radio">
                    <label>
                        <input type="radio" name="cateId" value="1"> 服装服饰
                    </label>
                    <label>
                        <input type="radio" name="cateId" value="2"> 运动器材
                    </label>
                    <label>
                        <input type="radio" name="cateId" value="3"> 家用电器
                    </label>
                    <label>
                        <input type="radio" name="cateId" value="4"> 电子产品
                    </label>
                </div>
            </div>
        </div>


        <div class="form-group">
            <label for="goodsDesc" class="col-sm-3 control-label">商品描述:</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="goodsDesc" name="goodsDesc" placeholder="goodsDesc">
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-offset-3 col-sm-6">
                <input type="button" class="btn btn-info" value="添加" onclick="addGoods()">
                <input type="button" class="btn btn-warning" value="取消" onclick="toHome()">
            </div>
        </div>
    </form>
</div>

</body>

</html>
