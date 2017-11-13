package org.zkoss.zktest.test2.B80

import org.openqa.selenium.Keys
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 02/11/2017.
  */
class B80_ZK_3528Test extends ZTL4ScalaTestCase {

  def test () = {
    runZTL(() => {
      keyPressNative("9")
      keyPressNative("9")
      verifyEquals("z-focus-a", getEval("document.activeElement.className"))
      sendKeys(jq(".z-focus-a"), Keys.ENTER)
      waitResponse(true)
      verifyTrue(jq(".z-listitem").length() == 0)
      verifyEquals("z-focus-a", getEval("document.activeElement.className"))
      sendKeys(jq(".z-focus-a"), Keys.ESCAPE)
      waitResponse(true)
      verifyTrue(getZKLog().startsWith("[KeyEvent onCancel <Listbox "))
      verifyEquals("z-focus-a", getEval("document.activeElement.className"))
      jq("#zk_log").eval("val(\"\")")
      verifyEquals("", getZKLog())
      sendKeys(jq(".z-focus-a"), Keys.ENTER)
      waitResponse(true)
      verifyTrue(getZKLog().startsWith("[KeyEvent onOK <Listbox "))
    })
  }

}
