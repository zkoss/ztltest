/* 

{{IS_NOTE
	Purpose:
		
	Description:
		
	History:
}}IS_NOTE

Copyright (C) 2011 Potix Corporation. All Rights Reserved.

{{IS_RIGHT
}}IS_RIGHT
*/
package org.zkoss.zktest.bind.basic
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.ZKSeleneseTestCase
import org.openqa.selenium.Keys
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_ExecutionParamTest extends ZTL4ScalaTestCase {
  def testArg() = {
    val zul = { // executionparam.zul
      <vbox id="box">
        <zscript><![CDATA[
          void doClick1(){
            org.zkoss.zk.ui.Execution ex = org.zkoss.zk.ui.Executions.getCurrent();
            ex.setAttribute("param1", "foo");
            java.util.Map args = new java.util.HashMap();
            args.put("arg1", "bar");
            ex.createComponents("/bind/basic/executionparam-inner.zul", w1, args);
          }]]>
        </zscript>
        <button label="create compoents" id="btn1" onClick="doClick1()"/>
        <window id="w1"/>
        <window id="w2">
          <zscript><![CDATA[
            void doClick2(){
              org.zkoss.zk.ui.Execution ex = org.zkoss.zk.ui.Executions.getCurrent();
              ex.setAttribute("param1", "abc");
              inc.src = "/bind/basic/executionparam-inner.zul";
            }]]>
          </zscript>
          <button label="do include" id="btn2" onClick="doClick2()"/>
          <include id="inc" arg1="goo"/>
        </window>
      </vbox>
    }

    runZTL(zul, () => {
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("foo", jq("$w1 $l11").toWidget().get("value"))
      verifyEquals("bar", jq("$w1 $l12").toWidget().get("value"))
      click(jq("$w1 $cmd1").toWidget())
      waitResponse()
      verifyEquals("", jq("$w1 $l11").toWidget().get("value"))
      verifyEquals("", jq("$w1 $l12").toWidget().get("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("abc", jq("$w2 $l11").toWidget().get("value"))
      verifyEquals("goo", jq("$w2 $l12").toWidget().get("value"))
      click(jq("$w2 $cmd1").toWidget())
      waitResponse()
      verifyEquals("", jq("$w2 $l11").toWidget().get("value"))
      verifyEquals("", jq("$w2 $l12").toWidget().get("value"))
    })
  }
}
