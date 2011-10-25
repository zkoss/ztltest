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
2.	Change the `config.properties` setting under ztltest folder.
	For example,
		server=http://localhost:8080
		context-path=/zktest
	
3.	Configure your browser setting in this case it is firefox only.
	For example,
		firefox=FirefoxDriver
		all=firefox

	If you want to use remove driver, you can change with the following setting.
		firefox=http://10.1.3.245:4444/wd/hub;FirefoxDriver
	
	This means you have a [selenium remote server](http://code.google.com/p/selenium/downloads/list) at `10.1.3.245` IP.

4. After all above things done, you can run the testing case where is under `ztltest/zstl/test` folder as Junit test case in Eclipse.

**Note**: In the folder named `zstl`(ZK Scala Testing Language) is to run ZTL testing case upon Scala language, which can support XML syntax in its language idiom.

How to contribute testing case
------------------------------

#### Introduction ####
Since ZK is a popular Ajax framework, we need to continue to maintain our high testing standards and find areas to improve upon. Automation is one of the best ways in which you can improve testing of your product which is the main reason for introducing ZTL, to make it easier to automate testing of ZK applications. We have begun the process of translating each of our zktest/test2 manual test cases to ZTL. Should you with to contribute a new test case or translate a manual test case to a ZTL you are more than welcome to. We will be using this tool to run through all test cases before ZK release or freshly builds. 

#### ZTL (Scala) Naming Convention ####

For translating [zktest/test2/](https://github.com/zkoss/zk/tree/master/zktest/src/archive/test2), each ZTL file name should be the same as the test zul file. 
For example
		`zktest/test2/B30-123456.zul` It should be `zstl/test/org/zkoss/zktest/test2/B30/B30_123456Test.scala` And the tags of the test case should be the same as the [zktest/test2/config.properties](https://github.com/zkoss/zk/tree/master/zktest/src/archive/test2/config.properties)
		
Here is the [ExampleTest.scala](https://github.com/zkoss/ztltest/blob/master/zstl/test/ExampleTest.scala).
For more testing cases, please refer to this folder [zstl/test/org](https://github.com/zkoss/ztltest/tree/master/zstl/test)