<%--
  Created by IntelliJ IDEA.
  User: 野心
  Date: 2019/11/18
  Time: 11:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/public/js/jquery-3.3.1.min.js"></script>
</head>
<body>
    <h1>index</h1>

    <input type="button" value="list" id="btnList"/>
    <input type="button" value="insert" id="btnInsert"/>
    <input type="button" value="insert2" id="btnInsert2"/>

    <script>
        $(function () {
            $("#btnList").click(function () {
                $.ajax({
                    url:"/list",
                    type:"GET",
                    success:function (date) {
                        console.log(date);
                        alert(date.username);
                    }
                });
            });


            $("#btnInsert").click(function () {
                var data = {id:100,username:"client"};
                $.ajax({
                    url:"/insert",
                    data:JSON.stringify(data),
                    type:"POST",
                    contentType:"application/json",
                    dataType:"json",
                    success:function (data) {
                        alert(data.username);
                    }
                });
            });


           $("#btnInsert2").click(function () {
               var data = {id:101,username:"chient"}
               $.ajax({
                   url:"insert2",
                   data:data,
                   type:"POST",
                   dataType:"json",
                   success:function (data) {
                       alert(data.username);
                   }
               });
           });


        });
    </script>
</body>
</html>
