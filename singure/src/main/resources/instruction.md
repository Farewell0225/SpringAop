<script type="text/javascript">
document.addEventListener("DOMContentLoaded", function() {
    // 生成目录列表
    var toc = document.createElement("ul");
    toc.setAttribute("id", "table-of-content");
    toc.style.cssText = "border: 1px solid #ccc;";
    document.body.insertBefore(toc, document.body.childNodes[0]);
    // 用于计算当前标题层级的栈,先进先出,从左到右每一个元素代表当前标题所在的层级索引，初始为空
    var stack = new Array();
    // 获取所有标题
    var headers = document.querySelectorAll('h1,h2,h3,h4,h5,h6');
    for (var i = 0; i < headers.length; i++) {
        var header = headers[i];
        // 计算标题级数，为后面计算标号及缩进空格准备
        var level = parseInt(header.tagName.replace('H', ''), 10);
        // 通过两个where循环对栈进行调整,确保stack中标题级数与当前标题级数相同
        while(stack.length < level){
            stack.push(0);
        }
        while(stack.length > level){
            stack.pop();
        }
        // 最小一级标题标号步进+1
        stack[stack.length-1]++;
        // 生成标题标号( 1.1,1.2.. )
        var index = stack.join(".")
        // 生成标题ID
        var id = "title" + index;
        header.setAttribute("id", id);
        // 为标题加上标号,如果不希望显示标号，把下面这行注释就可以了
        header.textContent = index + " " + header.textContent;
        toc.appendChild(document.createElement("li"));
        var a = document.createElement("a");
        // 为目录项设置链接
        a.setAttribute("href", "#" + id)
        // 目录项文本前面放置缩进空格
        a.innerHTML = new Array(level * 4).join('&nbsp;') + header.textContent;
        toc.lastChild.appendChild(a);
    }
});
</script>

#RSA 算法加签与验签

## 获取公钥与私钥 
### 获取证书
- https://blog.csdn.net/qq_31289187/article/details/84973338
#### 使用 linux 工具openssl生成
- openssl

####输入指令：openssl

- 生成私钥证书
genrsa -out rsa_oo_private_key.pem 2048

####打印私钥
- pkcs8 -topk8 -inform PEM -in rsa_oo_private_key.pem -outform PEM -nocrypt


####依据私钥证书生成公钥证书

- rsa -in rsa_oo_private_key.pem -pubout -out rsa_public_key.pem

####打印公钥

- 在生成的公钥证书目录下 输入  more rsa_public_key.pem  即可打印公钥



