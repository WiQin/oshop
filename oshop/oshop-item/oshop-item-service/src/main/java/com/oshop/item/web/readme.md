web层

Rest风格介绍
1. 路径要求:  路径名不出现操作，不同请求方式代表不同操作
GET:获取一个资源  
POST：创建一个新的资源  
PUT：修改一个资源状态  
DELETE：删除一个资源
2.响应  
不同状态码代表不同结果

-->使用ResponseEntity接收
出现异常，返回状态码（如400等）-->响应不够友好，如何处理?
-->抛出异常，不再返回异常信息-->throw new RunTimeException(“”)
-->异常由spring mvc处理，无法满足要求
-->通用异常

接口异常时如何返回--service异常抛出到web，在web层进行拦截
    抛RunTimeException，返回500，不是服务器异常，不合适
    解决：common层进行通用异常处理
    自定义异常
    
ES6规范
~~~html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<script>
    for(let i = 0;i<5;i++){
        console.log(i);
    }
    //console.log(i);  let定义的为局部变量，作用域外不可使用

    const num = 5;
    //console.log(num++);  const定义的常量不可被修改

    //解构表达式
    //快速实现数据解析和重新封装
    let arr = [2,5,-10,15];
    let [x,y] = arr;//[2,5]
    let [,,a,b] = arr;//[-10,15]
    let [,...test] = arr;//[5,-10,15]

    let p = {name:"test",age:12};
    let {name,age} = p;
    let {name:n} = p;
    let {...obj} = p;

    //函数优化
    function sum(a,b){
        return a+b;
    }

    const add = (a,b) => a+b;

    const p = {
        name:"jack",
        age:12,
        ssyHello(){
            console.log("hello");
        }
    }

    //map和reduce
    let arr = ["2","5","-10","15"];
    let arr2 = arr.map(s => parseInt(s));//遍历数组中元素，返回int值
    arr2.reduce((a,b) => a+b);//数组中元素求和
</script>
</body>
</html>
~~~