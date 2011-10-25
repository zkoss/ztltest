A project for collecting [ZK](http://www.zkoss.org/) testing cases
=========================================

How to install ztltest environment
----------------------------------

1. Please checkout this repository to a folder named ztltest
2. In Eclipse IDE, `File`>`Import...`>`Existing Projects into Workspace`

**Note**: In your Eclipse, you have to install [Scala IDE](http://www.scala-ide.org/) and [m2e](http://eclipse.org/m2e/)

How to run ztltest
------------------

1. You have to run a ZK Test web application. In this case, you can check out the [zktest project](https://github.com/zkoss/zk/tree/master/zktest) and import it as `Existing Projects into Workspace`.
2. Change the `config.properties` setting under ztltest folder.
For example,
	server=http://localhost:8080
	context-path=/zktest
	
3. Configure your browser setting in this case it is firefox only.
For example,
	firefox=FirefoxDriver
	all=firefox

If you want to use remove driver, you can change with the following setting.
	firefox=http://10.1.3.245:4444/wd/hub;FirefoxDriver
	
This means you have a [selenium remote server](http://code.google.com/p/selenium/downloads/list) at `10.1.3.245` IP.

4. After all above things done, you can run the testing case where is under `ztltest/zstl/test` folder as Junit test case in Eclipse.
**Note**: In the folder named `zstl`(ZK Scala Testing Language) is to run ZTL testing case upon Scala language, which can support XML syntax in its language idiom.