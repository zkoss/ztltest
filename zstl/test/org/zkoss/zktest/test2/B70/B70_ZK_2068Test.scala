package org.zkoss.zktest.test2.B70

import org.junit.Test
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.Tags

@Tags(tags = "B70-ZK-2068.zul")
class B70_ZK_2068Test extends ZTL4ScalaTestCase {

  @Test
  def testClick() = {
    val zscript =
      """<?page title="Portallayout" contentType="text/html;charset=UTF-8"?>
<zk>
	<window border="normal" title="Portallayout">
		<label multiline="true">
			1.Click "resize",the yellow area will change width.
			2.Resize browser window, the width of yellow area will not be changed.
		</label>
		<button id="btn" label="resize" onClick="click()"/>
		<portallayout>
	    	<portalchildren id="child1" style="background-color:yellow;" height="450px"  width="30%"/>
	    	<portalchildren style="background-color:blue;" height="450px" width="30%"/>
	        <portalchildren style="background-color:green;" height="450px"  width="30%"/>
		</portallayout>
		<zscript>
			public void click(){
			  	child1.setWidth("25px");
			}
		</zscript>
	</window>
</zk>
"""
    runZTL(zscript,
      () => {

        val pc = jq(".z-portalchildren")
        val w = pc.width()
        click(jq(".z-button"))
        waitResponse()

        verifyTrue("the yellow area will change width", pc.width() != w)
      })

  }
}