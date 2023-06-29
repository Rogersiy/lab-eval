# 实验室评测系统

系统目前设计分为两部分，Java springboot 和 Python 推理服务端。

在Java服务端 访问http://localhost:5000/evaluate,并附带 json post提交到Python推理服务端，处理结果之后 返回Json内容。

## Java 服务器部分

 ![image-20230629111755390](https://images-1302444479.cos.ap-beijing.myqcloud.com/markdown/image-20230629111755390.png)

Python文件夹中存放 前台传来的Json文件

Main函数中 http访问 Python服务端。

在测试的时候，可以假设result 为

{AP=0.004, AP50=0.006, AP75=0.005, AP_large=0.0, AP_medium=0.003, AP_small=0.003, AR_large=0.001, AR_maxDets=1=0.0, AR_maxDets=10=0.001, AR_maxDets=100=0.002, AR_medium=0.002, AR_small=0.002}

## Python服务端部分

依赖：

pycocotools

flask 