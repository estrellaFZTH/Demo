<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异步响应</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //页面加载，绑定单击事件
        //如果不在springmvc里面配置
        //<%--<mvc:resources mapping="/js/**" location="/js/"></mvc:resources> --%>
        //的话，此事件会被拦截，即点击按钮无反应。
        $(function(){
            $("#btn").click(function() {
                alert("hello btn.");
                //发送ajax请求
                $.ajax({
                    //编写json格式
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"userName":"信息","passWord":"111"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) { //回调函数
                        // data服务器端响应json的数据，进行解析
                        alert(data);
                        alert(data.userName);
                        alert(data.passWord);
                    }
                })
            });
        });
    </script>
</head>
<body>
    <button id="btn">发送ajax的请求</button>
</body>
</html>
