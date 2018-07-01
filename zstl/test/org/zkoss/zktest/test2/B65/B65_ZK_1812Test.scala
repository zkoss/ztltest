package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1812.zul")
class B65_ZK_1812Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk xmlns:w="client">

	<vlayout>
		currently only buttons 1-5 should work as expected (and return the expected data). before the fix 4 and 5 ignore all or parts of event data
		<div>
			1. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f('message1'), 'onFoo', 'plain string', {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f('message1'), 'onFoo', 'plain string', {toServer:true}));
		</div>
		Expected Result: plain string
		<hlayout>
			Actual Result: <label id="message1" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>
		
		<div>
			2. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f('message2'), 'onFoo', {'' : 'attrValueWithEmptyName'}, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f('message2'), 'onFoo', {'' : 'attrValueWithEmptyName'}, {toServer:true}));
		</div>
		Expected Result: attrValueWithEmptyName -------------> {'' : 'attrValueWithEmptyName'} is interpreted as plain string
		<hlayout>
			Actual Result: <label id="message2" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>

		<div>
			3. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f('message3'), 'onFoo', {'' : {'attrName' : 'attrValue'}}, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f('message3'), 'onFoo', {'' : {'attrName' : 'attrValue'}}, {toServer:true}));
		</div>
		Expected Result: {"attrName" : "attrValue"} -------------> {'' : {'attrName' : 'attrValue'}} is interpreted as {'attrName' : 'attrValue'}
		<hlayout>
			Actual Result: <label id="message3" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>
			
		<div>
			4. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f('message4'), 'onFoo', {'attrName' : 'attrValue'}, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f('message4'), 'onFoo', {'attrName' : 'attrValue'}, {toServer:true}))
		</div>
		Expected Result: {"attrName" : "attrValue"} -------------> should remain unchanged (no ERROR thrown)
		<hlayout>
			Actual Result: <label id="message4" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>

		<div>
			5. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f('message5'), 'onFoo', {'' : 'attrValueWithEmptyName', 'attrName' : 'attrValue'}, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f('message5'), 'onFoo', {'' : 'attrValueWithEmptyName', 'attrName' : 'attrValue'}, {toServer:true}));
		</div>
		Expected Result: {"" : "attrValueWithEmptyName", "attrName" : "attrValue"} -------------> should remain unchanged
		<hlayout>
			Actual Result: <label id="message5" onFoo="self.setValue(event.getData().toString())"/>
		</hlayout>

	</vlayout>
</zk>"""
    runZTL(zscript,
      () => {
        click(jq(".z-button:contains(fire event):eq(0)"))
        waitResponse()
        val lbl0 = jq(".z-label:contains(Actual Result)").eq(0).parent().next().find(".z-label")
        verifyContains(lbl0.text(), "plain string")

        click(jq(".z-button:contains(fire event):eq(1)"))
        waitResponse()
        val lbl1 = jq(".z-label:contains(Actual Result)").eq(1).parent().next().find(".z-label")
        verifyContains(lbl1.text(), "attrValueWithEmptyName")

        click(jq(".z-button:contains(fire event):eq(2)"))
        waitResponse()
        val lbl2 = jq(".z-label:contains(Actual Result)").eq(2).parent().next().find(".z-label")
        verifyContains(lbl2.text(), "{\"attrName\":\"attrValue\"}")

        click(jq(".z-button:contains(fire event):eq(3)"))
        waitResponse()
        val lbl3 = jq(".z-label:contains(Actual Result)").eq(3).parent().next().find(".z-label")
        verifyContains(lbl3.text(), "{\"attrName\":\"attrValue\"}")

        click(jq(".z-button:contains(fire event):eq(4)"))
        waitResponse()
        val lbl4 = jq(".z-label:contains(Actual Result)").eq(4).parent().next().find(".z-label")
        verifyContains(lbl4.text(), "{\"\":\"attrValueWithEmptyName\",\"attrName\":\"attrValue\"}")
      })
  }
}