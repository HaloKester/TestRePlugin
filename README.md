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
在Plugin1目录下执行bash makePlugin1.sh完成Plugin1的编译和推送到SD卡  
点击“安装外置插件Plugin1”完成安装
#### 1.2 卸载插件Plugin1
点击“卸载插件Plugin1”完成卸载，若Plugin1正在运行，则在进程重启后生效
#### 1.3 更新插件Plugin1
修改Plugin1内容  
在Plugin1目录下执行bash makePlugin1.sh  
点击“更新插件Plugin1”，若Plugin1正在运行，则在进程重启后生效
### 2.宿主插件调用Activity/Service
验证了以下几个场景，log可通过标签"jinghai"查看  
宿主打开宿主Activity  
宿主打开宿主Service  
宿主打开插件Activity  
宿主打开插件Service  
插件打开宿主Activity  
插件打开宿主Service  
插件打开插件Activity  
插件打开插件Service
### 3.宿主插件调用Provider/Receiver
验证了以下几个场景，log可通过标签"jinghai"查看
宿主发广播给宿主静态Receiver  
宿主发广播给插件静态Receiver（不生效，插件未加载起来）  
宿主创建宿主动态Receiver
宿主创建插件动态Receiver  
宿主发广播给宿主创建的宿主动态Receiver  
宿主发广播给宿主创建的插件动态Receiver  
宿主发广播给插件创建的宿主动态Receiver  
宿主发广播给插件创建的插件动态Receiver  
插件发广播给宿主静态Receiver  
插件发广播给插件静态Receiver  
插件创建宿主动态Receiver  
插件创建插件动态Receiver  
插件发广播给宿主创建的宿主动态Receiver  
插件发广播给宿主创建的插件动态Receiver  
插件发广播给插件创建的宿主动态Receiver  
插件发广播给插件创建的插件动态Receiver    
宿主向宿主静态Provider发增加查询请求  
插件向插件静态Provider发增加查询请求
### 4.公共库使用
使用了两种形态公共库  
PluginBigLibrary：大型公共库，用于放置较大、不可混淆、自定义View、宿主插件对其使用保持一致性的东西，是一个内置插件
LitLibrary：小型公共库，用于放置非常独立的业务无关的工具类，不可放置不可混淆、自定义View等东西，宿主插件对其使用不必保持一致性，可各自版本控制，是一个放置到Maven的AAR  
验证了以下几个场景，log可通过标签"jinghai"查看  
宿主反射获取BigLibrary的View展示，通过传递View规避了共享资源  
宿主反射调用BigLibrary的带参数带返回值方法  
宿主插件调用LitLibrary方法  
