/**
  *
  */
package org.zkoss.zstl

import org.zkoss.ztl._
import org.zkoss.ztl.annotation._
import org.zkoss.ztl.util.ConfigHelper

import scala.collection.JavaConversions._
import com.thoughtworks.selenium.SeleniumException
import org.zkoss.ztl.util.ZKSelenium
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.ArrayList
import java.util.HashSet
import java.util.Date

import com.thoughtworks.selenium.Selenium
import java.util.concurrent.Future

import org.zkoss.ztl.testcafe.Widget$Cafe
import org.zkoss.ztl.unit.Widget
import org.zkoss.ztl.util.AggregateError

/**
  * ZTL for Scala to test
  *
  * @author jumperchen
  */
class ZTL4ScalaTestCase extends ZKParallelClientTestCase {
  var ch = ConfigHelper.getInstance()
  target = ch.getServer() + ch.getContextPath() + "/" + ch.getAction()
  caseID = getClass().getSimpleName()
  val _engine = new ThreadLocal[Widget]();

  def runZTL(zscript: scala.xml.Elem, executor: () => Unit) {
    runZTL(zscript.toString(), "", executor);
  }

  def runZTL(zscript: String, executor: () => Unit) {
    runZTL(zscript, "", executor);
  }

  def runZTLinAction(action: String, executor: () => Unit) {
    runZTL("", action, executor)
  }

  def runZTL(executor: () => Unit) {
    var action = "test2/" + this.getClass.getSimpleName.replace("_", "-").replace("Test", ".zul")
    runZTL("", action, executor)
  }

  def runZTL(zscript: String, action: String, executor: () => Unit) {
    if (action != null && !action.isEmpty)
      target = ch.getServer + ch.getContextPath + "/" + action;
    val testingEnv = ch.getTestingEnvironment
    if (testingEnv == null || "selenium".equals(testingEnv)) { //default
      //update timeout
      _timeout = ch.getTimeout().toInt
      val luuid = new Date().getTime();
      println(getTimeUUID() + "-" + luuid + ":log 1");
      val executorService = Executors.newCachedThreadPool();
      val browserSet = new HashSet[String];
      val futures = new ArrayList[Future[_]];
      var annotIgnoreBrowsers = ""
      if (this.getClass.isAnnotationPresent(classOf[IgnoreBrowsers]))
        annotIgnoreBrowsers = this.getClass.getAnnotation(classOf[IgnoreBrowsers]).value();
      println("ignore browsers : " + annotIgnoreBrowsers);
      val browsers = getBrowsers(ch.getBrowser(), annotIgnoreBrowsers)
      for (browser <- browsers) {
        println(getTimeUUID() + "-" + luuid + ":log 2");
        val zkSelenium = browser.asInstanceOf[ZKSelenium];
        println(zkSelenium);
        browserSet.add(zkSelenium.getBrowserName());
        println("add browser: " + zkSelenium.getBrowserName());
        futures.add(executorService.submit(new Runnable() {
          def run() = {
            println(getTimeUUID() + "-" + luuid + ":log 3" + ConnectionManager.getInstance().getOpenedRemote(zkSelenium.getBrowserName()));
            try {
              println(getTimeUUID() + "-" + luuid + ":log 4-1");
              start(browser);
              windowFocus();
              windowMaximize();
              println(getTimeUUID() + "-" + luuid + ":log 4-2");
              if (!zscript.isEmpty())
                runRawZscript(
                  zscript
                    toString());
              waitResponse();
              executor();
              println(getTimeUUID() + "-" + luuid + ":log 4-3");
            } catch {
              case e: SeleniumException =>
                println(getTimeUUID() + "-" + luuid + "selenium exception...");
                println(e.getMessage());
                e.printStackTrace();
                ConfigHelper.getInstance().clearCache(zkSelenium);
                zkSelenium.shutdown();
                throw e;
              case e: InterruptedException =>
                println(getTimeUUID() + "-" + luuid + ":interrupt exception-" + e.getMessage());
              case other: Throwable =>
                println(getTimeUUID() + "-" + luuid + ":other exception-" + other.getMessage());
                other.printStackTrace();
                throw other;
            } finally {
              println(getTimeUUID() + "-" + luuid + ":log 4-4");
              stop();
              println(getTimeUUID() + "-" + luuid + ":log 4-5");
              browserSet.remove(zkSelenium.getBrowserName());
              println(getTimeUUID() + "-" + luuid + ":log 4-6");
            }
            println(getTimeUUID() + "-" + luuid + ":log 4-7-" + zkSelenium.getBrowserName());
          }
        }));
      }

      executorService.shutdown();

      try {
        if (!executorService.awaitTermination(_timeout, TimeUnit.MILLISECONDS))
          executorService.shutdownNow();

        detectException(futures);
      } catch {
        case e: AggregateError =>
          throw e;
        case e: Throwable =>
          println(getTimeUUID() + "-" + luuid + ":in termination ex..." + e.getMessage());
          e.printStackTrace();
      }

      println(getTimeUUID() + "-" + luuid + ":log 5-1");

      handleTimeout(browserSet, luuid);

      println(getTimeUUID() + "-" + luuid + ":log 6");

      waitAndRelease(browserSet);

      println(getTimeUUID() + "-" + luuid + ":log 7");
    } else if ("testcafe".equals(testingEnv)) { //testingEnv
      //check ignore list
      var testCaseName = getClass().getSimpleName().replaceAll("_", "-");
      testCaseName = testCaseName.substring(0, testCaseName.length() - 8) + ".ztl";

      val browsers = ConfigHelper.getInstance.getBrowsersForLazy("all", testCaseName, null)
      if (browsers.size() == 0) return
      enableTestCafe();
      if (!zscript.isEmpty())
        runRawZscript(zscript.toString)
      executor()
      generateCafeTest(target.replace("zulCafe", "zul"), ch.getCafeTestDir)
    }
  }

  def engine(): Widget = {
    val testingEnv = ch.getTestingEnvironment
    if ("testcafe".equals(testingEnv)) {
      enableTestCafe();
      _engine.set(new Widget$Cafe(new StringBuffer("zk.Desktop._dt"), testCodeList));
    } else {
      _engine.set(new Widget(new StringBuffer("zk.Desktop._dt")));
    }
    return _engine.get();
  }
  def getSelenium(): Selenium = selenium.get();

}
