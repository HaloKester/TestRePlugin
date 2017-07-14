发布到仓库做版本控制，宿主compile，插件provided
中型公共库主要放置基本不做版本迭代的公共代码，以及需要被插件在XML中使用的自定义View
./gradlew -p MidLibrary clean build uploadArchives --info