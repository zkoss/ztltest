package org.zkoss.zktest.test2.B60

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

import scala.annotation.tailrec

@Tags(tags = "B60-ZK-1298.zul")
class B60_ZK_1298Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
          <zscript>
            public class MyComposer extends org.zkoss.zk.ui.select.SelectorComposer{

              public String getName() {
                return "testing";
              }
            }
          </zscript>
          <window id="win" title="custom" border="normal" apply="MyComposer">
            <custom-attributes composerName="mc"/>
            <vlayout>
              <label>value: '${ win$composer.name }', value should be 'testing'</label>
              <label>value: '${ mc.name }', value should be 'testing'</label>
            </vlayout>
          </window>
          <window id="win2" title="custom" border="normal" apply="MyComposer">
            <vlayout>
              <label>value: '${ win2$composer.name }', value should be 'testing'</label>
              <label>value: '${ mc.name }', value should be ''</label>
            </vlayout>
          </window>
        </zk>"""
    runZTL(zscript,
      () => {
        verifyEquals(countSubstring(jq(".z-label:eq(0)").text(), "testing"), 2)
        verifyEquals(countSubstring(jq(".z-label:eq(1)").text(), "testing"), 2)
        verifyEquals(countSubstring(jq(".z-label:eq(2)").text(), "testing"), 2)
        verifyEquals(countSubstring(jq(".z-label:eq(3)").text(), "''"), 2)
      })
  }

  def countSubstring(str1: String, str2: String): Int = {
    return count(str1, str2, 0, 0)
  }
  def count(str1: String, str2: String, pos: Int, c: Int): Int = {
    val idx = str1.indexOf(str2, pos)
    if (idx == -1)
      return c
    else
      return count(str1, str2, idx + str2.size, c + 1)
  }
}
