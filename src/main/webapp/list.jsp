<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
    <%--注释--%>
    <script>
        function delSelected() {
            var flag=false;
            if(confirm("删除选中条目？")) {
                alert("aaa");
                var uid = $("input[name='uid']");
                $.each(uid, function () {
                    if (this.checked) {
                        flag=true;
                        return false;
                    }
                });
            }

            if (flag) {
                $("#form").submit();
            }
        }

        $(function () {
            $("#firstCb").click(function () {
                var checked = $("#firstCb")[0].checked;
                // if($("#firstCb").is(":checked")
                var uid = $("input[name='uid']");
                $.each(uid, function () {
                    this.checked=checked;
                })
            });
        });
            function deleteById(id) {
                if(confirm("删除选中条目？")) {
                    location="${pageContext.request.contextPath}/user/delete?id="+id;
                }
            }

    </script>
</head>
<body>
<div class="container">
    <div>${user.username}</div>
    <h3 style="text-align: center" id="h3">用户信息列表</h3>

    <div style="float: left;">

        <form class="form-inline" action="" method="post">
            <div class="form-group">
                <label>姓名</label>
                <input type="text" name="name" class="form-control">
            </div>
            <div class="form-group">
                <label>籍贯</label>
                <input type="text" name="address" class="form-control">
            </div>

            <div class="form-group">
                <label>邮箱</label>
                <input type="text" name="email" class="form-control">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>

    </div>

    <div style="float: right;margin: 5px;">

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add.jsp">添加联系人</a>
        <a class="btn btn-primary" href="javascript:delSelected();">删除选中</a>

    </div>
    <form id="form" action="${pageContext.request.contextPath}/user/deleteByIds" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th><input type="checkbox" id="firstCb"></th>
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>年龄</th>
                <th>籍贯</th>
                <th>QQ</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${list}" var="user" varStatus="s">
            <tr>
                <td><input type="checkbox" name="uid" value="${user.id}"></td>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/user/selectUserById?id=${user.id}" >修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteById(${user.id})">删除</a></td>   <%-- href="${pageContext.request.contextPath}/user/delete?id=${user.id}" --%>
            </tr>

        </c:forEach>


        </table>
    </form>

</div>


</body>
</html>
