1. 将需要远程化的类，implements于业务接口(请酌情定义)。示例中原来的业务代码在crazy.view.BizCommon里面，新定义了业务接口crazy.biz.ServiceBizCommon
2. crazy.rpc中，包括了远程化的基本原理和demo实现
3. 在需要远程化的方式前，加上crazy.rpc.RPCDecorator标签，待远程运行业务稳定一段时间后，可以直接删除远程化方法里面的代码，使之完全为空也无所谓
4. 同样这份代码，除了原来的业务web服务器之外，再增加一个service部署，即原来的web服务部署作为client，新部署的service作为server
5. server的启动方式：java -Drpcserver -Dhost=MyServer -jar superman.jar --*server*.port=9000
6. client的启动方式: java -Drpcclient -Dhost=MyClient -jar superman.jar --*server*.port=8000
7. 用curl "http://localhost:8000/hello?name=foobar" 来访问client服务器，可以看到显示的名字里面，带着MyServer，与直接访问server服务器是一样的