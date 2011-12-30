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
package org.zkoss.zktest.bind.issue
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

/**
 * @author pao
 */
@Tags(tags = "zbind")
class Z60_F00633Test extends ZTL4ScalaTestCase {
  def testIssue() = {
    val zul = { // F00633.zul
      <window apply="org.zkoss.bind.BindComposer" viewModel="@id('vm') @init('org.zkoss.zktest.bind.issue.F00633')">
        <vbox onCreate="@command('create',label=l12)">
          <label id="l11" value="@load(vm.value1)"/>
          <label id="l12"/>
          <hbox id="h11">
            <button id="btn1" label="cmd1" onClick="@command('cmd1')"/>
            <button id="btn2" label="cmd2" onClick="@command('cmd2')"/>
            <button id="btn3" label="cmd3" onClick="@command('cmd3')"/>
            <button id="btn4" label="cmd4" onClick="@command('cmd4')"/>
            <button id="btn5" label="cmd5" onClick="@command('cmd5',arg1=99,arg2=true,arg3='XYZ')"/>
            <button id="btn6" label="cmd6" onClick="@command('cmd6')"/>
            <button id="btn7" label="cmd7" onClick="@command('cmd7',arg3='XYZ')"/>
            <button id="btn8" label="cmd8" onClick="@command('cmd8',arg1=22)"/>
            <button id="btn9" label="cmd9" onClick="@command('cmd9',arg2=false,arg3='EFG')"/>
            <button id="btn10" label="cmdA1" onClick="@command('cmdA',label=l12,unknow=self)"/>
            <button id="btn11" label="cmdA2" onClick="@command('cmdA',label=l12,unknow=desktop)"/>
            <button id="btn12" label="cmdA3" onClick="@command('cmdA',label=l12,unknow=self.parent)"/>
          </hbox>
        </vbox>
        <button label="Dump" onClick="binder.getTracker().dump()"/>
      </window>
    }

    runZTL(zul, () => {
      verifyEquals("onCreate 1", jq("$l11").toWidget().get("value"))
      verifyEquals("onCreate 2", jq("$l12").toWidget().get("value"))
      click(jq("$btn1").toWidget())
      waitResponse()
      verifyEquals("doCommand1", jq("$l11").toWidget().get("value"))
      click(jq("$btn2").toWidget())
      waitResponse()
      verifyEquals("doCommand2", jq("$l11").toWidget().get("value"))
      click(jq("$btn3").toWidget())
      waitResponse()
      verifyEquals("doCommand3 btn3 true", jq("$l11").toWidget().get("value"))
      click(jq("$btn4").toWidget())
      waitResponse()
      verifyEquals("doCommand4 3 false null btn4 true", jq("$l11").toWidget().get("value"))
      click(jq("$btn5").toWidget())
      waitResponse()
      verifyEquals("doCommand5 99 true XYZ btn5 true", jq("$l11").toWidget().get("value"))
      click(jq("$btn6").toWidget())
      waitResponse()
      verifyEquals("doCommand6 9 true ABCD btn6 true", jq("$l11").toWidget().get("value"))
      click(jq("$btn7").toWidget())
      waitResponse()
      verifyEquals("doCommandX 9 true XYZ cmd7", jq("$l11").toWidget().get("value"))
      click(jq("$btn8").toWidget())
      waitResponse()
      verifyEquals("doCommandX 22 true ABCD cmd8", jq("$l11").toWidget().get("value"))
      click(jq("$btn9").toWidget())
      waitResponse()
      verifyEquals("doCommandX 9 false EFG cmd9", jq("$l11").toWidget().get("value"))
      click(jq("$btn10").toWidget())
      waitResponse()
      verifyEquals("object is btn10", jq("$l12").toWidget().get("value"))
      click(jq("$btn11").toWidget())
      waitResponse()
      verifyEquals("object is desktop", jq("$l12").toWidget().get("value"))
      click(jq("$btn12").toWidget())
      waitResponse()
      verifyEquals("object is h11", jq("$l12").toWidget().get("value"))
    })
  }
}