package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1847.zul")
class B65_ZK_1847Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk xmlns:w="client">
	<vlayout>
		click the buttons, it should work as expected (and return the expected data). 
		<div>
			1. 
			<button label="fire event" w:onClick="zAu.send(new zk.Event(this.$f('message1'), 'onFoo', null, {toServer:true}));"/>
			zAu.send(new zk.Event(this.$f('message1'), 'onFoo', null, {toServer:true}));
		</div>
		Expected Result: null
		<hlayout>
			Actual Result: <label id="message1" onFoo='self.value = "" + event.data' />
		</hlayout>
	</vlayout>
</zk>

"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button"))
      waitResponse()
      verifyTrue("it should work as expected", 
          jq(".z-hlayout .z-label").text().contains("null"))
    })
    
  }
}