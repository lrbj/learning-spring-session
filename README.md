# Spring Session 学习
参考自：http://blog.didispace.com/spring-session-xjf-1/
## 1. session认识
### 1.1. Session 与cookie 基础
由于Http 协议是无状态协议，为了记住请求状态， 因此引入了Session和 Cookie 机制。
Session 存在于服务端， Cookie 存在于客户端。
维系客户端与服务端的桥梁， Session 相关的sessionId
### 1.2. 关于HttpServletRequest，HttpSession
当服务端往HttpSession中保存一些数据时，HttpServletRequest中自动添加了一个Cookie：JSESSIONID：xxxx,再后续的请求中，
浏览器也是自动的带上了这个Cookie，服务端根据Cookie中的JSESSIONID取到了对应的session。 服务端根据cookie中
的JSESSIONID来辨别身份。
