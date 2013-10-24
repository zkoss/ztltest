package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1834.zul")
class B65_ZK_1834Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  val zscript = """<zk>
	<label multiline="true">
	1. Click "add data" button.
	2. Scroll down to last item, and select it.
	3. Click "clear data" button, if you still can see the scroll-bar, it is a bug.
	</label>
	<window border="normal" title="hello">
		<zscript><![CDATA[
		void add() {
			for(int i = 0; i < 20; ++i) {
				theListbox.appendChild(new Listitem("" + i));
			}
		}
		void clear() {
			theListbox.getItems().clear();
		}
		]]></zscript>
		<listbox id="theListbox" multiple="true" checkmark="true" width="100%" height="100px"></listbox>
		<button label="add data" onClick="add()" />
		<button label="clear data" onClick="clear()" />
	</window>
</zk>
"""  
  runZTL(zscript,
    () => {
      click(jq(".z-button:contains(add)"))
      waitResponse()
      
      verScroll(jq(".z-listbox"), 1)
      click(jq(".z-listitem:contains(19)"))
      waitResponse()
      
      click(jq(".z-button:contains(clear)"))
      waitResponse()
      
      verifyImage()
    })
    
  }
}