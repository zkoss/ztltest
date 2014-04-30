package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-2105.zul")
class B65_ZK_2105Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
  <window title="Server Push" border="normal" apply="org.zkoss.zktest.test2.B65_ZK_2105">
		<label multiline="true">
		1. Click the button
		2. Wait 5 seconds.
		3. Should see true.
		</label>
      
    <button id="startLongOp" label="Click" />
    <separator/>
    <label id="msg"/>
		<script type="text/javascript" defer="true"><![CDATA[
zk.afterMount(function () {
	var oldFn = zAu.cmd0.script,
			arr = ["cpsp.start", "cpsp.stop"],
	  	i = 0,
	  	result = true;
	zAu.cmd0.script = function (script) {
		oldFn.apply(this, arguments);
		result = result && (script.indexOf(arr[i]) != -1);
		i = i + 1;
		if (i == 2) 
			zk.Widget.$(jq('$msg')[0]).setValue(result);
		};
});
		]]></script>
  </window>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq("$startLongOp"))
      waitResponse()
      sleep(5500)
      verifyTrue("Should see true.", jq(".z-label:eq(1)").text() == "true")
    })
    
  }
}