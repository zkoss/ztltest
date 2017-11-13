package org.zkoss.zktest.test2.B80

import org.junit.Assert._
import org.zkoss.zstl.ZTL4ScalaTestCase

/**
  * Created by wenninghsu on 01/11/2017.
  */
class B80_ZK_3340Test extends ZTL4ScalaTestCase {

  def test() = {
    runZTL(() => {
      val bbi = jq(".z-bandbox-input")
      click(bbi)
      waitResponse(true)
      System.out.println("zklog = " + getZKLog().trim())
      assertEquals(getZKLog().trim(), "bandbox focussed:onFocus")
      getEval("jq('.z-log > textarea').val(\"\")")
      System.out.println("zklog = " + getZKLog().trim())

      sendKeys(bbi, "ABC")
      waitResponse(true)
      assertEquals(getZKLog().trim(), "bandbox changing:onChanging")
      System.out.println("zklog = " + getZKLog().trim())
      getEval("jq('.z-log > textarea').val(\"\")")
      System.out.println("zklog = " + getZKLog().trim())

      click(jq(".z-bandbox-button"))
      waitResponse(true)
      assertEquals(getZKLog().trim(), "bandbox focussed:onFocus")
      System.out.println("zklog = " + getZKLog().trim())
      getEval("jq('.z-log > textarea').val(\"\")")
      System.out.println("zklog = " + getZKLog().trim())

      clickAt(jq(".z-bandpopup"), "180,10")
      waitResponse(true)
      assertEquals(getZKLog().trim(), "bandbox focussed:onFocus")
      System.out.println("zklog = " + getZKLog().trim())
      getEval("jq('.z-log > textarea').val(\"\")")
      System.out.println("zklog = " + getZKLog().trim())

      clickAt(jq(".z-bandbox"), "300,100")
      waitResponse(true)
      assertEquals(getZKLog().trim(), "bandbox changed:onChange\nbandbox blurred:onBlur")
      System.out.println("zklog = " + getZKLog().trim())
      getEval("jq('.z-log > textarea').val(\"\")")
      System.out.println("zklog = " + getZKLog().trim())
    })
  }

}
