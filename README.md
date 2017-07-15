# TestRePlugin
## 一、简介  
TestRePlugin是插件化框架RePlugin各种开发场景覆盖的Demo，主要用于验证RePlugin的适用开发场景。
## 二、项目结构
宿主和插件分开不同的Project管理，  
宿主：Host  
外置插件：Plugin1  
内置插件：PluginBigLibrary  
本地仓库：localrepo  
## 三、运行使用
### 1.插件更新
#### 1.1 安装外置插件
在Plugin1目录下执行bash makePlugin1.sh完成Plugin1的编译和推送到SD卡  <br/>
点击“安装外置插件Plugin1”完成安装  <br/>
#### 1.2 卸载插件Plugin1
点击“卸载插件Plugin1”完成卸载，若Plugin1正在运行，则在进程重启后生效  <br/>
#### 1.3 更新插件Plugin1
修改Plugin1内容  <br/>
在Plugin1目录下执行bash makePlugin1.sh  <br/>
点击“更新插件Plugin1”，若Plugin1正在运行，则在进程重启后生效  <br/>
### 2.宿主插件调用Activity/Service
验证了以下几个场景，log可通过标签"jinghai"查看  <br/>
a.宿主打开宿主Activity  <br/>
b.宿主打开宿主Service  <br/>
c.宿主打开插件Activity  <br/>
d.宿主打开插件Service  <br/>
e.插件打开宿主Activity  <br/>
f.插件打开宿主Service  <br/>
g.插件打开插件Activity  <br/>
h.插件打开插件Service  <br/>
### 3.宿主插件调用Provider/Receiver
验证了以下几个场景，log可通过标签"jinghai"查看  <br/>
a.宿主发广播给宿主静态Receiver  <br/>
b.宿主发广播给插件静态Receiver（不生效，插件未加载起来  <br/>
c.宿主创建宿主动态Receiver  <br/>
d.宿主创建插件动态Receiver  <br/>
e.宿主发广播给宿主创建的宿主动态Receiver  <br/>
f.宿主发广播给宿主创建的插件动态Receiver  <br/>
g.宿主发广播给插件创建的宿主动态Receiver  <br/>
h.宿主发广播给插件创建的插件动态Receiver  <br/>
i.插件发广播给宿主静态Receiver  <br/>
j.插件发广播给插件静态Receiver  <br/>
k.插件创建宿主动态Receiver  <br/>
l.插件创建插件动态Receiver  <br/>
m.插件发广播给宿主创建的宿主动态Receiver  <br/>
n.插件发广播给宿主创建的插件动态Receiver  <br/>
o.插件发广播给插件创建的宿主动态Receiver  <br/>
p.插件发广播给插件创建的插件动态Receiver  <br/>
q.宿主向宿主静态Provider发增加查询请求  <br/>
r.插件向插件静态Provider发增加查询请求  <br/>
### 4.公共库使用
#### 4.1 库分类
使用了两种形态公共库  <br/>
PluginBigLibrary：大型公共库，用于放置较大、不可混淆、自定义View、宿主插件对其使用保持一致性的东西，是一个内置插件  <br/>
LitLibrary：小型公共库，用于放置非常独立的业务无关的工具类，不可放置不可混淆、自定义View等东西，宿主插件对其使用不必保持一致性，可各自版本控制，是一个放置到Maven的AAR  <br/>
#### 4.2 验证场景
验证了以下几个场景，log可通过标签"jinghai"查看  <br/>
a.宿主反射获取BigLibrary的View展示，通过传递View规避了共享资源  <br/>
b.宿主反射调用BigLibrary的带参数带返回值方法  <br/>
c.宿主插件调用LitLibrary方法  <br/>
#### 4.3 库更新
PluginBigLibrary的更新使用插件正常更新机制  <br/>
LitLibrary的更新可以在Host目录下使用bash uploadLitLibrary.sh更新AAR到本地Maven（localrepo目录里)，由宿主或插件自行在gradle里提高版本号依赖  <br/>
