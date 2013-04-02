package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase

@Tags(tags = "B65-ZK-1692.zul")
class B65_ZK_1692Test extends ZTL4ScalaTestCase {

def testClick() = {
  val zscript = """<zk xmlns:w="client">
	If you see "true" in the log window, it is a bug.
	<script type="text/javascript">zk.load('zul.wnd');</script>
	<button label="Create Widget">
		<attribute w:name="onBind"><![CDATA[
			if (!this._win) {
				this._win = new zul.wnd.Window();
			}
			zk.log('isVisible: ' + this._win.isVisible(true));
			zk.log('isRealVisible: ' + this._win.isRealVisible());
		]]></attribute>
	</button>
</zk>"""  
  runZTL(zscript,
    () => {
      verifyTrue("you should not see 'true' in the log window", !jq("#zk_log").`val`().contains("true"))
    })
    
  }
}