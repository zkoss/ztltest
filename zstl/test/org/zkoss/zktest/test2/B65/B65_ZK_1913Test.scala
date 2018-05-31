package org.zkoss.zktest.test2.B65

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B65-ZK-1913.zul")
class B65_ZK_1913Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<zk>
	<window title="Detail"
	       apply="org.zkoss.bind.BindComposer"
	       viewModel="@id('detail') @init('org.zkoss.zktest.test2.B65_ZK_1913')"
	       width="300px" border="normal">
	    <vlayout>
	        Click the button, it will show true.
		<button label="Button" onClick="@command('toggltServerPush')"/>
		<label id="msg"/>
		<script type="text/javascript" defer="true"><![CDATA[
		    var arr = [
				"cmsp.start",
				"cmsp.stop"];
		    var i = 0,
		    	result = true;
	        zAu.cmd0.script = function (script)  {
	       		result = result && (script.indexOf(arr[i]) != -1);
	       		i = i + 1;
				if (i == 2) 
					zk.Widget.$(jq('$msg')[0]).setValue(result);
	        };
		]]></script>
		</vlayout>
	</window>
</zk>
"""
    runZTL(zscript,
      () => {
        click(jq(".z-button"))
        waitResponse()
        verifyTrue("it will show true.", jq(".z-label:contains(true)").length() == 2)
      })

  }
}