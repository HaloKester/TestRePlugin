发布到仓库做版本控制，宿主compile，插件compile
小型公共库主要放置各种业务无关工具类
尽量不放不能被混淆精简的类，如自定义View
所有宿主插件各compile一份解除版本依赖

在Host目录下
./gradlew -p LitLibrary clean build uploadArchives --info