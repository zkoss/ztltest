package org.zkoss.zktest.test2.B60

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B60-ZK-1596.zul")
class B60_ZK_1596Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk xmlns:n="native">
	<label multiline="true">
		1. Click "Invalidate" button.
		2. If you see JS error showed, it is a bug.
	</label>
	<button id="btn" label="Invalidate" onClick="cave.invalidate()" />
	<div id="cave">
		<n:div>
			<window title="Root" border="normal">
				<n:div>
					<window title="Nest inside native" border="normal" />
				</n:div>
			</window>
		</n:div>
	</div>
</zk>"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button:contains(Invalidate)"))
      waitResponse()
      verifyFalse("should see no javascript error", jq(".z-error").exists())
    })
    
  }
}