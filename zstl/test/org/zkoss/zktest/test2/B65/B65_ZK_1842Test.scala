package org.zkoss.zktest.test2.B65

import org.zkoss.ztl.Tags
import org.zkoss.zstl.ZTL4ScalaTestCase
import org.junit.Test

@Tags(tags = "B65-ZK-1842.zul")
class B65_ZK_1842Test extends ZTL4ScalaTestCase {

@Test
def testClick() = {
  runZTL(() => {
      val open = jq(".z-button:contains(Open)")
      click(open)
      waitResponse()
      
      verScroll(jq(".z-listbox"), 1)
      click(jq(".z-listitem:contains(i)"))
      waitResponse()
      
      click(jq(".z-menuitem").toWidget().$n("a"))
      waitResponse()
      
      click(open)
      waitResponse()
      
      verifyTrue("You should see 'l' and 'a' item only.", 
          jq(".z-listitem").length() == 2 && jq(".z-listitem:contains(a)").exists 
          && jq(".z-listitem:contains(l)").exists)
    })
    
  }
}