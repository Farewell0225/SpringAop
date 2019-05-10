<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
</head>
<script src="js/jquery-3.1.0.js"/>
<script src="js/jquery.json-2.4.js"/>
<script type="text/javascript">

    $(function() {

        $("#t").click(function() {
            var  name = $("#name").val();
            var  password = $("#password").val();
            alert("ssssssssssss");
            $.ajax({

                type : "GET",
                url : "${application.getContext()}/login?name=" + name + "&password="+password,
                data : "",
                dataType : "json",
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

        });

    });

</script>
</head>

    <body>
        <h2>Hello World!</h2>

        <form action="" >
            <input type="text" id="name" name="name"/>
             <br>
            <input type="text" id="password" name="password"/>
            <input type="button" id="t" value="提交" />


        </form>

    </body>

</html>
