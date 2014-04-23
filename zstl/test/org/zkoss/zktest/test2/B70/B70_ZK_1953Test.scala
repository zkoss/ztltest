package org.zkoss.zktest.test2.B70

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B70-ZK-1953.zul")
class B70_ZK_1953Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<?page title="Checkmark Listhead Listbox" contentType="text/html;charset=UTF-8"?>
<zk>
	<window title="Checkmark Listhead Listbox" border="normal">
		<label value="Listhead's checkmark should be invisible "/>
		<div>
		    <listbox width="300px" checkmark="true" multiple="true">
		        <listhead>
		            <listheader>
		                <label value="Can an empty list be all selected?"/>
		            </listheader>
		        </listhead>
		    </listbox>
		</div>
	</window>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyTrue("Listhead's checkmark should be invisible", !jq(".z-listheader-checkable").exists)
    })
    
  }
}