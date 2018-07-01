package org.zkoss.zktest.test2.B65

import org.zkoss.zstl.ZTL4ScalaTestCase
import org.zkoss.ztl.annotation.Tags

@Tags(tags = "B65-ZK-1568.zul")
class B65_ZK_1568Test extends ZTL4ScalaTestCase {

  def testClick() = {
    val zscript =
      """<zk>
	<label multiline="true">Expected result:
		Window 1, 3, 4, 5 should be visible while 2 should not	
	</label>
	<div height="50px">
		<window title='1. visible="false" mode="overlapped"' 
			visible="false" mode="overlapped" width="640px" renderdefer="100" />
	</div>
	<div height="50px">
		<window title='2. mode="overlapped" visible="false"'
			mode="overlapped" visible="false" width="640px" renderdefer="100" />
	</div>
	
	<div height="50px">
		<window title='3. visible="true" mode="overlapped"' 
			visible="true" mode="overlapped" width="640px" renderdefer="100" />
	</div>
	
	<div height="50px">
		<window title='4. mode="overlapped" visible="true"' 
			mode="overlapped" visible="true" width="640px" renderdefer="100" />
	</div>
	
	<div height="50px">
		<window title='5. mode="overlapped"' 
			mode="overlapped" width="640px" renderdefer="100" />
	</div>
</zk>
    """

    runZTL(zscript,
      () => {
        verifyTrue("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(1)").exists())
        verifyFalse("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(2)").exists())
        verifyTrue("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(3)").exists())
        verifyTrue("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(4)").exists())
        verifyTrue("Window 1, 3, 4, 5 should be visible while 2 should not", jq(".z-window-overlapped:contains(5)").exists())
      })

  }
}
