
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.1.0.js"></script>
    <script src="js/jquery.json-2.4.js"></script>
    <script type="text/javascript" >

        $(function() {

        });

    function test() {
            var  name = $("#name").val();
            var  password = $("#password").val();
            alert("ssssssssssss");
            $.ajax({

                type : "GET",
                url : "login.do?name=" + name + "&password="+password,
                data : "",
                dataType : "json",
                contentType : 'application/json;charset=utf-8',
                async : false,
                error : function(request) {

                },
                success : function(data) {
                    var resname = data.resName;
                    var respas = data.resPassWord;
                    alert('respas' + respas);
                    alert('resname' + resname);

                }

            });

        }
    </script>
</head>
<body>



    <input type="text" id="name" name="name" />
</br>
    <input type="text" id="password" name="password" />
    <input type="button" id="tst" value="sss" onclick="test()"/>
qqqqqqqq
wwwwwwwwwww
ssss


dsffd

</body>
</html>
